public class Addition extends Operation{
    public Addition(Nombre op1,Nombre op2){
        super(op1,op2);
    }

    @Override
    public int valeur() {
        return getOperande1().valeur() + getOperande2().valeur();
    }

    @Override
    public String toString(){
        return "(" + getOperande1() + " + " + getOperande2() + ")";
    }
}
