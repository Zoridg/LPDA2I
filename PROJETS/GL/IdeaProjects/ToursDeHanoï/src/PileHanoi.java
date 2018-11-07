public class PileHanoi implements Pile<DisqueHanoi> {

    private Affichage algoAffichage = new AffichageSimple();
    private int nbElement;
    private DisqueHanoi[] tabDisque;
    private String nomPile;

    public PileHanoi(String nomPile, Affichage a){
        tabDisque = new DisqueHanoi[10];
        nbElement = 0;
        algoAffichage = a;
        this.nomPile = nomPile;
    }

    @Override
    public boolean vide() {
        return (nbElement == 0);
    }

    @Override
    public boolean pleine() {
        return (tabDisque.length == nbElement);
    }

    @Override
    public boolean peutEmpiler(DisqueHanoi x) {
        if (x == null){
            return false;
        }
        return nbElement == 0 || x.diametre() < tabDisque[nbElement - 1].diametre();
    }

    @Override
    public DisqueHanoi sommet() {
        return (nbElement == 0) ? null : tabDisque[nbElement - 1];
    }

    @Override
    public DisqueHanoi depile() {
        if (nbElement == 0){
            return null;
        }
        else {
            DisqueHanoi temp = this.sommet();
            tabDisque[nbElement - 1] = null;
            nbElement--;
            return temp;
        }
    }

    @Override
    public void empile(DisqueHanoi x) {
        if (x != null){
            if (nbElement == 0){
                tabDisque[nbElement] = x;
            }
            else if (x.diametre() < this.sommet().diametre()){
                tabDisque[nbElement] = x;
            }
        }
        nbElement++;
    }

    @Override
    public void vider() {
        if (nbElement != 0){
            for (int i = nbElement; i > 0; i--){
                this.depile();
            }
        }
        else {
            System.out.println("Pile vide");
        }
    }

    @Override
    public int nbElements() {
        return nbElement;
    }

    @Override
    public void deplacerUnElementVers(Pile<DisqueHanoi> p) {
        if (p.peutEmpiler(this.sommet())){
            p.empile(this.depile());
        }
    }

    public String toString(){
        Disque [] lesDisques = tabDisque;
        return nomPile + " : " + algoAffichage.affichage_tableau(lesDisques, nbElement);
    }

    public void deplacerDesDisques(int n, Pile dest, Pile interm) {
        if (n == 0) return;
        this.deplacerDesDisques(n-1, interm, dest);
        System.out.println("Déplacement de " + n + " disques de " + this + " vers " + dest);
        this.deplacerUnElementVers(dest);
        ((PileHanoi)interm).deplacerDesDisques(n-1, dest, this);
    }

    public static void resoudreAuto(PileHanoi a, PileHanoi b, PileHanoi c) {
        a.deplacerDesDisques(a.nbElement, b,c);
    }
}
