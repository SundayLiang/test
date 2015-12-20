package lfl.gossip;

public class Gossip {
	private Node[] nodes;
	public int size;
	
	public Gossip(int size){
		this.size = size;
	}
	
	public void run(){
		nodes = new Node[size];
		for (int i = 0; i < nodes.length; i++) {
			nodes[i] = new Node(i+1, 0.1);
		}
		for (int i = 0; i < nodes.length; i++) {
			while(nodes[i].getSpreadProbability()>=0) {
				if (Math.random()<=nodes[i].getSpreadProbability()) {
					int iterator = (int)(Math.random()*(nodes.length));
					System.out.println("************************************************");
					nodes[i].push(nodes[iterator]);
					
					System.out.println("Node["+i+"] : "+nodes[i].getValue());
					System.out.println("Node["+iterator+"] : "+nodes[iterator].getValue());
				}
			}
		}
		System.out.println("--------------------------------------------------");
		for (int i = 0; i < nodes.length; i++) {
			System.out.println("Node["+i+"] : "+nodes[i].getValue());
		}
		
		
		System.out.println("aaa");
		
	}
	
}
