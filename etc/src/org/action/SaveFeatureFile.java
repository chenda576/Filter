package org.action;

import java.util.ArrayList;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.model.Feature;
import org.model.FileClass;
import org.model.Userinfo;
import org.util.HibernateSessionFactory;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SaveFeatureFile extends ActionSupport{
	private String msg;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String execute() throws Exception{
		Map sessionFeature=(Map)ActionContext.getContext().getSession();
		ArrayList<Feature> flist=(ArrayList<Feature>)sessionFeature.get("flist");
		String model=(String) sessionFeature.get("model");
		if(flist==null){
			setMsg("目前还没有特征以供保存,请先选择一种方法进行特征选择");
			return SUCCESS;
		}
		try{
			Map requestUser=(Map)ActionContext.getContext().getSession();
			Userinfo user=(Userinfo)requestUser.get("user");
			FileClass fClass=new FileClass();
			if(user.getFolder()==null){
				user.setFolder(fClass.SaveResult(user.getId(),user.getFolder(),model,flist));
				Session session=HibernateSessionFactory.getSession();
				Transaction ts=session.beginTransaction();
				session.update(user);
				ts.commit();
				HibernateSessionFactory.closeSession();
			}
			else{
				fClass.SaveResult(user.getId(),user.getFolder(),model,flist);
			}
		}catch(Exception e){
			this.setMsg(e.toString());
			return SUCCESS;
		}
		return SUCCESS;
	}
}
