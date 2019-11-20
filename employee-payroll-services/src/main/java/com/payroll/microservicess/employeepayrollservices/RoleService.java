package com.payroll.microservicess.employeepayrollservices;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@FeignClient(name="role-service",url = "localhost:8101")
//@RibbonClient(name="role-service")
//@FeignClient(name="role-service")
//@FeignClient(name = "ZUUL-EDGE-SERVER")
//@RibbonClient(name = "role-service")
/*public interface RoleService {
	@RequestMapping(value = "/role-service/role/{roleName}",method = RequestMethod.GET)
	EmployeePayroll getRoleDetail(@PathVariable String roleName);

}*/
