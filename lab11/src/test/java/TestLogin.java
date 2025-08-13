import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import com.security.Security;


public class TestLogin {
    
    @Test
	public void testLoginEmptyUserId() {
        String userId = "", password = "Freddy99";
        Security security = new Security();
        boolean actual = security.login(userId, password);
        boolean expected = false;
        assertEquals(expected, actual);
        // assertFalse(actual);   // can also use this assert
    }

    @Test
	public void testLoginWhitespaceUserId() {
        String userId = "  ", password = "Freddy99";
        Security security = new Security();
        boolean actual = security.login(userId, password);
        boolean expected = false;
        assertEquals(expected, actual);
        // assertFalse(actual);   // can also use this assert
        
    }

    @Test
	public void testLoginEmptyUserIdAndPassword() {
        String userId = "", password = "";
        Security security = new Security();
        boolean actual = security.login(userId, password);
        boolean expected = false;
        assertEquals(expected, actual);
        // assertFalse(actual);   // can also use this assert
    }

    @Test
	public void testLoginEmptyPassword() {
        String userId = "Tom", password = "";
        Security security = new Security();
        boolean actual = security.login(userId, password);
        boolean expected = false;
        assertEquals(expected, actual);
        // assertFalse(actual);   // can also use this assert
    }

    @Test
	public void testLoginWhitespacePassword() {
        String userId = "Tom", password = "  ";
        Security security = new Security();
        boolean actual = security.login(userId, password);
        boolean expected = false;
        assertEquals(expected, actual);
        // assertFalse(actual);   // can also use this assert
    }

    @Test
	public void testLoginWithUserIdAndShortPassword() {
        String userId = "Tom", password = "Pass";
        Security security = new Security();
        boolean actual = security.login(userId, password);
        boolean expected = false;
        assertEquals(expected, actual);
        // assertFalse(actual);   // can also use this assert
    }

    @Test
	public void testLoginWithUserIdAndLowerCasePass() {
        String userId = "Tom", password = "passwordfffff";
        Security security = new Security();
        boolean actual = security.login(userId, password);
        boolean expected = false;
        assertEquals(expected, actual);
        // assertFalse(actual);   // can also use this assert
    }

    @Test
	public void testLoginWithUserIdAndValidPassword() {
        String userId = "Tom", password = "Password1234!";
        Security security = new Security();
        boolean actual = security.login(userId, password);
        assertTrue(actual);
    }

}
