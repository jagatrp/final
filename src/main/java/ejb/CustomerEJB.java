
package ejb;

import entity.Customer;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class CustomerEJB {

    @PersistenceContext(unitName = "rimsPU")
    private EntityManager entityManager;

    //add customer details
    public Customer addCustomer(Customer customer) {
        entityManager.persist(customer);
        return customer;
    }

    //get customer details
    public List<Customer> getAllCustomer() {
        TypedQuery<Customer> query = entityManager.createNamedQuery("findAllCustomer", Customer.class);
        return query.getResultList();
    }
}
