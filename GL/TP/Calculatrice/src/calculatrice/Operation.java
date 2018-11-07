package calculatrice;

public enum Operation {
    PLUS("+"), MOINS("-"), FOIS("*"), DIV("/"), PUISS("^") ;
    private final String code_operation;

    Operation(String code_operation){
        this.code_operation = code_operation;
    }

    public String getCode_operation(){
        return this.code_operation;
    }

    public String toString(){
        String res = "";
        return res += this.code_operation;
    }

    public double eval(double x, double y){
        double result = 0;
        switch(code_operation){
            case "+":
                result = x + y;
                break;
            case "-":
                result = x - y;
                break;
            case "*":
                result = x * y;
                break;
            case "/":
                result = x / y;
                break;
            case "^":
                result = Math.pow(x, y);
                break;
        }
        return result;
    }
}
