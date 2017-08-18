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
@Table(name = "level")
public class Level {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String code;
	private String name;
	@ManyToOne(cascade = { PERSIST, REFRESH})
	private Option option;
	@Version
	private int version;

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

	public Long getId() {
		return id;
	}

	public Option getOption() {
		return option;
	}
	public String getOptionName() {
		return option.getName();
	}

	public void setOption(Option option) {
		this.option = option;
	}

	public void updateInternal(Level level) {
		this.code = level.getCode();
		this.name = level.getName();
		this.option = level.getOption();
	}
}
