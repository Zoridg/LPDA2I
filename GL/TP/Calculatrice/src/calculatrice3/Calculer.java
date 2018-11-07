package calculatrice3;

public class Calculer {
    public static void main(String [] args) {
        Calculatrice c = new Calculatrice() ;
        for (int i=0; i<args.length; i++) {
            try {
                System.out.println(args[i] + " = " + c.calculer(args[i])) ;
            } catch (CalculatriceException e) {
                e.printStackTrace();
            }
        }
//        try {
//
//	    } catch (CalculatriceException e) {
//            System.out.println(e.getMessage()) ;
//	    }
    }
}
