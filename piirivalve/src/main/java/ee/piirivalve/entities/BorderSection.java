package ee.piirivalve.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;
import ee.piirivalve.entities.Guard;

/**
 * Entity implementation class for Entity: BorderSection
 *
 */
@Entity
@RooToString
@RooEntity
public class BorderSection implements Serializable {

	   
	@Id
	private Long id;
	private static final long serialVersionUID = 1L;

	private String code;
	private String name;
	private String comment;
	private String longitude;
	private String latitude;
	private String height;
	
	@ManyToOne
	private Manager manager;
	
	@ManyToOne
	private CrossingPoint crossingPoints;
	@ManyToOne
	private Guard guard;
	
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
	public Manager getManager() {
	    return manager;
	}
	public void setManager(Manager param) {
	    this.manager = param;
	}
	public CrossingPoint getCrossingPoints() {
	    return crossingPoints;
	}
	public void setCrossingPoints(CrossingPoint param) {
	    this.crossingPoints = param;
	}
	public Guard getGuard() {
	    return guard;
	}
	public void setGuard(Guard param) {
	    this.guard = param;
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
   
	
}
