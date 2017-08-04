package preprocessing;
import java.util.ArrayList;
public class SepString {
	public String []Sep(String data){
		ArrayList<String> dataList=new ArrayList<String>();
		try{
			NLPIRSeparate S=new NLPIRSeparate();
			CutIrrevant CI=new CutIrrevant();
			String dataString[]=S.separateString(data).split("\\s+br\\s+");
			for(int i=0;i<dataString.length;i++){
				dataList.add(CI.cutIrrevantWord(dataString[i]));
			}
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		return dataList.toArray(new String[dataList.size()]);
	}
}
