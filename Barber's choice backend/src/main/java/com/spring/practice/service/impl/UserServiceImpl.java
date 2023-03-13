package com.spring.practice.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.practice.entities.User;
import com.spring.practice.exception.ResourceNotFoundException;
import com.spring.practice.repository.UserRepository;
import com.spring.practice.responce.UserDto;
import com.spring.practice.service.UserService;

@Service
public class UserServiceImpl implements UserService {
  
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper modelmapper;
	
	public UserServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public UserDto saveUser (UserDto userdto) {
		// TODO Auto-generated method stub
		User user = this.dtoTobUser(userdto);
		User saveUser = this.userRepository.save(user);
		return this.UserToDto(saveUser);
		
	}

	@Override
	public List<UserDto> getAllUser() {
		List<User> user1 = (List<User>) this.userRepository.findAll();
		List<UserDto> branddto = user1.stream().map(user11-> this.UserToDto(user11)).collect(Collectors.toList());
		return branddto;
	}

	@Override
	public UserDto updateUser(UserDto user ,int id) {
		User existinguser = userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("user", "id", id));
		existinguser.setNamelast(user.getNamelast());
		existinguser.setNamefirst(user.getNamefirst());
		
		User updateUser = this.userRepository.save(existinguser);
		UserDto UserDto = this.UserToDto(updateUser);
		
		return UserDto;
	}

	@Override
	public UserDto getUserById(int id) {
	
		User user2 =this.userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User", "id", id));
		return this.UserToDto(user2);
	}

	@Override
	public void deleteUser(int id) {
		
		User user =this.userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User", "id", id));	
		this.userRepository.delete(user);	
	}
	
	
	
	

	
	public User dtoTobUser(UserDto userDto) {
		User user = this.modelmapper.map(userDto, User.class);
		return user;
	}
	
	
	public UserDto UserToDto(User user) {
		UserDto userDto =this.modelmapper.map(user, UserDto.class);
		return userDto;
	}
	

}
