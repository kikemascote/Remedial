package controlador;

import com.google.gson.JsonArray;
import dao.JsonTools;
import modelo.CarrosModel;
import modelo.PartesModel;
import modelo.UserModel;
import org.springframework.web.servlet.view.JstlView;

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
    List<UserModel> users;
    List<CarrosModel> auto; //lista para llenar los datos
    JsonTools jReader = new JsonTools();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            auto = jReader.jsonAutoReader();
             users = jReader.jsonUserReader();
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
            //formulario
            out.println("<div id=form-add>");
            out.println("<form class=\"form-horizontal\">");
            out.println("<fieldset>");
            out.println("<!-- Form Name -->");
            out.println("<legend>Agregar carro</legend>");
            out.println("<!-- Text input-->");
            out.println("<div class=\"form-group\">");
            out.println("  <label class=\"col-md-4 control-label\" for=\"marca\">Marca</label>  ");
            out.println("  <div class=\"col-md-4\">");
            out.println("  <input id=\"marca\" name=\"marca\" type=\"text\" placeholder=\"Marca del carro\" class=\"form-control input-md\" required=\"\">");
//            out.println("  <span class=\"help-block\">Escriba la marca del carro</span>  ");
            out.println("  </div>");
            out.println("</div>");
            out.println("<!-- Text input-->");
            out.println("<div class=\"form-group\">");
            out.println("  <label class=\"col-md-4 control-label\" for=\"linea\">Linea</label>  ");
            out.println("  <div class=\"col-md-4\">");
            out.println("  <input id=\"linea\" name=\"linea\" type=\"text\" placeholder=\"Linea del carro \" class=\"form-control input-md\" required=\"\">");
//            out.println("  <span class=\"help-block\">Escriba la linea del carro (suru, bora, sentra, etc)</span>  ");
            out.println("  </div>");
            out.println("</div>");
            out.println("<!-- Text input-->");
            out.println("<div class=\"form-group\">");
            out.println("  <label class=\"col-md-4 control-label\" for=\"modelo\">Modelo</label>  ");
            out.println("  <div class=\"col-md-4\">");
            out.println("  <input id=\"modelo\" name=\"modelo\" type=\"text\" placeholder=\"Escriba el año del modelo\" class=\"form-control input-md\" required=\"\">");
//            out.println("  <span class=\"help-block\">Escriba un numero de 4 digitos</span>  ");
            out.println("  </div>");
            out.println("</div>");
            out.println("<!-- Text input-->");
            out.println("<div class=\"form-group\">");
            out.println("  <label class=\"col-md-4 control-label\" for=\"descripcion\">Descripcion</label>  ");
            out.println("  <div class=\"col-md-4\">");
            out.println("  <input id=\"descripcion\" name=\"descripcion\" type=\"text\" placeholder=\"Anote detalles del carro\" class=\"form-control input-md\" required=\"\">");
//            out.println("  <span class=\"help-block\">Anote detalles del carro</span>  ");
            out.println("  </div>");
            out.println("</div>");
            out.println("<!-- Text input-->");
            out.println("<div class=\"form-group\">");
            out.println("  <label class=\"col-md-4 control-label\" for=\"parte1\">Parte 1</label>  ");
            out.println("  <div class=\"col-md-4\">");
            out.println("  <input id=\"parte1\" name=\"parte1\" type=\"text\" placeholder=\"anote la pieza\" class=\"form-control input-md\" required=\"\">");
//            out.println("  <span class=\"help-block\">help</span>  ");
            out.println("  </div>");
            out.println("</div>");
            out.println("<!-- Text input-->");
            out.println("<div class=\"form-group\">");
            out.println("  <label class=\"col-md-4 control-label\" for=\"parte2\">Parte 2</label>  ");
            out.println("  <div class=\"col-md-4\">");
            out.println("  <input id=\"parte2\" name=\"parte2\" type=\"text\" placeholder=\"placeholder\" class=\"form-control input-md\" required=\"\">");
//            out.println("  <span class=\"help-block\">help</span>  ");
            out.println("  </div>");
            out.println("</div>");
            out.println("<!-- Text input-->");
            out.println("<div class=\"form-group\">");
            out.println("  <label class=\"col-md-4 control-label\" for=\"parte4\">Parte 4</label>  ");
            out.println("  <div class=\"col-md-4\">");
            out.println("  <input id=\"parte4\" name=\"parte4\" type=\"text\" placeholder=\"placeholder\" class=\"form-control input-md\" required=\"\">");
