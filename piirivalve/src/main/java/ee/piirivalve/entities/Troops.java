package ee.piirivalve.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;

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
	private Troops fatherTroops;
	@ManyToOne
	private Location location;
	@OneToMany(mappedBy = "troops")
	private Collection<CrossingPoint> crossingPoint;
	@OneToMany(mappedBy = "troops")
	private Collection<ChildTroops> childTroops;
	@OneToMany(mappedBy = "troops")
	private Collection<BorderSection> borderSection;
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
	
	public Troops getFatherTroops() {
	    return fatherTroops;
	}

	public void setFatherTroops(Troops param) {
	    this.fatherTroops = param;
	}

	public Location getLocation() {
	    return location;
	}

	public void setLocation(Location param) {
	    this.location = param;
	}

	public Collection<CrossingPoint> getCrossingPoint() {
	    return crossingPoint;
	}

	public void setCrossingPoint(Collection<CrossingPoint> param) {
	    this.crossingPoint = param;
	}

	public Collection<ChildTroops> getChildTroops() {
	    return childTroops;
	}

	public void setChildTroops(Collection<ChildTroops> param) {
	//	  this.childTroops = param;
		if(param==null) {
			this.childTroops = new ArrayList<ChildTroops>();
			} else {
				this.childTroops = param;
			}
			for(ChildTroops c : this.childTroops) {
				if (c.getTroops() != this) {
					c.setTroops(this);
			}			
		}
	}

	public Collection<BorderSection> getBorderSection() {
	    return borderSection;
	}

	public void setBorderSection(Collection<BorderSection> param) {
	    this.borderSection = param;
	}


}
