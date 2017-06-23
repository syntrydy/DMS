package cm.gasmyr.mougang.it.sgs.core;

import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.REFRESH;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity
@Table(name = "defense")
public class Defense {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@Temporal(TemporalType.DATE)
	private Date schoolyear;
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	@OneToOne(cascade = { PERSIST, MERGE, REFRESH })
	@JoinColumn(name = "university_id", referencedColumnName = "id")
	private University university = new University();
	@OneToOne(cascade = { PERSIST, MERGE, REFRESH })
	@JoinColumn(name = "department_id", referencedColumnName = "id")
	private Department department = new Department();
	@OneToOne(cascade = { PERSIST, MERGE, REFRESH })
	@JoinColumn(name = "field_id", referencedColumnName = "id")
	private Field field = new Field();
	@OneToOne(cascade = { PERSIST, MERGE, REFRESH })
	@JoinColumn(name = "level_id", referencedColumnName = "id")
	private Level level = new Level();
	@OneToOne(cascade = { PERSIST, MERGE, REFRESH })
	@JoinColumn(name = "option_id", referencedColumnName = "id")
	private Option option = new Option();
	@OneToOne(cascade = { PERSIST, MERGE, REFRESH })
	@JoinColumn(name = "facility_id", referencedColumnName = "id")
	private Facility facility = new Facility();
	@OneToOne(cascade = { PERSIST, MERGE, REFRESH })
	@JoinColumn(name = "jury", referencedColumnName = "id")
	private Jury jury = new Jury();
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "defense_student", joinColumns = { @JoinColumn(name = "defense_id") }, inverseJoinColumns = {
			@JoinColumn(name = "student_id") })
	private List<Student> students = new ArrayList<>();
	@Version
	private int version;

	public Long getId() {
		return id;
	}

	public Date getSchoolyear() {
		return schoolyear;
	}

	public void setSchoolyear(Date schoolyear) {
		this.schoolyear = schoolyear;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Field getField() {
		return field;
	}

	public void setField(Field field) {
		this.field = field;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public Option getOption() {
		return option;
	}

	public void setOption(Option option) {
		this.option = option;
	}

	public Facility getFacility() {
		return facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public Jury getJury() {
		return jury;
	}

	public void setJury(Jury jury) {
		this.jury = jury;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public void updateInternal(Defense defense) {
		this.department = defense.getDepartment();
		this.field = defense.getField();
		this.option = defense.getOption();
		this.level = defense.getLevel();
		this.facility = defense.getFacility();
		this.jury = defense.getJury();
	}

}
