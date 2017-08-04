package org.action;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.model.Userinfo;
import org.util.HibernateSessionFactory;
import security.MessageDigestUtil;
import com.opensymphony.xwork2.ActionSupport;
public class UserRegister extends ActionSupport{
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
			String pw=user.getPassword();
			user.setPassword(MessageDigestUtil.digestByMD5(pw));
			session.save(user);
			ts.commit();  // 提交事务
			HibernateSessionFactory.closeSession();// 关闭Session
			return SUCCESS;
		}
		catch(Exception e){
			ts.rollback();
			HibernateSessionFactory.closeSession();
			this.setMsg(e.toString());
			return ERROR;
		}
	}
}
