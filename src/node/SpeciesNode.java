package node;

public class SpeciesNode implements SpeciesNodeInterface {

	private String commonName;
	private String scientificName;
	private int numTrees;
	private TreeNode downPtr;
	private TreeNode lastPtr;
	private SpeciesNode rightPtr;

	public SpeciesNode(String commonName, String scientificName) {
		// TODO Auto-generated constructor stub
		this.commonName = commonName;
		this.scientificName = scientificName;
	}

	@Override
	public String getCommonName() {
		// TODO Auto-generated method stub
		return this.commonName;
	}

	@Override
	public void setCommonName(String s) {
		// TODO Auto-generated method stub
		this.commonName = s;
	}

	@Override
	public String getScientificName() {
		// TODO Auto-generated method stub
		return this.scientificName;
	}

	@Override
	public void setScientificName(String s) {
		// TODO Auto-generated method stub
		this.scientificName = s;
	}

	@Override
	public int getNumTrees() {
		// TODO Auto-generated method stub
		return this.numTrees;
	}

	@Override
	public void setNumTrees(int n) {
		// TODO Auto-generated method stub
		this.numTrees = n;
	}

	@Override
	public TreeNode getDownPtr() {
		// TODO Auto-generated method stub
		return this.downPtr;
	}

	@Override
	public void setDownPtr(TreeNode p) {
		// TODO Auto-generated method stub
		this.downPtr = p;
	}

	@Override
	public TreeNode getLastPtr() {
		// TODO Auto-generated method stub
		return this.lastPtr;
	}

	@Override
	public void setLastPtr(TreeNode p) {
		// TODO Auto-generated method stub
		this.lastPtr = p;
	}

	public void setRightPtr(SpeciesNode p) {
		this.rightPtr = p;
	}

	public SpeciesNode getRightPtr() {
		return this.rightPtr;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub

		String ans = this.getCommonName() + "/" + this.getScientificName();
		SpeciesNode p = this;

		while (p.rightPtr != this) {
			ans = ans + " -->  " + p.rightPtr.getCommonName() + "/" + p.rightPtr.getScientificName();
			p = p.rightPtr;

		}

		return ans;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		SpeciesNode p = this;
		SpeciesNode newHead = new SpeciesNode("Head", "");
		SpeciesNode newp = newHead;

		while (p.rightPtr != this) {
			SpeciesNode newNode = new SpeciesNode(p.rightPtr.commonName, p.rightPtr.scientificName);

			newp.rightPtr = newNode;
			
			newp = newp.rightPtr;
			p = p.rightPtr;
		}
		newp.rightPtr = newHead;

		return newHead;
	}
}
