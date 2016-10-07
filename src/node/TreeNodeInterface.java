package node;


public interface TreeNodeInterface {
	 // public double getPoints()
    //   -->  returns the points field of the specified TreeNode
    //
    // public void setPoints(double d)
    //   -->  sets the points field of the specified TreeNode to d
    //
    // public double getCircumferance()
    //   -->  returns the circumferance field of the specified TreeNode
    //
    // public void setCircumferance(double d)
    //   -->  sets the circumferance field of the specified TreeNode to d
    //
    // public double getHeight()
    //   -->  returns the height field of the specified TreeNode
    //
    // public void setHeight(double d)
    //   -->  sets the height field of the specified TreeNode to d
    //
    // public double getCrownSpread()
    // -->  returns the crownSpread field of the specified TreeNode
    //
    // public void setCrownSpread(double d)
    // -->  sets the crownSpread field of the specified TreeNode to d
    //
    // public String getYrStarted()
    // -->  returns the yrStarted field of the specified TreeNode
    //
    // public void setYrStarted(String s)
    // -->  sets the yrStarted field of the specified TreeNode to s
    //
    // public String getYrEnded()
    // -->  returns the yrEnded field of the specified TreeNode
//-->  returns the yrEnded field of the specified TreeNode
    //
    // public void setYrEnded(String s)
    // -->  sets the yrEnded field of the specified TreeNode to s
    //
    // public String getName()
    // -->  returns the personName field of the specified TreeNode
    //
    // public void setName(String s)
    // -->  sets the personName field of the specified TreeNode to s
    //
    // public TreeNode getDownPtr()
    // -->  returns the downPtr field of the specified TreeNode
    //
    // public void setLastPtr(TreeNode p);
    //   -->  sets the downPtr field of the specified TreeNode to p
    //
    //****************************************************************************
    /**
    * Protocol for TreeNodeInterface
    * @author James Comer
    */
    //Method signatures
    public double getPoints();
    public void setPoints(double d);
    public double getCircumferance();
    public void setCircumferance(double d);
    public double getHeight();
    public void setHeight(double d);
    public double getCrownSpread();
    public void setCrownSpread(double d);
    public String getYrStarted();
    public void setYrStarted(String s);
    public String getYrEnded();
    public void setYrEnded(String s);
    public String getName();
    public void setName(String s);
    public TreeNode getDownPtr();
    public void setDownPtr(TreeNode p);;
}
