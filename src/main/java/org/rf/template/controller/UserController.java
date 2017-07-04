package org.rf.template.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.rf.template.constants.Keyword;
import org.rf.template.dao.UsersDao;
import org.rf.template.entities.Group;
import org.rf.template.entities.Role;
import org.rf.template.entities.Users;
import org.rf.template.model.UserInfo;
import org.rf.template.model.table.DataTableBean;
import org.rf.template.services.UserService;
import org.rf.template.util.DateUtil;
import org.rf.template.util.SessionUtil;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {
	@Inject
	private UserService userService;

	@Inject
	private UsersDao userDao;

	@RequestMapping
	public String getInitialPage(final Model model, HttpSession session) {
		UserInfo userLogin = (UserInfo) session
				.getAttribute(SessionUtil.USER_LOGIN);
		if (!userLogin.getRoleId().equalsIgnoreCase(Role.ROLE_ADMINISTRATOR)) {
			return "notAccess";
		}
		return "user/user";
	}

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public @ResponseBody DataTableBean list(@RequestParam("draw") Integer draw,
			@RequestParam("start") Integer start,
			@RequestParam("length") Integer length,
			@RequestParam("search[value]") String searchValue,
			@RequestParam("order[0][column]") String orderColumn,
			@RequestParam("order[0][dir]") String orderDirection,
			HttpSession session) {
		UserInfo user = (UserInfo) session.getAttribute(SessionUtil.USER_LOGIN);
		int page = start / length;
		Page<Users> result = userService.paginateUserByGroup(user.getGroupId(),
				searchValue, orderColumn, orderDirection, page, length);

		return buildDataTable(result, draw);

	}

	private DataTableBean buildDataTable(Page<Users> data, Integer draw) {
		List<Users> users = data.getContent();
		Integer rowCount = (int) data.getTotalElements();
		List<Map<String, Object>> listOfMap = new ArrayList<Map<String, Object>>();
		for (Users user : users) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", user.getId());
			map.put("nama", user.getNama());
			map.put("username", user.getUserName());
			map.put("email", user.getEmail());
			Group group = user.getGroup();
			map.put("groupNama", group.getNama());
			map.put("groupId", group.getId());
			Role role = user.getRole();
			map.put("roleNama", role.getNama());
			map.put("roleId", role.getId());
			map.put("aktif", user.getAktif().equals("1") ? "Aktif"
					: "Tidak Aktif");

			if (user.getLastLogin() == null) {

				map.put("lastLogin", "");
			} else {
				map.put("lastLogin", DateUtil.timeFormatIndonesia.format(user
						.getLastLogin()));
			}
			if (user.getCreatedDate() == null) {
				map.put("createdDate", "");
			} else {
				map.put("createdDate", DateUtil.timeFormatIndonesia.format(user
						.getCreatedDate()));
			}
			if (user.getUpdatedDate() == null) {
				map.put("updatedDate", "");
			} else {
				map.put("updatedDate", DateUtil.timeFormatIndonesia.format(user
						.getUpdatedDate()));
			}

			listOfMap.add(map);
		}
		DataTableBean dtb = new DataTableBean();
		dtb.setData(listOfMap);
		dtb.setDraw(draw);
		dtb.setRecordsFiltered(rowCount);
		dtb.setRecordsTotal(rowCount);
		return dtb;
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> getUserById(
			@PathVariable String id, HttpSession session) {

		Map<String, Object> map = new HashMap<String, Object>();
		Users user = userDao.findOne((id));
		map.put("id", user.getId());
		map.put("nama", user.getNama());
		map.put("username", user.getUserName());
		map.put("email", user.getEmail());
		Group group = user.getGroup();
		map.put("groupNama", group.getNama());
		map.put("groupId", group.getId());
		Role role = user.getRole();
		map.put("roleNama", role.getNama());
		map.put("roleId", role.getId());
		map.put("aktif", user.getAktif().equals("1") ? "Aktif" : "Tidak Aktif");

		map.put("jenisHirarki", user.getJenisHirarki());
		map.put("idReferensiHirarki", user.getIdReferensiHirarki());

		if (user.getLastLogin() == null) {

			map.put("lastLogin", "");
		} else {
			map.put("lastLogin",
					DateUtil.timeFormatIndonesia.format(user.getLastLogin()));
		}
		if (user.getCreatedDate() == null) {
			map.put("createdDate", "");
		} else {
			map.put("createdDate",
					DateUtil.timeFormatIndonesia.format(user.getCreatedDate()));
		}
		if (user.getUpdatedDate() == null) {
			map.put("updatedDate", "");
		} else {
			map.put("updatedDate",
					DateUtil.timeFormatIndonesia.format(user.getUpdatedDate()));
		}
		return map;
	}

	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> delete(HttpServletRequest request,
			HttpSession session) {
		UserInfo userAdmin = (UserInfo) session
				.getAttribute(SessionUtil.USER_LOGIN);
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Users user = userService.deleteUser(request.getParameter("id"),
					userDao.findOne(userAdmin.getId()));
			map.put(Keyword.PESAN, Keyword.BERHASIL_HAPUS_DATA);
		} catch (Exception ex) {
			map.put(Keyword.PESAN, Keyword.GAGAL_HAPUS_DATA);
		}
		return map;
	}

	@RequestMapping(value = "aktif", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> aktif(HttpServletRequest request,
			HttpSession session) {
		UserInfo userAdmin = (UserInfo) session
				.getAttribute(SessionUtil.USER_LOGIN);
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Users user = userService.aktifkanUser(request.getParameter("id"),
					userDao.findOne(userAdmin.getId()));
			map.put(Keyword.PESAN, Keyword.BERHASIL_AKTIFKAN_USER);
		} catch (Exception ex) {
			map.put(Keyword.PESAN, Keyword.GAGAL_AKTIFKAN_USER);
		}
		return map;
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> add(@ModelAttribute Users user,
			HttpServletRequest request, HttpSession session) {
		UserInfo userAdmin = (UserInfo) session
				.getAttribute(SessionUtil.USER_LOGIN);
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			// if (user.getIdReferensiHirarki()==null ||
			// user.getIdReferensiHirarki().equals("")) {
			// throw new NullPointerException("Data Hirarki belom dipilih");
			// }
			Users result = userService.insertUser(user,
					userDao.findOne(userAdmin.getId()));
			if (result == null) {
				map.put(Keyword.PESAN, Keyword.DUPLIKAT_USERNAME);
			} else {
				map.put(Keyword.PESAN, Keyword.BERHASIL_SIMPAN_DATA);
			}

		} catch (NullPointerException ex) {
			map.put(Keyword.PESAN, ex.getMessage());
		} catch (Exception ex) {
			map.put(Keyword.PESAN, Keyword.GAGAL_SIMPAN_DATA);
		}
		return map;

	}

	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> edit(@ModelAttribute Users user,
			HttpServletRequest request, HttpSession session) {
		UserInfo userAdmin = (UserInfo) session
				.getAttribute(SessionUtil.USER_LOGIN);
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			// if (user.getIdReferensiHirarki()==null ||
			// user.getIdReferensiHirarki().equals("")) {
			// throw new NullPointerException("Data Hirarki belom dipilih");
			// }
			Users result = userService.updateUser(user,
					userDao.findOne(userAdmin.getId()));
			map.put(Keyword.PESAN, Keyword.BERHASIL_UBAH_DATA);
		} catch (NullPointerException ex) {
			map.put(Keyword.PESAN, ex.getMessage());
		} catch (Exception ex) {
			map.put(Keyword.PESAN, Keyword.GAGAL_UBAH_DATA);
		}
		return map;
	}

	@RequestMapping(value = "changePassword", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> changePassword(
			@RequestParam("userId") String userId,
			@RequestParam("oldPassword") String oldPassword,
			@RequestParam("newPassword1") String newPassword1,
			@RequestParam("newPassword2") String newPassword2,
			HttpSession session) throws Exception {
		UserInfo userAdmin = (UserInfo) session
				.getAttribute(SessionUtil.USER_LOGIN);
		Map<String, Object> map = new HashMap<String, Object>();
		Users user = null;
		try {
			user = userDao.findOne((userId));
			if (newPassword1.equals(newPassword2)) {
				if (userService.gantiPassword(user, newPassword1, oldPassword,
						userDao.findOne(userAdmin.getId())) != null) {
					map.put(Keyword.PESAN,
							Keyword.UPDATE_PASSWORD_BARU_BERHASIL);
				} else {
					map.put(Keyword.PESAN, Keyword.UPDATE_PASSWORD_BARU_GAGAL);
				}
			} else {
				map.put(Keyword.PESAN, Keyword.KONFIRMASI_PASSWORD_SALAH);
			}

		} catch (Exception ex) {
			map.put(Keyword.PESAN, Keyword.TERJADI_KESAHALAN);
		}
		return map;
	}

}
