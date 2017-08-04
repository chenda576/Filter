package preprocessing;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CutIrrevant {
	public String cutIrrevantWord(String data){
		Pattern pattern=Pattern.compile("[^\u4e00-\u9fa5|\\s]");
		Matcher matcher=pattern.matcher(data);
		String CWord=matcher.replaceAll("").trim();
		WipeWord wiper=new WipeWord();
		return wiper.WipeStopWord(CWord);
	}
}
