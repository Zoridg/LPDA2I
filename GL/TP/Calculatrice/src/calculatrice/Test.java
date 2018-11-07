package calculatrice;

public class Test {
    public static void main(String [] args) {
        if (args.length < 2) 
            System.err.println("Au moins deux nombres sur la ligne de commande !") ;
        else {
            // deux nombres passés sur la ligne de commande
            double x = new Double(args[0]) ;
            double y = new Double(args[2]) ;
            // la liste des opérations disponibles
            for(Operation o : Operation.values()){
                if(o.getCode_operation().equals(args[1])){
                    System.out.println(x + " " + args[1] + " " + y + " = " + o.eval(x,y)) ;
                }
            }
        }
    }
}
