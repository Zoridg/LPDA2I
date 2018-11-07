package Dictionnaire;

import java.util.Iterator;

public class DictIterator<K> implements Iterator<K> {

    TabDict<K,?> dict;
    int nb = 0;
    int pos=0;

    public DictIterator(TabDict<K, ?> tab) {
        dict = tab;
    }
    @Override
    public boolean hasNext() {
        if (nb == dict.nbElements()) return false;
        return true;
    }

    @Override
    public K next() {
        if(hasNext()) {
            do {
                pos++;
            } while(dict.clefPourIndex(pos)==null);
            nb++;
            return dict.clefPourIndex(pos);
        }
        return null;
    }

    public void remove() {
        dict.remove(pos);
        nb--;
    }
}