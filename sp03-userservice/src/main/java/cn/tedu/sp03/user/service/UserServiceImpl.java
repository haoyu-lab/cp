package cn.tedu.sp03.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;

import cn.tedu.sp01.pojo.User;
import cn.tedu.sp01.service.UserService;
import cn.tedu.web.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;

@RefreshScope
@Service
@Slf4j
public class UserServiceImpl implements UserService{
	
	@Value("${sp.user-service.users}")
	private String userJson;
	
	@Override
	public User getUser(Integer id) {
		log.info("userJson="+userJson);
		
		//把userJson转成一组用户对象
		List<User> users = JsonUtil.from(userJson, new TypeReference<List<User>>() {});
		
		for (User u : users) {
			if (u.getId().equals(id)) {
				return u;
			}
		}
		
		return new User(id, "name-"+id, "pwd-"+id);
	}
	@Override
	public void addScore(Integer id, Integer score) {
		log.info("增加用户积分: id="+id+", score="+score);
	}
}









