package ee.piirivalve.entities;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import javax.persistence.*;
import ee.piirivalve.entities.BorderSection;
import java.util.Collection;

/**
 * Entity implementation class for Entity: Manager
 *
 */
@Entity

public class Manager implements Serializable {

	   
	@Id
	private Long id;
	private String name;
	private static final long serialVersionUID = 1L;
	@OneToMany(mappedBy = "manager")
	private Collection<BorderSection> borderSections;

	public Manager() {
		super();
	}   
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public Collection<BorderSection> getBorderSections() {
	    return borderSections;
	}
	public void setBorderSections(Collection<BorderSection> param) {
	    this.borderSections = param;
	}
   
}
