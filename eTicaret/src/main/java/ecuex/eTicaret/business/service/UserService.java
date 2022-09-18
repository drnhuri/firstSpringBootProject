package ecuex.eTicaret.business.service;

import java.util.List;

import ecuex.eTicaret.business.dto.UserDto;
import ecuex.eTicaret.business.requests.user.CreateUserRequest;
import ecuex.eTicaret.business.requests.user.DeleteUserRequest;
import ecuex.eTicaret.business.requests.user.LoginRequest;
import ecuex.eTicaret.business.requests.user.UpdateUserRequest;
import ecuex.eTicaret.core.utilities.results.DataResult;


public interface UserService {
	DataResult<List<UserDto>> getAll();
	
	DataResult<UserDto> getByUserId(int ıd);
	
	DataResult<UserDto> login(LoginRequest loginRequest);
	
	DataResult<UserDto> add(CreateUserRequest createUserRequest);
	
	DataResult<UserDto> delete(DeleteUserRequest deleteUserRequest);
	
	DataResult<UserDto> update(UpdateUserRequest updateUserRequest);
	
}
