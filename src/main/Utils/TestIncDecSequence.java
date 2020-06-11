package main.Utils;

import java.util.ArrayList;

public class TestIncDecSequence {
	private ArrayList<Double> list;
	private String type;
	
	public TestIncDecSequence(ArrayList<Double> list) {
		this.list = list;
		setType();
	}
	
	private void setType() {
		double check = list.get(0) - list.get(1);
		if(check > 0) type = "tăng";
		else type = "giảm";
	}
	
	public int countNumSequence() {
		int seq = 1;
		
		if(type.equals("giảm")) {
			while(list.get(seq+1) > list.get(seq)) {
				seq ++;
			}
		} else {
			while(list.get(seq+1) < list.get(seq)) {
				seq ++;
			}
		}
		
		return seq;
	}
	
	public String getType() {
		return type;
	}
}
