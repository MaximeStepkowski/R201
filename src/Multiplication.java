public class Multiplication extends Operation{
    public Multiplication(Expression op1,Expression op2){
        super(op1,op2);
    }

    @Override
    public double valeur() {
        return getOperande1().valeur() * getOperande2().valeur();
    }

    @Override
    public String toString(){
        return "(" + getOperande1() + " * " + getOperande2() + ")";
    }
}
