package cz.czechitas.ukol3;

public class Pocitac {

    private boolean jeZapnuty;
    private Procesor cpu;
    private Pamet ram;
    private Disk pevnyDisk;


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
            System.out.println("Počítač je zapnutý.");
            jeZapnuty = true;
        }

    }

    public void vypniSe () {
        if (jeZapnuty) {
            System.out.println("Počítač je vypnutý.");
            jeZapnuty = false;
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
