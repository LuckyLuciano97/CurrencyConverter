package com.example.currencyconverter;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "converterServlet", urlPatterns = "/converter")
public class ConverterServlet extends HttpServlet {



    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String baseCurrency = request.getParameter("baseCurrency");
        String targetCurrency = request.getParameter("targetCurrency");
        String amount = request.getParameter("amount");

        ExchangeRateFetcher calculate = new ExchangeRateFetcher(baseCurrency, targetCurrency, amount);
        String result = calculate.getResult();

        response.setContentType("text/plain");

        // Get PrintWriter to write response to output stream
        PrintWriter out = response.getWriter();

        // Write result to the response body
//        request.setAttribute("result", result);
        out.print(result);



    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> currencyCodes = CurrencyCodes.getSupportedCodes();
        request.setAttribute("currencyCodes", currencyCodes);
    getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);
    }

}