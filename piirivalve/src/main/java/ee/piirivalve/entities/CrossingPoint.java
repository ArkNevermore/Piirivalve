package ee.piirivalve.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
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

	   
	@Id
	private Long id;
	
	private String code;
	private String name;
	private String comment;
	private Coordinates coordinates;
	private Date start;
	private Date end;

	
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
	public Coordinates getCoordinates() {
		return coordinates;
	}
	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
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
   
}
