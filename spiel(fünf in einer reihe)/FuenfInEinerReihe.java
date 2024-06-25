public class FuenfInEinerReihe {
    private Brett brett = new Brett();

    public static void main(String[] args) {
        (new FuenfInEinerReihe()).start();

    }

    public void start() {
        brett.spielfeldAufsetzen();
    }
}
