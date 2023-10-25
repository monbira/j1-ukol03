package cz.czechitas.ukol3;

public class Pocitac {
    private boolean jeZapnuty;
    private Procesor cpu;
    private Pamet ram;
    private Disk pevnyDisk;
    private Disk externiDisk;


    public Pocitac() {

    }



    public void setPevnyDisk(Disk pevnyDisk) {
        this.pevnyDisk = pevnyDisk;
    }
    public Disk getPevnyDisk() {
        return pevnyDisk;
    }

    public void setExterniDisk(Disk externiDisk) {
        this.externiDisk = externiDisk;
    }

    public Disk getExterniDisk() {
        return externiDisk;
    }

    public void setCpu(Procesor cpu) {
        this.cpu = cpu;
    }
    public Procesor getCpu() {
        return cpu;
    }

    public void setRam(Pamet ram) {
        this.ram = ram;
    }

    public Pamet getRam() {
        return ram;
    }

    public boolean isJeZapnuty() {
        return jeZapnuty;
    }
    public void setJeZapnuty(boolean jeZapnuty) {
        this.jeZapnuty = jeZapnuty;
    }

    public void zapniSe() {
        if (jeZapnuty) {
            System.err.println("PC je již zapnutý. Není možné jej zapnout opakovaně. ");
        } else if (cpu == null) {
            System.err.println("PC nemá procesor. Není možné jej zapnout!");
        } else if (ram == null) {
            System.err.println("PC nemá operační paměť. Není možné jej zapnout!");
        } else if (pevnyDisk == null) {
            System.err.println("PC nemá pevný disk. Není možné jej zapnout!");
        } else {
            jeZapnuty = true;
            System.out.println("PC se zapnul.");
        }
    }

    public void vypniSe() {
        if (jeZapnuty) {
            jeZapnuty = false;
            System.out.println("PC se vypnul.");
        } else {
            System.out.println("PC je již vypnutý.");
        }
    }

    public void vytvorSouborOVelikosti(long velikost) {
        if (!jeZapnuty) {
            System.err.println("PC je vypnutý. Není možné vytvářet nové soubory!");
            return;
        }

        if (!pevnyDisk.vlozSoubor(velikost)) {
            if (!externiDisk.vlozSoubor(velikost)) {
                System.err.println("Není dostatečná kapacita na pevném ani externím disku.");
            } else {
                System.out.println("Data byla uložena na externí disk.");
            }

        } else {
            System.out.println("Data byla uložena na pevný disk.");
        }
    }

    public void vymazSouboryOVelikosti(long velikost) {
        if (!jeZapnuty) {
            System.err.println("PC je vypnutý. Není možné vytvářet nové soubory!");
            return;
        }
        if (!pevnyDisk.odstranSoubor(velikost)) {
            if (!externiDisk.odstranSoubor(velikost)) {
                System.err.println("Ani z jednoho z disků není možné odstranit soubor o požadované velikosti. ");
            } else {
                System.out.println("Soubor o velikosti " + velikost + " bajtů byl odstraněn z externího disku.");
            }
        } else {
            System.out.println("Soubor o velikosti " + velikost + " bajtů byl odstraněn z pevného disku. ");
        }
    }
    //pevnyDisk.odstranSoubor(velikost);



    @Override
    public String toString() {
        String vypis;
        if (jeZapnuty) {
            vypis = "PC je zapnutý. ";
        } else {
            vypis = "PC je vypnutý. ";
        }

        return vypis + '\n' + "Informace o PC: " + '\n' +
                getInfoCpu() + getInfoRam() + getInfoDisk();
    }

    private String getInfoCpu() {
        if (cpu != null) {
            return cpu.toString() + '\n';
        }
        return "PC neobsahuje procesor. \n";
    }

    private String getInfoRam() {
        if (ram != null) {
            return ram.toString() + '\n';
        }
        return "PC neobsahuje paměť. \n";
    }

    private String getInfoDisk() {
        if (pevnyDisk != null) {
            return pevnyDisk.toString() + '\n';
        }
        return "PC neobsahuje pevný disk. \n";
    }

}