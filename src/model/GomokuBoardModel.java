package model;

//package model;
public class GomokuBoardModel extends BoardGamesModel {

    /** Constructors
     *
     */
    public GomokuBoardModel(){
        super (15, 15);
    }
    public GomokuBoardModel(PlayerModel p1, PlayerModel p2){
        super(p1,p2, 15, 15);
    }
}
