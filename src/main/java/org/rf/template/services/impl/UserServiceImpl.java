package org.rf.template.services.impl;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.collections.IteratorUtils;
import org.rf.template.dao.UserLogDao;
import org.rf.template.dao.UsersDao;
import org.rf.template.entities.UserLog;
import org.rf.template.entities.Users;
import org.rf.template.services.UserService;
import org.rf.template.util.PasswordUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("UserService")
public class UserServiceImpl implements UserService {

	@Inject
	private UsersDao userDao;
	@Inject
	private UserLogDao userLogDao;

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<Users> findAllUser() {
		return IteratorUtils.toList(userDao.findAll().iterator());
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public Page<Users> paginateUser(String search, int... rowStartIdxAndCount) {
		PageRequest page = new PageRequest(rowStartIdxAndCount[0],
				rowStartIdxAndCount[1]);
		if (search.equalsIgnoreCase("")) {
			return userDao.findAll(page);
		} else {
			return userDao.paginateAllByUserNameLike(search, page);
		}
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public Page<Users> paginateUserByGroup(String groupId, String search,
			String orderColumn, String orderDirection,
			int... rowStartIdxAndCount) {
		PageRequest page = new PageRequest(rowStartIdxAndCount[0],
				rowStartIdxAndCount[1]);
		if (orderColumn.equalsIgnoreCase("0")) {
			if (orderDirection.equalsIgnoreCase("asc")) {
				page = new PageRequest(rowStartIdxAndCount[0],
						rowStartIdxAndCount[1], Direction.ASC, "userName");
			} else {
				page = new PageRequest(rowStartIdxAndCount[0],
						rowStartIdxAndCount[1], Direction.DESC, "userName");
			}
		}
		if (orderColumn.equalsIgnoreCase("1")) {
			if (orderDirection.equalsIgnoreCase("asc")) {
				page = new PageRequest(rowStartIdxAndCount[0],
						rowStartIdxAndCount[1], Direction.ASC, "nama");
			} else {
				page = new PageRequest(rowStartIdxAndCount[0],
						rowStartIdxAndCount[1], Direction.DESC, "nama");
			}
		}
		if (orderColumn.equalsIgnoreCase("2")) {
			if (orderDirection.equalsIgnoreCase("asc")) {
				page = new PageRequest(rowStartIdxAndCount[0],
						rowStartIdxAndCount[1], Direction.ASC, "email");
			} else {
				page = new PageRequest(rowStartIdxAndCount[0],
						rowStartIdxAndCount[1], Direction.DESC, "email");
			}
		}
		if (orderColumn.equalsIgnoreCase("3")) {
			if (orderDirection.equalsIgnoreCase("asc")) {
				page = new PageRequest(rowStartIdxAndCount[0],
						rowStartIdxAndCount[1], Direction.ASC, "role.nama");
			} else {
				page = new PageRequest(rowStartIdxAndCount[0],
						rowStartIdxAndCount[1], Direction.DESC, "role.nama");
			}
		}
		if (orderColumn.equalsIgnoreCase("5")) {
			if (orderDirection.equalsIgnoreCase("asc")) {
				page = new PageRequest(rowStartIdxAndCount[0],
						rowStartIdxAndCount[1], Direction.ASC, "aktif");
			} else {
				page = new PageRequest(rowStartIdxAndCount[0],
						rowStartIdxAndCount[1], Direction.DESC, "aktif");
			}
		}
		if (search.equalsIgnoreCase("")) {
			return userDao.paginateAllByGroup(groupId, page);
		} else {
			return userDao.paginateAllByUserNameLikeAndGroup(groupId, search,
					page);
		}
	}

	@Transactional(readOnly = false)
	public Users insertUser(Users user, Users userAdmin) {
		List<Users> listUSer = userDao.findByUserName(user.getUserName());
		if (!listUSer.isEmpty()) {
			return null;
		}
		user.setUserPassword(encryptPassword(user.getUserPassword()));
		user.setAktif("1");
		user.setCreatedDate(new Date());
		user.setUpdatedDate(new Date());
		user.setCreatedBy(userAdmin);
		user.setUpdatedBy(userAdmin);
		return userDao.save(user);

	}

	@Transactional(readOnly = false)
	public Users updateUser(Users user, Users userAdmin) {
		// if(userDao.findByUserNameIgnoreCase(user.getUserName().trim())!=null){
		// throw new RuntimeException("Sloc harus unik");
		// }
		Users userFromDB = userDao.findOne(user.getId());
		userFromDB.setRole(user.getRole());
		userFromDB.setGroup(user.getGroup());
		if (!user.getUserPassword().equalsIgnoreCase("")) {
			userFromDB.setUserPassword(encryptPassword(user.getUserPassword()));
		}
		// userFromDB.setAktif(user.getAktif());
		userFromDB.setUpdatedDate(new Date());
		userFromDB.setNama(user.getNama());
		userFromDB.setUserName(user.getUserName());
		userFromDB.setEmail(user.getEmail());
		userFromDB.setUpdatedBy(userAdmin);
		userFromDB.setUpdatedDate(new Date());
		//
		userFromDB.setJenisHirarki(user.getJenisHirarki());
		userFromDB.setIdReferensiHirarki(user.getIdReferensiHirarki());
		return userDao.save(userFromDB);

	}

	@Transactional(readOnly = false)
	public Users deleteUser(String id, Users userAdmin) {
		Users instance = userDao.findOne((id));
		instance.setAktif("0");
		instance.setUpdatedDate(new Date());
		instance.setUpdatedBy(userAdmin);
		// insert ke USER_LOG
		UserLog userLog = new UserLog();
		userLog.setAction("NON AKTIF");
		userLog.setCreatedDate(new Date());
		userLog.setUser(instance);
		userLog.setUserAdmin(userAdmin);
		// insert into user log
		userLogDao.save(userLog);
		//
		return userDao.save(instance);
	}

	@Transactional(readOnly = false)
	public Users aktifkanUser(String id, Users userAdmin) {
		Users instance = userDao.findOne((id));
		instance.setAktif("1");
		instance.setUpdatedDate(new Date());
		instance.setUpdatedBy(userAdmin);
		// insert ke USER_LOG
		UserLog userLog = new UserLog();
		userLog.setAction("AKTIF");
		userLog.setCreatedDate(new Date());
		userLog.setUser(instance);
		userLog.setUserAdmin(userAdmin);
		userLogDao.save(userLog);
		//
		return userDao.save(instance);
	}

	@Transactional(readOnly = false)
	public Users gantiPassword(Users user, String newPassword,
			String oldPasswordInput, Users userUpdatedBy) {
		PasswordUtil passwordUtil = new PasswordUtil();
		boolean isValid = false;
		try {
			isValid = passwordUtil.isPasswordEqual(oldPasswordInput,
					user.getUserPassword());
		} catch (Exception e) {
			isValid = false;
		}
		if (!isValid) {
			return null;
		}
		user.setUserPassword(encryptPassword(newPassword));
		user.setUpdatedDate(new Date());
		user.setUpdatedBy(userUpdatedBy);
		return userDao.save(user);
	}

	private String encryptPassword(String password) {
		String encryptedPassword = "";
		PasswordUtil passwordUtil = new PasswordUtil();
		try {
			encryptedPassword = passwordUtil.encryptPassword(password);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return encryptedPassword;
	}

}
