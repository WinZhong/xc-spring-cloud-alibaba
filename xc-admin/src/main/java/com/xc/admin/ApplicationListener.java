package com.xc.admin;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.xc.service.user.UserService;
import com.xc.util.LoginUserHolder;

@Component
public class ApplicationListener implements ApplicationRunner {
	@Reference
	private UserService userService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		LoginUserHolder.setUserPubKey(userService.getJwtUserPubKey().getResult().getBytes("pubKey"));
	}
}
