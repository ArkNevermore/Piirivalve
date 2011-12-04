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

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.transaction.annotation.Transactional;

import ee.itcollege.piirivalve.web.AuthController;
import ee.piirivalve.entities.Guard;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

/**
 * Entity implementation class for Entity: BorderSection
 *
 */
@Entity
@RooToString
@RooEntity
public class BorderSection implements Serializable {

	@GeneratedValue(strategy = GenerationType.AUTO)  
	@Id
	private Long id;
	private static final long serialVersionUID = 1L;

	@NotNull
	private String code;
	@NotNull
	private String name;
	private String comment;
	
	@NotNull
	private String coordinates;
	
	private String creator;
	private String modifier;
	private String deleter;
	
	@DateTimeFormat(style="M-")
	private Date modified;
	
	@DateTimeFormat(style="M-")
	private Date created;
	
	@DateTimeFormat(style="M-")
	private Date deleted;
	
	@DateTimeFormat(style="M-")
	private Date startdate;
	@DateTimeFormat(style="M-")
	private Date enddate;
	
	@OneToMany(mappedBy = "borderSection")
	private Collection<CrossingPoint> crossingPoint;
	@ManyToOne
	private Troops troops;
	@ManyToMany
	private Collection<Guard> guard;
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

	public String getCoordinates() {
		return coordinates;
	}
	public void setCoordinates(String coordinates) {
		this.coordinates = coordinates;
	}
	public Collection<CrossingPoint> getCrossingPoint() {
	    return crossingPoint;
	}
	public void setCrossingPoint(Collection<CrossingPoint> param) {
	    this.crossingPoint = param;
	}
	public Troops getTroops() {
	    return troops;
	}
	public void setTroops(Troops param) {
		
		if (getTroops() == null ) {
			this.troops = param;
			this.setStartdate(new Date());
		}
		else if (param != getTroops()) {
			this.setStartdate(new Date());
			//this.setEnddate(new Date());
			troops = param;
			
		}else {	
	    this.troops = param;
		}
	}
	public Collection<Guard> getGuard() {
	    return guard;
	}
	public void setGuard(Collection<Guard> param) {
	    this.guard = param;
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
	
	private Date maxDate() {
		Calendar cal = new GregorianCalendar();
		cal.set(9999, Calendar.DECEMBER, 31);
		return cal.getTime();
	}
	
	public void setEnddate(Date enddate) {
		if (enddate == null) 
		{
			this.enddate = maxDate();
		}else{
			this.enddate = enddate;
			//setTroops(null);
		}
	}
	@PrePersist
    public void recordCreated() {
        setCreated(new Date());
        setCreator(AuthController.user());
        setStartdate(new Date());
        
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
        setModified(new Date() );
        setModifier(AuthController.user());
        setEnddate(null);
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
    public BorderSection merge() {
        if(id != null && !entityManager.contains(this)) {
        	BorderSection oldEntity = entityManager.find(getClass(), id);
            if(getCreated() == null)
                setCreated(oldEntity.getCreated());
            if (getModified() == null)
            	setModified(oldEntity.getModified()); 
            if (getCreator() == null)
            	setCreator(oldEntity.getCreator());
            if (getModifier() == null)
            	setModifier(oldEntity.getModifier());           
        }
        BorderSection merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
    @Transactional
    public void remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
        	preventRemove();
        	setEnddate(new Date());
            //this.entityManager.remove(this);
        } else {
            BorderSection attached = BorderSection.findBorderSection(this.id);
            this.entityManager.remove(attached);
        }
    }
	
    public static List<BorderSection> findAllBorderSections() {
        return entityManager().createQuery("SELECT o FROM BorderSection o where o.deleted is null", BorderSection.class).getResultList();
    }
    
    public static List<BorderSection> findBorderSectionEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM BorderSection o where o.deleted is null", BorderSection.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
}
