package org.action;
import com.opensymphony.xwork2.ActionSupport;
public class StartSelect extends ActionSupport{
	private String msg;
	private String modelTag;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getModelTag() {
		return modelTag;
	}
	public void setModelTag(String modelTag) {
		this.modelTag = modelTag;
	}
	public String execute() throws Exception{
		if(!(modelTag.equals("ST")||modelTag.equals("MT")||modelTag.equals("FT"))){
			setMsg("请先选择你要用的方法！");
			return SUCCESS;
		}
		return modelTag;
	}
}
