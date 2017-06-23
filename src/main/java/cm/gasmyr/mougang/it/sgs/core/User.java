package cm.gasmyr.mougang.it.sgs.core;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "utilisateur")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "kind")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String fname;
	private String lname;
	private String phone;
	private String email;
	@Column(name = "can_login")
	private boolean signInAble;
	private String username;
	private String password;
	@Version
	private int version;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isSignInAble() {
		return signInAble;
	}

	public void setSignInAble(boolean signInAble) {
		this.signInAble = signInAble;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswd() {
		return password;
	}

	public void setPasswd(String password) {
		this.password = password;
	}

	public void updateInternal(User user) {
		this.fname = user.getFname();
		this.lname = user.getLname();
		this.email = user.getEmail();
		this.phone = user.getPhone();
		this.signInAble = user.isSignInAble();
		this.username = user.getUsername();
		this.password = user.getPasswd();
	}

}
