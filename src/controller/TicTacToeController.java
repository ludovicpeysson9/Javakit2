package controller;
import model.BoardGamesModel;
import model.CellModel;
import model.PlayerModel;
import model.TictactoeBoardModel;
import view.DisplayView;
import util.TupleUtil;

import java.util.ArrayList;
import java.util.Scanner;

public class TicTacToeController implements GameController{
    Scanner scanner;
    BoardGamesModel boardGames;
    DisplayView display;

//    private ArrayList<int[]> availableCoords = new ArrayList<>();

    /**
     * Constructors
     *
     */
    public TicTacToeController(){
        this.boardGames = new TictactoeBoardModel();
        this.scanner = new Scanner(System.in);
        this.display = new DisplayView();
    }
    public TicTacToeController(PlayerModel p1, PlayerModel p2){
        this.boardGames = new TictactoeBoardModel(p1, p2);
        this.scanner = new Scanner(System.in);
        this.display = new DisplayView();
    }
    public TicTacToeController(TupleUtil<PlayerModel, PlayerModel> players){
        this.boardGames = new TictactoeBoardModel(players.x, players.y);
        this.scanner = new Scanner(System.in);
        this.display = new DisplayView();
    }

    /**
     * Function to get verified coords from player. Return an array of 2 integers
     *
     * @return
     */
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

    /**
     * Function which returns coords from a computer
     *
     * @return
     */
    public int[] getMoveFromComputer(){
        boolean available = false;
        int goodCoordX = -1;
        int goodCoordY = -1;
        while(!available){
            int[]coords = getCoordsOfComputer();
            available = boardGames.cellIsEmptyComputer(coords[0], coords[1]);
            goodCoordX = coords[0];
            goodCoordY = coords[1];
        }
        return new int[]{goodCoordX,goodCoordY};
    }

    /**
     * Function which returns random coords from a computer
     *
     * @return
     */
    public int[] getCoordsOfComputer(){
        int x = (int) ((Math.random() * (3-0)) + 0);
        int y = (int) ((Math.random() * (3-0)) + 0);
        return new int[]{y,x};
    }
    /**
     * Function to get the input from a player and verify if they are within the bounds. Return an array of 2 integers.
     *
     * @return
     */
    public int[] getCoordsWithinBounds() {
        int x = -1;
        int y = -1;
        int tailleMaxAbscisse = boardGames.getDimensions()[0] - 1;
        int tailleMaxOrdonnee = boardGames.getDimensions()[1] - 1;

        while (x < 0 || x > tailleMaxAbscisse) {
            display.instructionAbscisse(tailleMaxAbscisse);
            if (scanner.hasNextInt()) {
                x = scanner.nextInt();
            } else {
                display.errorEntier();
                scanner.next();
            }
            if(x != -1 && (x < 0 || x > tailleMaxAbscisse)){
                display.errorOutOfBounds(tailleMaxAbscisse);
            }
        }
        while (y < 0 || y > tailleMaxOrdonnee) {
            display.instructionOrdonnee(tailleMaxOrdonnee);

            if (scanner.hasNextInt()) {
                y = scanner.nextInt();
            } else {
                display.errorEntier();
                scanner.next();
            }
            if(y != -1 && (y < 0 || y > tailleMaxOrdonnee)){
                display.errorOutOfBounds(tailleMaxOrdonnee);
            }
        }
        return new int[]{y, x};
    }

    /**
     * Function changing a cell representation by a model.Player's one
     *
     * @param player
     * @param abscisse
     * @param ordonnee
     */
    public void capture(PlayerModel player, int abscisse, int ordonnee){
        int[] coords = {abscisse, ordonnee};
        boardGames.getPlateau()[abscisse][ordonnee].setRepresentation(player.getRepresentation());
//        availableCoords.remove((valueof(coords));
    }

    //TODO Modifier la facon dont l'ordinateur choisit son coup
//    private void fillWithAvailableCoords(){
//        for (int i = 0; i < this.boardGames.getDimensions()[0]; i++){
//            for (int j = 0; j < this.boardGames.getDimensions()[1]; j++){
//                int[] toAdd = new int[2];
//                toAdd[0]=i;
//                toAdd[1]=j;
//                availableCoords.add(toAdd);
//            }
//        }
//    }

