package ee.piirivalve.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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

	   
	@Id
	private Long id;
	private String code;
	private String name;
	private String comment;
	
	private Date start;
	private Date end;
	private Troops child;
	private Troops father;
	
	public Troops getChild() {
		return child;
	}
	public void setChild(Troops child) {
		this.child = child;
	}
	public Troops getFather() {
		return father;
	}
	public void setFather(Troops father) {
		this.father = father;
	}
	
	private static final long serialVersionUID = 1L;
	@ManyToOne
	private Location location;
	public Troops() {
		super();
	}   
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public Location getLocation() {
	    return location;
	}
	public void setLocation(Location param) {
	    this.location = param;
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

}
