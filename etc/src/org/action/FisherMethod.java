package org.action;
import java.util.ArrayList;
import java.util.Map;

import preprocessing.Countfeq;
import preprocessing.SepString;

import org.FisherMethod.FTest;
import org.model.Feature;
import org.model.FileClass;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class FisherMethod extends ActionSupport{
	private String msg;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String execute() throws Exception{
		Map sessionFile=(Map)ActionContext.getContext().getSession();
		FileClass fileInput=(FileClass)sessionFile.get("file");
		if(fileInput==null||fileInput.getFile()==null){
			setMsg("请先上传文件！");
			return SUCCESS;
		}
		try{
			String data=fileInput.OpenFile();
			String modelString="FT";
			SepString seper=new SepString();
			Countfeq counter=new Countfeq();
			String sepString[]=seper.Sep(data);
			ArrayList<Feature> FeatureList=new ArrayList<Feature>();
			counter.countfeq(sepString,FeatureList);
			FTest FT=new FTest();
			FT.TestFisher(FeatureList,sepString.length/2);
			Map sessionMap=(Map)ActionContext.getContext().get("session");
			sessionMap.put("flist",FeatureList);
			sessionMap.put("model",modelString);
		}catch (Exception e){
			this.setMsg("产生了错误");
	    	return SUCCESS;
		}
		return SUCCESS;
	}
}
