public class AffichageSimple implements Affichage {
    /**
     * Méthode construisant une chaîne qui correspond à la façon dont
     * on veut afficher les n premiers éléments du tableau de disques
     *
     * @param d
     * @param n
     */
    @Override
    public String affichage_tableau(Disque[] d, int n) {
        String res = "";
        for(int i = 0; i < n; i++){
            if(d[i] != null) {
                res += " " + d[i];
            }
        }
        return res;
    }
}
