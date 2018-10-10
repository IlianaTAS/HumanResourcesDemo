package com.lam.recursoshumanoscenicco.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lam.recursoshumanoscenicco.dao.MenuDao;
import com.lam.recursoshumanoscenicco.model.Menu;
import com.lam.recursoshumanoscenicco.service.MenuService;

@Service("menuService")
public class MenuServiceImpl extends GenericAbstractService<Menu, Long> implements MenuService{

	private MenuDao menuDao;
	
	@Autowired
	public MenuServiceImpl(MenuDao menuDao) {
		super(menuDao);
		this.menuDao=menuDao;
	}
}
