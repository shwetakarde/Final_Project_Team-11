package com.Sharecare.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Sharecare.model.Artistic;
import com.Sharecare.model.User;
import com.Sharecare.repository.RegistrationRepository;
import com.Sharecare.service.RegistrationService;
import org.springframework.mail.javamail.JavaMailSender;


@RestController
public class RegistrationController {

	@Autowired
	private RegistrationService regservice;
	@Autowired
	private RegistrationRepository regrepo;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@PostMapping("/registeruser")
	@CrossOrigin(origins = "http://localhost:4200")

	public User registerUser(@RequestBody User user) throws Exception {
	
		String tempEmailId=user.getEmail();
		
		if(tempEmailId != null && !"".equals(tempEmailId)) {
		
			User userObj=regservice.fetchUserByEmailId(tempEmailId);
			if(userObj!= null) {
				throw new Exception("User With" +tempEmailId+ "already exist");
			}
		}
		
		User userObj=null;
		userObj=regservice.saveuser(user);
		return userObj;
	}
	
	@PostMapping("/login")
	@CrossOrigin(origins = "http://localhost:4200")
	public User loginUser(@RequestBody User user) throws Exception {
		
		String tempEmail=user.getEmail();
		String tempPassword=user.getPassword();
		
		User userObj=null;
		User userAdminObj=null;
		
		if(tempEmail=="admin@gmail.com" && tempPassword=="admin") {
			return userAdminObj;
		}
		else if(tempEmail != null && tempPassword !=null) {
			userObj=regservice.fetchUserByEmailIdAndPassword(tempEmail, tempPassword);
		}
		
		if(userObj == null) {
			throw new Exception("Bad Credentials");
		}
		return userObj;
	}
	
	//show profile
	@GetMapping(value="/myprofile/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public User myprofile(@PathVariable int id) {
		User user=regservice.get(id);
		return user;
	}
	
	//update profile
//	@PutMapping(value = "/updateUser/{id}")
//	@CrossOrigin(origins = "http://localhost:4200")
//    public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody User user){
//	
//    }
	
	//forgot password
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/sendKeyByEmail")
	public User sendEmail(@RequestBody User apr) {
		SimpleMailMessage msg = new SimpleMailMessage();
			System.out.println("User object ======================================="+apr);
			User user=regrepo.findByemail(apr.getEmail());
			//System.out.println("After find"+user);
			String mail = user.getEmail();
			msg.setTo(mail);
			msg.setSubject("Sharecare Bookstore Varification  OTP For Approval");
			msg.setText("Hello, "+user.getEmail()+" Your Password for Registration Approval is "+user.getPassword()+"\n Your Regards - Sharecare Bookstore");
			javaMailSender.send(msg);
			return user;
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("getUserByEmail/{email}")
	public User getuserByEmail(@PathVariable String email) {
		User user=regrepo.findByemail(email);
		if(Objects.nonNull(user)) {
			return user;
		}
		else {
			System.out.println("user not found");
			return null;
		}
		
	}
	
	@PutMapping(value = "/updateUser/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody User user){
		
		User users=regrepo.findById(id);
		
		//System.out.println(users);

		users.setfirstName(user.getfirstName());
		users.setlastName(user.getlastName());
		users.setEmail(user.getEmail());
		users.setPhoneNo(user.getPhoneNo());
		
		User updatedUser=regrepo.save(users);
		//System.out.println(updatedUser);
		return ResponseEntity.ok(updatedUser);
		
    }
	
	
}
