package de.pm.menue;

import de.pm.awk.usecase.ILoginverwaltung;
import de.pm.awk.usecase.impl.Loginverwaltung;

public class HauptmenueService {

    private static ILoginverwaltung loginverwaltung;

    public HauptmenueService() {
        loginverwaltung = new Loginverwaltung();
    }

    public static ILoginverwaltung getLoginverwaltung() {
        return loginverwaltung;
    }
}