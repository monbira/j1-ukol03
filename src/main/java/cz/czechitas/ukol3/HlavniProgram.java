package cz.czechitas.ukol3;

/**
 * Spouštěcí třída celého programu
 */
public class HlavniProgram {

    public static void main(String... args) {

            Pocitac monikyPocitac;
            monikyPocitac = new Pocitac();
            System.out.println(monikyPocitac.toString());


            Procesor monikyProcesor = new Procesor();
            monikyProcesor.setRychlost(2_000_000_000_000L);
            monikyProcesor.setVyrobce("Intel");

            Pamet monikyPamet = new Pamet();
            monikyPamet.setKapacita(3_450_000_000L);

            Disk monikyDisk = new Disk();
            monikyDisk.setKapacita(450_000_000_000L);

            monikyPocitac.setCpu(monikyProcesor);
            monikyPocitac.setRam(monikyPamet);
            monikyPocitac.setPevnyDisk(monikyDisk);

            System.out.println(monikyPocitac.toString());

            monikyPocitac.zapniSe();

            System.out.println(monikyPocitac.toString());

            monikyPocitac.vypniSe();

        }

        System.out.println("Program spuštěn.");
    }


