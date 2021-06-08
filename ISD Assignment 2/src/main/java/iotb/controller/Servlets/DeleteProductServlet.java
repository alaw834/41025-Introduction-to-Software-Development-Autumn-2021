package iotb.controller.Servlets;

import iotb.controller.ProductValidator;
import iotb.model.Product;
import iotb.model.dao.ProductManager;
import java.io.IOException;
import java.io.PrintWriter;
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
public class DeleteProductServlet extends HttpServlet {

    private ProductManager productmanager
;   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        String id = request.getParameter("productID");       
        
        productmanager = (ProductManager)session.getAttribute("productManager");
        
        ProductValidator validator = new ProductValidator();
        validator.clear(session);

        if (!validator.validateProductID(id)) {
            session.setAttribute("productIDErr", "Product ID Incorrect"); 
            request.getRequestDispatcher("removeproduct.jsp").include(request, response);   
        } else { 
        try{
            Product exist = productmanager.readProduct(Integer.parseInt(id));       
            if (exist == null){
                    session.setAttribute("existErr", "Product Does Not Exist!");
                    request.getRequestDispatcher("removeproduct.jsp").include(request, response);
            }else{
                productmanager.deleteProduct(Integer.parseInt(id));
                request.getRequestDispatcher("catalogue.jsp").include(request, response);
                }
            }catch (SQLException | NullPointerException ex) {
                System.out.println(ex.getMessage() == null ? "Product does not exist" : "welcome");
                Logger.getLogger(DeleteProductServlet.class.getName()).log(Level.SEVERE, null, ex);
                request.getRequestDispatcher("removeproduct.jsp").include(request, response);
            }
        }
    }
}

