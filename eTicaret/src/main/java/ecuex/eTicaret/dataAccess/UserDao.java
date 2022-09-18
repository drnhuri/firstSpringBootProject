
package ecuex.eTicaret.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import ecuex.eTicaret.entities.User;

public interface UserDao extends JpaRepository<User, Integer>{

	boolean existsByEmail(String email);
	
	boolean existsByPassword(String password);

	boolean existsByPhoneNumber(String phone);
}


