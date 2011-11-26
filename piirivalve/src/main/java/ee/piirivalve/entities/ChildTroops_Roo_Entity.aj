// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ee.piirivalve.entities;

import ee.piirivalve.entities.ChildTroops;
import java.lang.Integer;
import java.lang.Long;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Version;
import org.springframework.transaction.annotation.Transactional;

privileged aspect ChildTroops_Roo_Entity {
    
    @PersistenceContext
    transient EntityManager ChildTroops.entityManager;
    
    @Version
    @Column(name = "version")
    private Integer ChildTroops.version;
    
    public Integer ChildTroops.getVersion() {
        return this.version;
    }
    
    public void ChildTroops.setVersion(Integer version) {
        this.version = version;
    }
    
    @Transactional
    public void ChildTroops.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void ChildTroops.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            ChildTroops attached = ChildTroops.findChildTroops(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void ChildTroops.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void ChildTroops.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public ChildTroops ChildTroops.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        ChildTroops merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
    public static final EntityManager ChildTroops.entityManager() {
        EntityManager em = new ChildTroops().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long ChildTroops.countChildTroopses() {
        return entityManager().createQuery("SELECT COUNT(o) FROM ChildTroops o", Long.class).getSingleResult();
    }
    
    public static List<ChildTroops> ChildTroops.findAllChildTroopses() {
        return entityManager().createQuery("SELECT o FROM ChildTroops o", ChildTroops.class).getResultList();
    }
    
    public static ChildTroops ChildTroops.findChildTroops(Long id) {
        if (id == null) return null;
        return entityManager().find(ChildTroops.class, id);
    }
    
    public static List<ChildTroops> ChildTroops.findChildTroopsEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM ChildTroops o", ChildTroops.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
}
