package com.payroll.microservicess.roleservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {
	
	
	
	@Autowired
	private RoleRepository roleRepo;
	
	@RequestMapping(value = "/role/{roleName}",method = RequestMethod.GET)
	public Role getRoleDetail(@PathVariable String roleName)
	{
		Role role=roleRepo.findByRoleName(roleName);
		return role;
	}

}
