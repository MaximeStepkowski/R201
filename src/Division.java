public class Division extends Operation{
    public Division(Expression op1, Expression op2){
        super(op1,op2);
        if(op2.valeur() == 0) {
            throw new ArithmeticException("Division par zéro interdite !");
        }
    }

    @Override
    public double valeur() {
        return getOperande1().valeur() / getOperande2().valeur();
    }

    @Override
    public String toString(){
        return "(" + getOperande1() + " / " + getOperande2() + ")";
    }
}
