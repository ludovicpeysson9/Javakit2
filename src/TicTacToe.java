public class TicTacToe {
    final int size = 3;
    Cell[][] plateau = new Cell[size][size];

    public TicTacToe(){ //TODO A refaire en boucle normale
        for(Cell[] row : plateau){
            for(Cell cell : row){
                cell = new Cell();
            }
        }
    }
    public void display(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++)
                System.out.print(plateau[i][j].getRepresentation());

            System.out.println();
        }
    }
}
