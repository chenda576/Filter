package org.action;

import java.util.Map;

import org.model.FileClass;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UploadFile extends ActionSupport{
	private FileClass fileInput;
	private String msg;
	public FileClass getFileInput() {
		return fileInput;
	}
	public void setFileInput(FileClass fileInput) {
		this.fileInput = fileInput;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String execute() throws Exception{
		if(fileInput==null||fileInput.getFile()==null){
			setMsg("请先上传文件！");
			return INPUT;
		}
		try{
			fileInput=new FileClass(fileInput.Upload());
			Map sessionMap=(Map)ActionContext.getContext().getSession();
			sessionMap.put("file",fileInput);
		}catch(Exception e){
			this.setMsg(e.toString());
			return SUCCESS;
		}
		return SUCCESS;
	}
}
