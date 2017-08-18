package cm.gasmyr.mougang.it.sgs.core;

import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.REFRESH;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "teacher")
@DiscriminatorValue("teacher")
public class Teacher extends User {
	private String address;
	private String title;
	@ManyToOne(cascade = { PERSIST, REFRESH })
	private Jury jury;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void updateInternal(User user, String address, String title) {
		super.updateInternal(user);
		this.address = address;
		this.title = title;
	}

	public Jury getJury() {
		return jury;
	}

	public void setJury(Jury jury) {
		this.jury = jury;
	}

}
