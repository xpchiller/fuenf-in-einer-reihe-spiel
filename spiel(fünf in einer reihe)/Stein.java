import jserver.XSendAdapter;

public class Stein {
    int x;
    int y;
    private String form = "c";


    //Um Später herauszufinden ob Stein Schwarz oder Weiß ist
    private static int objektZaehler = 0;



    private boolean active = true;



    Stein(){
        bestimmeFarbe();
        objektZaehler++;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int neuX){
        this.x = neuX;
    }

    public void setY(int neuY){
        this.y = neuY;
    }

    public static int getAnzahlObjekte() {
        return objektZaehler;
    }

    public static int bestimmeFarbe(){
        if(istGerade()){
            return XSendAdapter.BLACK;
        }else{
            return XSendAdapter.WHITE;
        }
    }

    public static boolean istGerade(){
        return objektZaehler % 2 == 1;
    }


        public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }






}
