package ru.maxima.calculatorservlet;

import java.io.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "calculatorServlet", value = "/calculator-servlet")

public class CalculatorServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello calculator!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        String num1 = request.getParameter("num1");
        String num2 = request.getParameter("num2");
        String sign = request.getParameter("sign");
        String result;

        if ("plus".equals(sign)) {
            result = Double.toString(Double.parseDouble(num1) + Double.parseDouble(num2));
        } else if ("minus".equals(sign)) {
            result = Double.toString(Double.parseDouble(num1) - Double.parseDouble(num2));
        } else if ("umnoj".equals(sign)) {
            result = Double.toString(Double.parseDouble(num1) * Double.parseDouble(num2));
        } else if ("delit".equals(sign)) {
            result = Double.toString(Double.parseDouble(num1) / Double.parseDouble(num2));
        } else {
            result = "error";
        }

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + num1 + " " + sign + " " + num2 + " = " + result + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}