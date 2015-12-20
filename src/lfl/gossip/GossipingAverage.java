//import java.text.DecimalFormat;
//import java.util.ArrayList;
//import java.util.Scanner;
//
//
//public class GossipingAverage {
//										
//	static DecimalFormat df = new DecimalFormat("###.00000");  
//	
//	public static void main(String[] args){
//		long beginTime = System.currentTimeMillis();
//		
//		GossipingPerform perform = new GossipingPerform();
//		perform.initialize();
//		perform.action();
//		perform.display();
//		
//		long endTime = System.currentTimeMillis();
//		System.out.print("time spent: "+(df.format((endTime-beginTime)*0.001)+" s\n"));
//	}
//	
//	
//	
//}
//
//class GossipingPerform{
//	DecimalFormat    df   = new DecimalFormat("###.00");   
//	static ArrayList<Node> nodes = new ArrayList();
//	Scanner sc = new Scanner(System.in);
//	static int n;										//the number of nodes
//	static double k;									//attenuation
//	static int round = 0;							    //times
//	
//	void initialize(){
//		
//		System.out.println("How many nodes?");
//		n = sc.nextInt();
//	
//		for(int i=0;i<n;i++){
//			Node node = new Node();
//			nodes.add(node);
//		}
//		
//		System.out.println("attenuation? 0-1");
//		k= sc.nextDouble();
//		
//		System.out.println("Initialization\n");
//		for(int i=0;i<n;i++){
//			nodes.get(i).setIdentifier(i);
//			nodes.get(i).setValue(Double.valueOf(df.format(Math.random()*100)));
//			nodes.get(i).setInterest(1);
//			System.out.println("<"+i+">"+": "+nodes.get(i).getValue());
//		}
//		System.out.println("\n");
//	}
//	
//	
//	void action(){
//			infect(nodes.get(0),nodes.get((int)(Math.random()*n)));
//	}
//	
//	
//	static void infect(Node sender,Node acceptor){
//		if(!acceptor.isRemoved()){
//			if(sender.getInterest()<=0.05){
//				sender.setRemoved(true);
//				return;
//			}
//			if(acceptor.isInfected()){
//				sender.setInterest((sender.interest*k));
//			}
//			
//			acceptor.setInfected(true);
//			sender.setValue((sender.getValue()+acceptor.getValue())/2);
//			acceptor.setValue((sender.getValue()+acceptor.getValue())/2);
//		
//			System.out.println("<"+sender.getIdentifier()+">"+"infect"+"<"+acceptor.getIdentifier()+">");
//			
//			round = round + 1;
//			
//			infect(sender,nodes.get((int)(Math.random()*n)));
//			infect(acceptor,nodes.get((int)(Math.random()*n)));
//		}
//	}
//	
//	void display(){
//		System.out.println("result:");
//		for(int i=0;i<n;i++){
//			System.out.println("<"+i+">"+": "+nodes.get(i).getValue());
//		}
//		System.out.println("calculation number of times: "+round);
//		System.out.println("attenuation: "+k);
//	}
//}
