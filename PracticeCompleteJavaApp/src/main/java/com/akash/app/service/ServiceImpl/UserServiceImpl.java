package com.akash.app.service.ServiceImpl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.akash.app.dto.UserDTO;
import com.akash.app.entity.User;
import com.akash.app.respository.UserRepository;
import com.akash.app.service.UserService;
import com.akash.app.utils.Utils;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	Utils utils;

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public UserDTO createUser(UserDTO userDto) {

		if (userRepository.findByEmail(userDto.getEmail()) != null)
			throw new RuntimeException("Record already exists");

		User user = new User();
		BeanUtils.copyProperties(userDto, user);

		String publicUserId = utils.generateUserId(30);
		user.setUserId(publicUserId);
		user.setEncryptedPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));

		User storedUserDetails = userRepository.save(user);

		UserDTO returnValueUserDTO = new UserDTO();
		BeanUtils.copyProperties(storedUserDetails, returnValueUserDTO);

		return returnValueUserDTO;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
