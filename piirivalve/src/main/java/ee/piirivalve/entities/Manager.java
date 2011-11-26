package ee.piirivalve.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;
import ee.piirivalve.entities.BorderSection;
import java.util.Collection;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Manager
 *
 */
@Entity
@RooToString
@RooEntity
public class Manager implements Serializable {
	
	@GeneratedValue(strategy = GenerationType.TABLE)   
	@Id
	private Long id;
	
	private String name;
	
	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy = "manager")
	private Collection<BorderSection> borderSection;
	
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
	public Collection<BorderSection> getBorderSection() {
	    return borderSection;
	}
	public void setBorderSection(Collection<BorderSection> param) {
	    this.borderSection = param;
	}
   
}
