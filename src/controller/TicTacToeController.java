package controller;
import model.BoardGamesModel;
import model.CellModel;
import model.PlayerModel;
import model.TictactoeBoardModel;
import view.DisplayView;
import util.TupleUtil;

import java.util.Scanner;

public class TicTacToeController implements GameController{
    Scanner scanner;
    BoardGamesModel boardGames;
    DisplayView display;


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
    private int[] getMoveFromPlayer(){
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
    private int[] getMoveFromComputer(){
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
    private int[] getCoordsOfComputer(){
        int x = (int) ((Math.random() * (3-0)) + 0);
        int y = (int) ((Math.random() * (3-0)) + 0);
        return new int[]{y,x};
    }
    /**
     * Function to get the input from a player and verify if they are within the bounds. Return an array of 2 integers.
     *
     * @return
     */
    private int[] getCoordsWithinBounds() {
        int x = -1;
        int y = -1;
        int tailleMaxAbscisse = boardGames.getDimensions()[0] - 1;
        int tailleMaxOrdonnee = boardGames.getDimensions()[1] - 1;

        while (x < 0 || x > tailleMaxAbscisse) {
            display.instructionXAxis(tailleMaxAbscisse);
            if (scanner.hasNextInt()) {
                x = scanner.nextInt();
            } else {
                display.errorInteger();
                scanner.next();
            }
            if(x != -1 && (x < 0 || x > tailleMaxAbscisse)){
                display.errorOutOfBounds(tailleMaxAbscisse);
            }
        }
        while (y < 0 || y > tailleMaxOrdonnee) {
            display.instructionYAxis(tailleMaxOrdonnee);

            if (scanner.hasNextInt()) {
                y = scanner.nextInt();
            } else {
                display.errorInteger();
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
    private void capture(PlayerModel player, int abscisse, int ordonnee){
        boardGames.getPlateau()[abscisse][ordonnee].setRepresentation(player.getRepresentation());
    }

    /**
     * Function to define the turn of a player
     *
     */
    private void turn(){
        PlayerModel currentPlayer = boardGames.getCurrentPlayer();
        int[] coordonnees;
        display.display("Joueur " + currentPlayer.getIdentity() + " à toi de jouer !");
        if(!currentPlayer.getHuman()){
            coordonnees = getMoveFromComputer();
        }else{
            coordonnees = getMoveFromPlayer();
        }
        capture(currentPlayer, coordonnees[0], coordonnees[1]);
        boardGames.nextPlayer();
        display.display(boardGames.getRepresentation());
    }

    /**
     * Function which returns true if the game is over
     *
     * @param gameCounter
     * @param drawCounter
     * @return
     */
    private boolean isOver(int gameCounter, int drawCounter){
        drawCounter = boardGames.getDrawCounter();
        gameCounter = boardGames.getGameCounter();
        if(gameCounter < drawCounter){
            boardGames.incrementGameCounter();
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
    private boolean checkRow(CellModel[] row){
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
    private boolean checkColumn(CellModel[] column){
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
     * @param diagTopToBottom
     * @return
     */
    private boolean checkDiagTopToBottom(CellModel[] diagTopToBottom){
        String potentialWinner = diagTopToBottom[0].getRepresentation();
        for(CellModel cell : diagTopToBottom){
            if(cell.getRepresentation() == "|   "){
                return false;
            }
        }
        for(CellModel cell : diagTopToBottom){
            if(potentialWinner != cell.getRepresentation()){
                return false;
            }
        }
        return true;
    }

    /**
     * Function to check if the diagonale from bottom to top is winning. Return a boolean
     *
     * @param diagBottomToTop
     * @return
     */
    private boolean checkDiagBottomToTop(CellModel[] diagBottomToTop){
        String potentialWinner = diagBottomToTop[0].getRepresentation();
        for(CellModel cell : diagBottomToTop){
            if(cell.getRepresentation() == "|   "){
                return false;
            }
        }
        for(CellModel cell : diagBottomToTop){
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
    private boolean isWinning(){
        return (isAnyRowWinning())
                || (isAnyColumnWinning())
                || (checkDiagTopToBottom(boardGames.getDiagTopToBottom()))
                || (checkDiagBottomToTop(boardGames.getDiagBottomToTop()));
    }

    /**
     * Function which defines the execution of the game
     *
     */
    public void runOfTheGame(){
        boolean partieFinie = isOver(boardGames.getGameCounter(), boardGames.getDrawCounter());
        boolean partieGagnee = isWinning();

        display.display(boardGames.getRepresentation());

        while(!partieFinie && !partieGagnee){
            turn();
            partieGagnee = isWinning();
            partieFinie = isOver(boardGames.getGameCounter(), boardGames.getDrawCounter());
        }
        if(partieGagnee){
            boardGames.nextPlayer();
            display.winMessage(boardGames.getCurrentPlayer());
        }
        if(partieFinie && !partieGagnee){
            display.drawMessage();
        }
    }
}

