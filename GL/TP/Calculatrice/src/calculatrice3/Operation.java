package calculatrice3;

import java.util.Stack;

public enum Operation {
    PLUS("+", 2), MOINS("-", 2), FOIS("*", 2), DIV("/", 2), PUISS("^", 2), SQRT("V", 1), ABS("ABS", 1), NOT("NOT", 1), IF("IF", 3), DROP("DROP"), DUP("DUP"), SWAP("SWAP"), COUNT("COUNT");
    private final String code_operation;
    private final int arite;

    Operation(String code_operation, int arite){
        this.code_operation = code_operation;
        this.arite = arite;
    }

    Operation(String code_operation) {
        this.code_operation = code_operation;
        this.arite = 0;
    }

    public String getCode_operation(){
        return this.code_operation;
    }

    public String toString(){
        String res = "";
        return res += this.code_operation;
    }

    public int getArite() {
        return arite;
    }

    public double eval(double [] operandes) {
        double result = 0;
        switch(code_operation){
            case "+":
                result = operandes[0] + operandes[1];
                break;
            case "-":
                result = operandes[0] - operandes[1];
                break;
            case "*":
                result = operandes[0] * operandes[1];
                break;
            case "/":
                if(operandes[1] > 0){
                    result = operandes[0] / operandes [1];
                }
                break;
            case "^":
                result = Math.pow(operandes[0], operandes[1]);
                break;
            case "V":
                result = Math.sqrt(operandes[0]);
                break;
            case "ABS":
                result = Math.abs(operandes[0]);
                break;
            case "NOT":
                result = (operandes[0] == 0) ? 1 : 0;
                break;
            case "IF":
                result = (operandes[0] == 0) ? operandes[1] : operandes[2];
                break;
            default:
                System.out.println("Wrong");
        }
        return result;
    }

    public void execute(Stack<Double> pile){
        if(arite != 0){
            double [] operandes = new double[arite];
            for(int i = 0; i < getArite(); i++){
                operandes[i] = pile.pop();
            }
            pile.add(eval(operandes));
        }
        else {
            switch(this.code_operation){
                case "DROP":
                    pile.pop();
                    break;
                case "DUP":
                    double sommet = pile.peek();
                    pile.push(sommet);
                    break;
                case "SWAP":
                    double sommet1 = pile.pop();
                    double sommet2 = pile.pop();
                    pile.push(sommet1);
                    pile.push(sommet2);
                    break;
                case "COUNT":
                    double size = pile.size();
                    pile.push(size);
                    break;
                default:
                    System.out.println("Wrong");
            }
        }
    }
}
