package by.tomko;

import java.io.*;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "firstServlet", value = "/first-servlet")
public class FirstServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet (HttpServletRequest request, HttpServletResponse response)
            throws  IOException {
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>First Servlet</title></head>");
        out.println("<body><h1>This is first Servlet</h1>");
        out.println("</body></html>");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)

            throws  IOException
    {
        doGet(request,response);
    }
}

