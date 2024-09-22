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
        if (cpu != null && ram != null && pevnyDisk != null) {
            System.out.println("Počítač je zapnutý.");
        } else {
            System.err.println("Počítač nemá všechny komponenty.");
        }
        if (jeZapnuty) {
            System.err.println("Počítač je už zapnutý.");
        }
    }

    public void vypniSe () {

    }

    @Override
    public String toString() {
        if (jeZapnuty) {
            return "Počítač je zapnutý" + ", cpu: " + cpu + ", ram: " + ram +
                    ", pevný disk:" + pevnyDisk + ".";
        }
        return "Počítač je vypnutý" + ", cpu: " + cpu + ", ram: " + ram +
                ", pevný disk:" + pevnyDisk + ".";
    }
}
