
import jserver.Board;
import jserver.BoardClickEvent;
import jserver.XSend;
import jserver.XSendAdapter;
import plotter.Graphic;

import java.util.ArrayList;

public class FuenfInEinerReihe {
    private int spielfeldGroesse = 15;

    private ArrayList<Stein> schwarz = new ArrayList<>();
    private ArrayList<Stein> weiss = new ArrayList<>();






    private Board board = new Board();
    private XSendAdapter xsend = new XSendAdapter(board);
    private Graphic graphic;



    public static void main(String[] args) {
        (new FuenfInEinerReihe()).start();

    }
    public void start() {
        spielfeldAufsetzen();


    }

    public void spielfeldAufsetzen(){
        board.addClickListener(this::boardClick);



        xsend.groesse(spielfeldGroesse, spielfeldGroesse);
        xsend.rahmen(XSend.BLACK);
    }

    public void setzeStein(int xSpieler, int ySpieler){

        wechsel();
        xsend.farbe2(xSpieler, ySpieler, Stein.bestimmeFarbe());



    }

    public void wechsel(){
        Stein stein = new Stein();
        if(Stein.istGerade()){
            schwarz.add(stein);
        }else {
            weiss.add(stein);

        }

    }


    private void boardClick(BoardClickEvent mouseclick) {

        int deltaX = mouseclick.getX() ;
        int deltaY = mouseclick.getY() ;
        setzeStein(deltaX, deltaY);



    }

}
