public class Multiplication extends Operation{
    public Multiplication(Nombre op1,Nombre op2){
        super(op1,op2);
    }

    @Override
    public int valeur() {
        return getOperande1().valeur() * getOperande2().valeur();
    }

    @Override
    public String toString(){
        return "(" + getOperande1() + " * " + getOperande2() + ")";
    }
}
