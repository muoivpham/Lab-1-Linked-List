package node;


public interface SpeciesNodeInterface {
	// ******************PUBLIC METHODS******************************************
    // public String getCommonName()
    //   -->  returns the commonName field of the specified SpeciesNode
    //
    // public void setCommonName(String s)
    //   -->  sets the commonName field of the specified SpeciesNode to s
    //
    // public String getScientificName()
    //   -->  returns the scientificName field of the specified SpeciesNode
    //
    // public void setScientificName(String s)
    //   -->  sets the scientificName field of the specified SpeciesNode to s
    //
    // public int getNumTrees()
    //   -->  returns the numTrees field of the specified SpeciesNode
    //
    // public void setNumTrees(int n)
    //   -->  sets the numTrees field of the specified SpeciesNode to n
    //
    // public TreeNode getDownPtr()
    // -->  returns the downPtr field of the specified SpeciesNode
    //
    // public void setDownPtr(TreeNode p)
    // -->  sets the downPtr field of the specified SpeciesNode to p
    //
    // public void setLastPtr(TreeNode p)
    // -->  sets the lastPtr field of the specified SpeciesNode to point to p
    //
    // public TreeNode getLastPtr);
    //   -->  returns the lastPtr field of the specified SpeciesNode
    //
    //****************************************************************************
/**
    * Protocol for SpeciesNodeInterface
    * @author James Comer
    */
    //Method signatures
    public String getCommonName();
    public void setCommonName(String s);
    public String getScientificName();
    public void setScientificName(String s);
    public int getNumTrees();
    public void setNumTrees(int n);
    public TreeNode getDownPtr();
    public void setDownPtr(TreeNode p);
    public TreeNode getLastPtr();
    public void setLastPtr(TreeNode p);
}
