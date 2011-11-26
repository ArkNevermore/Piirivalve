package ee.piirivalve.entities;

import java.io.Serializable;
import java.lang.Long;
import javax.persistence.*;

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
	private static final long serialVersionUID = 1L;

	public Troops() {
		super();
	}   
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
   
}
