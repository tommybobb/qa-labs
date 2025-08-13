import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

import com.security.Security;


public class TestLogin {

    private Security security;

    @Before
    public void setUp() {
        security = new Security();
    }

    @Test
	public void testLoginEmptyUserId() {
        String userId = "", password = "Freddy99";
        boolean actual = security.login(userId, password);
        boolean expected = false;
        assertEquals(expected, actual);
        // assertFalse(actual);   // can also use this assert
    }

    @Test
	public void testLoginWhitespaceUserId() {
        String userId = "  ", password = "Freddy99";
        boolean actual = security.login(userId, password);
        boolean expected = false;
        assertEquals(expected, actual);
        // assertFalse(actual);   // can also use this assert
        
    }

    @Test
	public void testLoginEmptyUserIdAndPassword() {
        String userId = "", password = "";
        boolean actual = security.login(userId, password);
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
	public void testLoginEmptyPassword() {
        String userId = "Tom", password = "";
        boolean actual = security.login(userId, password);
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
	public void testLoginWhitespacePassword() {
        String userId = "Tom", password = "  ";
        boolean actual = security.login(userId, password);
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
	public void testLoginWithUserIdAndShortPassword() {
        String userId = "Tom", password = "Pass";


        assertThrows(IllegalArgumentException.class, () -> {
            security.login(userId, password);
        });
    }

    @Test
	public void testLoginWithUserIdAndLowerCasePass() {
        String userId = "Tom", password = "passwordfffff";
        
        
        assertThrows(IllegalArgumentException.class, () -> {
            security.login(userId, password);
        });
    }

    @Test
	public void testLoginWithUserIdAndValidPassword() {
        String userId = "Tom", password = "Password1234!";
        boolean actual = security.login(userId, password);
        assertTrue(actual);
    }

}
