package controller;//package controller
import model.BoardGames;
import model.Player;
import model.PuissanceQuatreBoard;
import view.Display;
import util.Tuple;
import java.util.Scanner;
public class Puissance4{
    Scanner scanner;
    BoardGames boardGames;
    Display display;
    public Puissance4(){
        this.boardGames = new PuissanceQuatreBoard();
        this.scanner = new Scanner(System.in);
        this.display = new Display();
    }
    public Puissance4(Player p1, Player p2){
        this.boardGames = new PuissanceQuatreBoard(p1, p2);
        this.scanner = new Scanner(System.in);
        this.display = new Display();
    }
    public Puissance4(Tuple<Player,Player> players){
        this.boardGames = new PuissanceQuatreBoard(players.x, players.y);
        this.scanner = new Scanner(System.in);
        this.display = new Display();
    }

    public void displayp4(){
        display.display(boardGames.getRepresentation());
    }
//    /** Function to get verified coords from player. Return an array of 2 integers
//     *
//     * @return
//     */
//    public int[] getMoveFromPlayer(){
//        boolean available = false;
//        int goodCoordX =-1;
//        int goodCoordY = -1;
//        while (!available){
//            int[] coords = getCoordsWithinBounds();
//            available = boardGames.cellIsEmpty(coords[0], coords[1]);
//            goodCoordX = coords[0];
//            goodCoordY = coords[1];
//        }
//        return new int[]{goodCoordX, goodCoordY};
//    }
//    public int[] getMoveFromComputer(){
//        boolean available = false;
//        int goodCoordX = -1;
//        int goodCoordY = -1;
//        while(!available){
//            int[]coords = getCoordsOfComputer();
//            available = boardGames.cellIsEmptyComputer(coords[0], coords[1]);
//            goodCoordX = coords[0];
//            goodCoordY = coords[1];
//        }
//        return new int[]{goodCoordX,goodCoordY};
//    }
//    public int[] getCoordsOfComputer(){
//        int x = (int) ((Math.random() * (7-0)) + 0);
//        int y = (int) ((Math.random() * (6-0)) + 0);
//        return new int[]{y,x};
//    }
//    public int[] getCoordsWithinBounds() {
//        int x = -1;
//        int y = -1;
//        int tailleMaxAbscisse = boardGames.getDimensions()[0] - 1;
//        int tailleMaxOrdonnee = boardGames.getDimensions()[1] - 1;
//
//        while (x < 0 || x > tailleMaxAbscisse) {
//            display.instructionAbscisse(tailleMaxAbscisse);
//            if (scanner.hasNextInt()) {
//                x = scanner.nextInt();
//            } else {
//                display.errorEntier();
//                scanner.next();
//            }
//            if(x != -1 && (x < 0 || x > tailleMaxAbscisse)){
//                display.errorOutOfBounds(tailleMaxAbscisse);
//            }
//        }
//        while (y < 0 || y > tailleMaxOrdonnee) {
//            display.instructionOrdonnee(tailleMaxOrdonnee);
//
//            if (scanner.hasNextInt()) {
//                y = scanner.nextInt();
//            } else {
//                display.errorEntier();
//                scanner.next();
//            }
//            if(y != -1 && (y < 0 || y > tailleMaxOrdonnee)){
//                display.errorOutOfBounds(tailleMaxOrdonnee);
//            }
//        }
//        return new int[]{y, x};
//    }
//    /** Function changing a cell representation by a model.Player's one
//     *
//     * @param player
//     * @param abscisse
//     * @param ordonnee
//     */
//    public void capture(model.Player player, int abscisse, int ordonnee){
//        boardGames.getPlateau()[abscisse][ordonnee].representation = player.getRepresentation();
//    }
//
//    /** Function to define the turn of a player
//     *
//     */
//    public void tourJoueur(){
//        model.Player currentPlayer = boardGames.getCurrentPlayer();
//        int[] coordonnees;
//        display.display("Joueur " + currentPlayer.getIdentity() + " à toi de jouer !");
//        if(currentPlayer.isHuman == false){
//            coordonnees = getMoveFromComputer();
//        }else{
//            coordonnees = getMoveFromPlayer();
//        }
//        capture(currentPlayer, coordonnees[0], coordonnees[1]);
//
//        display.display(boardGames.getRepresentation());
//    }
//
//    /** Function which returns true if the game is over
//     *
//     * @param gameCounter
//     * @param drawCounter
//     * @return
//     */
//    public boolean isOver(int gameCounter, int drawCounter){ // Prend en paramètre une variable qui determinera si le jeu est fini un booleen
//        drawCounter = boardGames.getDrawCounter();
//        gameCounter = boardGames.getGameCounter();
//        if(gameCounter < drawCounter){
//            boardGames.setGameCounter();
//            return false;
//        } else {
//            return true;
//        }
//    }
//    /** Function to check if a row is winning. Return a boolean
//     *
//     * @param row
//     * @return
//     */
//    public boolean checkRow(model.Cell[] row){
//        String potentialWinner = row[0].getRepresentation();
//        for(model.Cell cell : row){
//            if(cell.getRepresentation().equals("|   ")){
//                return false;
//            }
//        }
//        for(model.Cell cell: row){
//            if(potentialWinner != cell.getRepresentation()){
//                return false;
//            }
//        }
//        return true;
//    }
//
//    /** Function to check if a column is winning. Return a boolean
//     *
//     * @param column
//     * @return
//     */
//    public boolean checkColumn(model.Cell[] column){
//        String potentialWinner = column[0].getRepresentation();
//        for(model.Cell cell : column){
//            if(cell.getRepresentation().equals("|   ")){
//                return false;
//            }
//        }
//        for(model.Cell cell: column){
//            if(potentialWinner != cell.getRepresentation()){
//                return false;
//            }
//        }
//        return true;
//    }
//
//    /** Function to check if the diagonale from top to bottom is winning. Return a boolean
//     *
//     * @param DiagTopToBottom
//     * @return
//     */
//    public boolean checkDiagTopToBottom(model.Cell[] DiagTopToBottom){
//        String potentialWinner = DiagTopToBottom[0].getRepresentation();
//        for(model.Cell cell : DiagTopToBottom){
//            if(cell.getRepresentation().equals("|   ")){
//                return false;
//            }
//        }
//        for(model.Cell cell : DiagTopToBottom){
//            if(potentialWinner != cell.getRepresentation()){
//                return false;
//            }
//        }
//        return true;
//    }
//
//    /** Function to check if the diagonale from bottom to top is winning. Return a boolean
//     *
//     * @param DiagBottomToTop
//     * @return
//     */
//    public boolean checkDiagBottomToTop(model.Cell[] DiagBottomToTop){
//        String potentialWinner = DiagBottomToTop[0].getRepresentation();
//        for(model.Cell cell : DiagBottomToTop){
//            if(cell.getRepresentation() == "|   "){
//                return false;
//            }
//        }
//        for(model.Cell cell : DiagBottomToTop){
//            if(potentialWinner != cell.getRepresentation()){
//                return false;
//            }
//        }
//        return true;
//    }
//
//    /** Function to check if any row is winning. Return a boolean
//     *
//     * @return
//     */
//    private boolean isAnyRowWinning() {
//        for(int i = 0; i < boardGames.getDimensions()[1]; i++){
//            if(checkRow(boardGames.getRow(i))){
//                return true;
//            }
//        }
//        return false;
//    }
//
//    /** Function to check if any column is winning. Return a boolean
//     *
//     * @return
//     */
//    private boolean isAnyColumnWinning(){
//        boolean res = false;
//        for(int i = 0; i < boardGames.getDimensions()[0]; i++){
//            if(checkColumn(boardGames.getColumn(i))){
//                res = true;
//            }
//        }
//        return res;
//    }
//
//    /** Function to check the winning state. Return a boolean
//     *
//     * @return
//     */
//    public boolean isWinning(){
//        return (isAnyRowWinning())
//                || (isAnyColumnWinning())
//                || (checkDiagTopToBottom(boardGames.getDiagTopToBottom()))
//                || (checkDiagBottomToTop(boardGames.getDiagBottomToTop()));
//    }
//
//    /** Function which defines the execution of the game
//     *
//     */
//    public void deroulementPartie(){
//        boolean partieFinie = isOver(boardGames.getGameCounter(), boardGames.getDrawCounter());
//        boolean partieGagnee = isWinning();
//
//        display.display(boardGames.getRepresentation());
//
//        while(!partieFinie && !partieGagnee){
//            tourJoueur();
//            partieGagnee = isWinning();
//            partieFinie = isOver(boardGames.getGameCounter(), boardGames.getDrawCounter());
//        }
//        if(partieGagnee){
//            display.winMessage();
//        }
//        if(partieFinie){
//            display.drawMessage();
//        }
//    }
}
