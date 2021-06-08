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
public class SearchProductServlet extends HttpServlet {

    private ProductManager productmanager;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String name = request.getParameter("productName");

        productmanager = (ProductManager) session.getAttribute("productManager");

        ProductValidator validator = new ProductValidator();
        validator.clear(session);

        if (!validator.validateProductName(name)) {
            session.setAttribute("productNameErr", "Product Name Format Incorrect");
            request.getRequestDispatcher("searchproduct.jsp").include(request, response);

        } else {
            try {
                Product exist = productmanager.readProduct(productmanager.getID(name));
                if (exist == null) {
                    session.setAttribute("existErr", "Product Does not Exist!");
                    request.getRequestDispatcher("searchproduct.jsp").include(request, response);
                } else {
                    productmanager.readProduct(productmanager.getID(name));
                    Product searchproduct = new Product(productmanager.getID(name),exist.getProductName(), exist.getProductDescription(), exist.getProductCategory(), exist.getProductPrice(), exist.getProductStock());
                    session.setAttribute("searchproduct",searchproduct); 
                    request.getRequestDispatcher("searchproductresult.jsp").include(request, response);
                    
                }
            } catch (SQLException | NullPointerException ex) {
                System.out.println(ex.getMessage() == null ? "Product does not exist" : "welcome");      
                Logger.getLogger(SearchProductServlet.class.getName()).log(Level.SEVERE, null, ex);
                request.getRequestDispatcher("searchproduct.jsp").include(request, response);
            }
        }
    }
}
