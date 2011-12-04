package ee.piirivalve.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;

/**
 * Entity implementation class for Entity: BorderGuard
 *
 */
@Entity
@RooToString
@RooEntity
public class BorderGuard implements Serializable {

	@GeneratedValue(strategy = GenerationType.AUTO)    
	@Id
	private Long id;
	
	@NotNull
	private String name;
	
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	private Guard guard;

	public BorderGuard() {
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
	public Guard getGuard() {
	    return guard;
	}
	public void setGuard(Guard param) {
	    this.guard = param;
	}
   
}
