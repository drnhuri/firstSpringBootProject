package ecuex.eTicaret.entities;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")

public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "productName")
	private String productName;
	
	@Column(name = "unitPrice")
	private double unitPrice;
	
	@Column(name = "unitsInStock")
	private short unitsInStock;

	@OneToMany(mappedBy = "product")
	private List<Sales> saless;
	
	@OneToMany(mappedBy = "product")
	private List<Basket> baskets;
}
