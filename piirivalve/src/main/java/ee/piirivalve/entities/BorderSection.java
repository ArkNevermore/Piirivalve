package ee.piirivalve.entities;

import java.io.Serializable;
import java.util.ArrayList;
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
 * Entity implementation class for Entity: BorderSection
 *
 */
@Entity
@RooToString
@RooEntity
public class BorderSection implements Serializable {

	@GeneratedValue(strategy = GenerationType.TABLE)  
	@Id
	private Long id;
	private static final long serialVersionUID = 1L;

	private String code;
	private String name;
	private String comment;
	private String longitude;
	private String latitude;
	private String height;
	
	@OneToMany(mappedBy = "borderSection")
	private Collection<CrossingPoint> crossingPoint;
	@OneToMany(mappedBy = "borderSection")
	private Collection<Guard> guard;
	@ManyToOne
	private Troops troops;
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
	public BorderSection() {
		super();
	}   
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public Collection<CrossingPoint> getCrossingPoint() {
	    return crossingPoint;
	}
	public void setCrossingPoint(Collection<CrossingPoint> param) {
	    this.crossingPoint = param;
	}
	public Collection<Guard> getGuard() {
	    return guard;
	}
	public void setGuard(Collection<Guard> param) {
		if(param==null) {
			this.guard = new ArrayList<Guard>();
			} else {
				this.guard = param;
			}
			for(Guard g : this.guard) {
				if (g.getBorderSection() != this) {
					g.setBorderSection(this);
			}			
		}
	}
	public Troops getTroops() {
	    return troops;
	}
	public void setTroops(Troops param) {
	    this.troops = param;
	}
	
}
