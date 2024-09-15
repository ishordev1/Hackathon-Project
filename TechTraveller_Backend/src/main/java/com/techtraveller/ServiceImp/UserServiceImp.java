package com.techtraveller.ServiceImp;

import com.techtraveller.Dto.TourGuideDto;
import com.techtraveller.Dto.UserDto;
import com.techtraveller.Entity.Role;
import com.techtraveller.Entity.TourGuide;
import com.techtraveller.Entity.User;
import com.techtraveller.Exception.BadApiRequest;
import com.techtraveller.Exception.ResourceNotFoundException;
import com.techtraveller.Repository.UserRepository;
import com.techtraveller.Service.EmailService;
import com.techtraveller.Service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;
    
    @Autowired
	private PasswordEncoder passwordEncoder;
    
    @Autowired
    private EmailService emailService;

    @Override
    public UserDto createUser(UserDto userDto) {
    	User userFound = this.userRepository.findByEmail(userDto.getEmail());
    	if(userFound!=null) {
    		throw new BadApiRequest("this email is already found");
    	}
        User user = modelMapper.map(userDto, User.class);
        user.setPassword(this.passwordEncoder.encode(userDto.getPassword()));
//        System.out.println("Encoded passfdword:"+user.getPassword());
        user.setIsActive(false);
        user.setEmailVerify(false);
        
        String emailToken = UUID.randomUUID().toString();
		user.setEmailToken(emailToken);
		System.out.println("this is user Role:"+user.getRole());
		User savedUser = userRepository.save(user);

		String html = "<div style='border: 2px solid #000; padding: 20px; width: 300px; margin: 0 auto; text-align: center;'>"
				+ "<h1 style='color: #333;'>Verify Your Email</h1>" + "<h3 style='color: #333;'>Assignment Website</h3>"
				+ "<p style='font-size: 16px;'>Please enter this code to verify your email address.</p>"
				+ "<a href='http://localhost:8080/auth/verify-email?token=" + emailToken
				+ "' style='display: inline-block; margin-top: 20px; padding: 10px 20px; color: white; background-color: #007bff; text-decoration: none; border-radius: 5px;'>Verify Email</a>"
				+ "</div>";

//		this.emailService.sendEmailWithHtml(user.getEmail(), "Tech Traveller Verify Link", html);
		
        return modelMapper.map(savedUser, UserDto.class);
    }

    @Override
    public UserDto getUserById(String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(user -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(String userId, UserDto userDto) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        user.setEmail(userDto.getEmail());
        
        if (userDto.getPassword() != null && !userDto.getPassword().isEmpty()) {
            user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        }
        
        User updatedUser = userRepository.save(user);
        return modelMapper.map(updatedUser, UserDto.class);
    }
    
   @Override
    public UserDto updateVerifyUser(String userId, UserDto userDto) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        user.setIsActive(userDto.getIsActive());
        user.setEmailVerify(userDto.getEmailVerify());
        User updatedUser = userRepository.save(user);
        return modelMapper.map(updatedUser, UserDto.class);
    }

    @Override
    public void deleteUser(String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        userRepository.delete(user);
    }
    

	@Override
	public UserDto getUserByEmailToken(String token) {
		User user = this.userRepository.findUserByEmailToken(token)
				.orElseThrow(() -> new ResourceNotFoundException("Sorry... user not found"));
		return this.modelMapper.map(user, UserDto.class);
	}
}
