/**
 * 
 */
package com.ssm.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.ssm.mapper.UserMapper;
import com.ssm.pojo.User;
import com.ssm.service.UserService;

/**
 * @author 作者
 * @data 2019年7月31日 
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{
	@Autowired
	UserMapper userMapper;
	
	@Override
	public List<User> getAllUser() throws Exception {
		
		try {
			List<User> list = userMapper.getAllUser();
			return list;
		} catch (Exception e) {
			 TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return null;
	}
	
}
