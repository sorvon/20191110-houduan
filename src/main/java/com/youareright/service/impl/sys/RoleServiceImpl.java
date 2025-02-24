package com.youareright.service.impl.sys;

import java.util.List;

import com.youareright.dao.RoleMenuDao;
import com.youareright.service.sys.RoleMenuService;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youareright.dao.RoleDao;
import com.youareright.model.sys.RoleEntity;
import com.youareright.service.sys.RoleService;

@Service(value = "roleServiceImpl")
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDao roleDao;

	@Autowired
	private RoleMenuDao roleMenuDao;

	@Override
	public List<RoleEntity> rolesList(int pageSize, int start) {
		List<RoleEntity> roleEntityList = roleDao.rolesList(pageSize, start);
		for (RoleEntity roleEntity : roleEntityList){
			List<String> menuIds = roleMenuDao.getMenuByRoleId(roleEntity.getId());
			String menuStr = "";
			for (String menuId : menuIds){
				menuStr = menuStr + menuId +";";
			}
			roleEntity.setModules(menuStr);
		}
		return roleEntityList;
	}

	@Override
	public Integer rolesSize(int pageSize, int start) {
		return roleDao.rolesSize(pageSize, start);
	}

	@Override
	public void insertRole(RoleEntity roleEntity) {
		roleDao.insertRole(roleEntity);
	}

	@Override
	public void updateRole(RoleEntity roleEntity) {
		roleDao.updateRole(roleEntity);
	}

	@Override
	public void deleteRoles(List<String> groupId) {
		roleDao.deleteRoles(groupId);
	}

	@Override
	public List<RoleEntity> allRoles() {
		return roleDao.allRoles();
	}

}
