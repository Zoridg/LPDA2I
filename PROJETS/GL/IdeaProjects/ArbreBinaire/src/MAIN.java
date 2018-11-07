public class MAIN {

    public static void main(String[] args) {

        if(args.length != 0){
            NoeudArbre question = new NoeudArbre(args[0], new NoeudArbre(args[1]), new NoeudArbre(args[2]));
            question.rechercherAnimal();
        }
        else {
            NoeudArbre racine = new NoeudArbre("Est-ce un mammifère ?",new NoeudArbre("un crocodile" +
                    ""), new NoeudArbre("Est-ce qu’il aboie ?", new NoeudArbre("un cheval"), new NoeudArbre("un chien")));
            racine.rechercherAnimal();
        }
    }
}
