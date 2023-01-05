package model;

//package model;
public class PlayerModel {
    private String representation;
    private int identity;

    protected boolean isHuman;
    public PlayerModel(String representation, int identity){

        this.representation = representation;
        this.identity = identity;
        this.isHuman = true;
    }

    public String getRepresentation(){
        return this.representation;
    }
    public int getIdentity(){
        return this.identity;
    }

    public boolean getHuman() {
        return isHuman;
    }
}
