package org.sac.mod;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "addedusers")
public class UserDetails {

	@Id
        @Column(name="userid")
	private String uid;
        @Column(name="username")
	private String uname;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
}
