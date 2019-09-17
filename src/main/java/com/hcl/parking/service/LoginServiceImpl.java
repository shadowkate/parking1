package com.hcl.parking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hcl.parking.dto.LoginReqDto;
import com.hcl.parking.dto.LoginResDto;
import com.hcl.parking.entity.User;
import com.hcl.parking.exception.EnterValidCredentials;
import com.hcl.parking.exception.UserNotFound;
import com.hcl.parking.repository.UserRepository;
@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public LoginResDto userLogin(LoginReqDto loginDto) {
		
		
		User details=userRepository.findByEmailAndPassword(loginDto.getEmail(),loginDto.getPassword());
		
		if(null!=details) {
			if (details.getEmail().equals(loginDto.getEmail()) && details.getPassword().equals(loginDto.getPassword())) {
				LoginResDto loginResDto=new LoginResDto();
				loginResDto.setUserId(details.getUserId());
				loginResDto.setRole(details.getRole());
				loginResDto.setUserName(details.getUserName());
				loginResDto.setMessage("Login Success");
				loginResDto.setStatus("SUCCESS");
				loginResDto.setStatusCode(HttpStatus.OK.value());
				return loginResDto;
			}else {
				throw new EnterValidCredentials("Please enter correct username or password");
			}
			
		}
		else {
			throw new UserNotFound("User does not exists");
		}
	}
}
