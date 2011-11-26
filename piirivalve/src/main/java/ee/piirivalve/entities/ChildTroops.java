package ee.piirivalve.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;
import ee.piirivalve.entities.Troops;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: ChildTroops
 *
 */
@Entity
@RooToString
@RooEntity
public class ChildTroops implements Serializable {

	@GeneratedValue(strategy = GenerationType.TABLE)     
	@Id
	private Long id;
	private static final long serialVersionUID = 1L;
	@ManyToOne
	private Troops troops;
	
	public ChildTroops() {
		super();
	}   
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public Troops getTroops() {
	    return troops;
	}
	public void setTroops(Troops param) {
	    this.troops = param;
	}
   
}
