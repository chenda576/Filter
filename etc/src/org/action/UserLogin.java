package org.action;
import java.util.Map;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.util.HibernateSessionFactory;
import org.model.Userinfo;
import security.MessageDigestUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class UserLogin extends ActionSupport{
	private Userinfo user;
	private String msg;
	public Userinfo getUser() {
		return user;
	}
	public void setUser(Userinfo user) {
		this.user = user;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String execute() throws Exception{
		Session session=HibernateSessionFactory.getSession();
		Transaction ts=session.beginTransaction();
		try{
			Query query=session.createQuery("from Userinfo where email=?");
			query.setParameter(0, user.getEmail());
			query.setMaxResults(1);
			Userinfo ui=(Userinfo)query.uniqueResult();
			if(ui==null){	throw new Exception("用户不存在"); }
			if(ui.getPassword().equals(MessageDigestUtil.digestByMD5(user.getPassword()))){
				Map sessionMap=(Map)ActionContext.getContext().getSession();
				sessionMap.put("user",ui);
				ts.commit();  // 提交事务
				HibernateSessionFactory.closeSession();// 关闭Session
				return SUCCESS;
			}
			else{	throw new Exception("密码不正确"); }
		}
		catch(Exception e){
			ts.rollback();
			HibernateSessionFactory.closeSession();
			this.setMsg(e.toString());
			return ERROR;
		}
	}
}
