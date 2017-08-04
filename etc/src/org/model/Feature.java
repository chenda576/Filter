package org.model;

public class Feature implements Comparable<Feature>{
	private String name;
	private double value;
	private int posFeq;
	private int negFeq;
	
	public Feature(){
		
	}
	
	public Feature(Feature feature){
		this.setName(feature.getName());
		this.setValue(feature.getValue());
		this.setPosFeq(feature.getPosFeq());
		this.setNegFeq(feature.getNegFeq());
	}
	
	public Feature(String name,double value,int posFeq,int negFeq){
		this.setName(name);
		this.setValue(value);
		this.setPosFeq(posFeq);
		this.setNegFeq(negFeq);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public int getPosFeq() {
		return posFeq;
	}

	public void setPosFeq(int posFeq) {
		this.posFeq = posFeq;
	}

	public int getNegFeq() {
		return negFeq;
	}

	public void setNegFeq(int negFeq) {
		this.negFeq = negFeq;
	}
	
	@Override
	public int compareTo(Feature o) {
		if(this.getValue()>((Feature) o).getValue()){
			return -1;
		}
		else if(this.getValue()<((Feature) o).getValue()){
			return 1;
		}
		else{
			return 0;
		}
	}
}
