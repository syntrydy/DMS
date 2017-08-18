package cm.gasmyr.mougang.it.sgs.core;

import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.REFRESH;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "department")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String name;
	private String description;
	@ManyToOne(cascade = { PERSIST, REFRESH})
	private University owner;
	@OneToMany(mappedBy = "department")
	private List<Field> fields;
	@Version
	private int version;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public University getOwner() {
		return owner;
	}

	public void setOwner(University owner) {
		this.owner = owner;
	}

	public Long getId() {
		return id;
	}

	public String getUniversityName() {
		return this.owner.getName();
	}

	public void updateInternal(Department department) {
		this.name = department.getName();
		this.description = department.getDescription();
		this.owner = department.getOwner();
	}

}
