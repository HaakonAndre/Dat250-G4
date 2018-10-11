package ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Product;

@Stateless
public class AuctionDAO {
	
	@PersistenceContext(unitName="AuctionApp")
    private EntityManager em;
	
	public Product findProduct(int id) {
		return em.find(Product.class, id);
	}
	
	public List<Product> findProducts(){
		Query q = em.createNativeQuery("SELECT p FROM Product p WHERE p.sold = FALSE AND p.published = TRUE");
		List<Product> products = q.getResultList();
		return products;
	}
	public String addBid(String email, int bid, int productid) {
		return "hallo";
	}

}
