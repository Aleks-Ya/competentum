package ru.yaal.competentum.web;

import ru.yaal.competentum.domain.Shop;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "InitEmulationServlet", urlPatterns = "/init")
public class InitEmulationServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int cashCount = Integer.parseInt(req.getParameter("cashCount"));
        Shop shop = new Shop(cashCount);
        req.getSession().setAttribute("shop", shop);
        req.getRequestDispatcher("emulator.jsp").forward(req, resp);
    }
}