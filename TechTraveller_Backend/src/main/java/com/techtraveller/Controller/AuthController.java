package com.techtraveller.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techtraveller.Dto.ApiResponse;
import com.techtraveller.Dto.RoomProviderDto;
import com.techtraveller.Dto.TourGuideDto;
import com.techtraveller.Dto.TouristDto;
import com.techtraveller.Dto.UserDto;
import com.techtraveller.Entity.User;
import com.techtraveller.Exception.BadApiRequest;
import com.techtraveller.Repository.UserRepository;
import com.techtraveller.Service.EmailService;
import com.techtraveller.Service.RoomProviderService;
import com.techtraveller.Service.TourGuideService;
import com.techtraveller.Service.TouristService;
import com.techtraveller.Service.UserService;
import com.techtraveller.config.CustomUserDetails;
import com.techtraveller.config.JwtProvider;
import com.techtraveller.config.JwtRequest;
import com.techtraveller.config.JwtResponse;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private TourGuideService tourGuideService;
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TouristService touristService;
	
	@Autowired
	private CustomUserDetails customUserDetail;
	
	@Autowired
	private PasswordEncoder passwordEncorder;

	@Autowired
	private RoomProviderService roomProviderService;
	
	
	@PostMapping("/signin")
	public ResponseEntity<JwtResponse> createTourGuideSignIn(@RequestBody JwtRequest jwtRequest) {
		
		Authentication authentication=authenticate(jwtRequest.getEmail(),jwtRequest.getPassword());
//		System.out.println("this is user"+authentication.getName());
		String token=JwtProvider.generateToken(authentication);
		JwtResponse jwtResponse =JwtResponse.builder().token(token).user(this.userRepository.findByEmail(authentication.getName())).build();
				
		return new ResponseEntity<>(jwtResponse,HttpStatus.OK);
	}

	@PostMapping("/tourguidesignup")
	public ResponseEntity<TourGuideDto> createTourGuide(@RequestBody TourGuideDto tourGuideDto) {
		TourGuideDto createdTourGuide = tourGuideService.createTourGuide(tourGuideDto);
	
		return new ResponseEntity<>(createdTourGuide, HttpStatus.CREATED);
	}


	@PostMapping("/roomprovidersignup")
	public ResponseEntity<RoomProviderDto> createRoomProvider(@RequestBody RoomProviderDto roomProviderDto) {
		 RoomProviderDto savedRoomProvider = roomProviderService.createRoomProvider(roomProviderDto);
		return new ResponseEntity<>(savedRoomProvider, HttpStatus.CREATED);
	}
	

	@PostMapping("/touristsignup")
	public ResponseEntity<TouristDto> signupTourist(@RequestBody TouristDto touristDto) {

		TouristDto createdTourist = touristService.createTourist(touristDto);
		return ResponseEntity.ok(createdTourist);
	}



	@GetMapping("/verify-email")
	ResponseEntity<ApiResponse> verify_Email(@RequestParam("token") String token) {
		UserDto userDto = this.userService.getUserByEmailToken(token);

		userDto.setEmailVerify(true);
		userDto.setIsActive(true);
		UserDto updateUser = this.userService.updateVerifyUser(userDto.getUserId(), userDto);
		ApiResponse apiResponse = ApiResponse.builder().message("your account is Verify successfully").success(true)
				.Status(HttpStatus.OK).build();
		return new ResponseEntity<>(apiResponse, HttpStatus.OK);
	}
	
	
	private Authentication authenticate(String username, String password) {
		UserDetails userDetails=this.customUserDetail.loadUserByUsername(username);
		if(userDetails==null) {
			throw new BadCredentialsException("invalid user and password");
		}
		if(!passwordEncorder.matches(password, userDetails.getPassword())) {
			throw new BadCredentialsException("invalid password");
		}
		return new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
	}

//    private void authentication(String email, String password) {
//
//        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, password);
//        try {
//            manager.authenticate(authentication);
//
//        } catch (BadCredentialsException e) {
//     System.out.println("invalid password");
//            throw new BadCredentialsException(" Invalid Password  !!");
//        }
//       
//        catch(Exception ex) {
//        	System.out.println("invalid email");
//        	 throw new BadCredentialsException("Invalid email ");
//        }

//    }

//    @ExceptionHandler(BadCredentialsException.class)
//    public String exceptionHandler() {
//    
//        return "Credentials Invalid!! username and password";
//    }


}
