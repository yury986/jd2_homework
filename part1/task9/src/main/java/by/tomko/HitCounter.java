package by.tomko;

import java.io.*;


import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "hit", value = "/hit-counter")


public class HitCounter extends HttpServlet {

    private int hitCount;

    public void init() {
        // Reset hit counter.
        hitCount = 0;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html");
        hitCount++;
        PrintWriter out = response.getWriter();
        String title = "Total Number of Hits";
        String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";

        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor = \"#f0f0f0\">\n" +
                "<h1 align = \"center\">" + title + "</h1>\n" +
                "<h2 align = \"center\">" + hitCount + "</h2>\n" +
                "</body> </html>");

        String str = Integer.toString(hitCount);
        String userHomeDir = System.getProperty("user.home");
        String counterFileDir = userHomeDir + File.separator + "task9";
        new File(counterFileDir).mkdirs();
        String counterFilePath = counterFileDir + File.separator + "hit.txt";

        FileWriter writer = new FileWriter(counterFilePath);
        writer.write(str);
        writer.close();

    }

    public void destroy() {

    }
}
