package cm.gasmyr.mougang.it.sgs.core;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "jury")
public class Jury {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String name;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "jury_teacher", joinColumns = { @JoinColumn(name = "jury_id") }, inverseJoinColumns = {
			@JoinColumn(name = "teacher_id") })
	private List<Teacher> teachers = new ArrayList<>();
	@Version
	private int version;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}

	public int getNumberOfTeachers() {
		return teachers.size();
	}

	public Long getId() {
		return id;
	}

	public void updateInternal(Jury jury) {
		this.name = jury.name;
	}

}
