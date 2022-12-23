import java.util.Scanner;

public class TicTacToe {
    Scanner scanner ;

    // Définit la taille du plateau
//    final int size = 3;
//    final int drawCounter = (boardGames.width * boardGames.height); // Gère la modularité du plateau.
//    int gameCounter = 0;

    BoardGames boardGames;

    Display display;
    public TicTacToe(){
        this.boardGames =new TictactoeBoard();
        this.scanner = new Scanner(System.in);
        this.display = new Display();
    }

//    Cell[][] plateau = new Cell[size][size]; // Déclaration d'une variable tableau de type Cell a plusieurs dimensions de taille max modulaire size (3)

//    Player player1 = new Player("| X ", 1);
//    Player player2 = new Player("| O ", 2);

//    public TicTacToe(){
//        createPlateau();
//    }


//    TictactoeBoard ticTacToeBoard = new TictactoeBoard();



    // Fonction qui affiche le plateau
    // TODO Rendre l'affichage du tableau modulaire (.repeat() pour multiplier les chaines de caracteres).
//    public void display(){
//        System.out.print("     0   1   2");
//        System.out.println();
//        for(int i = 0; i < size; i++){
//            System.out.print("   ");
////            System.out.println("        " + i +"   ");
//            System.out.print("-------------");
//            System.out.println();
//            System.out.print(i);
//            System.out.print("  ");
//            for(int j = 0; j < size; j++){
//
////                System.out.print(plateau[i][j].getRepresentation());
//                //FIXME tableau inversé pour avoir les coordonnées en abscisse et en ordonnées
//                System.out.print(plateau[i][j].getRepresentation());
//
//            }
//            System.out.print("|");
//            System.out.println();
//        }
//        System.out.print("   ");
//        System.out.print("-------------");
//        System.out.println();
//    }

    //TODO Vérifier si le changement fait sur l'affichage display coopere bien avec la fonction createPlateau()
//    private void createPlateau(){ // Remplissage du plateau à plusieurs dimensions avec la classe Cell
//        for (int i = 0; i < size; i++){
//            for (int j = 0; j < size; j++){
//                plateau[i][j] = new Cell();
//            }
//        }
//    }

    public int[] getMoveFromPlayer(){
        boolean available = false;
        int goodCoordX =-1;
        int goodCoordY = -1;
        while (!available){
            int[] coords = getCoordsWithinBounds();
            available = boardGames.cellIsEmpty(coords[0], coords[1]);
            goodCoordX = coords[0];
            goodCoordY = coords[1];
        }
        return new int[]{goodCoordX, goodCoordY};
     }

    /** Fonction qui récupère l'input d'un joueur sous forme de coordonnées et vérifie si elles correspondent au jeu ou à une case vide. Renvoie un tableau de 2 entiers
     *
     * @return
     */
    public int[] getCoordsWithinBounds() {
        int x = -1;
        int y = -1;
        int tailleMaxAbscisse = boardGames.getDimensions()[0] - 1;
        int tailleMaxOrdonnee = boardGames.getDimensions()[1] - 1;

        while (x < 0 || x > tailleMaxAbscisse) {
            System.out.println("Entrez l'abscisse' de la case libre ciblée sous forme d'entier entre 0 et " + tailleMaxAbscisse);
            if (scanner.hasNextInt()) {
                x = scanner.nextInt();
            } else {
                System.out.println(" Renseignez un entier!");
                scanner.next();
            }
        }
        while (y < 0 || y > tailleMaxOrdonnee) {
            System.out.println("Entrez l'ordonnée' de la case libre ciblée sous forme d'entier entre 0 et " + tailleMaxOrdonnee);
            if (scanner.hasNextInt()) {
                y = scanner.nextInt();
            } else {
                System.out.println(" Renseignez un entier!");
                scanner.next();
            }
        }
        return new int[]{y, x};

//        int[] coords = new int[]{x, y};
//        return coords;
    }
//    public boolean cellIsEmpty(int abscisse, int ordonnee){
//
//        if(plateau[abscisse][ordonnee].representation == "|   " ){
//            return true;
//        } else {
//            System.out.println("Cette case est déjà prise!");
//            return false;
//        }
////        Cell[] line = plateau[abscisse];
////        Cell cell   = line[ordonnee];
////        String repr = cell.representation;
////        char c      = repr.charAt(0);
//    }
    public void capture(Player player, int abscisse, int ordonnee){
        boardGames.getPlateau()[abscisse][ordonnee].representation = player.getRepresentation();
    }

