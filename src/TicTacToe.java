import java.util.Scanner;

public class TicTacToe {
    Scanner scanner = new Scanner(System.in);

    // Définit la taille du plateau
    final int size = 3;
    Cell[][] plateau = new Cell[size][size];

//    Player player;

    Player player1 = new Player("| X ");
    Player player2 = new Player("| O ");

    public TicTacToe(){
        createPlateau();
    }

    // Fonction qui affiche le plateau
    public void display(){
        for(int i = 0; i < 3; i++){
            System.out.print("-------------");
            System.out.println();
            for(int j = 0; j < 3; j++){
                System.out.print(plateau[i][j].getRepresentation());
            }
            System.out.print('|');
            System.out.println();
        }
        System.out.print("-------------");
        System.out.println();
    }

    private void createPlateau(){
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                plateau[i][j] = new Cell();
            }
        }
    }

    // Fonction qui récupère l'input d'un joueur sous forme de coordonnées et vérifie si elles correspondent au jeu ou à une case vide
    public void getMoveFromPlayer(){
        int x = -1;
        int y = -1 ;
        System.out.println("Entrez les coordonnées de la case ciblée sous forme d'entier entre 0 et 2");

        // Vérifie le bon format de données

        while (x==-1){
            if(scanner.hasNextInt()){
                x = scanner.nextInt();
            } else {
                System.out.println(" Renseignez un entier!");
            }
        }

        while (y==-1){
            if(scanner.hasNextInt()){
                y = scanner.nextInt();
            } else {
                System.out.println(" Renseignez un entier!");
            }
        }


        // Vérifier coordonnées si autorisées
        if( x > 2 || x < 0){
            System.out.println("Erreur, utilisez un ENTIER entre 0 et 2!");
        }
        if( y > 2 || y < 0){
            System.out.println("Erreur, utilisez un ENTIER entre 0 et 2!");
        }

        // Coordonnées bien sur le plateau et disponibles
        if(plateau[x][y] === "|   "){
            setOwner([x],[y], player); // Comment spécifier le joueur en cours?
        }
        // Si ok set la case selon la representation du joueur grâce à la fonction setOwner, sinon demande nouvelles coordonnées

    }

    // Fonction qui prend en paramètres les coordonnées et un player pour capturer une cellule
    public void setOwner(abscisse, ordonnee, player){ // Sous quelle forme entrer ces paramètres?
        plateau[abscisse][ordonne] = player.getRepresentation();
    }

    // Fonction qui gère le déroulement d'une partie
    public void play(){
        // Demande au joueur 1 de jouer (vérifie si case ok)
        // Vérifie si partie finie ou gagnant
        // Demande au joueur 2 de jouer (vérifie si case ok)
        // Vérifie si partie finie ou gagnant
    }

    // Fonction qui définit si le jeu est terminé (plateau rempli ou 3 pions alignés)
    public void isOver(){
        // Vérifie si le plateau est rempli
        // Test si il y a 3 X ou 3 O aux coordonées horizontales : [0,0 ; 1,0 ; 2,0 || 0,1 ; 1,1 ; 2,1 || 0,2 ; 1,2 ; 2,2] ou
        // verticales : [0,0 ; 0,1 ; 0,2 || 1,0 ; 1,1 ; 1,2 || 2,0 ; 2,1 ; 2,2] ou
        // diagonales : [0,0 ; 1,1 , 2,2 || 0,2 ; 1,1 ; 2,0]
    }
}
