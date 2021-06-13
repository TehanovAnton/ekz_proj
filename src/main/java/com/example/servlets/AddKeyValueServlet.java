package com.example.servlets;

import classes.KVTRepository;
import classes.KeyValueTable;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.logging.*;

@WebServlet(name = "AddKeyValueServlet", value = "/AddKeyValueServlet")
public class AddKeyValueServlet extends HttpServlet {

    private KVTRepository repository = new KVTRepository();

    public static Logger LOGGER = Logger.getLogger("MyLog");
    private static FileHandler fileHandler;
    static {
        try {
            fileHandler = new FileHandler("C:\\Users\\Anton\\source\\repos\\pacei_NV_sovremenueTehnologiyVInternet\\экзамен\\ekz_proj\\log_file.log");
            LOGGER.addHandler(fileHandler);
            SimpleFormatter simpleFormatter = new SimpleFormatter();
            fileHandler.setFormatter(simpleFormatter);
        } catch (Exception ignore) {
            ignore.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        KeyValueTable el = new KeyValueTable(
                        Integer.valueOf(request.getParameter("Key")),
                        request.getParameter("Value")
        );
        repository.addRow(el);
        LOGGER.log(Level.INFO,"New KeyValue: " + el.key + " --> " + el.value + ";");
    }
}
