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
import ee.piirivalve.entities.Guard;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: CrossingPoint
 *
 */
@Entity
@RooToString
@RooEntity
public class CrossingPoint implements Serializable {

    @GeneratedValue(strategy = GenerationType.TABLE)   
	@Id
	private Long id;
	
	private String code;
	private String name;
	private String comment;
	private String longitude;
	private String latitude;
	private String height;
	
	private String startdate;
	private String enddate;

	
	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy = "crossingPoints")
	private Collection<BorderSection> borderSection;

	@ManyToOne
	private Guard guard;

	public CrossingPoint() {
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
	public Collection<BorderSection> getBorderSection() {
	    return borderSection;
	}
	public void setBorderSection(Collection<BorderSection> param) {
	    this.borderSection = param;
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
   
	
}
