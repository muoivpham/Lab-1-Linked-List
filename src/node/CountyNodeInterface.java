package node;



public interface CountyNodeInterface {

    // ******************PUBLIC METHODS******************************************
    // public String getCountyName();
    //    --> returns the countyName of the node being pointed to
    //
    // public void setCountyName(String cn);
    //    --> sets the countyName of the node being pointed to to cn.
    //
    // public int getNumTrees();
    //    --> returns the numTrees field of the CountyNode being pointed to
    //
    // public void setNumTrees(int nt);
    //    --> sets the numTrees field of the CountyNode being pointed to to nt.
    //
    // public CountyNode getDown();
    //    --> returns the value of the downPtr for the specified CountyNode
    //
    // public void setDown(CountyNode ptr);
    //    --> sets the downPtr of the specified CountyNode to ptr
    //
    // public SpeciesNode getRight();
    //    --> returns the value of the rightPtr for the specified CountyNode
    //
    // public void setRight(SpeciesNode ptr);
    //    --> sets the rightPtr of the specified CountyNode to ptr
      //**************************************************************************
/**
    * Protocol for CountyNameNodeInterface
    * @author James Comer
    */
    //Method signatures
    public String getCountyName();
    public void setCountyName(String cn);
    public int getNumTrees();
    public void setNumTrees(int nt);
    public CountyNode getDown();
    public void setDown(CountyNode ptr);
    public SpeciesNode getRight();
    public void setRight(SpeciesNode ptr);
}
