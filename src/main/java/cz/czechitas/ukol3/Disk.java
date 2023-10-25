package cz.czechitas.ukol3;

public class Disk {

    private long kapacita;
    private long vyuziteMisto;

    private final String nazevDisku;

    public String getNazevDisku() {
        return nazevDisku;
    }

    public long getKapacita() {
        return kapacita;
    }

    public void setKapacita(long kapacita) {
        this.kapacita = kapacita;
    }

    public long getVyuziteMisto() {
        return vyuziteMisto;
    }

    public void setVyuziteMisto(long vyuziteMisto) {
        this.vyuziteMisto = vyuziteMisto;
    }
    public Disk(String nazevDisku) {
        this(0L, nazevDisku);

    }
    public Disk(long kapacita, String nazevDisku) {
        this(kapacita, 0L, nazevDisku);

    }

    public Disk(long kapacita, long vyuziteMisto, String nazevDisku) {
        this.kapacita = kapacita;
        this.vyuziteMisto = vyuziteMisto;
        this.nazevDisku = nazevDisku;
    }

    public boolean vlozSoubor(long velikost) {


        if (vyuziteMisto + velikost < kapacita) {
            vyuziteMisto = vyuziteMisto + velikost;

            return true;
        }
            return false;

    }

    public boolean odstranSoubor(long velikost) {
        if (vyuziteMisto < velikost) {

            velikost = vyuziteMisto;

        } else {

            vyuziteMisto = vyuziteMisto - velikost;

            return true;


        }
        return false;
    }

    @Override
    public String toString() {
        return "Dísk: " + nazevDisku + " má kapacitu: " + kapacita + " bajtů, využité místo: " + vyuziteMisto + " bajtů.";
    }
}