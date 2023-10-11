package by.tomko;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "NameServlet", urlPatterns = "/formservlet")


public class FormServlet extends HttpServlet {

    public void doGet (HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException
    {
        // Read data from Request
        String fio = request.getParameter("fio");
        System.out.println("Fio:" + fio);

        String phone = request.getParameter("phone");
        System.out.println("Phone:" + phone);

        String email = request.getParameter("email");
        System.out.println("Email:" + email);



        // Send Response to browser
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        if (fio == "" || phone == "" && email == ""){
            out.println("<html>");
            out.println("<h2>" + "Error" + "<h2>" );
        }else {
            out.println("<html>");
            out.println("<h2>" + fio + "<h2><br/>");
            out.println("<h2>" + phone + "<h2><br/>");
            out.println("<h2>" + email + "<h2><br/>");


            out.println("<a href='/task10/form.html'>Back</a>");
            out.println("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet (req,resp);
    }

}
