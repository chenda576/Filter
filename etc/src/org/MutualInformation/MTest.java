package org.MutualInformation;

import java.util.ArrayList;
import java.util.Collections;

import org.model.Feature;

public class MTest {
	public void TestInfor(ArrayList<Feature> FeatureList,int pos){
		int A,B,C,D;
		Double r=0.0;
		double N=2*pos;
		Double N11,N10,N01,N00;
        String key;
        for(int i=0;i<FeatureList.size();i++){
        	key=FeatureList.get(i).getName();
		    A=FeatureList.get(i).getPosFeq();
		    B=FeatureList.get(i).getNegFeq();
		    C=pos-A;
		    D=pos-B;
		    N11=Math.log((N*A)/((A+B)*(A+C)));
		    if(N11.isNaN()||N11.isInfinite()){
		    	N11=(double) 0;
		    }
		    N10=Math.log((N*B)/((B+A)*(B+D)));
		    if(N10.isNaN()||N10.isInfinite()){
		    	N10=(double) 0;
		    }
		    N01=Math.log((N*C)/((C+A)*(C+D)));
		    if(N01.isNaN()||N01.isInfinite()){
		    	N01=(double) 0;
		    }
		    N00=Math.log((N*D)/((D+B)*(D+C)));
		    if(N00.isNaN()||N00.isInfinite()){
		    	N00=(double) 0;
		    }
		    r=(1.0*A*N11+1.0*B*N10+1.0*C*N01+1.0*D*N00)/(N*1.0);
		    r=Math.pow((A*D-B*C),2)/((A+B)*(C+D));
		    if(r.isNaN()){
		    	r=0.0;
		    }
		    FeatureList.set(i,new Feature(key,r,A,B));
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
