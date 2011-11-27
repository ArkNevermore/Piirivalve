package ee.piirivalve.entities;

import java.io.Serializable;
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
	private Collection<BorderGuard> borderGuards;
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
	public Collection<BorderGuard> getBorderGuards() {
	    return borderGuards;
	}
	public void setBorderGuards(Collection<BorderGuard> param) {
	    this.borderGuards = param;
	}
	public Troops getTroops() {
	    return troops;
	}
	public void setTroops(Troops param) {
	  this.troops = param;		
	}
}
   
