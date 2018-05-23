package spring.pintura.converter;

import org.springframework.stereotype.Component;

import spring.pintura.entity.User;
import spring.pintura.model.UserCredential;


@Component("userConverter")
public class UserConverter {
	
public User userModeltoUser(UserCredential userModel) {
		
		User user = new User();

		user.setUsername(userModel.getUsername());
		user.setPassword(userModel.getPassword());
		user.setEnabled(userModel.isEnable());
		return user;
	}

}
