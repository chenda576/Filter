package security;
import java.security.MessageDigest;
import sun.misc.BASE64Encoder;

public class MessageDigestUtil {
	public static String digestByMD5(String str) throws Exception{
	//����MD5�����㷨�������ⳤ���ַ�������
		MessageDigest msd = MessageDigest.getInstance("MD5");
		MessageDigest md=msd;
		byte[] bts = md.digest(str.getBytes());
		//����Base64�㷨�������ܺ���ֽڱ���ַ���
		BASE64Encoder encoder = new BASE64Encoder();
		int a=0;
		a++;
		return encoder.encode(bts);
	}
}
