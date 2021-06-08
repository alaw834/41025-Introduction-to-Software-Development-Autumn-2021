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
import java.util.ArrayList;
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
public class ListProductServlet extends HttpServlet {

    private ProductManager productmanager;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        productmanager = (ProductManager) session.getAttribute("productManager");
        ProductValidator validator = new ProductValidator();
        validator.clear(session);
        
        ArrayList<Product> productList = null;
        
        try {
            productList = productmanager.listProduct();
            if (productList != null) {
                System.out.println("List Created");
                session.setAttribute("productList", productList);
                request.getRequestDispatcher("listproduct.jsp").include(request, response);
            }
            else{
                request.getRequestDispatcher("listproduct.jsp").include(request, response);
                    session.setAttribute("existErr", "Products Do Not Exist In The Database");
                    request.getRequestDispatcher("catalogue.jsp").include(request, response);
            }
        } catch (SQLException | NullPointerException ex) {
            System.out.println(ex.getMessage() == null ? "Products cannot be loaded" : "welcome");      
            Logger.getLogger(SearchProductServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.getRequestDispatcher("catalogue.jsp").include(request, response);
        }
    }
}
