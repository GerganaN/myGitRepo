package com.skrill.interns.cart;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add")
public class Add extends CherryServlet {

    private static final long serialVersionUID = 2L;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

        String idParameter = request.getParameter("id");
        if (idParameter == null) {
            String responseMessage = "400 Bad Request\n\nId parameter not set";
            respondToClient(response, responseMessage, 400);
            return;
        }
        int id;
        try {
            id = Integer.parseInt(idParameter);
        } catch (NumberFormatException e) {
            String responseMessage = "400 Bad Request\n\nIncorrectly set id parameter";
            respondToClient(response, responseMessage, 400);
            return;
        }

        String quantityParameter = request.getParameter("quantity");
        int quantity;
        if (quantityParameter == null) {
            quantity = 1;
        } else {
            try {
                quantity = Integer.parseInt(quantityParameter);
            } catch (NumberFormatException e) {
                String responseMessage = "400 Bad Request\n\nIncorrectly set qunatity parameter";
                respondToClient(response, responseMessage, 400);
                return;
            }
        }

        Item selectedItem = null;
        // search for required item in dataBase
        for (Item item : database) {
            if (item.getId() == id) {
                selectedItem = item;
                break;
            }
        }
        if (selectedItem == null) {
            String responseMessage = "Sorry, we don't have this item. Please choose something else.";
            respondToClient(response, responseMessage, 200);
            return;
        }
        Cookie[] cookies = request.getCookies();
        boolean hasCartCookie = false;

        if (cookies == null) {
            ClientCart newCart = new ClientCart();
            Cookie newCookie = bakeCookie(newCart, id, quantity);
            if (newCookie == null) {
                String responseMessage = "500 Internal Server Error\n\nCould not create cookie!";
                respondToClient(response, responseMessage, 400);
                return;
            }
            response.addCookie(newCookie);

        } else {
            for (Cookie cookie : cookies) {
                if ("CART".equals(cookie.getName())) {
                    ClientCart cart = null;
                    cart = encoder.convertXmlToCart(decryptCookie(cookie));
                    if (cart == null) {
                        String responseMessage = "406 Not Acceptable\n\nCorrupted cookie! It will be deleted";
                        respondToClient(response, responseMessage, 406);
                        cart = new ClientCart();
                    }
                    Cookie newCookie = bakeCookie(cart, id, quantity);
                    response.addCookie(newCookie);
                    hasCartCookie = true;
                    break;
                }
            }
            if (!hasCartCookie) {
                ClientCart newCart = new ClientCart();
                Cookie newCookie = bakeCookie(newCart, id, quantity);
                response.addCookie(newCookie);
            }
        }
        String responseMessage = "Added " + quantity + " new item(s):\n" + encoder.viewItemAsXML(selectedItem);
        respondToClient(response, responseMessage, 200);
    }
}