    // TODO A factoriser
    public void tourJoueur(){
        Player currentPlayer = boardGames.getCurrentPlayer();
        int[] coordonneesDuJoueur;
        display.display("Joueur " + currentPlayer.getIdentity() + " à toi de jouer !");
        coordonneesDuJoueur = getMoveFromPlayer();
        capture(currentPlayer, coordonneesDuJoueur[0], coordonneesDuJoueur[1]);

        display.display(boardGames.getRepresentation());
        return;
    }
//    public void tourJoueur2(){
//        int[] coordonneesDuJoueur;
//        System.out.println("Joueur 2 à toi de jouer !");
//        coordonneesDuJoueur = getMoveFromPlayer();
//        capture(player2, coordonneesDuJoueur[0], coordonneesDuJoueur[1]);
//        display();
//
//        return;
//    }


    public boolean isOver(int gameCounter, int drawCounter){ // Prend en paramètre une variable qui determinera si le jeu est fini un booleen
        drawCounter = boardGames.getDrawCounter();
        gameCounter = boardGames.getGameCounter();
        if(gameCounter < drawCounter){
            boardGames.setGameCounter();
            return false;
        } else {
            return true;
        }
    }

    // TODO
//    public Cell[] getRows(){
//        for(int i = 0; i < size; i++){
//
//        }
//        return null;
//    }
//
//
//    public boolean isWinningline(Cell[] row){
//        return false;
//    }

    //TODO A factoriser

//    public boolean checkRows(){
//        for(int i = 0; i < boardGames.getDimensions()[0]; i++){
//            Cell[][] row = boardGames.getRow(i);
//            if row[i][j] =
//        }
//        return false;
//    }

    public boolean checkRow(Cell[] row){
        String potentialWinner = row[0].getRepresentation();
        for(Cell cell : row){
            if(cell.getRepresentation() == "|   "){
                return false;
            }
        }
        for(Cell cell: row){
            if(potentialWinner != cell.getRepresentation()){
                return false;
            }
        }
        return true;
    }

    public boolean checkColumn(Cell[] column){
        String potentialWinner = column[0].getRepresentation();
        for(Cell cell : column){
            if(cell.getRepresentation() == "|   "){
                return false;
            }
        }
        for(Cell cell: column){
            if(potentialWinner != cell.getRepresentation()){
                return false;
            }
        }
        return true;
    }

    public boolean checkDiagTopToBottom(Cell[] DiagTopToBottom){
        String potentialWinner = DiagTopToBottom[0].getRepresentation();
        for(Cell cell : DiagTopToBottom){
            if(cell.getRepresentation() == "|   "){
                return false;
            }
        }
        for(Cell cell : DiagTopToBottom){
            if(potentialWinner != cell.getRepresentation()){
                return false;
            }
        }
        return true;
    }
    public boolean checkDiagBottomToTop(Cell[] DiagBottomToTop){
        String potentialWinner = DiagBottomToTop[0].getRepresentation();
        for(Cell cell : DiagBottomToTop){
            if(cell.getRepresentation() == "|   "){
                return false;
            }
        }
        for(Cell cell : DiagBottomToTop){
            if(potentialWinner != cell.getRepresentation()){
                return false;
            }
        }
        return true;
    }



    public boolean isWinning(){


        //TODO isAnyRowWinning à factoriser

        if (isAnyRowWinning()) return true;
        if (isAnyColumnWinning()) return true;
        if (checkDiagTopToBottom(boardGames.getDiagTopToBottom())) return true;
        if (checkDiagBottomToTop(boardGames.getDiagBottomToTop()))return true;


        for(int i = 0; i < boardGames.getDimensions()[1]; i++){
            Cell[] row = boardGames.getRow(i);
            for (Cell cell: row) {
                if(cell.getRepresentation() == "|   "){
                    return false;
                }
            }
            if(row[i].getRepresentation()== "|   "){

            }
        }
        return false;
    }

    private boolean isAnyRowWinning() {
        for(int i = 0; i < boardGames.getDimensions()[1]; i++){
            if(checkRow(boardGames.getRow(i))){
                return true;
            }
        }
        return false;
    }

    private boolean isAnyColumnWinning(){
        for(int i = 0; i < boardGames.getDimensions()[0]; i++){
            if(checkColumn(boardGames.getColumn(i))){
                return true;
            }
        }
        return false;
    }

    public void deroulementPartie(){ // TODO regler le soucis ci dessous
        boolean partieFinie = isOver(boardGames.getGameCounter(), boardGames.getDrawCounter());
        boolean partieGagnee = isWinning();
//        boolean partieGagnee = false; // Pour test
//        Player currentPlayer = boardGames.getCurrentPlayer();

        display.display(boardGames.getRepresentation());

        while(!partieFinie && !partieGagnee){
            tourJoueur();
            partieGagnee = isWinning();
            partieFinie = isOver(boardGames.getGameCounter(), boardGames.getDrawCounter());

            if(partieGagnee){
                System.out.println("Bien joué vous avez gagné!");
                return;
            }
            if(partieFinie){
                System.out.println("Match Nul!!!");
                return;
            }
            tourJoueur();
            partieGagnee = isWinning();
            partieFinie = isOver(boardGames.getGameCounter(), boardGames.getDrawCounter());
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

