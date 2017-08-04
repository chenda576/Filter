package org.action;
import java.util.Map;
import org.model.FileClass;
import org.model.Userinfo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class Download extends ActionSupport{
	private String msg;
	private String fname;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String execute() throws Exception{
		Map requestUser=(Map)ActionContext.getContext().getSession();
		Userinfo user=(Userinfo)requestUser.get("user");
		try{
			FileClass download=new FileClass(user.getFolder()+"\\"+fname);
			download.download();
		}catch (Exception e){
			this.setMsg("²úÉúÁË´íÎó");
	    	return SUCCESS;
		}
		return SUCCESS;
	}
}
