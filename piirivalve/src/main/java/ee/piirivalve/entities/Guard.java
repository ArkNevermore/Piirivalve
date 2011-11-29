package ee.piirivalve.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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

/**
 * Entity implementation class for Entity: Guard
 *
 */
@Entity
@RooToString
@RooEntity
public class Guard implements Serializable {

    @GeneratedValue(strategy = GenerationType.AUTO)  
	@Id
	private Long id;
    
    @NotNull
	private String name;

	private String creator;
	private String modifier;
	private String deleter;
	
	@DateTimeFormat(style="M-")
	private Date modified;
	
	@DateTimeFormat(style="M-")
	private Date created;
	
	@DateTimeFormat(style="M-")
	private Date deleted;
	
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
	
    @Transactional
    public Guard merge() {
        if(id != null && !entityManager.contains(this)) {
            Guard oldEntity = entityManager.find(getClass(), id);
            if(getCreated() == null)
                setCreated(oldEntity.getCreated());
            if (getModified() == null)
            	setModified(oldEntity.getModified()); 
            if (getCreator() == null)
            	setCreator(oldEntity.getCreator());
            if (getModifier() == null)
            	setModifier(oldEntity.getModifier()); 
        }
        Guard merged = this.entityManager.merge(this);
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
        	setTroops(null);

        } else {
            Guard attached = Guard.findGuard(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    public static List<Guard> findAllGuards() {
        return entityManager().createQuery("SELECT o FROM Guard o where o.deleted is null", Guard.class).getResultList();
    }
    
    public static List<Guard> findGuardEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Guard o where o.deleted is null", Guard.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
}
   
