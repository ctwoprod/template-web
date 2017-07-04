package org.rf.template.services;

import java.util.List;

import org.rf.template.entities.Users;
import org.springframework.data.domain.Page;

public interface UserService {
	List<Users> findAllUser();

	Page<Users> paginateUser(String search, int... rowStartIdxAndCount);

	Page<Users> paginateUserByGroup(String groupId, String search,
			String orderColumn, String orderDirection,
			int... rowStartIdxAndCount);

	Users insertUser(Users user, Users userAdmin);

	Users updateUser(Users user, Users userAdmin);

	Users deleteUser(String id, Users userAdmin);

	Users aktifkanUser(String id, Users userAdmin);

	Users gantiPassword(Users user, String newPassword,
			String oldPasswordInput, Users userUpdatedBy);
}
