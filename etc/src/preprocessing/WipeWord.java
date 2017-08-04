package preprocessing;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.File;  
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashSet; 
import java.util.Iterator;
import java.util.Set; 
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.model.Feature;
public class WipeWord {
	public String WipeStopWord(String CWord){
			String []CwordArray=CWord.split("\\s+");
			Set<String> stopWordSet = new HashSet<String>();
			try {
				BufferedReader stopWordFile=new BufferedReader(new InputStreamReader(new FileInputStream(new File("E:\\graduate design\\data\\StopWord.txt"))));
				String stopWord=null;
				while((stopWord = stopWordFile.readLine())!= null){
					stopWordSet.add(stopWord);
				}
				stopWordFile.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			for(int i=0;i<CwordArray.length;i++){
				if(stopWordSet.contains(CwordArray[i])){
					CwordArray[i]=" ";
				}
			}
			String resultWord=String.join(" ", CwordArray);
			Pattern patternForBlank=Pattern.compile("\\s+");
			Matcher matcherForBlank=patternForBlank.matcher(resultWord);
			return matcherForBlank.replaceAll(" ").trim();
	}
	
	public void WipeLFWord(ArrayList<Feature> FeatureList,int n){
		Iterator<Feature> it = FeatureList.iterator();
		Feature feature=new Feature();
        while(it.hasNext()){
            feature=it.next();
            if(feature.getNegFeq()+feature.getPosFeq()<n){
            	it.remove();
            }
        }
	}
}
