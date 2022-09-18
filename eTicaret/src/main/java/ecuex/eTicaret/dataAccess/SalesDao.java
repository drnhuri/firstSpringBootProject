package ecuex.eTicaret.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import ecuex.eTicaret.entities.Sales;

public interface SalesDao extends JpaRepository<Sales, Integer>{

}
