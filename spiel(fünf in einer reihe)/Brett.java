import jserver.Board;
import jserver.BoardClickEvent;
import jserver.XSend;
import jserver.XSendAdapter;

public class Brett {
    private int spielfeldGroesse = 15;
    private Board board = new Board();
    private XSendAdapter xsend = new XSendAdapter(board);
    private Stein[][] spielfeld = new Stein[spielfeldGroesse][spielfeldGroesse];

    public void spielfeldAufsetzen() {
        xsend.groesse(spielfeldGroesse, spielfeldGroesse);
        xsend.rahmen(XSend.BLACK);
        for (int i = 0; i <= (spielfeldGroesse * spielfeldGroesse); i++) {
            xsend.hintergrund(i, XSendAdapter.SANDYBROWN);
        }
        xsend.formen("s");
        xsend.farben(XSend.NAVAJOWHITE);
        xsend.symbolGroessen(0.4);
        board.addClickListener(this::boardClick);

    }

    public void setzeStein(int xSpieler, int ySpieler, Stein stein) {
        if (Stein.istBenutzbar()) {
            if (spielfeld[xSpieler][ySpieler] == null) {
                spielfeld[xSpieler][ySpieler] = stein;
                xsend.farbe2(xSpieler, ySpieler, stein.getFarbe());
                xsend.form2(xSpieler, ySpieler, stein.getForm());
                if (pruefeGewinn(xSpieler, ySpieler, stein)) {
                    xsend.statusText("Spieler " + (Stein.istGerade() ? "Schwarz" : "Weiß") + " gewinnt!");
                    Stein.setBenutzbar(false);
                } else if (Stein.getAnzahlObjekte() == spielfeldGroesse * spielfeldGroesse) {
                    xsend.statusText("Das Spiel endet unentschieden.");
                }
            }
        }

    }

    private boolean pruefeGewinn(int x, int y, Stein stein) {
        int farbe = stein.getFarbe();
        return (pruefeRichtung(x, y, 1, 0, farbe) || // horizontal
                pruefeRichtung(x, y, 0, 1, farbe) || // vertikal
                pruefeRichtung(x, y, 1, 1, farbe) || // diagonal rechts
                pruefeRichtung(x, y, 1, -1, farbe));  // diagonal links
    }

    private boolean pruefeRichtung(int x, int y, int dx, int dy, int farbe) {
        int count = 1;
        for (int i = 1; i < 5; i++) {
            int neuX = x + i * dx;
            int neuY = y + i * dy;
            if (neuX >= 0 && neuY >= 0 && neuX < spielfeldGroesse && neuY < spielfeldGroesse && spielfeld[neuX][neuY] != null && spielfeld[neuX][neuY].getFarbe() == farbe) {
                count++;
            } else {
                break;
            }
        }
        for (int i = 1; i < 5; i++) {
            int neuX = x - i * dx;
            int neuY = y - i * dy;
            if (neuX >= 0 && neuY >= 0 && neuX < spielfeldGroesse && neuY < spielfeldGroesse && spielfeld[neuX][neuY] != null && spielfeld[neuX][neuY].getFarbe() == farbe) {
                count++;
            } else {
                break;
            }
        }
        return count >= 5;
    }

    private void boardClick(BoardClickEvent mausklick) {
        if (Stein.istBenutzbar()) {
            int deltaX = mausklick.getX();
            int deltaY = mausklick.getY();
            if (spielfeld[deltaX][deltaY] == null) {
                Stein stein = new Stein(deltaX, deltaY);
                stein.setFarbe();
                setzeStein(deltaX, deltaY, stein);
            }
        }

    }

}
