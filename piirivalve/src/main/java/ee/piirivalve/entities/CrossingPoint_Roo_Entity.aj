// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ee.piirivalve.entities;

import ee.piirivalve.entities.CrossingPoint;
import java.lang.Integer;
import java.lang.Long;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Version;
import org.springframework.transaction.annotation.Transactional;

privileged aspect CrossingPoint_Roo_Entity {
    
    @PersistenceContext
    transient EntityManager CrossingPoint.entityManager;
    
    @Version
    @Column(name = "version")
    private Integer CrossingPoint.version;
    
    public Integer CrossingPoint.getVersion() {
        return this.version;
    }
    
    public void CrossingPoint.setVersion(Integer version) {
        this.version = version;
    }
    
    @Transactional
    public void CrossingPoint.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void CrossingPoint.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            CrossingPoint attached = CrossingPoint.findCrossingPoint(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void CrossingPoint.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void CrossingPoint.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public CrossingPoint CrossingPoint.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        CrossingPoint merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
    public static final EntityManager CrossingPoint.entityManager() {
        EntityManager em = new CrossingPoint().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long CrossingPoint.countCrossingPoints() {
        return entityManager().createQuery("SELECT COUNT(o) FROM CrossingPoint o", Long.class).getSingleResult();
    }
    
    public static List<CrossingPoint> CrossingPoint.findAllCrossingPoints() {
        return entityManager().createQuery("SELECT o FROM CrossingPoint o", CrossingPoint.class).getResultList();
    }
    
    public static CrossingPoint CrossingPoint.findCrossingPoint(Long id) {
        if (id == null) return null;
        return entityManager().find(CrossingPoint.class, id);
    }
    
    public static List<CrossingPoint> CrossingPoint.findCrossingPointEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM CrossingPoint o", CrossingPoint.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
}
