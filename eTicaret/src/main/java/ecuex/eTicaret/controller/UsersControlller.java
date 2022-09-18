package ecuex.eTicaret.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ecuex.eTicaret.business.dto.UserDto;
import ecuex.eTicaret.business.requests.user.CreateUserRequest;
import ecuex.eTicaret.business.requests.user.DeleteUserRequest;
import ecuex.eTicaret.business.requests.user.LoginRequest;
import ecuex.eTicaret.business.requests.user.UpdateUserRequest;
import ecuex.eTicaret.business.service.UserService;
import ecuex.eTicaret.core.utilities.results.DataResult;
 
@RestController
@RequestMapping("/api/users")

public class UsersControlller {

	private UserService userService;

	@Autowired
	public UsersControlller(UserService userService) {
		super();
		this.userService = userService;
	}
	@GetMapping("/getall")
	public DataResult<List<UserDto>> getAll(){
		return this.userService.getAll();
	}
	
	@GetMapping("/getByUserId")
	public DataResult<UserDto> getByUserId(@RequestParam int id){
		return this.userService.getByUserId(id);	
	}
	
	@PostMapping("/add")
	public DataResult<UserDto> add(@RequestBody @Validated CreateUserRequest createUserRequest) {
		return this.userService.add(createUserRequest);
	}
	@PutMapping("/update")
	public DataResult<UserDto> update(@RequestBody @Validated UpdateUserRequest updateUserRequest) {
		return this.userService.update(updateUserRequest);
	}
    @DeleteMapping("/delete")
	public DataResult<UserDto> delete(@RequestBody @Validated DeleteUserRequest deleteUserRequest) {
		return this.userService.delete(deleteUserRequest);
	}
    
    @PostMapping("/login")
    public DataResult<UserDto> login(LoginRequest loginRequest){
    	    	
    	return this.userService.login(loginRequest);
    }
    
    
}
