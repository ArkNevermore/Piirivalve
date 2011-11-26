package ee.piirivalve.entities;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import javax.persistence.*;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;
import ee.piirivalve.entities.Troops;
import java.util.Collection;

/**
 * Entity implementation class for Entity: Location
 *
 */
@Entity
@RooToString
@RooEntity
public class Location implements Serializable {

	   
	@Id
	private Long id;
	private String name;
	private static final long serialVersionUID = 1L;
	@OneToMany(mappedBy = "location")
	private Collection<Troops> troops;

	public Location() {
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
	public Collection<Troops> getTroops() {
	    return troops;
	}
	public void setTroops(Collection<Troops> param) {
	    this.troops = param;
	}
   
}
