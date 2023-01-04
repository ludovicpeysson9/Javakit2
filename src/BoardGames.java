//package model;

public class BoardGames {

    private int width;
    private int height;

    private final int drawCounter;

    int gameCounter = 0;
    int currentPlayerId = 1;

    Menu menu;
    Display display;
    private Cell[][] plateau;

    Player player1;
    Player player2;

    public BoardGames(){
        this(3,3);
    }

    public BoardGames(int width, int height){
        this.width = width;
        this.height = height;
        this.drawCounter = width*height;
        this.plateau = new Cell[width][height];
        for (int i = 0; i < width; i++){
            for (int j = 0; j < height; j++){
                this.plateau[i][j] = new Cell();
            }
        }
        this.display = new Display();
    }

    public BoardGames(Player p1, Player p2, int width, int height){
        this(width, height);
        this.player1 = p1;
        this.player2 = p2;
    }
    public BoardGames(Player p1, Player p2){
        this();
        this.player1 = p1;
        this.player2 = p2;
    }

    /** Function which returns the dimensions of the board (array of 2 integers)
     *
     * @return
     */
    public int[] getDimensions(){
        return new int[]{width, height};
    }

    /** Function which returns the board (2D array of objects)
     *
     * @return
     */
    public Cell[][] getPlateau() {
        return this.plateau;
    }

    /** Function which manages who is the current player and return it
     *
     * @return
     */
    public Player getCurrentPlayer(){
        if(currentPlayerId == 1){
            currentPlayerId ++;
            return player1;
        }else{
            currentPlayerId --;
            return player2;
        }
    }

    /** Function which returns gameCounter
     *
     * @return
     */
    public int getGameCounter(){
        return this.gameCounter;
    }

    /** Function which returns the drawCounter
     *
     * @return
     */
    public int getDrawCounter(){
        return this.drawCounter;
    }

    /** Function which increments the gameCounter
     *
     */
    public void setGameCounter(){
        this.gameCounter ++;
    }

    /** Function which returns true if the cell is empty
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
    public boolean cellIsEmptyComputer(int abscisse, int ordonnee){

        if(plateau[abscisse][ordonnee].representation == "|   " ){
            return true;
        } else {
            return false;
        }
    }

    /** Function which returns the board representation
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

    /** Function which returns a row (array of objects)
     *
     * @param rowNumber
     * @return
     */
    public Cell[] getRow(int rowNumber){
        Cell[] row = new Cell[this.height];
        for(int j = 0; j < this.height; j++){
            row[j] = this.plateau[rowNumber][j];
        }
        return row;
    }

    /** Function which returns a column (array of objects)
     *
     * @param columnNumber
     * @return
     */
    public Cell[] getColumn(int columnNumber){
        Cell[] column = new Cell[this.width];
        for(int i = 0 ; i < this.width ; i++){
            column[i] = this.plateau[i][columnNumber];
        }
        return column;

    }

    /** Function which returns the diagonale from top to bottom (array of objects)
     *
     * @return
     */
    public Cell[] getDiagTopToBottom(){
        int j = 0;
        Cell[] diag = new Cell[this.width];
        for(int i = 0 ; i < this.width ; i++){
            diag[i] = this.plateau[i][j];
            j++;
        }
        return diag;
    }

    /** Function which returns the diagonale from bottom to top (array of objects)
     *
     * @return
     */
    public Cell[] getDiagBottomToTop(){
        int j = this.height -1 ;
        Cell[] diag = new Cell[this.width];
        for(int i = 0 ; i < this.width ; i++){
            diag[i] = this.plateau[i][j];
            j--;
        }
        return diag;
    }
}
