package model;

public class ArtificialPlayerModel extends PlayerModel {

    /** Constructor
     *
     * @param representation
     * @param identity
     */
    public ArtificialPlayerModel(String representation, int identity){
        super(representation, identity);
        this.isHuman = false;
    }
}
