import jserver.XSendAdapter;

public class Stein {

    private static int objektZaehler = 0;
    private static int farbe;
    private int x;
    private int y;
    private String form = "c";
    private static boolean benutzbar = true;

    Stein(int x, int y, int farbe) {
        this.x = x;
        this.y = y;
        this.form = form;
        this.farbe = farbe;
        objektZaehler++;
    }

    public static int getAnzahlObjekte() {
        return objektZaehler;
    }

    public static int getFarbe() {
        if (istGerade()) {
            return farbe = XSendAdapter.BLACK;
        } else {
            return farbe = XSendAdapter.WHITE;
        }
    }

    public static boolean istGerade() {
        return objektZaehler % 2 == 1;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getForm() {
        return this.form;
    }

    public static boolean isBenutzbar() {
        return benutzbar;
    }

    public static void setBenutzbar(boolean benutzbar) {
        Stein.benutzbar = benutzbar;
    }

}
