public class Rationnel implements Comparable<Rationnel>{
    private int p;
    private int q;

    public Rationnel(int p, int q){
        this.p = p;
        this.q = q;
    }

    @Override
    public int compareTo(Rationnel r){
        return (int) (this.getValue() -r.getValue());
    }

    public double getValue(){
        return (double) p / (double) q;
    }

    public String toString(){
        return p + "/" + q;
    }
}