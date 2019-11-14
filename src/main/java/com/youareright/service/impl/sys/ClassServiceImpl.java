package com.youareright.service.impl.sys;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.youareright.dao.ClassDao;
import com.youareright.model.sys.ClassEntity;
import com.youareright.model.sys.UserEntity;
import com.youareright.service.sys.ClassService;

@Service(value = "classServiceImpl")
public class ClassServiceImpl implements ClassService {

	@Autowired
	private ClassDao classDao;
	
	@Override
	public void insertClass(ClassEntity classEntity) {
		classDao.insertClass(classEntity);
	}

	@Override
	public void deleteClasses(List<String> className) {
		classDao.deleteClasses(className);
	}
	
	@Override
	public void del(ClassEntity classEntity) {
		classDao.del(classEntity);
	}

	@Override
	public void updateClass(ClassEntity classEntity) {
		classDao.updateClass(classEntity);
	}

	@Override
	public List<ClassEntity> classList(String goodsClass, int pageSize, int start) {
		return classDao.classList( goodsClass, pageSize,  start);
	}

	@Override
	public Integer classSize(String goodsClass, int pageSize, int start) {
		return classDao.classSize(goodsClass, pageSize, start);
	}


}
