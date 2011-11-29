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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.transaction.annotation.Transactional;

import ee.itcollege.piirivalve.web.AuthController;
/**
 * Entity implementation class for Entity: CrossingPoint
 *
 */
@Entity
@RooToString
@RooEntity
public class CrossingPoint implements Serializable {

    @GeneratedValue(strategy = GenerationType.AUTO)   
	@Id
	private Long id;
	
    @NotNull
	private String code;
    @NotNull
	private String name;
    @NotNull
	private String comment;
    @NotNull
	private String longitude;
    @NotNull
	private String latitude;
    @NotNull
    private String height;
	
	@DateTimeFormat(style="M-")
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
	private BorderSection borderSection;

	@ManyToMany
	private Collection<Guard> guard;

	@ManyToOne
	private Troops troops;

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
			setTroops(null);
		}
	}
	public BorderSection getBorderSection() {
	    return borderSection;
	}
	public void setBorderSection(BorderSection param) {
	    this.borderSection = param;
	}
	public Collection<Guard> getGuard() {
	    return guard;
	}
	public void setGuard(Collection<Guard> param) {
	    this.guard = param;
	}
	public Troops getTroops() {
	    return troops;
	}
	public void setTroops(Troops param) {
	    this.troops = param;
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
    public CrossingPoint merge() {
        if(id != null && !entityManager.contains(this)) {
        	CrossingPoint oldEntity = entityManager.find(getClass(), id);
            if(getCreated() == null)
                setCreated(oldEntity.getCreated());
            if (getModified() == null)
            	setModified(oldEntity.getModified()); 
            if (getCreator() == null)
            	setCreator(oldEntity.getCreator());
            if (getModifier() == null)
            	setModifier(oldEntity.getModifier()); 
        }
        CrossingPoint merged = this.entityManager.merge(this);
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
        	CrossingPoint attached = CrossingPoint.findCrossingPoint(this.id);
            this.entityManager.remove(attached);
        }
    }
	
    public static List<CrossingPoint> findAllCrossingPoints() {
        return entityManager().createQuery("SELECT o FROM CrossingPoint o where o.deleted is null", CrossingPoint.class).getResultList();
    }
    
    public static List<CrossingPoint> findCrossingPointEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM CrossingPoint o where o.deleted is null", CrossingPoint.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
}
