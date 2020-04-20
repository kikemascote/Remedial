package controlador;

import dao.JsonTools;
import modelo.CarrosModel;
import modelo.UserModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "AdminServlet", urlPatterns = {"/AdminServlet"})
public class AdminServlet extends HttpServlet {

    List<CarrosModel> auto = null; //lista para llenar los usuarios
    JsonTools jReader = new JsonTools();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            auto = jReader.jsonAutoReader();

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link rel=\"stylesheet\" href=\"css/style.css\"/>");
            out.println("<script src=\"https://cdn.jsdelivr.net/npm/sweetalert2@9\"></script>");
            out.println("<title>Administrador::$user$</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div id='admin-main'>");
            out.println("<div id='titulo'>");
            out.println("<h1 id='admh1'>Taller \"El Pitirijas\" - Consola de administración</h1>");
            out.println("</div>");
            out.println("<div id='carros'>");
            for (int i=0; i<auto.size(); i++) {
                out.println("<div id='auto-" + i + "' class='autos' onClick='libNarnia()'>");
                out.println("</div>");
            }
                out.println("<div id='auto-2' class='autos' onClick='libPrincipito()'>");
                out.println("</div>");
                out.println("<div id='auto-3' class='autos' onClick='libLadrona()'>");
                out.println("</div>");
            out.println("<div id='lib1' class='libros' onClick='libNarnia()'>");
            out.println("</div>");
            out.println("<div id='lib2' class='libros' onClick='libPrincipito()'>");
            out.println("</div>");
            out.println("<div id='lib3' class='libros' onClick='libLadrona()'>");
            out.println("</div>");

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
