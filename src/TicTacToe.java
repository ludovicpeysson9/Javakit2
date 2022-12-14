import java.util.Scanner;

public class TicTacToe {
    Scanner scanner = new Scanner(System.in);

    // Définit la taille du plateau
    final int size = 3;
    Cell[][] plateau = new Cell[size][size]; // Déclaration d'une variable tableau de type Cell a plusieurs dimensions de taille max size (3)

//    Player player;

    Player player1 = new Player("| X ");
    Player player2 = new Player("| O ");

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
                System.out.print(plateau[i][j].getRepresentation());
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.print("   ");
        System.out.print("-------------");
        System.out.println();
    }

    private void createPlateau(){ // Remplissage du plateau à plusieurs dimensions avec la classe Cell
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                plateau[i][j] = new Cell();
            }
        }
    }

    // Fonction qui récupère l'input d'un joueur sous forme de coordonnées et vérifie si elles correspondent au jeu ou à une case vide. Renvoie un tableau de 2 entiers
    public int[] getMoveFromPlayer() {
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
//        System.out.println(x);
//        System.out.println(y);
        return new int[]{x, y};
    }

    public boolean cellIsEmpty(int abscisse, int ordonnee){

//        Cell[] line = plateau[abscisse];
//        Cell cell   = line[ordonnee];
//        String repr = cell.representation;
//        char c      = repr.charAt(0);

        if(plateau[abscisse][ordonnee].representation == "|   " ){
            return true;
        } else {
            System.out.println("Cette case est déjà prise!");
            return false;
        }
    }
    public void capture(Player player, int abscisse, int ordonnee){
        plateau[abscisse][ordonnee].representation = player.getRepresentation();
    }

    // Fonction qui gère le déroulement d'une partie

    public void tour(){
        getMoveFromPlayer();
        if(cellIsEmpty(getMoveFromPlayer()[0], getMoveFromPlayer()[1]) == true){
            capture(player1, getMoveFromPlayer()[0], getMoveFromPlayer()[1]);
        }
        display();




        // Demande au joueur 1 de jouer (vérifie si case ok)
        // Vérifie si partie finie ou gagnant
        // Demande au joueur 2 de jouer (vérifie si case ok)
        // Vérifie si partie finie ou gagnant
    }
    public void play(){
        tour();
    }

    // Fonction qui définit si le jeu est terminé (plateau rempli ou 3 pions alignés)
    public void isOver(){
        // Vérifie si le plateau est rempli
        // Test si il y a 3 X ou 3 O aux coordonées horizontales : [0,0 ; 1,0 ; 2,0 || 0,1 ; 1,1 ; 2,1 || 0,2 ; 1,2 ; 2,2] ou
        // verticales : [0,0 ; 0,1 ; 0,2 || 1,0 ; 1,1 ; 1,2 || 2,0 ; 2,1 ; 2,2] ou
        // diagonales : [0,0 ; 1,1 , 2,2 || 0,2 ; 1,1 ; 2,0]
    }
}
