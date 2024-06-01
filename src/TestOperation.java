public class TestOperation {
    public static void main(String[] args) {
        Nombre huit = new Nombre(8);
        Nombre deux = new Nombre(2);
        Nombre quatre = new Nombre(4);
        Nombre zero = new Nombre(0);

        System.out.println("Division :");
        Operation s1 = new Division(huit, deux);
        Operation s2 = new Division(huit, quatre);

        try {
            Operation s3 = new Division(quatre, zero); //doit afficher : Division par zero interdite !
        } catch (ArithmeticException e) {
            System.out.println(e);
        }

        System.out.println(s1 + "=" + s1.valeur()); //doit afficher : (8 / 2) = 4
        System.out.println(s2 + "=" + s2.valeur()); //doit afficher : (8 / 4) = 2

        System.out.println("Addition :");
        Operation t1 = new Addition(huit, deux);
        Operation t2 = new Addition(quatre, zero);

        System.out.println(t1 + "=" + t1.valeur()); //doit afficher : (8 + 2) = 10
        System.out.println(t2 + "=" + t2.valeur()); //doit afficher : (4 + 0) = 4

        System.out.println("Soustraction :");
        Operation a1 = new Soustraction(huit, deux);
        Operation a2 = new Soustraction(zero, quatre);

        System.out.println(a1 + "=" + a1.valeur()); //doit afficher : (8 - 2) = 6
        System.out.println(a2 + "=" + a2.valeur()); //doit afficher : (0 - 4) = -4

        System.out.println("Multiplication :");
        Operation x1 = new Multiplication(huit, deux);
        Operation x2 = new Multiplication(zero, quatre);

        System.out.println(x1 + "=" + x1.valeur()); //doit afficher : (8 * 2) = 16
        System.out.println(x2 + "=" + x2.valeur()); //doit afficher : (0 - 4) = 0

        Expression trois = new Nombre(3);
        Expression dixSept = new Nombre(17);
        Expression s = new Soustraction(dixSept, deux);
        Expression a = new Addition(deux, trois);
        Expression d = new Division(s, a);
        System.out.println(d + " = " + d.valeur()); //doit afficher ((17 - 2) / (2 + 3)) = 3

        System.out.println("Création de l'expression : ( (4 + 2)*( 6-3 ))");
        System.out.println(fabriqueExpression("( (4 + 2)*( 6-3 ))"));       //Fabrique l'expression et doit afficher ((4.0 + 2.0) * (6.0 - 3.0))

        System.out.println("Création de l'expression : ( ( ( 2 * 3 ) + ( 4 * 5 ) ) / 2 )");
        Expression E1 = fabriqueExpression("( ( ( 2 * 3 ) + ( 4 * 5 ) ) / 2 )");        //Fabrique l'expression
        System.out.println(E1);             //Doit afficher (((2.0 * 3.0) + (4.0 * 5.0)) / 2.0)
        System.out.println(E1.valeur());    //Doit afficher 13.0

        System.out.println("Création de l'expression : (4+8)/3)");
        try {
            System.out.println(fabriqueExpression("(4 + 8) / 3)")); //Doit afficher une erreur
        } catch(IllegalArgumentException e){
            System.out.println(e);
        }
    }

    public static Expression fabriqueExpression(String e) {
        if (e.isEmpty()) {      //Vérifie si la Chaine est vide.
            throw new IllegalArgumentException("La chaîne d'expression est vide.");     //Affiche une erreur disant que la chaine est vide.
        }

        e = e.replaceAll(" ", "");      //Remplace tous les espaces par des caractères vides. L'équivalent est "enlève tous les espaces de la chaine.

        if (e.matches("[0-9]+")) {      //Vérifie si la chaine e est composé uniquement de chiffres (2,8,16,98489,...).
            return new Nombre(Integer.parseInt(e));     //Retourne un objet de la classe Nombre.
        }

        if (e.startsWith("(") && e.endsWith(")")) {     //Regarde si la chaine e commence et se termine par des parenthèses.
            e = e.substring(1, e.length() - 1);     //Supprime les parenthèses en début et en fin de chaine.
        }

        int longueur = e.length();      //Affecte la longueur de la chaine à une variable appelée longueur.

        int compteurParentheses = 0;        //Création d'une variable qui va compter les parenthèses

        for (int i = 0; i <= longueur-1; i++) {       //Parcours la chaine e
            char caractere = e.charAt(i);       //Affecte à la variable "caractere" le caractère actuel.

            if(caractere == '('){       //Vérifie si le caractère est une parenthèse ouvrante.
                compteurParentheses+=1;     //Ajoute 1 au compteur de parenthèses
            }
            else if(caractere ==')'){       //Vérifie si le caractère est une parenthèse ouvrante.
                compteurParentheses-=1;     //Enlève 1 au compteur de parenthèses
            }

            else if (caractere == '+' || caractere == '-' || caractere == '*' || caractere == '/') {     //Vérifie si le caractère est un opérateur (+,-,*,/)
                if (compteurParentheses == 0) {     //Vérifie qu'il y ait autant de parenthèses ouvrantes que de parenthèses fermantes qui ont été comptées.
                    String OpGauche = e.substring(0, i);        //Récupère l'opération à gauche de l'opérateur trouvé

                    String OpDroite = e.substring(i + 1);       //Récupère l'opération à droite de l'opérateur trouvé

                    Expression gauche = fabriqueExpression(OpGauche);       //Fabrique l'expression à gauche de manière récurrente
                    Expression droite = fabriqueExpression(OpDroite);       //Fabrique l'expression à droite de manière récurrente

                    if (caractere == '+') {     //Si le caractère est un +
                        return new Addition(gauche, droite);        //Fabrique une addition
                    }
                    if (caractere == '-') {     //Si le caractère est un -
                        return new Soustraction(gauche, droite);        //Fabrique une soustraction
                    }
                    if (caractere == '*') {     //Si le caractère est un *
                        return new Multiplication(gauche, droite);        //Fabrique une multiplication
                    }
                    return new Division(gauche, droite);        //Fabrique une division
                }
            }
        }
        throw new IllegalArgumentException("Invalid expression: " + e);     //Si l'expression est invalide, par exemple : qu'il n'y a pas le même nombre de parenthèses ouvrantes que de parenthèses fermantes, alors affiche une erreur.
    }
}