package node;

public class CountyNode implements CountyNodeInterface {
	
	private String countyName;
	private int numTrees;
	private CountyNode downPtr;
	private SpeciesNode rightPtr;
	
	
	public CountyNode(String name) {
		// TODO Auto-generated constructor stub
		this.countyName = name;
		this.numTrees = 0;
		this.downPtr = null;
		this.rightPtr = null;
		
	}
	
	public CountyNode(String countyName, int numTrees, CountyNode downPtr, SpeciesNode rightPtr) {
		super();
		this.countyName = countyName;
		this.numTrees = numTrees;
		this.downPtr = downPtr;
		this.rightPtr = rightPtr;
	}



	public void add(CountyNode other){
		CountyNode p = this;
		while (p.downPtr != this){
			if (p.downPtr.compareTo(other) > 0){
				other.downPtr = p.downPtr;
				p.downPtr = other;
				return;
			} else if (p.downPtr.compareTo(other) == 0) {
			// add the same node -> increase numTree
				
			}
			p = p.downPtr;
		}
		other.downPtr = p.downPtr;
		p.downPtr = other.downPtr;
		
	}
	
	
	
	

		
	
	
	@Override
	public String getCountyName() {
		// TODO Auto-generated method stub
		
		return this.countyName;
	}

	@Override
	public void setCountyName(String cn) {
		// TODO Auto-generated method stub
		this.countyName = cn;
	}

	@Override
	public int getNumTrees() {
		// TODO Auto-generated method stub
		return this.numTrees;
	}

	@Override
	public void setNumTrees(int nt) {
		// TODO Auto-generated method stub
		this.numTrees = nt;
	}

	@Override
	public CountyNode getDown() {
		// TODO Auto-generated method stub
		return this.downPtr;
	}

	@Override
	public void setDown(CountyNode ptr) {
		// TODO Auto-generated method stub
		this.downPtr = ptr;
	}

	@Override
	public SpeciesNode getRight() {
		// TODO Auto-generated method stub
		
		return this.rightPtr;
	}

	@Override
	public void setRight(SpeciesNode ptr) {
		// TODO Auto-generated method stub
		this.rightPtr = ptr;
	}
	
	
	public int compareTo(CountyNode other){
		return this.countyName.compareTo(other.countyName);
	}
	
	public void addSameNode(CountyNode other){
		this.numTrees = this.numTrees + other.numTrees;
		SpeciesNode currentNode = other.rightPtr;
		
		
	}
	public String toString() {
		
		String ans = this.getCountyName();
		CountyNode p = this;
		
		while( p.downPtr != this ){
			ans = ans  + "->" + p.downPtr.countyName +" ("+p.downPtr.numTrees+") ";
			p = p.downPtr;
		}
		
		
		return ans;
	}

}
