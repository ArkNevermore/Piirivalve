package ee.piirivalve.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;
import ee.piirivalve.entities.Guard;
import java.util.Collection;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Troops
 *
 */
@Entity
@RooToString
@RooEntity
public class Troops implements Serializable {

	@GeneratedValue(strategy = GenerationType.TABLE)   
	@Id
	private Long id;
	private String code;
	private String name;
	private String comment;
	
	private String startdate;
	private String enddate;
	
	private static final long serialVersionUID = 1L;
	@ManyToOne
	private Location location;
	
	@ManyToOne
	private Troops childTroops;
	@ManyToOne
	private Troops fatherTroops;
	@OneToMany(mappedBy = "troops")
	private Collection<Guard> guard;
	
	public Troops() {
		super();
	} 
	
	public Long getId() {
		return this.id;
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
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Location getLocation() {
	    return location;
	}
	public void setLocation(Location param) {
	    this.location = param;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public Troops getChildTroops() {
	    return childTroops;
	}

	public void setChildTroops(Troops param) {
	    this.childTroops = param;
	}

	public Troops getFatherTroops() {
	    return fatherTroops;
	}

	public void setFatherTroops(Troops param) {
	    this.fatherTroops = param;
	}

	public Collection<Guard> getGuard() {
	    return guard;
	}

	public void setGuard(Collection<Guard> param) {
	    this.guard = param;
	}


}
