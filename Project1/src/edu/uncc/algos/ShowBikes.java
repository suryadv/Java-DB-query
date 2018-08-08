package edu.uncc.algos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;

public class ShowBikes {
	
	BikeList bl;
	
	
	public static void main(String[] args) {
		String fileName ="database.txt";
		BufferedReader br = null;
		ShowBikes sb = (new ShowBikes());
		try{
			br = new BufferedReader(new FileReader(fileName));
		    String line = br.readLine();
		    
		    sb.bl = new BikeList();

		    while (line != null) {
		        String[] bikeArr = line.split(",");		        
		        Bike bike = new Bike(bikeArr[0],bikeArr[1],bikeArr[3],bikeArr[2],bikeArr[4],bikeArr[5]);		        
		        sb.bl.addNode(bike);
		        line = br.readLine();
		    }
		    
		    //System.out.println(sb.bl);
		    sb.searchBike(args);		    
		    
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void searchBike(String[] criteria){
		Map<String, String> argMap = new HashMap<String,String>();
		String sortAttr = "";
		for(int i =0; i<criteria.length; i++){
	    	if(i%2 == 0){	    		
	    		if(i == criteria.length-1){
	    			sortAttr = criteria[i];
	    		}else{		
					argMap.put(criteria[i],criteria[i+1]);
	    		}
	    	}
	    }
		
		System.out.println("args size: "+argMap.size());
		
		//search
		
		BikeNode n = bl.getHead();
		
		ArrayList<Bike> resultBikes = new ArrayList<Bike>();
		
		while(n!=null){
			Bike bike = n.getBike();
			String type = bike.getType();
			Iterator it = argMap.entrySet().iterator();
			String[] valArr = new String[6];
			
			boolean flag = true;
			int flag1 = 0;
		    while (it.hasNext()) {
		        Map.Entry<String, String> pair = (Map.Entry<String, String>)it.next();	   
	        	if(pair.getKey().contains("type")){
	        		if(flag1==0){
	        			if(type.equals(pair.getValue())){
	        				flag1 = 1;
		        		}else{
		        			flag = false;
		        			break;
		        		}
	        		}else{
	        			if(!type.equals(pair.getValue())){
	        				flag = false;
	        				break;
		        		}
	        		}
	        		
				}else if(pair.getKey().contains("gear")){
					if(flag1==0){
	        			if(bike.getGear().equals(pair.getValue())){
	        				flag1 = 1;
		        		}else{
		        			flag = false;
		        			break;
		        		}
	        		}else{
	        			if(!bike.getGear().equals(pair.getValue())){
	        				flag = false;
	        				break;
		        		}
	        		}
				}else if(pair.getKey().contains("wheelbase")){
					if(flag1==0){
	        			if(bike.getWhl_base().equals(pair.getValue())){
	        				flag1 = 1;
		        		}else{
		        			flag = false;
		        			break;
		        		}
	        		}else{
	        			if(!bike.getWhl_base().equals(pair.getValue())){
	        				flag = false;
	        				break;
		        		}
	        		}
				}else if(pair.getKey().contains("height")){
					if(flag1==0){
						if(bike.getHeight().equals(pair.getValue())){
	        				flag1 = 1;
		        		}else{
		        			flag = false;
		        			break;
		        		}
	        		}else{
	        			if(!bike.getHeight().equals(pair.getValue())){
	        				flag = false;
	        				break;
		        		}
	        		}
				}else if(pair.getKey().contains("color")){
					if(flag1==0){
	        			if(bike.getColor().equals(pair.getValue())){
	        				flag1 = 1;
		        		}else{
		        			flag = false;
		        			break;
		        		}
	        		}else{
	        			if(!bike.getColor().equals(pair.getValue())){
	        				flag = false;
	        				break;
		        		}
	        		}
				}else if(pair.getKey().contains("material")){
					if(flag1==0){
	        			if(bike.getMaterial().equals(pair.getValue())){
	        				flag1 = 1;
		        		}else{
		        			flag = false;
		        			break;
		        		}
	        		}else{
	        			if(!bike.getMaterial().equals(pair.getValue())){
	        				flag = false;
	        				break;
		        		}
	        		}
				}
		    }
		    
		    
		    if(flag){
        		resultBikes.add(bike);
        	}
		    
			n = n.getNext();
		}
		
		System.out.println("result size: "+resultBikes.size());
		
		if(!"".equals(sortAttr)){
			
			if(sortAttr.contains("gear")){
				Collections.sort(resultBikes, new Comparator<Bike>() {
					public int compare(Bike b1, Bike b2){
						return Integer.parseInt(b1.getGear())-Integer.parseInt(b2.getGear());
					}
				});
			}else if(sortAttr.contains("wheelbase")){
				Collections.sort(resultBikes, new Comparator<Bike>() {
					public int compare(Bike b1, Bike b2){
						return Integer.parseInt(b1.getWhl_base())-Integer.parseInt(b2.getWhl_base());
					}
				});
			}else if(sortAttr.contains("height")){
				Collections.sort(resultBikes, new Comparator<Bike>() {
					public int compare(Bike b1, Bike b2){
						return Integer.parseInt(b1.getHeight())-Integer.parseInt(b2.getHeight());
					}
				});
			}else if(sortAttr.contains("color")){
				Collections.sort(resultBikes, new Comparator<Bike>() {
					public int compare(Bike b1, Bike b2){
						return b1.getColor().compareTo(b2.getColor());
					}
				});
			}else if(sortAttr.contains("type")){
				Collections.sort(resultBikes, new Comparator<Bike>() {
					public int compare(Bike b1, Bike b2){
						return b1.getType().compareTo(b2.getType());
					}
				});
			}else if(sortAttr.contains("material")){
				Collections.sort(resultBikes, new Comparator<Bike>() {
					public int compare(Bike b1, Bike b2){
						return b1.getMaterial().compareTo(b2.getMaterial());
					}
				});
			}
			
		}
		
		for(Bike b: resultBikes){
			System.out.println(b);
		}
		
	}

}
