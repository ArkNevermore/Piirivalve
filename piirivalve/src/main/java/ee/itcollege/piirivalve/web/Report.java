package ee.itcollege.piirivalve.web;

import java.util.List;
import ee.piirivalve.entities.Troops;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.roo.addon.javabean.RooJavaBean;

@Configurable
@RooJavaBean
public class Report {

	@PersistenceContext
    EntityManager entityManager;
	
	Troops troops;
	List<String[]> items;
	
	public Report() {
		
	}
	
	public Report(Troops troops, List<String[]> items) {
		this.troops = troops;
		this.items = items;
	}

    @SuppressWarnings("unchecked")
	public static Report findAllEntries(Troops c) {
    	Query q = entityManager().createQuery("Select Count(c.name), t.name FROM BorderSection AS t JOIN t.guard as c WHERE t.troops = :troops GROUP BY c.name");
    		//	"Select t.name, COUNT(c.name), b.name FROM CrossingPoint AS t JOIN t.borderSection AS b JOIN b.guard as c WHERE t.troops = :troops GROUP BY c.name");
    	q.setParameter("troops", c);
    	
    	return new Report(c, q.getResultList());
    }
    
    public static final EntityManager entityManager() {
        EntityManager em = new Report().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
	
	
}
