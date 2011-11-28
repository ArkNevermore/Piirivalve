package ee.piirivalve.entities;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.transaction.annotation.Transactional;

import ee.itcollege.piirivalve.web.AuthController;
import ee.piirivalve.entities.BorderSection;
import ee.piirivalve.entities.CrossingPoint;

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
	@NotNull
	private String code;
	@NotNull
	private String name;
	@NotNull
	private String comment;
	
	@DateTimeFormat(style="M-")
	@NotNull
	private Date startdate;
	@DateTimeFormat(style="M-")
	private Date enddate;
	
	private String creator;
	private String modifier;
	private String deleter;
	
	@DateTimeFormat(style="M-")
	private Date modified;
	
	@DateTimeFormat(style="M-")
	private Date created;
	
	@DateTimeFormat(style="M-")
	private Date deleted;
	
	private static final long serialVersionUID = 1L;
	@ManyToOne
	private Troops fatherTroops;
	@ManyToOne
	private Location location;
	@OneToMany(mappedBy = "troops")
	private Collection<Guard> guard;
	@OneToMany(mappedBy = "troops")
	private Collection<BorderSection> borderSection;
	@OneToMany(mappedBy = "troops")
	private Collection<CrossingPoint> crossingPoint;
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
	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		if (enddate == null) 
			{
				Calendar cal = new GregorianCalendar();
				cal.set(9999, Calendar.DECEMBER, 31);
				this.enddate = cal.getTime();
			}else{
				this.enddate = enddate;
				
			}
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

	public Collection<Guard> getGuard() {
	    return guard;
	}

    public void setGuard(Collection<Guard> guard) {
    	manageRelations(this.guard, guard);
        this.guard = guard;
    }

    private void manageRelations(Collection<Guard> oldGuard, Collection<Guard> newGuard) {
        if(oldGuard != null) {
            for(Guard g: oldGuard)
                if(newGuard == null || !newGuard.contains(g))
                    g.setTroops(null);
        }

        if(newGuard != null) {
            for(Guard g: newGuard)
                g.setTroops(this);
        }
    }

	public Collection<BorderSection> getBorderSection() {
	    return borderSection;
	}

	public void setBorderSection(Collection<BorderSection> param) {
	    this.borderSection = param;
	}

	public Collection<CrossingPoint> getCrossingPoint() {
	    return crossingPoint;
	}

	public void setCrossingPoint(Collection<CrossingPoint> param) {
	    this.crossingPoint = param;
	}
	
    @PrePersist
    public void recordCreated() {
        setCreated(new Date());
        setCreator(AuthController.user());
    }

    public Date getModified() {
		return modified;
	}

	public Date getCreated() {
		return this.created;
	}

	private void setCreated(Date date) {
		this.created = date;	
	}
	
	@PreUpdate
    public void recordModified() {
        setModified( new Date() );
        setModifier(AuthController.user());
    }
	
    private void setModified(Date date) {
		this.modified = date;		
	}
    
	public Date getDeleted() {
		return deleted;
	}

	public void setDeleted(Date deleted) {
		this.deleted = deleted;
	}
    
	@PreRemove
    public void preventRemove() {
		setDeleted(new Date());
		setDeleter(AuthController.user());
    }
	
	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getModifier() {
		return modifier;
	}

	public void setModifier(String modifier) {
		this.modifier = modifier;
	}

	public String getDeleter() {
		return deleter;
	}

	public void setDeleter(String deleter) {
		this.deleter = deleter;
	}
	
	 @Transactional
	   public Troops merge() {
	        if(id != null && !entityManager.contains(this)) {
	        	Troops oldEntity = entityManager.find(getClass(), id);
	            if(getCreated() == null)
	                setCreated(oldEntity.getCreated());
	            if (getModified() == null)
	            	setModified(oldEntity.getModified()); 
	            if (getCreator() == null)
	            	setCreator(oldEntity.getCreator());
	            if (getModifier() == null)
	            	setModifier(oldEntity.getModifier()); 
	        }
	        Troops merged = this.entityManager.merge(this);
	        this.entityManager.flush();
	        return merged;
	    }
	    
	    @Transactional
	    public void remove() {
	        if (this.entityManager == null) this.entityManager = entityManager();
	        if (this.entityManager.contains(this)) {
	        	preventRemove();
	           // this.entityManager.remove(this);
	        	//Delete the relation
	        	setGuard(null);

	        } else {
	        	Troops attached = Troops.findTroops(this.id);
	            this.entityManager.remove(attached);
	        }
	    }
	    
	    public static List<Troops> findAllTroopses() {
	        return entityManager().createQuery("SELECT o FROM Troops o where o.deleted is null", Troops.class).getResultList();
	    }
	    
	    public static List<Troops> findTroopsEntries(int firstResult, int maxResults) {
	        return entityManager().createQuery("SELECT o FROM Troops o where o.deleted is null", Troops.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
	    }
}
