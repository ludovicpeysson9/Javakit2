public class BoardGames {

    private int width;
    private int height;

    private final int drawCounter;

    int gameCounter = 0;
    int currentPlayerId = 1;
    private Cell[][] plateau;

    Player player1 = new Player("| X ", 1);
    Player player2 = new Player("| O ", 2);

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
    }
    public int[] getDimensions(){
        return new int[]{width, height};
    }

//    public void createPlateau(){
//
//    }
    public Cell[][] getPlateau() {
        return this.plateau;
    }

    public Player getCurrentPlayer(){
        if(currentPlayerId == 1){
            currentPlayerId ++;
            return player1;
        }else{
            currentPlayerId --;
            return player2;
        }
    }

    public int getGameCounter(){
        return this.gameCounter;
    }
    public int getDrawCounter(){
        return this.drawCounter;
    }
    public void setGameCounter(){
        this.gameCounter ++;
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

    public String getRepresentation(){
        int width = this.width;
        int height = this.height;
        String repr = "";

        repr = repr + "     0   1   2\n";
        for(int i = 0; i < width; i++){
            repr = repr + "   ";
//            System.out.println("        " + i +"   ");
            repr = repr + "-------------\n";
            repr = repr + i;
            repr = repr + "  ";
            for(int j = 0; j < height; j++){

//                System.out.print(plateau[i][j].getRepresentation());
                //FIXME tableau inversé pour avoir les coordonnées en abscisse et en ordonnées
                repr = repr + this.plateau[i][j].getRepresentation();
//                System.out.print(this.plateau[i][j].getRepresentation());

            }
            repr = repr + "|\n";
        }
        repr = repr + "   ";
        repr = repr + "-------------\n";
//        System.out.print("   ");
//        System.out.print("-------------");
//        System.out.println();
        return repr;
    }

    public Cell[] getRow(int rowNumber){
        Cell[] row = new Cell[this.height];
        for(int j = 0; j < this.height; j++){
            row[j] = this.plateau[rowNumber][j];
        }
        return row;
    }

    public Cell[] getColumn(int columnNumber){
        Cell[] column = new Cell[this.width];
        for(int i = 0 ; i < this.width ; i++){
            column[i] = this.plateau[i][columnNumber];
        }
        return column;

    }

    public Cell[] getDiagTopToBottom(){
        int j = 0;
        Cell[] diag = new Cell[this.width];
        for(int i = 0 ; i < this.width ; i++){
            diag[i] = this.plateau[i][j];
            j++;
        }
        return diag;
    }

    public Cell[] getDiagBottomToTop(){
        int j = 2;
        Cell[] diag = new Cell[this.width];
        for(int i = 0 ; i < this.width ; i++){
            diag[i] = this.plateau[i][j];
            j--;
        }
        return diag;
    }

//    public Cell[] getDiag(){
//
//        return null;
//    }


}
