public class PileTableau<E> implements Pile<E> {

    private E [] elements ;  // les éléments contenus dans la pile
    private int nbElem = 0 ; // le nombre d’éléments dans la pile
    private String nom ;     // nom de la pile : information supplémentaire propre à PileTableau

    public String getNom() {
        return nom;
    }

    public PileTableau(){
        elements = (E[]) new Object[MAX_ELEMENTS];
    }

    public PileTableau(String nom){
        this();
        this.nom = nom;
    }

    @Override
    public boolean vide() {
        return elements.length == 0;
    }

    @Override
    public boolean pleine() {
        return nbElem == MAX_ELEMENTS;
    }

    @Override
    public boolean peutEmpiler(E x) {
        return !this.pleine();
    }

    @Override
    public E sommet() {
        return elements[nbElem-1];
    }

    @Override
    public E depile() {
        nbElem--;
        E e = elements[nbElem];
        elements[nbElem] = null;
        return e;
    }

    @Override
    public void empile(E x) {
        nbElem++;
        elements[nbElem-1] = x;
    }

    @Override
    public void vider() {
        while(nbElem != 0){
            this.depile();
        }
    }

    @Override
    public int nbElements() {
        return nbElem;
    }

    /**
     * Déplace un élément de l'instance courante vers une autre pile
     * @param p
     *
     * NB : Le getteur doit être implémenté dans l'interface Pile<E>
     * Sinon on ne peut pas récupérer le nom de la pile d'arrivée
     */

    @Override
    public void deplacerUnElementVers(Pile<E> p) {
        p.empile(this.depile());
        System.out.println("Pile de départ : " + this.nom);
        System.out.println("Pile d'arrivée : " + p.getNom());
    }

    public String toString(){
        String res = " ";
        for(int i = 0; i < elements.length; i++){
            res += elements[i] + " | ";
        }
        return res;
    }
}
