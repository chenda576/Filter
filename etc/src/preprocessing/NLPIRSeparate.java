package preprocessing;

import java.io.UnsupportedEncodingException;
import com.sun.jna.Library;
import com.sun.jna.Native;

public class NLPIRSeparate {
	public interface CLibrary extends Library {
		// 定义并初始化接口的静态变量
		CLibrary Instance = (CLibrary) Native.loadLibrary(
				"E:\\myEclipse\\myEclipseWorkispace\\filter\\win64\\NLPIR", CLibrary.class);
		public boolean NLPIR_Init(byte[] sDataPath, int encoding,
				byte[] sLicenceCode);
		public String NLPIR_ParagraphProcess(String sSrc, int bPOSTagged);
		public String NLPIR_GetKeyWords(String sLine,int nMaxKeyLimit,boolean bWeightOut);
		public void NLPIR_Exit();
	}
	public static String transString(String aidString, String ori_encoding,
			String new_encoding) {
		try {
			return new String(aidString.getBytes(ori_encoding), new_encoding);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String separateString(String data) throws Exception {
		String filepath = "E:\\myEclipse\\myEclipseWorkispace\\filter";
		String system_charset = "UTF-8";
		int charset_type = 1;
		if (!CLibrary.Instance.NLPIR_Init(filepath.getBytes(system_charset),
				charset_type, "0".getBytes(system_charset))) {
			System.err.println("初始化失败！");
		}
		String sInput = data;
		String nativeBytes = null;
		try {
			nativeBytes = CLibrary.Instance.NLPIR_ParagraphProcess(sInput, 0);
			CLibrary.Instance.NLPIR_Exit();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return nativeBytes;
	}
}
