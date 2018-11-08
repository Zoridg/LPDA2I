package calculatrice2;

import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class Calculatrice {

    Stack<Double> resultat;
    HashMap<String, Operation> operations;

    public Calculatrice(){
        resultat = new Stack<>();
        operations = new HashMap<>();
        for(Operation o : Operation.values()){
            operations.put(o.getCode_operation(), o);
        }
    }

    public double calculer(String s) throws CalculatriceException {
        StringTokenizer st = new StringTokenizer(s);
        while(st.hasMoreTokens()){
            String element = st.nextToken();
            if(operations.containsKey(element)) {
                Operation o =  operations.get(element);
                double [] operandes = new double[o.getArite()];
                for(int i = 0; i < o.getArite(); i++) {
                    operandes[i] = resultat.pop();
                }
                double result = o.eval(operandes);
                resultat.add(result);
            }
            else {
                resultat.add(new Double(element));
            }
        }
        if(resultat.size() == 1){
            return resultat.pop();
        }
        else {
            throw new CalculatriceException("Pas bon");
        }
    }
}
