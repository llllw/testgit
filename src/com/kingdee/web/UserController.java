package com.kingdee.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kingdee.domains.Address;
import com.kingdee.domains.User;
import com.kingdee.service.UserService;

@Controller
public class UserController
{
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/saveUser")
	@ResponseBody
	public String saveUser() {
		
		User user = new User();
		user.setAge(22);
		user.setName("yiyun");
		Address address = new Address();
		address.setProvince("广东省");
		address.setCity("深圳市");user.setAddress(address);
		userService.saveUser(user);
		return user.toString();
	}
}
