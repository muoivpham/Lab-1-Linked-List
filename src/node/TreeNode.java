package node;

public class TreeNode implements TreeNodeInterface {
	private double points;
	private double circumferance;
	private double height;
	private double crownSpread;
	private String yrStarted;
	private String yrEnded;
	private String treeName;
	private String namePerson;
	private TreeNode downPtr;

	public TreeNode() {
		// TODO Auto-generated constructor stub
		points = 0;
		circumferance = 0;
		height = 0;
		crownSpread = 0;
		yrStarted = "";
		yrEnded = "";
		treeName = "";
		namePerson = "";
		downPtr = null;

	}
	
	public TreeNode(String[] info){
		treeName = info[0];
		points = Double.parseDouble(info[1]);
		circumferance = Double.parseDouble(info[2]);
		height =  Double.parseDouble(info[3]);
		crownSpread =  Double.parseDouble(info[4]);
		yrStarted = info[5];
		yrEnded = info[6];
		namePerson = info[7];
	}

	public String getNamePerson() {
		return namePerson;
	}

	public void setNamePerson(String namePerson) {
		this.namePerson = namePerson;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String ans = "";
		TreeNode p = this;
		if (p != null) {
			ans = ans + p.getPoints() + "/" + p.getCircumferance() + "/" + p.getHeight() + "/" + p.getCrownSpread()
					+ "/" + p.yrStarted + "/" + p.yrEnded + "/" + p.namePerson + "\n";
			//p = p.downPtr;
		}
		return ans;
	}

	@Override
	public double getPoints() {
		// TODO Auto-generated method stub
		return this.points;
	}

	@Override
	public void setPoints(double d) {
		// TODO Auto-generated method stub
		this.points = d;
	}

	@Override
	public double getCircumferance() {
		// TODO Auto-generated method stub
		return this.circumferance;
	}

	@Override
	public void setCircumferance(double d) {
		// TODO Auto-generated method stub
		this.circumferance = d;
	}

	@Override
	public double getHeight() {
		// TODO Auto-generated method stub
		return this.height;
	}

	@Override
	public void setHeight(double d) {
		// TODO Auto-generated method stub
		this.height = d;
	}

	@Override
	public double getCrownSpread() {
		// TODO Auto-generated method stub
		return this.crownSpread;
	}

	@Override
	public void setCrownSpread(double d) {
		// TODO Auto-generated method stub
		this.crownSpread = d;
	}

	@Override
	public String getYrStarted() {
		// TODO Auto-generated method stub
		return this.yrStarted;
	}

	@Override
	public void setYrStarted(String s) {
		// TODO Auto-generated method stub
		this.yrStarted = s;
	}

	@Override
	public String getYrEnded() {
		// TODO Auto-generated method stub
		return this.yrEnded;
	}

	@Override
	public void setYrEnded(String s) {
		// TODO Auto-generated method stub
		this.yrEnded = s;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.treeName;
	}

	@Override
	public void setName(String s) {
		// TODO Auto-generated method stub
		this.treeName = s;
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

	public int compareTo(TreeNode other) {
		if (this.points > other.points)
			return 1;
		else if (this.points < other.points) {
			return -1;
		} else {
			if (this.circumferance > other.circumferance)
				return 1;
			else if (this.circumferance < other.circumferance)
				return -1;
			else {
				if (this.height > other.height)
					return 1;
				else if (this.height < other.height)
					return -1;
				else {
					if (this.crownSpread > other.crownSpread)
						return 1;
					else if (this.crownSpread < other.crownSpread)
						return -1;
					else {
						if (this.getNamePerson().compareTo(other.getNamePerson()) > 0) {
							return 1;
						} else if (this.getNamePerson().compareTo(other.getNamePerson()) < 0)
							return -1;
						else
							return 0;
					}
				}
			}
		}
	}

}
