package cz.czechitas.ukol3;

/**
 * Spouštěcí třída celého programu
 */
public class HlavniProgram {

    public static void main(String... args) {

        Procesor appleM1 = new Procesor();
        appleM1.setVyrobce("Apple");
        appleM1.setRychlost(3_200_000_000L);

        Pamet operacniPamet = new Pamet();
        operacniPamet.setKapacita(16_000_000_000L);

        Disk ssd = new Disk();
        ssd.setKapacita(245_110_000_000L);
        ssd.setVyuziteMisto(68_400_000_000L);

        Disk ssd2 = new Disk();
        ssd2.setKapacita(245_110_000_000L);
        ssd2.setVyuziteMisto(0L);

        System.out.println(appleM1.toString());
        System.out.println(operacniPamet.toString());
        System.out.println(ssd.toString());

        Pocitac moniccinPocitac = new Pocitac();
        moniccinPocitac.setCpu(appleM1);
        moniccinPocitac.setRam(operacniPamet);
        moniccinPocitac.setPevnyDisk(ssd);
        moniccinPocitac.setDruhyDisk(ssd2);
        moniccinPocitac.zapniSe();
        moniccinPocitac.vytvorSouborOVelikosti(245_110_000_000L);
        System.out.println(moniccinPocitac.toString());
        moniccinPocitac.vypniSe();
    }

}
