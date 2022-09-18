package ecuex.eTicaret.business.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ecuex.eTicaret.business.dto.UserDto;
import ecuex.eTicaret.business.requests.user.CreateUserRequest;
import ecuex.eTicaret.business.requests.user.DeleteUserRequest;
import ecuex.eTicaret.business.requests.user.LoginRequest;
import ecuex.eTicaret.business.requests.user.UpdateUserRequest;
import ecuex.eTicaret.business.service.UserService;
import ecuex.eTicaret.core.utilities.results.DataResult;
import ecuex.eTicaret.core.utilities.results.ErrorDataResult;
import ecuex.eTicaret.core.utilities.results.SuccessDataResult;
import ecuex.eTicaret.dataAccess.UserDao;
import ecuex.eTicaret.entities.User;

@Service
public class UserServiceImpl implements UserService {

	
	ModelMapper modelMapper;

	UserDao userDao;

	@Autowired
	public UserServiceImpl(UserDao userDao,ModelMapper modelMapper) {
		super();
		this.userDao = userDao;
		this.modelMapper = modelMapper;
	}

	
	
	@Override
	public DataResult<List<UserDto>> getAll() {
		
		List<User> users = this.userDao.findAll();
		List<UserDto> usersDto = users.stream().map(user -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
			
		return new SuccessDataResult<List<UserDto>>(usersDto, "Listelendi");
	}

	@Override
	public DataResult<UserDto> add(CreateUserRequest createUserRequest) {
	
		if (this.userDao.existsByEmail(createUserRequest.getEmail())) {
			return new ErrorDataResult<UserDto>("Email sistemde kayıtlı");
		}
		
		if (this.userDao.existsByPhoneNumber(createUserRequest.getPhoneNumber())) {
			
			return new ErrorDataResult<UserDto>("Telefon numarası sistemde kayıtlı");
		}
		
		/* butun kontroller hallolursa request icerisine gerekli şartları yazariz*/		
		
		User user = this.modelMapper.map(createUserRequest, User.class);
		user = userDao.save(user);
		UserDto userDto = this.modelMapper.map(user, UserDto.class);
		
		return new SuccessDataResult<UserDto>(userDto);
	}

	@Override
	public DataResult<UserDto> delete(DeleteUserRequest deleteUserRequest) {
		
		if (!this.userDao.existsById(deleteUserRequest.getId())) {
			return new 	ErrorDataResult<UserDto>("id bulunmamaktadır");
		}
		
		
		this.userDao.deleteById(deleteUserRequest.getId());
		
		return new SuccessDataResult<UserDto>("Kullanıcı silindi");
	}

	@Override
	public DataResult<UserDto> update(UpdateUserRequest updateUserRequest) {

		if (!this.userDao.existsById(updateUserRequest.getId())) {
			return new 	ErrorDataResult<UserDto>("id bulunmamaktadır");
		}
		
		
		User user = this.modelMapper.map(updateUserRequest, User.class);
		user = this.userDao.save(user);
		UserDto userDto = this.modelMapper.map(user, UserDto.class);
		
		return new SuccessDataResult<UserDto>(userDto,"Kullanıcı güncellendi");
	}

	@Override
	public DataResult<UserDto> getByUserId(int id) {
		
		if (!this.userDao.existsById(id)) {
			return new 	ErrorDataResult<UserDto>("id yoktur");
		}
		
		User user = this.userDao.getById(id);
		UserDto userDto = this.modelMapper.map(user, UserDto.class);
		
		return new SuccessDataResult<UserDto>(userDto);
	}


	@Override
	public DataResult<UserDto> login(LoginRequest loginRequest) {
		/*  kod yapisi eksik  */
				
		User user = this.modelMapper.map(loginRequest, User.class);
		user = userDao.save(user);
		UserDto userDto = this.modelMapper.map(user, UserDto.class);
				
		return new SuccessDataResult<UserDto>(userDto, "Giriş yapıldı");
	}



	
}
