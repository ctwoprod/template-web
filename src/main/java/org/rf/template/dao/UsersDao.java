package org.rf.template.dao;

import java.math.BigInteger;
import java.util.List;

import org.rf.template.entities.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author ditlahta-03
 */
@Repository("UsersDao")
public interface UsersDao extends PagingAndSortingRepository<Users, String> {
	List<Users> findByUserName(String userNama);

	@Query("select model from Users model where LOWER(model.userName) like %:param% or LOWER(model.nama) like %:param% order by model.userName asc")
	public Page<Users> paginateAllByUserNameLike(@Param("param") String param,
			Pageable Page);

	@Query("select model from Users model where (LOWER(model.userName) like %:param% or LOWER(model.nama) like %:param%) and model.group.id=:group")
	public Page<Users> paginateAllByUserNameLikeAndGroup(
			@Param("group") String group, @Param("param") String param,
			Pageable Page);

	@Query("select model from Users model where model.group.id =:param")
	public Page<Users> paginateAllByGroup(@Param("param") String param,
			Pageable Page);

	@Query(value = "SELECT count(*) " + "FROM Users u WHERE u.aktif = '1'", nativeQuery = true)
	List<BigInteger> countAktifUser();

	public Users findByUserNameIgnoreCase(String param);

}
