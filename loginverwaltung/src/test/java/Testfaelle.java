import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.pm.awk.model.Benutzer;
import de.pm.awk.usecase.impl.Loginverwaltung;

public class Testfaelle {
    

 private Loginverwaltung dao;

    @BeforeEach
    public void setUp() {
        dao = new Loginverwaltung();
    }
 @Test
    public void testLoginErfolgreich() {

        String username = "user" + System.nanoTime();
        String passwort = "1234";

        dao.registrieren(username, passwort);

        Benutzer result = dao.login(username, passwort);

        assertNotNull(result, "Login sollte erfolgreich sein");
        assertEquals(username, result.getUsername());
    }

    // @Test
    // public void testLoginFalschesPasswort() {

    //     String username = "user_" + System.nanoTime();
    //     String passwort = "1234";

    //     dao.registrieren(username, passwort);

    //     Benutzer result = dao.login(username, "falsch");

    //     assertNull(result, "Login sollte mit falschem Passwort fehlschlagen");
    // }

    // @Test
    // public void testLoginUnbekannterBenutzer() {

    //     Benutzer result = dao.login("unbekannt_" + System.nanoTime(), "1234");

    //     assertNull(result, "Login sollte für unbekannten Benutzer fehlschlagen");
    // }

    // @Test
    // public void testRegistrierungUndLoginMehrereBenutzer() {

    //     String user1 = "user1_" + System.nanoTime();
    //     String user2 = "user2_" + System.nanoTime();

    //     dao.registrieren(user1, "pass1");
    //     dao.registrieren(user2, "pass2");

    //     Benutzer r1 = dao.login(user1, "pass1");
    //     Benutzer r2 = dao.login(user2, "pass2");

    //     assertNotNull(r1);
    //     assertNotNull(r2);

    //     assertEquals(user1, r1.getUsername());
    //     assertEquals(user2, r2.getUsername());

    //     assertNull(dao.login(user1, "wrong"));
    // }
}
