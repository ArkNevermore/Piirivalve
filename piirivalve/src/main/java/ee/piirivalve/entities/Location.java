package ee.piirivalve.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.transaction.annotation.Transactional;

import ee.itcollege.piirivalve.web.AuthController;
import ee.piirivalve.entities.Troops;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Location
 *
 */
@Entity
@RooToString
@RooEntity
public class Location implements Serializable {

	@GeneratedValue(strategy = GenerationType.AUTO)   
	@Id
	private Long id;
	private String name;
	private static final long serialVersionUID = 1L;
	
	private String creator;
	private String modifier;
	private String deleter;
	
	@DateTimeFormat(style="M-")
	private Date modified;
	
	@DateTimeFormat(style="M-")
	private Date created;
	
	@DateTimeFormat(style="M-")
	private Date deleted;
	
	@OneToMany(mappedBy = "location")
	private Collection<Troops> troops;
	
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
	
	public Location() {
		super();
	}   
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public Collection<Troops> getTroops() {
	    return troops;
	}
	public void setTroops(Collection<Troops> param) {
	    this.troops = param;
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
    public Location merge() {
        if(id != null && !entityManager.contains(this)) {
            Location oldEntity = entityManager.find(getClass(), id);
            if(getCreated() == null)
                setCreated(oldEntity.getCreated());
            if (getModified() == null)
            	setModified(oldEntity.getModified()); 
            if (getCreator() == null)
            	setCreator(oldEntity.getCreator());
            if (getModifier() == null)
            	setModifier(oldEntity.getModifier()); 
        }
        Location merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
    @Transactional
    public void remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
           // this.entityManager.remove(this);
        	preventRemove();
        } else {
            Location attached = Location.findLocation(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    public static List<Location> findAllLocations() {
        return entityManager().createQuery("SELECT o FROM Location o where o.deleted is null", Location.class).getResultList();
    }
    
    public static List<Location> findLocationEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Location o where o.deleted is null", Location.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
}
