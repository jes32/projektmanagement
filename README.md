## Sprints


## Sprint 1 – Grundstruktur & Architektur
**Ziel:** Aufbau der Grundarchitektur und Projektstruktur

### Aufgaben:
- Maven Multi-Module Projekt eingerichtet
- Module erstellt:
  - loginverwaltung
  - appgui
  - handwerkerapp (Parent)
- JavaFX Grundsetup konfiguriert
- ScreensController implementiert (Basis für Screen-Wechsel)
- Initiale Struktur für FXML Navigation erstellt

### Ergebnis:
- Projekt läuft grundsätzlich
- Screens können registriert werden
- Grundgerüst für UI Navigation vorhanden

---

## Sprint 2 – Login & Registrierung
**Ziel:** Benutzeranmeldung und Registrierung funktional machen

### Aufgaben:
- Loginverwaltung implementiert
- Registrierung von Benutzern
- Passwort- und Username-Validierung
- Speicherung von Benutzerobjekten
- Login-Logik mit Fehlversuchs- und Sperrmechanismus
- Unit Tests für Login erstellt

### Ergebnis:
- Benutzer können sich registrieren
- Login funktioniert mit Validierung
- Fehlversuche werden gezählt und Benutzer können gesperrt werden
- Tests sichern Grundfunktionalität

---

## Sprint 3 – Screensystem & Session Handling
**Ziel:** Navigation zwischen Screens + Benutzer-Session

### Aufgaben:
- FXML Screens korrekt über Classpath geladen
- ScreensController mit Map für Screens & Controller erweitert
- CurrentUser im ScreensController eingeführt
- Login setzt aktuellen Benutzer
- Logout Funktion implementiert
- Fehlerbehebung bei FXMLLoader / Ressourcenpfaden

### Ergebnis:
- Navigation zwischen Login, Registrierung und Hauptmenü funktioniert
- Benutzer wird nach Login gespeichert
- Logout setzt Session zurück
- Screens werden korrekt geladen aus JAR

---

## Sprint 4 – Hauptmenü & UI Integration
**Ziel:** Hauptmenü mit Benutzeranzeige und Navigation

### Aufgaben:
- Hauptmenü-FXML erstellt und strukturiert
- Benutzeranzeige im Menü implementiert („Willkommen + Username“)
- Logout Button integriert
- UI Layout verbessert (Buttons, Labels strukturiert)
- Vorbereitung für weitere Module (Kunde, Auftrag, Ressource)

### Ergebnis:
- Hauptmenü zeigt eingeloggten Benutzer
- Logout führt zurück zum Login Screen
- UI ist strukturiert und erweiterbar
- Grundsystem für Business-Module vorhanden