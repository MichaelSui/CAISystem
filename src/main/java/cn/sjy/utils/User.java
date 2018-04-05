package cn.sjy.utils;

public class User {
    private String id;
    private Authority authority;

    public String getId() {
	return id;
    }

    public void setId(String id) {
	this.id = id;
    }

    public Authority getAuthority() {
	return authority;
    }

    public void setAuthority(Authority authority) {
	this.authority = authority;
    }
}
