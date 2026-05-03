package de.pm.awk.usecase.impl;

import de.pm.awk.model.Benutzer;

import de.pm.awk.usecase.ILoginverwaltung;

public class Loginverwaltung extends GenericDAO<Benutzer> implements ILoginverwaltung {

    public Loginverwaltung() {
        super(Benutzer.class);
    }

    public void registrieren(String username, String passwort) {

        // Eingabeprüfung (erste Validierung)
        if (username == null || username.isBlank()) {
            throw new IllegalArgumentException("Username darf nicht leer sein");
        }

        if (passwort == null || passwort.isBlank()) {
            throw new IllegalArgumentException("Passwort darf nicht leer sein");
        }


        if (!username.matches("[a-zA-Z0-9]+")) {

            throw new IllegalArgumentException("Username ungültig (Keine Sonderzeichen)");
        }

        // Prüfen, ob der Benutzername schon vergeben ist
        Benutzer exists = findByUsername(username);
        if (exists != null) {
            throw new IllegalArgumentException("Benutzer existiert bereits");
        }

        // Benutzer erstellen
        Benutzer benutzer = new Benutzer();
        benutzer.setUsername(username);
        benutzer.setPasswort(passwort);

        super.save(benutzer);
    }

    public Benutzer login(String username, String passwort) {

   
    // Eingabeprüfung
    if (username == null || username.isBlank()) {
        return null;
    }

    if (passwort == null || passwort.isBlank()) {
        return null;
    }

    // Benutzer laden
    Benutzer benutzer = findByUsername(username);

    if (benutzer == null) {
        return null;
    }

    // Sperrprüfung
    if (benutzer.isGesperrt()) {
        return null;
    }

    // Passwort falsch
    if (!benutzer.getPasswort().equals(passwort)) {

        benutzer.setFehlversuche(benutzer.getFehlversuche() + 1);

        // Sperren nach 3 Versuchen
        if (benutzer.getFehlversuche() >= 3) {
            benutzer.setGesperrt(true);
        }

        update(benutzer);
        return null;
    }

    // Login erfolgreich → reset
    benutzer.setFehlversuche(0);
    update(benutzer);

    return benutzer;

    }

    public Benutzer findByUsername(String username) {

        try {
            return em.createQuery(
                    "SELECT b FROM Benutzer b WHERE b.username = :username",
                    Benutzer.class)
                    .setParameter("username", username)
                    .getSingleResult();

        } catch (Exception e) {
            return null;
        }
    }

}
