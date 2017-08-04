package org.SquareTestPack;

import java.util.ArrayList;
import java.util.Collections;

import org.model.Feature;

public class STest {
	public void TestSquare(ArrayList<Feature> FeatureList,int pos){
		int A,B,C,D;
		Double r;
		String key;
		for(int i=0;i<FeatureList.size();i++){
		    key=FeatureList.get(i).getName();
		    A=FeatureList.get(i).getPosFeq();
		    B=FeatureList.get(i).getNegFeq();
		    C=pos-A;
		    D=pos-B;
		    r=(Math.pow((A*D-B*C),2)*2)/((A+B)*(C+D)*pos);
		    if(r.isNaN()){
		    	r=0.0;
		    }
		    FeatureList.set(i,new Feature(key,(double)r,A,B));
        }
		int sum=0;
		for(int i=0;i<FeatureList.size();i++){
			sum+=FeatureList.get(i).getValue();
		}
		int ave=sum/FeatureList.size();
	    Collections.sort(FeatureList);
	    for(int i=0;i<FeatureList.size();i++){
			if(FeatureList.get(i).getValue()<ave){
				FeatureList.subList(i,FeatureList.size()).clear();
			}
		}
	}
}
