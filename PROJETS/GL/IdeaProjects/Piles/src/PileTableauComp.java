import java.util.Arrays;

public class PileTableauComp implements Pile<Comparable> {

    private Comparable [] elements ;  // les éléments contenus dans la pile
    private int nbElem = 0 ; // le nombre d’éléments dans la pile
    private String nom ;     // nom de la pile : information supplémentaire propre à PileTableau

    public String getNom() {
        return nom;
    }

    public PileTableauComp(){
        elements = new Comparable[MAX_ELEMENTS];
    }

    public PileTableauComp(String nom){
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
    public boolean peutEmpiler(Comparable x) {
        return !this.pleine();
    }

    @Override
    public Comparable sommet() {
        return elements[nbElem-1];
    }

    @Override
    public Comparable depile() {
        nbElem--;
        Comparable e = elements[nbElem];
        elements[nbElem] = null;
        return e;
    }

    @Override
    public void empile(Comparable x) {
        nbElem++;
        elements[nbElem - 1] = x;
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
    public void deplacerUnElementVers(Pile<Comparable> p) {
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

    public void trier(){
        Comparable[] tmp = (Comparable[]) Arrays.copyOfRange(elements, 0, nbElem);
        Arrays.sort(tmp);
        this.vider();
        for(int i = 0; i < tmp.length; i++) {
            elements[i] = tmp[i];
        }
    }
}
