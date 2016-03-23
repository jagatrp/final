
package controller;

import ejb.CustomerEJB;
import entity.Customer;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
//creates managebean and access data from database eagerly
@ManagedBean(name = "customerController", eager = true)
@RequestScoped
public class CustomerController {

    @EJB
    private CustomerEJB customerEJB;

    private Customer customer = new Customer();
    private List<Customer> customerList = new ArrayList<>();

    /**
     * Creates a new instance of CustomerController
     */
    public CustomerController() {
    }

    public String doCreateCustomer() {
        customer = customerEJB.addCustomer(customer);
        return "index.xhtml";
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Customer> getCustomerList() {
        customerList = customerEJB.getAllCustomer();
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }
}
