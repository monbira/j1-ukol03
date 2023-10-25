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
            monikyProcesor.setRychlost(2_800_000_000L);
            monikyProcesor.setVyrobce("Intel");

            Pamet monikyPamet = new Pamet();
            monikyPamet.setKapacita(16_000_000_000L);

            Disk monikyDisk = new Disk(1_000_000_000_000L, 291_000_000_000L, "jedna - pevný disk");
            //monikyDisk.setKapacita(450_000_000_000L);

            Disk extDisk = new Disk(3_000_000_000_000L, "dvě - externí disk");

            monikyPocitac.setCpu(monikyProcesor);
            monikyPocitac.setRam(monikyPamet);
            monikyPocitac.setPevnyDisk(monikyDisk);
            monikyPocitac.setExterniDisk(extDisk);

            System.out.println(monikyPocitac.toString());

            monikyPocitac.zapniSe();
            monikyPocitac.zapniSe();

            System.out.println(monikyPocitac.toString());

            monikyPocitac.vypniSe();

            monikyPocitac.zapniSe();

            monikyPocitac.vytvorSouborOVelikosti(333_000L);


            monikyPocitac.vypniSe();

            monikyPocitac.vytvorSouborOVelikosti(200_000L);


            monikyPocitac.zapniSe();

            monikyPocitac.vytvorSouborOVelikosti(300_000L);

            monikyPocitac.vymazSouboryOVelikosti(300_000L);


            monikyPocitac.vytvorSouborOVelikosti(2_500_000_000_000L);
            monikyPocitac.vymazSouboryOVelikosti(2_500_000_000_000L);
    }

}
