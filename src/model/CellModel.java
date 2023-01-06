package model;

//package model;
public class CellModel {

    protected String representation = "|   ";


    /**
     *  Function which returns the representation of a cell
     *
     * @return
     */
    public String getRepresentation(){
        return representation;
    }

    /**
     * Function which sets representation the representation of the cell
     *
     * @param representation
     */
    public void setRepresentation(String representation){
        this.representation = representation;
    }
}
