package org.action;

import java.util.ArrayList;
import java.util.Map;

import org.model.FileClass;
import org.model.Userinfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class OpenUserSpace extends ActionSupport{
	private String msg;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String execute() throws Exception{
		Map sessionUser=(Map)ActionContext.getContext().getSession();
		Userinfo user=(Userinfo)sessionUser.get("user");
		ArrayList<FileClass> dataFileList=new ArrayList<FileClass>();
		ArrayList<FileClass> resultFileList=new ArrayList<FileClass>();
		String pathString=user.getFolder();
		FileClass folder=new FileClass(pathString);
		folder.sepFile(dataFileList, resultFileList);
		
		Map request=(Map)ActionContext.getContext().get("request");
		if(!dataFileList.isEmpty()){
			request.put("dflist",dataFileList);
		}
		if(!resultFileList.isEmpty()){
			request.put("rflist",resultFileList);
		}
		return SUCCESS;
	}
}
