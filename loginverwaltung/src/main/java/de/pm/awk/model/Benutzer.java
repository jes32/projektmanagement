package de.pm.awk.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "benutzer")
public class Benutzer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "benutzernrSeq")
    @SequenceGenerator(name = "benutzernrSeq", sequenceName = "benutzernrSeq", allocationSize = 1)
    private long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String passwort;

    private int fehlversuche = 0;
    private boolean gesperrt = false;

    public Benutzer() {
    }

    public Benutzer(String username, String passwort) {
        this.username = username;
        this.passwort = passwort;
    }

    // Getter & Setter
    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswort() {
        return passwort;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }

    public int getFehlversuche() {
        return fehlversuche;
    }

    public void setFehlversuche(int fehlversuche) {
        this.fehlversuche = fehlversuche;
    }

    public boolean isGesperrt() {
        return gesperrt;
    }

    public void setGesperrt(boolean gesperrt) {
        this.gesperrt = gesperrt;
    }

    
}
