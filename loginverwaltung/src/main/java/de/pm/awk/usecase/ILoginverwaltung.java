package de.pm.awk.usecase;

import de.pm.awk.model.Benutzer;

public interface ILoginverwaltung {
    
     Benutzer login(String username, String passwort);
     void registrieren( String username, String passwort);
     Benutzer findByUsername(String username);
}
