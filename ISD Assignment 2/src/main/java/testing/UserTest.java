package testing;

import iotb.model.User;
import junit.framework.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alaw8
 */
public class UserTest {

    private User user;

    public UserTest() {
        user = new User(1, "JUnit", "Testing", "Junittesting@gmail.com", "1234", "0432324089");
    }

    @Test
    public void testgetUserID() {
        int userid = user.getUserID();
        assertEquals(1, userid);
    }
    
    @Test
    public void testsetUserID() {
        user.setUserID(2);
        int userid = user.getUserID();
        assertEquals(2, userid);
    }
    
    @Test
    public void testgetfName() {
        String fname = user.getfName();
        assertEquals("JUnit", fname);
    }
    
    @Test
    public void testsetfName() {
        user.setfName("Test");
        String fname = user.getfName();
        assertEquals("Test", fname);
    }
    
    @Test
    public void testgetlName() {
        String fname = user.getlName();
        assertEquals("Testing", fname);
    }
    
    @Test
    public void testsetlName() {
        user.setfName("Test");
        String lname = user.getlName();
        assertEquals("Test", lname);
    }
    
    @Test
    public void testgetemail() {
        String email = user.getEmailAddress();
        assertEquals("Junittesting@gmail.com", email);
    }
    
    @Test
    public void testsetemail() {
        user.setEmailAddress("test@gmail.com");
        String email = user.getEmailAddress();
        assertEquals("test@gmail.com", email);
    }
    @Test
    public void testgetpw() {
        String password = user.getPassword();
        assertEquals("1234", password);
    }
    
    @Test
    public void testsetpw() {
        user.setPassword("Test");
        String pw = user.getPassword();
        assertEquals("Test", pw);
    }
    @Test
    public void testgetphnumber() {
        String ph = user.getPhNumber();
        assertEquals("Testing", ph);
    }
    
    @Test
    public void testsetphnumber() {
        user.setPhNumber("0123456789");
        String ph = user.getPhNumber();
        assertEquals("0123456789", ph);
    }
}