//            out.println("  <span class=\"help-block\">help</span>  ");
            out.println("  </div>");
            out.println("</div>");
            out.println("<!-- Text input-->");
            out.println("<div class=\"form-group\">");
            out.println("  <label class=\"col-md-4 control-label\" for=\"parte3\">parte 3</label>  ");
            out.println("  <div class=\"col-md-4\">");
            out.println("  <input id=\"parte3\" name=\"parte3\" type=\"text\" placeholder=\"placeholder\" class=\"form-control input-md\" required=\"\">");
//            out.println("  <span class=\"help-block\">help</span>  ");
            out.println("  </div>");
            out.println("</div>");
            out.println("<!-- Button (Double) -->");
            out.println("<div class=\"form-group\">");
            out.println("  <label class=\"col-md-4 control-label\" for=\"guardar\">Guardar?</label>");
            out.println("  <div class=\"col-md-8\">");
            out.println("    <button id=\"guardar\" name=\"guardar\" class=\"btn btn-success\">Listo</button>");
            out.println("    <button type=\"submit\" id=\"cancelar\" name=\"cancelar\" class=\"btn btn-danger\">Cancelar</button>");
            out.println("  </div>");
            out.println("</div>");
            out.println("</fieldset>");
            out.println("</form>");
            out.println("</div>");
            out.println("<br>");
//            out.println("<jsp:include page=\"form.jsp\"/>");  //No Jala

            //Tabla
            out.println("<div id='carros'>");
            out.println("<style type=\"text/css\">");
            out.println(".tg  {border-collapse:collapse;border-spacing:0;border-color:#9ABAD9;}");
            out.println(".tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:0px;overflow:hidden;word-break:normal;border-top-width:1px;border-bottom-width:1px;border-color:#9ABAD9;color:#444;background-color:#EBF5FF;}");
            out.println(".tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:0px;overflow:hidden;word-break:normal;border-top-width:1px;border-bottom-width:1px;border-color:#9ABAD9;color:#fff;background-color:#409cff;}");
            out.println(".tg .tg-8ea9{font-size:16px;font-family:\"Lucida Console\", Monaco, monospace !important;;border-color:inherit;text-align:left;vertical-align:middle}");
            out.println(".tg .tg-0lax{text-align:left;vertical-align:top}");
            out.println(".tg .tg-23dq{font-family:\"Lucida Console\", Monaco, monospace !important;;text-align:left;vertical-align:top}");
            out.println("</style>");
            out.println("<table class=\"tg\" style=\"undefined;table-layout: fixed; width: 488px\">");
            out.println("<colgroup>");
            out.println("<col style=\"width: 120px\">");
            out.println("<col style=\"width: 120px\">");
            out.println("<col style=\"width: 120px\">");
            out.println("<col style=\"width: 100px\">");
            out.println("<col style=\"width: 100px\">");
            out.println("</colgroup>");
            out.println("  <tr>");
            out.println("    <th class=\"tg-8ea9\">Marca</th>");
            out.println("    <th class=\"tg-0lax\">Linea</th>");
            out.println("    <th class=\"tg-0lax\">Modelo</th>");
            out.println("    <th class=\"tg-0lax\">Detalles</th>");
            out.println("    <th class=\"tg-0lax\">Eliminar</th>");
            out.println("  </tr>");
            out.println();

            for (int i = 0; i < auto.size(); i++) {
//            auto.forEach(out::println);
                out.println("<tr>");
                out.println("  <td class=\"tg-0lax\">" + auto.get(i).getMarca() + "</td>");
                out.println("  <td class=\"tg-0lax\">" + auto.get(i).getLinea() + "</td>");
                out.println("  <td class=\"tg-0lax\">" + auto.get(i).getModelo() + "</td>");
                out.println("  <td class=\"tg-0lax\"><a href=\"/detalle?id=" + i + "\">VER</a></td>");
                out.println("  <td class=\"tg-23dq\"><a href=\"/eliminar?id=" + i + "\">X</a></td>");
                out.println("</tr>");
            }
            out.println("</table>");
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
//        request.getRequestDispatcher("form.jsp").forward(request, response);
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
