package by.tomko;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;


@WebServlet (name = "hit", value = "/hit-image")

public class ServletImage extends HttpServlet {

    private int hitCount = 0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        resp.setContentType("image/jpeg");
        hitCount++;
        BufferedImage image = new BufferedImage(500,200, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();
        graphics.setFont(new Font("Serif", Font.ITALIC, 48));
        graphics.setColor(Color.CYAN);
        graphics.drawString(String.valueOf(hitCount),100,100);
        ServletOutputStream out = resp.getOutputStream();
        ImageIO.write(image, "jpeg", out);
    }
}
