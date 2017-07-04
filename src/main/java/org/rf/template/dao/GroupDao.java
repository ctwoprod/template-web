package org.rf.template.dao;

import java.util.List;

import org.rf.template.entities.Group;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * 
 * @author ditlahta-03
 */
public interface GroupDao extends
		PagingAndSortingRepository<Group, String> {

	@Query("select model from Group model order by model.id asc")
	public List<Group> findAll();
}
