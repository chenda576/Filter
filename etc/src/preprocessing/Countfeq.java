package preprocessing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.model.File;
import org.model.Feature;

public class Countfeq {
	public void countfeq(String []data,ArrayList<Feature> FeatureList){
		Map<String,Integer> MapWordInAll=new HashMap<String,Integer>(); 
		Set<String> SWordInsentence=new HashSet<String>();
		String []wordInSentence=null;
		String key="";
		int index=0;
		int pos=data.length/2;
		for(int i=0;i<data.length;i++){
			wordInSentence=data[i].split(" ");
			for(int j=0;j<wordInSentence.length;j++){
				key=wordInSentence[j];
				if(MapWordInAll.containsKey(key)){
					if(!SWordInsentence.contains(key)){
						SWordInsentence.add(key);
						Feature f=new Feature(FeatureList.get(MapWordInAll.get(key)));
						if(i<pos){
							f.setPosFeq(f.getPosFeq()+1);
						}
						else{
							f.setNegFeq(f.getNegFeq()+1);
						}
						FeatureList.set(MapWordInAll.get(key), f);
					}
				}
				else{
					SWordInsentence.add(key);
					MapWordInAll.put(key, index++);
					if(i<pos){	
						FeatureList.add(new Feature(key,0,1,0));	
					}
					else{		
						FeatureList.add(new Feature(key,0,0,1));	
					}
				}
			}
			SWordInsentence.clear();
		}
		WipeWord wiper=new WipeWord();
		wiper.WipeLFWord(FeatureList,pos/100);
	}
}
