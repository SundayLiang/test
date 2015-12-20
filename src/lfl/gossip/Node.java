package lfl.gossip;

public class Node {
	private double value2;
	private double spreadProbability = 1;
	private boolean isSpreaded = false;
	private double decreaseProbability;
	
	public Node(double value,double decreaseProbability){
		this.value2 = value;
		this.decreaseProbability = decreaseProbability;
	}
	
	public void push(Node node){
		if (!node.getIsSpreaded()) {
			double newValue = (this.value2+node.getValue())/2;
			setValue(newValue);
			node.setValue(newValue);
//			System.out.println(getValue());
//			System.out.println(node.getValue());
			
			node.setIsSpreaded(true);
		}
		else{
			this.spreadProbability -= this.decreaseProbability;
		}

	}
	
	
	public double getValue() {
		return value2;
	}
	public void setValue(double value) {
		this.value2 = value;
	}
	public double getSpreadProbability() {
		return spreadProbability;
	}
	public void setSpreadProbability(double spreadProbability) {
		this.spreadProbability = spreadProbability;
	}

	public boolean getIsSpreaded() {
		return isSpreaded;
	}

	public void setIsSpreaded(boolean isSpreaded) {
		this.isSpreaded = isSpreaded;
	}
	
	
}
