package com.seavus;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/calculate")
public class WebCalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet");
        printMessage(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost");
        printMessage(req, resp);
    }

    private void printMessage (HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        response.setContentType("text/html");
        int firstOperand;
        int secondOperand;
        
        try{
             firstOperand = Integer.parseInt(request.getParameter("first_operand"));
             secondOperand = Integer.parseInt(request.getParameter("second_operand"));
        } catch (Exception ex){
            writer.println("Wrong arguments");
            return;
        }

        String operation = request.getParameter("operation");
        switch (operation) {
            case "+":
                writer.printf("%d + %d = %d", firstOperand, secondOperand, firstOperand + secondOperand);
                break;
            case "-":
                writer.printf("%d - %d = %d", firstOperand, secondOperand, firstOperand - secondOperand);
                break;
            default:
                writer.println("Your operation was not recognized!");
        }
    }

}
