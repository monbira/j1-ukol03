package cz.czechitas.ukol3;

public class Pocitac {

    private boolean jeZapnuty;
    private Procesor cpu;
    private Pamet ram;
    private Disk pevnyDisk;
    private Disk druhyDisk;


    public Procesor getCpu() {
        return cpu;
    }

    public void setCpu(Procesor cpu) {
        this.cpu = cpu;
    }

    public Pamet getRam() {
        return ram;
    }

    public void setRam(Pamet ram) {
        this.ram = ram;
    }

    public Disk getPevnyDisk() {
        return pevnyDisk;
    }

    public void setPevnyDisk(Disk pevnyDisk) {
        this.pevnyDisk = pevnyDisk;
    }

    public Disk getDruhyDisk() {
        return druhyDisk;
    }

    public void setDruhyDisk(Disk druhyDisk) {
        this.druhyDisk = druhyDisk;
    }

    public boolean jeZapnuty() {
        return jeZapnuty;
    }

    public void zapniSe () {
        if (cpu == null || ram == null || pevnyDisk == null) {
            System.err.println("Počítač nemá všechny komponenty.");
            return;
        }

        if (jeZapnuty) {
            System.err.println("Počítač je už zapnutý.");
        } else {
            jeZapnuty = true;
            System.out.println("Počítač je zapnutý.");
        }

    }

    public void vypniSe () {
        if (jeZapnuty) {
            jeZapnuty = false;
            System.out.println("Počítač je vypnutý.");
        }
    }

    public void vytvorSouborOVelikosti (long velikost) {

        long noveVyuziteMisto = velikost + pevnyDisk.getVyuziteMisto();
        long mistoNaDruhemDisku = velikost + druhyDisk.getVyuziteMisto();

        if (!jeZapnuty) {
            System.err.println("Počítač je vypnutý, nelze vkládat soubory na disk.");
        } else if (noveVyuziteMisto <= pevnyDisk.getKapacita()) {
            pevnyDisk.setVyuziteMisto(noveVyuziteMisto);
            System.out.println("Počítač má nové využité místo: " + noveVyuziteMisto + ".");
        } else if (noveVyuziteMisto > pevnyDisk.getKapacita() && mistoNaDruhemDisku <= druhyDisk.getKapacita()) {
            druhyDisk.setVyuziteMisto(mistoNaDruhemDisku);
            System.out.println("Počítač použil k uložení drhý disk a má nové využité místo: " + mistoNaDruhemDisku + ".");
        } else {
            System.err.println("Soubor nelze vložit, došla kapacita.");
        }
    }

    public void vymazSouborOVelikosti (long velikost) {

        long noveVyuziteMisto = pevnyDisk.getVyuziteMisto() - velikost;

        if (!jeZapnuty) {
            System.err.println("Počítač je vypnutý, nelze mazat soubory z disku.");
        } else if (noveVyuziteMisto >= 0) {
            pevnyDisk.setVyuziteMisto(noveVyuziteMisto);
            System.out.println("Počítač má nové využité místo: " + noveVyuziteMisto + ".");
        } else {
            System.err.println("Soubor nelze smazat, převyšuje kapacitu.");
        }
    }

    @Override
    public String toString() {
        if (jeZapnuty) {
            return "Počítač je zapnutý." + cpu + ram + pevnyDisk;
        } else {
            return "Počítač je vypnutý." + cpu + ram + pevnyDisk;
        }
    }
}
