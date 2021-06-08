package testing;

import iotb.model.Payment;
import iotb.model.User;
import junit.framework.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alaw8
 */
public class PaymentTest {

    private Payment payment;

    public PaymentTest() {
        payment = new Payment("1", "2", "2", "2022-06-07");
    }

    @Test
    public void testgetPaymentID() {
        String paymentid = payment.getPaymentID();
        assertEquals("1", paymentid);
    }

    @Test
    public void testsetPaymentID() {
        payment.setPaymentID("2");
        String paymentID = payment.getPaymentID();
        assertEquals("2", paymentID);
    }

    @Test
    public void testgetPaymentType() {
        String paymentType = payment.getPaymentType();
        assertEquals("2", paymentType);
    }

    @Test
    public void testsetPaymentType() {
        payment.setPaymentType("1");
        String paymentType = payment.getPaymentType();
        assertEquals("Test", paymentType);
    }

    @Test
    public void testgetOrderID() {
        String orderID = payment.getOrderID();
        assertEquals("2", orderID);
    }

    @Test
    public void testsetOrderID() {
        payment.setOrderID("3");
        String orderID = payment.getOrderID();
        assertEquals("3", orderID);
    }

    @Test
    public void testgetPaymentDate() {
        String paymentDate = payment.getPaymentDate();
        assertEquals("2022-06-07", paymentDate);
    }

    @Test
    public void testsetPaymentDate() {
        payment.setPaymentDate("2022-09-10");
        String paymentDate = payment.getPaymentDate();
        assertEquals("2022-09-10", paymentDate);
    }

}