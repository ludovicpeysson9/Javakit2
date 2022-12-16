import java.util.List;
import java.util.Scanner;

public class TicTacToe {
    Scanner scanner = new Scanner(System.in);

    // Définit la taille du plateau
    final int size = 3;
    final int drawCounter = (size * size); // Gère la modularité du plateau.
    int gameCounter = 0;
    Cell[][] plateau = new Cell[size][size]; // Déclaration d'une variable tableau de type Cell a plusieurs dimensions de taille max modulaire size (3)

    Player player1 = new Player("| X ", 1);
    Player player2 = new Player("| O ", 2);

    public TicTacToe(){
        createPlateau();
    }

    // Fonction qui affiche le plateau
    // TODO Rendre l'affichage du tableau modulaire (.repeat() pour multiplier les chaines de caracteres).
    public void display(){
        System.out.print("     0   1   2");
        System.out.println();
        for(int i = 0; i < size; i++){
            System.out.print("   ");
//            System.out.println("        " + i +"   ");
            System.out.print("-------------");
            System.out.println();
            System.out.print(i);
            System.out.print("  ");
            for(int j = 0; j < size; j++){

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
        int tailleMax = this.size -1;

        while (x < 0 || x > tailleMax) {
            System.out.println("Entrez l'abscisse' de la case libre ciblée sous forme d'entier entre 0 et " + tailleMax);
            if (scanner.hasNextInt()) {
                x = scanner.nextInt();
            } else {
                System.out.println(" Renseignez un entier!");
                scanner.next();
            }
        }
        while (y < 0 || y > tailleMax) {
            System.out.println("Entrez l'ordonnée' de la case libre ciblée sous forme d'entier entre 0 et " + tailleMax );
            if (scanner.hasNextInt()) {
                y = scanner.nextInt();
            } else {
                System.out.println(" Renseignez un entier!");
                scanner.next();
            }
        }
        return new int[]{x, y};

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

    public boolean isOver(int gameCounter, int drawCounter){ // Prend en paramètre une variable qui determinera si le jeu est fini un booleen

        if(gameCounter < drawCounter){
            this.gameCounter += 1;
            return false;
        } else {
            return true;
        }
    }

    // TODO
    public Cell[] getRows(){
        for(int i = 0; i < size; i++){

        }
        return null;
    }


    public boolean isWinningline(Cell[] row){
        return false;
    }

    //TODO A factoriser
    public boolean isWinning(){

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(plateau[i][j].representation != "|   "){
                    if(plateau[i][j].representation == "| X " || plateau[i][j].representation == "| O "){
                        if(plateau[i][j].representation == "| X "){
                            if( i > 0 && i < size -1){
                                if(plateau[i-1][j].representation == "| X " && plateau[i+1][j].representation == "| X "){ // Test horizontal
                                    return true;
                                }else{
                                    return false;
                                }
                            }
                            if( j > 0 && j < size -1){
                                if(plateau[i][j-1].representation == "| X " && plateau[i][j+1].representation == "| X "){ // Test Vertical
                                    return true;
                                }else{
                                    return false;
                                }
                            }
                            if( i > 0 && j > 0 && i < size -1 && j < size-1){
                                if (plateau[i-1][j-1].representation == "| X " && plateau[i+1][j+1].representation == "| X "){ // Test diagonale
                                    return true;
                                }else{
                                    return false;
                                }
                            }
                        }else
                        if(plateau[i][j].representation == "| O "){
                            if( i> 0 && i < size -1){
                                if(plateau[i-1][j].representation == "| O " && plateau[i+1][j].representation == "| O "){ // Test horizontal
                                    return true;
                                }else{
                                    return false;
                                }
                            }
                            if( j > 0 && j < size -1){
                                if(plateau[i][j-1].representation == "| O " && plateau[i][j+1].representation == "| O "){ // Test Vertical
                                    return true;
                                }else{
                                    return false;
                                }
                            }
                            if( i > 0 && j > 0 && i < size -1 && j < size-1){
                                if (plateau[i-1][j-1].representation == "| O " && plateau[i+1][j+1].representation == "| O "){ // Test diagonale
                                    return true;
                                }else{
                                    return false;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public void deroulementPartie(){
        boolean partieFinie = isOver(gameCounter, drawCounter);
        boolean partieGagnee = isWinning();

        while(!partieFinie && !partieGagnee){
            tourJoueur1();
            partieGagnee = isWinning();
            partieFinie = isOver(gameCounter, drawCounter);

            if(partieGagnee){
                System.out.println("Bien joué vous avez gagné!");
                return;
            }
            if(partieFinie){
                System.out.println("Match Nul!!!");
                return;
            }
            tourJoueur2();
            partieGagnee = isWinning();
            partieFinie = isOver(gameCounter, drawCounter);
            if(partieGagnee){
                System.out.println("Bien joué vous avez gagné!");
                return;
            }
            if(partieFinie){
                System.out.println("Match Nul!!!");
                return;
            }
        }











//        while(!partieFinie && !partieGagnee){
//
//            tourJoueur1();
//            partieGagnee = isWinning();
//            partieFinie = isOver(gameCounter, drawCounter);
//
//            if(!partieGagnee){
//                if (!partieFinie){
//                    tourJoueur2();
//                    partieGagnee=isWinning();
//                    partieFinie=isOver(gameCounter, drawCounter);
//                }else{
//                    break;
//                }
//            }else {
//                System.out.println("Gagné Bien Joué!");
//            }
//            break;
//        }

//        while(!partieFinie && !partieGagnee){
//
//            tourJoueur1();
//            partieGagnee = isWinning();
//            partieFinie = isOver(gameCounter, drawCounter);
//
//            if(!partieGagnee){
//                if (!partieFinie){
//
//                    tourJoueur2();
//                    partieGagnee = isWinning();
//                }else{
//                    partieFinie = isOver(gameCounter, drawCounter);
//                    break;
//                }
//            }else{
//                System.out.println("Gagné! bien joué!");
//            }
//
//
////            if (!partieFinie){
////
////                tourJoueur2();
////                partieGagnee = isWinning();
////                partieFinie = isOver(gameCounter, drawCounter);
////
////            }else{
////                break;
////            }
////        }
//        if(partieGagnee){
//            System.out.println("Gagné! Bien joué!");
//        }else
//        if(partieFinie){
//            System.out.println("Match Nul ! ");
//        }
//        return;
    }

}

