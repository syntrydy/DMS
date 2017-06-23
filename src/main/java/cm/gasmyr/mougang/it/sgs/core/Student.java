package cm.gasmyr.mougang.it.sgs.core;

import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.REFRESH;
import static javax.persistence.CascadeType.REMOVE;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student")
@DiscriminatorValue("student")
public class Student extends User {
	private String cni;
	@ManyToOne(cascade = { PERSIST, REFRESH, REMOVE })
	private Jury jury;

	public String getCni() {
		return cni;
	}

	public void setCni(String cni) {
		this.cni = cni;
	}

	public void updateInternal(User user, String cni) {
		super.updateInternal(user);
		this.cni = cni;
	}

	public Jury getJury() {
		return jury;
	}

	public void setJury(Jury jury) {
		this.jury = jury;
	}
}
