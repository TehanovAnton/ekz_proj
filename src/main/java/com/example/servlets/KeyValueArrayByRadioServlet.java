package com.example.servlets;

import classes.KVTRepository;
import classes.KeyValueTable;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "KeyValueArrayByRadioServlet", value = "/KeyValueArrayByRadioServlet")
public class KeyValueArrayByRadioServlet extends HttpServlet {
    KVTRepository repos = new KVTRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String radio = request.getParameter("radios");
        ArrayList<KeyValueTable> kvs = getArray(Integer.valueOf(radio));

        ArrayList<String> keys = new ArrayList<>();
        for (KeyValueTable el : kvs)
            keys.add(String.valueOf(el.key));

        request.getSession().setAttribute("Keys", keys);
        request.setAttribute("KeyValueArray", kvs);

        request.getRequestDispatcher("KeyValueArrays").forward(request, response);
    }

    public ArrayList<KeyValueTable> getArray(int radio) {
        ArrayList<KeyValueTable> rs = new ArrayList<>();
        rs = repos.getValues(radio);
        return rs;
    }
}
