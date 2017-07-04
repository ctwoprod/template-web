package org.rf.template.dao;

import org.rf.template.entities.UserLog;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author ditlahta-03
 */
@Repository("UserLogDao")
public interface UserLogDao extends PagingAndSortingRepository<UserLog, String> {

}
