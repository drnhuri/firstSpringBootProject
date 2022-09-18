package ecuex.eTicaret.dataAccess;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import ecuex.eTicaret.entities.Product;

public interface ProductDao extends JpaRepository<Product, Integer>{

	Product getByProductName(String productName);
	
	//iceren urun ismini listeler
	List<Product> getByProductNameContains(String productName);
	
	//bu isime baslayan urunleri listeler
	List<Product> getByProductNameStartsWith(String productName);

	
//	@Query("From Product where productName=:productName and userId=:userId")
//	List<Product> getByNameAndUser(String productName, int userId);

	
	//Product getByProductNameAndCategoryId(String productName, int )

}
