package Dictionnaire;

import java.util.Iterator;

/** ICI les commentaires sur le fonctionnement de la classe */
public class TabDict<K,V> implements  Dictionnaire<K,V>, Iterable<K>
{
    private static final int INIT_SIZE = 100 ;       // taille initiale du tableau
    private Couple<K,V> [] associations ;            // tableau contenant les associations
    private int nbAssoc ;	// nombre d'elements effectivement presents dans le dictionnaire

    /** Crée une instance de dictionnaire vide */
    public TabDict() {
        nbAssoc = 0 ;
        associations = (Couple<K,V>[]) new Couple[INIT_SIZE] ;
    }

    // redimensionnement automatique du tableau en une taille double
    private void resize() {
        Couple<K,V> [] newTab = (Couple<K,V>[]) new Couple[associations.length * 2];
        for (int i = 0; i < associations.length; i++){
            newTab[i] = associations[i];
        }
        associations = newTab;
    }

    // ajoute une association à la première position libre (après avoir 
    // redimensionné le tableau si nécessaire)
    private void add(Couple<K,V> assoc) {
        nbAssoc++;
        if(nbAssoc - 1 == associations.length) {
            this.resize();
            associations[nbAssoc - 1] = assoc;
        }
        else{
            for(int i = 0; i < associations.length; i++){
                if(associations[i] == null){
                    associations[i] = assoc;
                    return;
                }
            }
        }
    }

    // enlève l'association à l'indice spécifié
    public void remove(int index) {
        nbAssoc--;
        associations[index] = null;
    }

    // indice de l'association assoc ; -1 si elle est absente 
    private int indexOf(Couple<K,V> assoc) {
        for(int i = 0; i < associations.length; i++){
            if(associations[i].equals(assoc)){
                return i;
            }
        }
        return -1;
    }

    // indice de l'association de clef c ; -1 si elle est absente
    private int indexOfClef(K c) {
        for(int i = 0; i < associations.length; i++){
            if(associations[i].premier().equals(c)){
                return i;
            }
        }
        return -1;
    }

    // méthode nécessaire pour l'itérateur :
    // retourne la clef située à l'indice i, null si i incorrect
    public K clefPourIndex(int i) {
        return associations[i].premier();
    }

    public String toString(){
        String result = "";
        for (Couple<K, V> association : associations) {
            if(association != null){
                result += association.premier() + " --> " + association.second() + " \n";
            }
        }
        return result;
    }

    @Override
    public boolean estVide() {
        return nbAssoc == 0;
    }

    @Override
    public boolean contient(Couple<K, V> assoc) {
        return (indexOf(assoc) != -1);
    }

    @Override
    public boolean contientClef(K c) {
        return (indexOfClef(c) != -1);
    }

    @Override
    public boolean contientValeur(V v) {
        for(int i = 0; i < associations.length; i++){
            if(associations[i].second().equals(v)){
                return true;
            }
        }
        return false;
    }

    @Override
    public int nbElements() {
        return nbAssoc;
    }

    @Override
    public Couple<K, V> assocPour(K c) {
        for(int i = 0; i < associations.length; i++){
            if(associations[i].premier().equals(c)){
                return associations[i];
            }
        }
        return null;
    }

    @Override
    public V valeurPour(K c) {
        return assocPour(c).second();
    }

    @Override
    public void ajouter(Couple<K, V> assoc) {
        add(assoc);
    }

    @Override
    public void ajouter(K c, V v) {
        Couple<K,V> tmp = new CoupleObj<K,V>(c, v);
        add(tmp);
    }

    @Override
    public void enlever(Couple<K, V> assoc) {
        remove(indexOf(assoc));
    }

    @Override
    public void enleverPour(K c) {
        remove(indexOfClef(c));
    }

     /** IMPLÉMENTATION DE L'INTERFACE Dictionnaire


     IMPLÉMENTATION DE L'INTERFACE Iterable (2e partie du TP)
     Itérateur permettant de parcourir les clefs (et d'en supprimer) */
     public Iterator<K> iterator() {
         return new DictIterator<K>(this);
     }
}