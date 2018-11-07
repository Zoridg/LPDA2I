package Dictionnaire;

public class CoupleObj<K,V> implements Couple {

    Object k;
    Object v;

    public CoupleObj(K k, V v){
        this.k = k;
        this.v = v;
    }

    @Override
    public Object premier() {
        return k;
    }

    @Override
    public Object second() {
        return v;
    }

    @Override
    public void defPremier(Object o) {
        this.k = o;
    }

    @Override
    public void defSecond(Object o) {
        this.v = o;
    }
}
