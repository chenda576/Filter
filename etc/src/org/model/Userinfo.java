package org.model;

/**
 * Userinfo entity. @author MyEclipse Persistence Tools
 */

public class Userinfo implements java.io.Serializable {

	// Fields

	private Integer id;
	private String username;
	private String password;
	private String email;
	private String folder;

	// Constructors

	/** default constructor */
	public Userinfo() {
	}

	/** minimal constructor */
	public Userinfo(String username, String password, String email) {
		this.username = username;
		this.password = password;
		this.email = email;
	}

	/** full constructor */
	public Userinfo(String username, String password, String email,
			String folder) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.folder = folder;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFolder() {
		return this.folder;
	}

	public void setFolder(String folder) {
		this.folder = folder;
	}

}