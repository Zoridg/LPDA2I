/**
 * Classe Date 
 *
 */
public class Date
{
    /** attribut jour */
    // les attributs des instances
    private int jour, mois, annee ;
    /** attribut mois */
    // les attributs de la classe
    public static final String [] NOM_DES_MOIS_F =
    { "Janvier", "Fevrier", "Mars", "Avril", "Mai", "Juin", "Juillet",
      "Aout", "Septembre", "Octobre", "Novembre", "Decembre" } ;

    public static final String [] NOM_DES_MOIS_A =
    { "January", "February", "March", "April", "May", "June", "July",
      "August", "September", "October", "November", "December" } ;
    /** Constructeur de la classe Date */
    
    public Date(int jour, int mois, int annee)
    {
        this.jour = jour ;
        this.mois = mois ;
        this.annee = annee ;
    }

    /** Surcharge de toString */
    public String toString(int l)
    {
	String result = "";
	if(l == 1){
	    result += jour + " " + NOM_DES_MOIS_F[mois-1];
	}
	else{
	    result += jour + " " + NOM_DES_MOIS_A[mois-1];
	}
	
        return result + " " +  annee ;
    }
    

    /** Méthode main : Exécution du programme */
    public static void main(String [] arg)
    {
	System.out.println("Entrez un jour");
	int j = Clavier.readInt();
	System.out.println("Entrez un mois");
	int m = Clavier.readInt();
	System.out.println("Entrez une année");
	int a = Clavier.readInt();
	Date d = new Date(j, m, a);
	switch(arg[0]){
	case "-anglais" : System.out.println(d.toString(0));
	    break;
	case "-français" : System.out.println(d.toString(1));
	    break;
	}
    }
    
}
