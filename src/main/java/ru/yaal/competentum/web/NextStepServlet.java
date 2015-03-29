package ru.yaal.competentum.web;

import ru.yaal.competentum.domain.Cash;
import ru.yaal.competentum.domain.Child;
import ru.yaal.competentum.domain.Customer;
import ru.yaal.competentum.domain.Man;
import ru.yaal.competentum.domain.Shop;
import ru.yaal.competentum.domain.Woman;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Random;

@WebServlet(name = "NextStepServlet", urlPatterns = "/nextStep")
public class NextStepServlet extends HttpServlet {
    private final Random random = new Random();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        Shop shop = (Shop) session.getAttribute("shop");
        shop.process();
        Customer customer = randomCustomer();
        List<Cash> cashes = shop.getCashes();
        Cash cash = customer.chooseCash(cashes);
        cash.getQueue().add(customer);

        session.setAttribute("newCustomer", customer);

        req.getRequestDispatcher("shop.jsp").forward(req, resp);
    }

    private Customer randomCustomer() {
        int productCount = random.nextInt(50) + 1;
        int type = random.nextInt(3);
        switch (type) {
            case 0: {
                return new Man(productCount);
            }
            case 1: {
                return new Woman(productCount);
            }
            case 2: {
                return new Child(productCount);
            }
            default: {
                throw new RuntimeException("Random customer generation");
            }
        }
    }

}
