package cn.sjy.db;

import java.io.Serializable;

import cn.sjy.utils.Authority;

public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String password;
    private String authority;

    public String getAuthority() {
	return authority;
    }

    public void setAuthority(String authority) {
	this.authority = authority;
    }

    public String getId() {
	return id;
    }

    public void setId(String id) {
	this.id = id;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }
}