    /**
     * Function to define the turn of a player
     *
     */
    public void tourJoueur(){
        PlayerModel currentPlayer = boardGames.getCurrentPlayer();
        int[] coordonnees;
        display.display("Joueur " + currentPlayer.getIdentity() + " à toi de jouer !");
        if(currentPlayer.getHuman() == false){
            coordonnees = getMoveFromComputer();
        }else{
            coordonnees = getMoveFromPlayer();
        }
        capture(currentPlayer, coordonnees[0], coordonnees[1]);

        display.display(boardGames.getRepresentation());
    }

    /**
     * Function which returns true if the game is over
     *
     * @param gameCounter
     * @param drawCounter
     * @return
     */
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

    /**
     * Function to check if a row is winning. Return a boolean
     *
     * @param row
     * @return
     */
    public boolean checkRow(CellModel[] row){
        String potentialWinner = row[0].getRepresentation();
        for(CellModel cell : row){
            if(cell.getRepresentation().equals("|   ")){
                return false;
            }
        }
        for(CellModel cell: row){
            if(potentialWinner != cell.getRepresentation()){
                return false;
            }
        }
        return true;
    }

    /**
     * Function to check if a column is winning. Return a boolean
     *
     * @param column
     * @return
     */
    public boolean checkColumn(CellModel[] column){
        String potentialWinner = column[0].getRepresentation();
        for(CellModel cell : column){
            if(cell.getRepresentation().equals("|   ")){
                return false;
            }
        }
        for(CellModel cell: column){
            if(potentialWinner != cell.getRepresentation()){
                return false;
            }
        }
        return true;
    }

    /**
     * Function to check if the diagonale from top to bottom is winning. Return a boolean
     *
     * @param DiagTopToBottom
     * @return
     */
    public boolean checkDiagTopToBottom(CellModel[] DiagTopToBottom){
        String potentialWinner = DiagTopToBottom[0].getRepresentation();
        for(CellModel cell : DiagTopToBottom){
            if(cell.getRepresentation() == "|   "){
                return false;
            }
        }
        for(CellModel cell : DiagTopToBottom){
            if(potentialWinner != cell.getRepresentation()){
                return false;
            }
        }
        return true;
    }

    /**
     * Function to check if the diagonale from bottom to top is winning. Return a boolean
     *
     * @param DiagBottomToTop
     * @return
     */
    public boolean checkDiagBottomToTop(CellModel[] DiagBottomToTop){
        String potentialWinner = DiagBottomToTop[0].getRepresentation();
        for(CellModel cell : DiagBottomToTop){
            if(cell.getRepresentation() == "|   "){
                return false;
            }
        }
        for(CellModel cell : DiagBottomToTop){
            if(potentialWinner != cell.getRepresentation()){
                return false;
            }
        }
        return true;
    }

    /**
     * Function to check if any row is winning. Return a boolean
     *
     * @return
     */
    private boolean isAnyRowWinning() {
        for(int i = 0; i < boardGames.getDimensions()[1]; i++){
            if(checkRow(boardGames.getRow(i))){
                return true;
            }
        }
        return false;
    }

    /**
     * Function to check if any column is winning. Return a boolean
     *
     * @return
     */
    private boolean isAnyColumnWinning(){
        boolean res = false;
        for(int i = 0; i < boardGames.getDimensions()[0]; i++){
            if(checkColumn(boardGames.getColumn(i))){
                res = true;
            }
        }
        return res;
    }

    /**
     * Function to check the winning state. Return a boolean
     *
     * @return
     */
    public boolean isWinning(){
        return (isAnyRowWinning())
                || (isAnyColumnWinning())
                || (checkDiagTopToBottom(boardGames.getDiagTopToBottom()))
                || (checkDiagBottomToTop(boardGames.getDiagBottomToTop()));
    }

    /**
     * Function which defines the execution of the game
     *
     */
    public void deroulementPartie(){
        boolean partieFinie = isOver(boardGames.getGameCounter(), boardGames.getDrawCounter());
        boolean partieGagnee = isWinning();

        display.display(boardGames.getRepresentation());

        while(!partieFinie && !partieGagnee){
            tourJoueur();
            partieGagnee = isWinning();
            partieFinie = isOver(boardGames.getGameCounter(), boardGames.getDrawCounter());
        }
        if(partieGagnee){
            display.winMessage();
        }
        if(partieFinie && !partieGagnee){
            display.drawMessage();
        }
    }
}

