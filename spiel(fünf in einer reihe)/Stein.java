import jserver.XSendAdapter;

public class Stein {

    private static int objektZaehler = 0;
    private static boolean benutzbar = true;
    private String form = "c";
    private int farbe = XSendAdapter.GRAY;
    private int x;
    private int y;

    Stein(int x, int y) {
        this.x = x;
        this.y = y;
        objektZaehler++;
    }

    public static int getAnzahlObjekte() {
        return objektZaehler;
    }

    public static boolean istGerade() {
        return objektZaehler % 2 == 1;
    }

    public static boolean istBenutzbar() {
        return benutzbar;
    }

    public static void setBenutzbar(boolean benutzbar) {
        Stein.benutzbar = benutzbar;
    }

    public int getFarbe() {
        return this.farbe;
    }

    public void setFarbe() {
        if (istGerade()) {
            this.farbe = XSendAdapter.BLACK;
        } else {
            this.farbe = XSendAdapter.WHITE;
        }

    }

    public String getForm() {
        return this.form;
    }

}
