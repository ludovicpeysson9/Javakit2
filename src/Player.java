//package model;
public class Player {
    private String representation;
    private int identity;

    protected boolean isHuman;
    public Player(String representation, int identity){

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

    public boolean isHuman() {
        return isHuman;
    }
}
