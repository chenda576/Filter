package org.action;

import java.io.File;
import java.util.Map;

import org.model.FileClass;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoadFile extends ActionSupport{
	private String file;
	private String msg;
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String execute() throws Exception{
		if(file==null){
			setMsg("请先上传文件！");
			return INPUT;
		}
		FileClass fClass=new FileClass(file);
		try{
			Map sessionMap=(Map)ActionContext.getContext().getSession();
			sessionMap.put("file",fClass);
		}catch(Exception e){
			this.setMsg(e.toString());
			return SUCCESS;
		}
		return SUCCESS;
	}
}
