package model;

import model.BoardGames;

//package model;
public class GomokuBoard extends BoardGames {

    public GomokuBoard(){
        super (5, 5);
    }
    public GomokuBoard(Player p1, Player p2){
        super(p1,p2, 5, 5);
    }
}
