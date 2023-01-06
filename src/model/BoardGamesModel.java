package model;
import view.DisplayView;

import controller.MenuController;

public class BoardGamesModel {

    private int width;
    private int height;

    private final int drawCounter;

    int gameCounter = 0;
    int currentPlayerId = 1;

    MenuController menu;
    DisplayView display;
    private CellModel[][] plateau;

    PlayerModel player1;
    PlayerModel player2;

    /**
     * Constructors
     *
     */
    public BoardGamesModel(){
        this(3,3);
    }

    public BoardGamesModel(int width, int height){
        this.width = width;
        this.height = height;
        this.drawCounter = width*height;
        this.plateau = new CellModel[width][height];
        for (int i = 0; i < width; i++){
            for (int j = 0; j < height; j++){
                this.plateau[i][j] = new CellModel();
            }
        }
        this.display = new DisplayView();
    }

    public BoardGamesModel(PlayerModel p1, PlayerModel p2, int width, int height){
        this(width, height);
        this.player1 = p1;
        this.player2 = p2;
    }
    public BoardGamesModel(PlayerModel p1, PlayerModel p2){
        this();
        this.player1 = p1;
        this.player2 = p2;
    }

    /**
     *  Function which returns the dimensions of the board (array of 2 integers)
     *
     * @return
     */
    public int[] getDimensions(){
        return new int[]{width, height};
    }

    /**
     *  Function which returns the board (2D array of objects)
     *
     * @return
     */
    public CellModel[][] getPlateau() {
        return this.plateau;
    }

    /**
     * Function which manages who is the current player and return it
     *
     * @return
     */
    public PlayerModel getCurrentPlayer(){
        if(currentPlayerId == 1){
            currentPlayerId ++;
            return player1;
        }else{
            currentPlayerId --;
            return player2;
        }
    }

    /**
     * Function which returns gameCounter
     *
     * @return
     */
    public int getGameCounter(){
        return this.gameCounter;
    }

    /**
     * Function which returns the drawCounter
     *
     * @return
     */
    public int getDrawCounter(){
        return this.drawCounter;
    }

    /**
     * Function which increments the gameCounter
     *
     */
    public void setGameCounter(){
        this.gameCounter ++;
    }

    /**
     * Function which returns true if the cell is empty
     *
     * @param abscisse
     * @param ordonnee
     * @return
     */
    public boolean cellIsEmpty(int abscisse, int ordonnee){

        if(plateau[abscisse][ordonnee].representation == "|   " ){
            return true;
        } else {
            display.notEmptyMessage(abscisse, ordonnee);
            return false;
        }
    }

    /**
     * Function which returns true if the cell is empty but don't display a message (because of computer's move)
     *
     * @param abscisse
     * @param ordonnee
     * @return
     */
    public boolean cellIsEmptyComputer(int abscisse, int ordonnee){

        if(plateau[abscisse][ordonnee].representation == "|   " ){
            return true;
        } else {
            return false;
        }
    }

    /**
     * Function which returns the board representation
     *
     * @return
     */
    public String getRepresentation(){

        int width = this.width;
        int height = this.height;
        String repr = "";
        String separator ="----";

        repr = repr + "     ";
        for(int k = 0; k < width; k++){
            repr = repr + k+"   ";
        }
        repr = repr +"\n";
        for(int i = 0; i < width; i++){
            repr = repr + "   ";
//            repr = repr + "-------------\n";

            repr = repr + "-" + separator.repeat(width) + "\n";
            repr = repr + i;
            repr = repr + "  ";

            for(int j = 0; j < height; j++){
                repr = repr + this.plateau[i][j].getRepresentation();
            }
            repr = repr + "|\n";
        }
        repr = repr + "   ";
        repr = repr + separator.repeat(width)+ "\n";
        return repr;
    }

    /**
     * Function which returns a row (array of objects)
     *
     * @param rowNumber
     * @return
     */
    public CellModel[] getRow(int rowNumber){
        CellModel[] row = new CellModel[this.height];
        for(int j = 0; j < this.height; j++){
            row[j] = this.plateau[rowNumber][j];
        }
        return row;
    }

    /**
     * Function which returns a column (array of objects)
     *
     * @param columnNumber
     * @return
     */
    public CellModel[] getColumn(int columnNumber){
        CellModel[] column = new CellModel[this.width];
        for(int i = 0 ; i < this.width ; i++){
            column[i] = this.plateau[i][columnNumber];
        }
        return column;

    }

    /**
     * Function which returns the diagonale from top to bottom (array of objects)
     *
     * @return
     */
    public CellModel[] getDiagTopToBottom(){
        int j = 0;
        CellModel[] diag = new CellModel[this.width];
        for(int i = 0 ; i < this.width ; i++){
            diag[i] = this.plateau[i][j];
            j++;
        }
        return diag;
    }

    /**
     * Function which returns the diagonale from bottom to top (array of objects)
     *
     * @return
     */
    public CellModel[] getDiagBottomToTop(){
        int j = this.height -1 ;
        CellModel[] diag = new CellModel[this.width];
        for(int i = 0 ; i < this.width ; i++){
            diag[i] = this.plateau[i][j];
            j--;
        }
        return diag;
    }
}
