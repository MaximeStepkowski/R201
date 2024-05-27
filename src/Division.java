public class Division extends Operation{
    public Division(Nombre op1,Nombre op2){
        super(op1,op2);
        if(op2.valeur() == 0) {
            throw new ArithmeticException("Division par zéro interdite !");
        }
    }

    @Override
    public int valeur() {
        return getOperande1().valeur() / getOperande2().valeur();
    }

    @Override
    public String toString(){
        return "(" + getOperande1() + " / " + getOperande2() + ")";
    }
}
