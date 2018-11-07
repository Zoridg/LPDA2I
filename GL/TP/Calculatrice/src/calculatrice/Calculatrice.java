package calculatrice;

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
                double x = resultat.pop();
                double y = resultat.pop();
                double result = operations.get(element).eval(x, y);
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
