package controlador;

import com.google.gson.JsonArray;
import dao.JsonTools;
import modelo.CarrosModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "InvitadoServlet", urlPatterns = "/InvitadoServlet")
public class InvitadoServlet extends HttpServlet {
    JsonArray autos;
    JsonTools jReader = new JsonTools();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            autos = jReader.jsonAutoReader();
            out.println("<div class=\"tg-wrap\"><table>");
            out.println("  <tr>");
            out.println("    <th>Marca</th>");
            out.println("    <th>Linea</th>");
            out.println("    <th>Modelo</th>");
            out.println("    <th>Detalles</th>");
            out.println("  </tr>");
            //for para llenar tabla
            for (int i=0; i<autos.size(); i++) {
                out.println("  <tr>");
                out.println("    <td>"+autos.get(i).getAsString()+"</td>");
                out.println("    <td></td>");
                out.println("    <td></td>");
                out.println("    <td></td>");
                out.println("  </tr>");
            }
            out.println("</table></div>");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            out.close();
        }



    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        processRequest(request, response);
    }
}
