import java.util.Scanner;

/**
 * <b>NoeudArbre est la classe permettant de générer un arbre binaire de String</b>
 * <p>
 *     Un NoeaudArbre est caractérisé par les informations suivantes ;
 *     <ul>
 *         <li>Le nom du noeud</li>
 *         <li>Un NoeudArbre droit</li>
 *         <li>Un NoeauArbre gauche</li>
 *         <li>Un NoeudArbre pere</li>
 *     </ul>
 * </p>
 */

public class NoeudArbre {

    private Scanner sc = new Scanner(System.in);
    private String nomNoeud;
    private NoeudArbre droit;
    private NoeudArbre gauche;
    private NoeudArbre pere;

    /**
     * <b>Constructeur de la classe NoeudArbre</b>
     *
     * @param nomNoeud
     * nom du Noeud
     */
    public NoeudArbre(String nomNoeud) {
        this.nomNoeud = nomNoeud;
    }

    /**
     * <b>Getteur du NoeudArbre droit</b>
     *
     * @return
     * une instance de NoeudArbre
     */
    public NoeudArbre getDroit() {
        return droit;
    }


    /**
     * <b>Setteur du NoeudArbre droit</b>
     *
     * @param droit
     * un NoeudArbre
     */
    public void setDroit(NoeudArbre droit) {
        this.droit = droit;
    }

    /**
     * <b>Getteur du NoeudArbre gauche</b>
     *
     * @return
     * une instance de NoeudArbre
     */

    public NoeudArbre getGauche() {
        return gauche;
    }

    /**
     * <b>Setteur du NoeudArbre gauche</b>
     *
     * @param gauche
     * une instance de NoeudArbre
     */
    public void setGauche(NoeudArbre gauche) {
        this.gauche = gauche;
    }

    /**
     * <b>Constructeur à trois paramètres</b>
     *
     * @param nomNoeud
     * le nom du Noeud
     * @param gauche
     * une instance de NoeudArbre
     * @param droit
     * une instance de NoeudArbre
     */
    public NoeudArbre(String nomNoeud, NoeudArbre gauche, NoeudArbre droit) {
        this.nomNoeud = nomNoeud;
        this.droit = droit;
        this.gauche = gauche;
        this.gauche.pere = this;
        this.droit.pere = this;
    }

    /**
     * <b>Setteur du père de l'instance courante</b>
     *
     * @param pere
     * une isntance de NoeudArbre
     */
    public void setPere(NoeudArbre pere) {
        this.pere = pere;
    }

    /**
     * <b>Surcharge de la méthode toString afin d'afficher le NoeudArbre</b>
     *
     * @return
     * un chaine de caractère représentant le NoeudArbre
     */
    public String toString(){
        String result = "\"" + nomNoeud + "\"";
        if (gauche != null){
            result += " " + gauche.toString() + " ";
        }
        if (droit != null){
            result += " " + droit.toString() + " ";
        }
        return result;
    }

    /**
     * <b>Méthode permettant de rechercher un animal en posant des questions à l'utilisateur</b>
     *
     * @see NoeudArbre#rejouer()
     */
    public void rechercherAnimal(){
        if(gauche != null){
            System.out.println(nomNoeud);
            String reponse = sc.nextLine();
            if(reponse.equals("oui")){
                droit.rechercherAnimal();
            }
            else if(reponse.equals("non")){
                gauche.rechercherAnimal();
            }
            else{
                System.out.println("Pas la bonne réponse");
            }
        }
        else {
            System.out.println(nomNoeud + "?");
            String reponseF = sc.nextLine();
            if(reponseF.equals("non")){
                this.apprendre();
            }
            else if(reponseF.equals("oui")){
                System.out.println("J'AI TROUVE ! YES =)");
            }
        }
        System.out.println("Veux-tu rejouer ?");
        String fin = sc.nextLine();
        if(fin.equals("oui")){
            this.rejouer();
        }
        else{
            System.out.println("Au revoir");
        }
    }

    /**
     * <b>Méthode permettant au programme d'apprendre des nouvelles questions et réponses et de les placer dans l'arbre</b>
     *
     * @see NoeudArbre#rechercherAnimal()
     */

    public void apprendre(){
        System.out.println("Qu'est-ce que c'est ?");
        String rep = sc.nextLine();
        System.out.println(rep + "! Je ne connais pas cet animal. Donnez-moi une question qui permette de différencier " + rep + " de " + nomNoeud);
        String question = sc.nextLine();
        System.out.println("Quelle doit être la réponse pour " + rep + "?");
        String mot = sc.nextLine();

        if(mot.equals("oui")){
            this.droit = new NoeudArbre(rep);
            this.gauche = new NoeudArbre(nomNoeud);
            this.droit.pere = this;
            this.gauche.pere = this;
        }
        else {
            this.droit = new NoeudArbre(nomNoeud);
            this.gauche = new NoeudArbre(rep);
            this.droit.pere = this;
            this.gauche.pere = this;
        }
        this.nomNoeud = question;
    }

    /**
     * <b>Methode permettant de demander à l'utilisateur s'il veut rejouer</b>
     *
     * @see NoeudArbre#rechercherAnimal()
     * @see NoeudArbre#apprendre()
     *
     */
    public void rejouer(){
        if (this.pere != null){
            pere.rejouer();
        }
        else {
            this.rechercherAnimal();
        }
    }
}
