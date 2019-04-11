package com.tution.service;

import java.util.UUID;


import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.tution.bureau.common.api.ApiMeta;
import com.tution.common.Utils;
import com.tution.dao.UserDao;
import com.tution.inmemory.GlobalCachedManager;
import com.tution.model.User;
import com.tution.request.UserLoginRequest;
import com.tution.response.TokenResponse;
import com.tution.response.UserLoginResponse;

@Component
public class LoginService {
	
	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(LoginService.class);

	public UserLoginResponse login(UserLoginRequest userLoginRequest, ApiMeta apiMeta) {
		UserLoginResponse response = new UserLoginResponse();
		try {
		if (Utils.isNotEmpty(userLoginRequest.getUsername()) && Utils.isNotEmpty(userLoginRequest.getPassword())) {
			User user = UserDao.getUser(userLoginRequest.getUsername());
			if(user != null) {
				User user1 = UserDao.userLogIn(userLoginRequest.getUsername(), userLoginRequest.getPassword());
				if(user1 != null) {
					response.setUser(user1);
					String token = UUID.randomUUID().toString();
					GlobalCachedManager.set(user1.getId(),
							token + "\t" + userLoginRequest.getIp(),
							600L);
					UserDao.updateLastLogin(user1.getId(), token);
					response.setToken(token + "_" + user1.getId());
					response.setS(true);
				} else {
					response.setEd("Email or password do not match");
				}
			} else {
				response.setEd("uername not exist");
			}
			
			response.setS(true);
		} else {
			response.setEd("Fields are missing");
		}
		} catch(Exception e) {
			logger.error(e.getMessage(), e);
			response.setEd(e.getMessage());
		}
			
		
		
		return response;
		
	}
	
	
	
	
	public static TokenResponse validateToken(ApiMeta apiMeta) {
		TokenResponse response = new TokenResponse();
		String token = apiMeta.getUserToken();
		String ipAddress = apiMeta.getIp();
		if (Utils.isNotEmpty(token) && Utils.isNotEmpty(ipAddress)) {
			try {
				String[] userTokens = token.split("_");
				String userToken = (String) GlobalCachedManager.get(userTokens[1]);
				if (userToken != null) {
					String[] tokens = userToken.split("\t");
					User user = UserDao.getById(userTokens[1]);
					if (user != null && userTokens[0].equals(tokens[0])) {
						response.setUser(user);
						GlobalCachedManager.set(userTokens[1], userToken, 600L);
						response.setS(true);
					} else {
						response.setEd("User logged in from another browser");
					}
				} else {
					response.setEd("Your session has expired. Please log in again");
				}
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				response.setEd(e.getMessage());
			}
		} else {
			response.setEd("Required field are comming invalid");
		}
		return response;
	}
}
