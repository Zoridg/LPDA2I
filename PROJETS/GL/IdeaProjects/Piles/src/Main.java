public class Main {
    public static int a = 6;
    public static int b = 366;
    public static int n = 367;

    public static void main(String args[]){
        /* PileTableau<String> pileString = new PileTableau<>( "pileString");
        PileTableau<Integer> pileInteger = new PileTableau<>( "pileInteger");
        PileTableau<Rationnel> pileRationnels = new PileTableau<>( "pileRationnels");

        pileString.empile("Wesh");
        pileString.empile("Bonjour");
        pileString.empile("CAVA");
        pileString.empile("William");

        pileInteger.empile(256);
        pileInteger.empile(512);
        pileInteger.empile(1024);
        pileInteger.empile(2048);

        pileRationnels.empile(new Rationnel(1,4));
        pileRationnels.empile(new Rationnel(2,3));
        pileRationnels.empile(new Rationnel(7,5));

        PileTableau<Comparable> pileCompare = new PileTableau<>("pileComparable"); */

        int result = (int) algo();
        System.out.println(result);
    }

    public static int algo(){
        int r = 1;
        int s = a;
        int k = b;
        while(k != 0){
            if(k%2 == 0){
                r = (r * s)%n;
            }
            s = s^2%n;
            k = k / 2;
        }
        return r;
    }
}
