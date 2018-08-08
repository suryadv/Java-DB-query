package edu.uncc.algos;

public class BikeList {
	
	private BikeNode head;
	
	
	
	public BikeNode getHead() {
		return head;
	}

	public void setHead(BikeNode head) {
		this.head = head;
	}

	public void addNode(Bike bike){
		BikeNode node = new BikeNode(bike);
		if(head==null){
			head = node;
		}else{
			BikeNode n = head;
			boolean flag = false;
			while(true){
				if(n.getNext()==null){
					flag = true;
					break;
				}
				n = n.getNext();
			}
			
			if(flag){
				n.setNext(node);
			}			
		}
	}

	@Override
	public String toString() {
		return "BikeList [head=" + head + "]";
	}
	
	
	
	

}
