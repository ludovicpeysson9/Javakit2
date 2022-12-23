public class Player {
    private String representation;
    private int identity;
    public Player(String representation, int identity){

        this.representation = representation;
        this.identity = identity;
    }

    public String getRepresentation(){
        return this.representation;
    }
    public int getIdentity(){
        return this.identity;
    }
}
