import java.util.Scanner;

public class TicTacToe {
    Scanner scanner = new Scanner(System.in);

    // Définit la taille du plateau
    final int size = 3;
    Cell[][] plateau = new Cell[size][size]; // Déclaration d'une variable tableau de type Cell a plusieurs dimensions de taille max size (3)

    Player player1 = new Player("| X ", 1);
    Player player2 = new Player("| O ", 2);

    public TicTacToe(){
        createPlateau();
    }

    // Fonction qui affiche le plateau
    public void display(){
        System.out.print("     0   1   2");
        System.out.println();
        for(int i = 0; i < 3; i++){
            System.out.print("   ");
            System.out.print("-------------");
            System.out.println();
            System.out.print(i);
            System.out.print("  ");
            for(int j = 0; j < 3; j++){
//                System.out.print(plateau[i][j].getRepresentation());
                //FIXME tableau inversé pour avoir les coordonnées en abscisse et en ordonnées
                System.out.print(plateau[j][i].getRepresentation());

            }
            System.out.print("|");
            System.out.println();
        }
        System.out.print("   ");
        System.out.print("-------------");
        System.out.println();
    }

    //TODO Vérifier si le changement fait sur l'affichage display coopere bien avec la fonction createPlateau()
    private void createPlateau(){ // Remplissage du plateau à plusieurs dimensions avec la classe Cell
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                plateau[i][j] = new Cell();
            }
        }
    }

    public int[] getMoveFromPlayer(){
        boolean available = false;
        int goodCoordX =-1;
        int goodCoordY = -1;
        while (!available){
            int[] coords = getCoordsWithinBounds();
            available = cellIsEmpty(coords[0], coords[1]);
            goodCoordX = coords[0];
            goodCoordY = coords[1];
        }
        return new int[]{goodCoordX, goodCoordY};
     }

    // Fonction qui récupère l'input d'un joueur sous forme de coordonnées et vérifie si elles correspondent au jeu ou à une case vide. Renvoie un tableau de 2 entiers
    public int[] getCoordsWithinBounds() {
        int x = -1;
        int y = -1;

        while (x < 0 || x > 2) {
            System.out.println("Entrez l'abscisse' de la case libre ciblée sous forme d'entier entre 0 et 2");
            if (scanner.hasNextInt()) {
                x = scanner.nextInt();
            } else {
                System.out.println(" Renseignez un entier!");
                scanner.next();
            }
        }
        while (y < 0 || y > 2) {
            System.out.println("Entrez l'ordonnée' de la case libre ciblée sous forme d'entier entre 0 et 2");
            if (scanner.hasNextInt()) {
                y = scanner.nextInt();
            } else {
                System.out.println(" Renseignez un entier!");
                scanner.next();
            }
        }
        return new int[]{x, y};

//        System.out.println(x);
//        System.out.println(y);
//        int[] coords = new int[]{x, y};
//        return coords;
    }

    public boolean cellIsEmpty(int abscisse, int ordonnee){

        if(plateau[abscisse][ordonnee].representation == "|   " ){
            return true;
        } else {
            System.out.println("Cette case est déjà prise!");
            return false;
        }
//        Cell[] line = plateau[abscisse];
//        Cell cell   = line[ordonnee];
//        String repr = cell.representation;
//        char c      = repr.charAt(0);
    }
    public void capture(Player player, int abscisse, int ordonnee){
        plateau[abscisse][ordonnee].representation = player.getRepresentation();
    }

    // TODO A factoriser
    public void tourJoueur1(){
        int[] coordonneesDuJoueur;
        System.out.println("Joueur 1 à toi de jouer !");
        coordonneesDuJoueur = getMoveFromPlayer();
        capture(player1, coordonneesDuJoueur[0], coordonneesDuJoueur[1]);
        display();

        return;
    }
    public void tourJoueur2(){
        int[] coordonneesDuJoueur;
        System.out.println("Joueur 2 à toi de jouer !");
        coordonneesDuJoueur = getMoveFromPlayer();
        capture(player2, coordonneesDuJoueur[0], coordonneesDuJoueur[1]);
        display();

        return;
    }
    // Fonction qui définit si le jeu est terminé (plateau rempli ou 3 pions alignés)
    // TODO Implémenter isOver() pour déterminer la fin de partie

    public boolean isOver(){


//         Vérifie si le plateau est rempli
//         Test si il y a 3 X ou 3 O aux coordonées horizontales : [0,0 ; 1,0 ; 2,0 || 0,1 ; 1,1 ; 2,1 || 0,2 ; 1,2 ; 2,2] ou
//         verticales : [0,0 ; 0,1 ; 0,2 || 1,0 ; 1,1 ; 1,2 || 2,0 ; 2,1 ; 2,2] ou
//         diagonales : [0,0 ; 1,1 , 2,2 || 0,2 ; 1,1 ; 2,0]
        return true;
    }

    //TODO A factoriser
    public void isWinning1(){
        System.out.println("Le joueur1 a gagné ! ");

    }
    public void isWinning2(){
        System.out.println("Le joueur2 a gagné ! ");

    }

    //FIXME Test de la fonction avec partieFinie = false. Modifier une fois isWinning() et isOver() implémentées

    public void deroulementPartie(){
//        boolean partieFinie = isOver();
        boolean partieFinie = false;
        tourJoueur1();
        tourJoueur2();
        while(!partieFinie){
            tourJoueur1();
//            partieFinie = isOver();
            partieFinie = false;
            if (!partieFinie){
                tourJoueur2();
                partieFinie = false;
            }else{
                break;
            }
        }
        return;
    }

}

