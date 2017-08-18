package cm.gasmyr.mougang.it.sgs.core;

import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.REFRESH;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "option")
public class Option {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String code;
	private String name;
	private String description;
	@ManyToOne(cascade = { PERSIST, REFRESH })
	private Field field;
	@Version
	private int version;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

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

	public Field getField() {
		return field;
	}
	
	public String getFieldName() {
		return field.getName();
	}

	public void setField(Field field) {
		this.field = field;
	}

	public void updateInternal(Option option) {
		this.name = option.getName();
		this.code = option.getCode();
		this.description = option.getDescription();
		this.field = option.getField();
	}

}
