public class Rationnel {
    private int e;
    private int n;
    private int d;

    public Rationnel(int e, int n, int d){
        this.n = n;
        this.e = e;
        this.d = d;
        this.reduction();
    }

    public Rationnel(int n, int d){
        this.n = n;
        this.d = d;
        this.reduction();
    }

    public Rationnel(int e){
        this.e = e;
    }

    public String toString(){
        if (n >= 10 && d >= 10){
            return "    " + n + "\n" + e + " + —— \n" + "    " + d;
        }
        return "     " + n + "\n" + e + " + —— \n" + "     " + d;

    }

    public Boolean estNul(){
        if(e == 0 && n == 0){
            return true;
        }
        return false;
    }

    public Rationnel entierToFrac(){
        Rationnel r = this;
        r.n = r.e * r.d + r.n;
        r.e = 0;

        return r;
    }

    public Rationnel inverse(){
        Rationnel r = this;
        int tmp = r.e * r.d + r.n;
        r.n = r.d;
        r.d = tmp;

        return r.reduction();
    }

    public Rationnel ajouter(Rationnel r){
        Rationnel t = this.entierToFrac();
        Rationnel p = r.entierToFrac();

        t.n = t.n * p.d;
        int tmpTD = t.d * p.d;

        p.n = p.n * t.d;
        p.d = p.d * t.d;

        t.d = tmpTD;

        Rationnel res = new Rationnel(t.n + p.n, t.d);
        return res.reduction();
    }

    public Rationnel multiplier(Rationnel r){
        Rationnel t = this.entierToFrac();
        Rationnel p = r.entierToFrac();

        t.n = t.n * p.n;
        t.d = t.d * p.d;

        return t.reduction();
    }

    public int compareTo(Rationnel r){
        Rationnel t = this.entierToFrac();
        Rationnel p = r.entierToFrac();

        double r1 = (double) t.e + (double) t.n + (double) t.d;
        double r2 = (double) p.e + (double) p.n + (double) p.d;
        if(r2 > r1) return -1;
        if(r2 < r1) return 1;
        return 0;

    }

    public Rationnel reduction(){
        Rationnel r = this;

        if (r.n > r.d){
            r.e = r.n / r.d;
            r.n = r.n % r.d;
        }
        else {
            r.e = 0;
        }

        while(r.pgcd(r.n, r.d) != 1){
            int div = r.pgcd(r.n, r.d);
            r.n = r.n / div;
            r.d = r.d / div;
        }
        return r;
    }

    public int pgcd(int nbr1, int nbr2){
        if(nbr2 == 0){
            return nbr1;
        }
        return pgcd(nbr2, nbr1%nbr2);
    }
}
