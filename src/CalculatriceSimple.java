public class CalculatriceSimple{
    public static void main(String[] args){
        Nombre huit = new Nombre(8);
        Nombre deux = new Nombre(2);
        Nombre quatre = new Nombre(4);
        Nombre zero = new Nombre(0);

        System.out.println("Division :");
        Operation s1 = new Division(huit,deux);
        Operation s2 = new Division(huit,quatre);

        try{
            Operation s3 = new Division(quatre,zero); //doit afficher : Division par zero interdite !
        }
        catch (ArithmeticException e){
            System.out.println(e);
        }

        System.out.println(s1 + "=" + s1.valeur()); //doit afficher : (8 / 2) = 4
        System.out.println(s2 + "=" + s2.valeur()); //doit afficher : (8 / 4) = 2

        System.out.println("Addition :");
        Operation t1 = new Addition(huit,deux);
        Operation t2 = new Addition(quatre,zero);

        System.out.println(t1 + "=" + t1.valeur()); //doit afficher : (8 + 2) = 10
        System.out.println(t2 + "=" + t2.valeur()); //doit afficher : (4 + 0) = 4

        System.out.println("Soustraction :");
        Operation a1 = new Soustraction(huit,deux);
        Operation a2 = new Soustraction(zero,quatre);

        System.out.println(a1 + "=" + a1.valeur()); //doit afficher : (8 - 2) = 6
        System.out.println(a2 + "=" + a2.valeur()); //doit afficher : (0 - 4) = -4

        System.out.println("Multiplication :");
        Operation x1 = new Multiplication(huit,deux);
        Operation x2 = new Multiplication(zero,quatre);

        System.out.println(x1 + "=" + x1.valeur()); //doit afficher : (8 * 2) = 16
        System.out.println(x2 + "=" + x2.valeur()); //doit afficher : (0 - 4) = 0

        Expression trois = new Nombre(3) ;
        Expression dixSept = new Nombre(17) ;
        Expression s = new Soustraction(dixSept, deux) ;
        Expression a = new Addition(deux, trois) ;
        Expression d = new Division(s, a) ;
        System.out.println(d + " = " + d.valeur()) ; // affiche ((17 - 2) / (2 + 3)) = 3
    }

    public static Expression fabriqueExpression(String e) {
    
        e = e.replaceAll("\\s", "");
    
        if (e.matches("\\d+")) {
            return new Nombre(Integer.parseInt(e));
        }
        
        longueur=e.length();

        for (int i = longueur - 1; i >= 0; i--) {
            char lettre = e.charAt(i);

            if (c == '+' || c == '-' || c == '*' || c == '/') {
                Expression gauche = fabriqueExpression(e.substring(0, i));
                Expression droite = fabriqueExpression(e.substring(i + 1));

            }
        throw new IllegalArgumentException("Invalid expression: " + e);
    }
}