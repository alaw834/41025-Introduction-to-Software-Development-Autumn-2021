/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotb.controller.Servlets;

import iotb.controller.ProductValidator;
import iotb.model.Product;
import iotb.model.dao.ProductManager;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author alaw8
 */
public class AddProductServlet extends HttpServlet {

    private ProductManager productmanager;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String name = request.getParameter("productName");
        String description = request.getParameter("productDesc");
        String category = request.getParameter("productCat");
        String price = request.getParameter("productPrice");
        String stock = request.getParameter("productStock");

        productmanager = (ProductManager) session.getAttribute("productManager");

        ProductValidator validator = new ProductValidator();
        validator.clear(session);

        if (!validator.validateProductName(name)) {
            session.setAttribute("productNameErr", "Product Name Format Incorrect");
            request.getRequestDispatcher("addproduct.jsp").include(request, response);

        } else if (!validator.validateProductDesc(description)) {
            session.setAttribute("productDescErr", "Product Description Format Incorrect");
            request.getRequestDispatcher("addproduct.jsp").include(request, response);

        } else if (!validator.validateProductCat(category)) {
            session.setAttribute("productCatErr", "Product Category Format Incorrect");
            request.getRequestDispatcher("addproduct.jsp").include(request, response);

        } else if (!validator.validateProductPrice(price)) {
            session.setAttribute("productPriceErr", "Product Price Format Incorrect");
            request.getRequestDispatcher("addproduct.jsp").include(request, response);

        } else if (!validator.validateProductStock(stock)) {
            session.setAttribute("productStockErr", "Product Stock Format Incorrect");
            request.getRequestDispatcher("addproduct.jsp").include(request, response);
        } else {
            try {
                Product exist = productmanager.readProduct(productmanager.getID(name));
                if (exist != null) {
                    session.setAttribute("existErr", "Product Already Exists!");
                    request.getRequestDispatcher("addproduct.jsp").include(request, response);
                } else {
                    productmanager.addProduct(name, description, category, Float.parseFloat(price), Integer.parseInt(stock));
                    request.getRequestDispatcher("catalogue.jsp").include(request, response);
                }
            } catch (SQLException | NullPointerException ex) {
                System.out.println(ex.getMessage() == null ? "Product does not exist" : "welcome");
                Logger.getLogger(AddProductServlet.class.getName()).log(Level.SEVERE, null, ex);
                request.getRequestDispatcher("addproduct.jsp").include(request, response);
            } catch (ParseException ex) {
                Logger.getLogger(AddProductServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
