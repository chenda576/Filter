package org.action;

import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.model.FileClass;
import org.model.Userinfo;
import org.util.HibernateSessionFactory;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SaveDataFile extends ActionSupport{
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
			Map requestUser=(Map)ActionContext.getContext().getSession();
			Userinfo user=(Userinfo)requestUser.get("user");
			if(user.getFolder()==null){
				user.setFolder(fileInput.SaveData(user.getId(),user.getFolder()));
				Session session=HibernateSessionFactory.getSession();
				Transaction ts=session.beginTransaction();
				session.update(user);
				ts.commit();  // 提交事务
				HibernateSessionFactory.closeSession();// 关闭Session
			}
			else{
				fileInput.SaveData(user.getId(),user.getFolder());
			}
			Map sessionMap=(Map)ActionContext.getContext().getSession();
			sessionMap.put("file",fileInput);
		}catch(Exception e){
			this.setMsg(e.toString());
			return SUCCESS;
		}
		return SUCCESS;
	}
}
