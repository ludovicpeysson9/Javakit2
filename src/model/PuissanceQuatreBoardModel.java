package model;

//package model;
public class PuissanceQuatreBoardModel extends BoardGamesModel {

    /**
     * Constructors
     *
     */
    public PuissanceQuatreBoardModel(){
        super (7, 6);
    }
    public PuissanceQuatreBoardModel(PlayerModel p1, PlayerModel p2){
        super(p1, p2, 7,6);
    }
}
