package ecuex.eTicaret.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "basket")

public class Basket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
//	@Column(name = "userId")
//	private int userId;
	
//	@Column(name = "productId")
//	private int productId;
	
	@Column(name = "quantity")
	private int quantity;

	@Column(name = "unitPrice")
	private double unitPrice;
	
	@Column(name = "status")
	private int status;
	
	@ManyToOne()
	@JoinColumn(name = "userId")
	private User user;

	@ManyToOne()
	@JoinColumn(name = "productId")
	private Product product;
}
