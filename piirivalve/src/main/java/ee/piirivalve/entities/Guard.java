package ee.piirivalve.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;
import ee.piirivalve.entities.Troops;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: Guard
 *
 */
@Entity
@RooToString
@RooEntity
public class Guard implements Serializable {

    @GeneratedValue(strategy = GenerationType.TABLE)  
	@Id
	private Long id;
	private String name;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private static final long serialVersionUID = 1L;
	@OneToMany(mappedBy = "guard")
	private Collection<CrossingPoint> crossingPoint;
	@OneToMany(mappedBy = "guard")
	private Collection<BorderSection> borderSection;
	@ManyToOne
	private Troops troops;
	public Guard() {
		super();
	}   
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public Collection<CrossingPoint> getCrossingPoint() {
	    return crossingPoint;
	}
	public void setCrossingPoint(Collection<CrossingPoint> param) {
	    this.crossingPoint = param;
	}
	public Collection<BorderSection> getBorderSection() {
	    return borderSection;
	}
	public void setBorderSection(Collection<BorderSection> param) {
	    this.borderSection = param;
	}
	public Troops getTroops() {
	    return troops;
	}
	public void setTroops(Troops param) {
	    this.troops = param;
	}
   
}
