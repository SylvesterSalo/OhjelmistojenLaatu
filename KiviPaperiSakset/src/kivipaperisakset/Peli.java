package kivipaperisakset;

/**
 *
 * @author Ira Dook
 */
public class Peli {

    public static void main(String args[]) {
        Pelaaja p1 = new Pelaaja();
        Pelaaja p2 = new Pelaaja();
        boolean peliLoppui = false;
        int pelatutPelit = 0;
        int tasapelit = 0;
        String p1Valinta;
        String p2Valinta;
        
        String p1Voitto = "\nPelaaja 1 voittaa";
        String p2Voitto = "\nPelaaja 2 voittaa";
       
        do {
            System.out.println("Erä: " + pelatutPelit + " =====================\n");
            System.out.println("Tasapelien lukumäärä: " + tasapelit + "\n");
            
            p1Valinta = p1.pelaajanValinta();
            System.out.println("Pelaaja 1: " + p1Valinta + "\n\t Pelaaja 1:llä koossa " + p1.getVoitot() + " voittoa.");
            
            p2Valinta = p2.pelaajanValinta();
            System.out.println("Pelaaja 2: " + p2Valinta + "\n\t Pelaaja 2:lla koossa " + p2.getVoitot() + " voittoa.");
            
          
            //Pelaajan 1 voittotilanteet
            if ((p1Valinta.equals("sakset")) && (p2Valinta.equals("paperi"))) {
            	p1.incrementVoitot();
                System.out.println(p1Voitto);
               
            } else if ((p1Valinta.equals("paperi")) && (p2Valinta.equals("kivi"))) {
                p1.incrementVoitot();
                System.out.println(p1Voitto);
                
            } else if ((p1Valinta.equals("kivi")) && (p2Valinta.equals("sakset"))) {
                p1.incrementVoitot();
                System.out.println(p1Voitto);
                
                //Pelaajan 2 voittotilanteet
            } else if ((p1Valinta.equals("sakset")) && (p2Valinta.equals("kivi"))) {
                p2.incrementVoitot();
                System.out.println(p2Voitto);
                
            }  else if ((p1Valinta.equals("paperi")) && (p2Valinta.equals("sakset"))) {
            	p2.incrementVoitot();
            	System.out.println(p2Voitto);
            	
            } else if ((p1Valinta.equals("kivi")) && (p2Valinta.equals("paperi"))) {
            	p2.incrementVoitot();
            	System.out.println(p2Voitto);
            }
            
            
            //Tasapeli
            if (p1Valinta.equals(p2Valinta)) {
                tasapelit++;
                System.out.println("\nTasapeli");
            }
            
            pelatutPelit++;
            
            if ((p1.getVoitot() >= 3) || (p2.getVoitot() >= 3)) {
                peliLoppui = true;
                System.out.println("\nKOLME VOITTOA - PELI PÄÄTTYY");
            }
        } while (!peliLoppui);
    }

}
