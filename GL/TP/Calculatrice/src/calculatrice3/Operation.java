package calculatrice3;

import java.util.Stack;

public enum Operation {
    PLUS("+", 2), MOINS("-", 2), FOIS("*", 2), DIV("/", 2), PUISS("^", 2), SQRT("V", 1), ABS("ABS", 1), NOT("NOT", 1), IF("IF", 3), DROP(), DUP(), SWAP(), COUNT();
    private final String code_operation;
    private final int arite;

    Operation(String code_operation, int arite){
        this.code_operation = code_operation;
        this.arite = arite;
    }

    Operation(){
        this.code_operation = code();
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

    public String code(){
        String result = "";
        switch(this){
            case DROP:
                result = "DROP";
                break;
            case DUP:
                result = "DUP";
                break;
            case SWAP:
                result = "SWAP";
                break;
            case COUNT:
                result = "COUNT";
                break;
        }
        return result;
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
        }
        return result;
    }

    public void execute(Stack<Double> pile){
        if(arite != 0){
            Double tab[] = new Double[arite];
            for(int i = 0; i < getArite(); i++){
                double operande = pile.pop();
                tab[i] = operande;
                pile.add(operande);
            }
        }
        else {
            switch(code()){
                case "DROP":

            }
        }
    }
}
