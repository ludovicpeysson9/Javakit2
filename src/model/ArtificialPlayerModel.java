package model;

public class ArtificialPlayerModel extends PlayerModel {
    public ArtificialPlayerModel(String representation, int identity){
        super(representation, identity);
        this.isHuman = false;
    }
}
