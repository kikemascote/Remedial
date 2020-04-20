package controlador;

import dao.JsonTools;
import modelo.UserModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@WebServlet(name = "ValidaServlet", urlPatterns = {"/ValidaServlet"})
public class ValidaServlet extends HttpServlet {
    static final String HASH_ALGORITHM = "SHA-256";
    //public UserModel usuario = new UserModel();
    List<UserModel> usuario = null; //lista para llenar los usuarios
    JsonTools jReader = new JsonTools();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {                                       //recuperando los usuarios
            usuario = jReader.jsonUserReader();     //para llenar la lista
        } catch (IOException e) {
            e.printStackTrace();
        }
        String uname, pwd;                                                  //recuperamos los strings de index.jsp
        uname = request.getParameter("user").toLowerCase();
        pwd = request.getParameter("pass");

        MessageDigest messageDigest;
        StringBuffer stringBuffer = new StringBuffer(); //almacenando la data del hash
        try {
            messageDigest = MessageDigest.getInstance(HASH_ALGORITHM);
            messageDigest.update(pwd.getBytes());
            byte[] sha256 = messageDigest.digest();
            //stringBuffer = new StringBuffer();
            for (byte bytes : sha256) {
                stringBuffer.append(String.format("%02x", bytes & 0xff));   //sacamos el hash del password enviado desde index.jsp
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        //comparando los elementos de la lista para buscar concordancia del usuario y contraseña
        try {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet validacion</title>");
            out.println("<script src=\"https://cdn.jsdelivr.net/npm/sweetalert2@9\"></script>");
            out.println("<link rel='stylesheet' href='css/style.css'/>");
            out.println("</head>");
            out.println("<body>");
            for (int i = 0; i < usuario.size(); i++) {
                String us = usuario.get(i).getUsuario();
                String pw = usuario.get(i).getPassword();
                int tipo = usuario.get(i).getTipo();
                System.out.println(us + "," + pw + "," + tipo);

                if (us.equals(uname) && pw.equals(stringBuffer.toString())) {
                    switch (tipo) {
                        case 1:
                            response.sendRedirect("AdminServlet");
                            break;
                        case 2:
                            response.sendRedirect("UserServlet");
                            break;
                        case 3:
                            response.sendRedirect("InvitadoServlet");
                            break;
                    }
                } else {
                    out.println("<script>Swal.fire({"
                            + "icon: 'error',"
                            + "title: 'Datos incorrectos',"
                            + "text: 'Intenta de nuevo'"
                            + "}).then(function(){"
                            + "location.href='index.jsp'});</script>");
                }
                out.println("</body>");
                out.println("</html>");
            }
        } finally {
            out.close();
        }

    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
