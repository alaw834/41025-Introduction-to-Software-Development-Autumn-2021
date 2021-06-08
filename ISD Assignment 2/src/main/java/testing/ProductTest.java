package testing;

import iotb.model.Product;
import junit.framework.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alaw8
 */
public class ProductTest {

    private Product product;

    public ProductTest() {
        product = new Product(1, "Dell Monitor", "Testing", "Monitors", (float) 15.6, 5);
    }

    @Test
    public void testgetUserID() {
        int userid = product.getProductID();
        assertEquals(1, userid);
    }
    
    @Test
    public void testsetUserID() {
        product.setProductID(2);
        int userid = product.getProductID();
        assertEquals(2, userid);
    }
    
    @Test
    public void testgetProductDescription() {
        String productDescription = product.getProductDescription();
        assertEquals("JUnit", productDescription);
    }
    
    @Test
    public void testsetProductDescription() {
        product.setProductDescription("Test");
        String productDescription = product.getProductDescription();
        assertEquals("Test", productDescription);
    }
    
    @Test
    public void testgetProductCategory() {
        String ProductCategory = product.getProductCategory();
        assertEquals("Testing", ProductCategory);
    }
    
    @Test
    public void testsetProductCategory() {
        product.setProductCategory("Test");
        String productCategory = product.getProductCategory();
        assertEquals("Test", productCategory);
    }
    
    @Test
    public void testgetProductPrice() {
        float ProductPrice = product.getProductPrice();
        assertEquals(70.6, ProductPrice);
    }
    
    @Test
    public void testsetProductPrice() {
        product.setProductPrice((float) 50.21);
        float productPrice = product.getProductPrice();
        assertEquals(99.4, productPrice);
    }
    @Test
    public void testgetProductStock() {
        int productStock = product.getProductStock();
        assertEquals(5990, productStock);
    }
    
    @Test
    public void testsetpw() {
        product.setProductStock(67);
        int productStock = product.getProductStock();
        assertEquals(600, productStock);
    }
}