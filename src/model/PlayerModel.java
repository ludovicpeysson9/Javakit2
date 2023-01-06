package model;

//package model;
public class PlayerModel {
    private String representation;
    private int identity;

    protected boolean isHuman;

    /**
     * Constructor
     *
     * @param representation
     * @param identity
     */
    public PlayerModel(String representation, int identity){

        this.representation = representation;
        this.identity = identity;
        this.isHuman = true;
    }

    /**
     * Function which returns representation
     *
     * @return
     */
    public String getRepresentation(){
        return this.representation;
    }

    /**
     *  Function which returns identity
     *
     * @return
     */
    public int getIdentity(){
        return this.identity;
    }

    /**
     *  Function which returns if the player is Human
     *
     * @return
     */
    public boolean getHuman() {
        return isHuman;
    }
}
