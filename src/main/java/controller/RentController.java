
package controller;

import ejb.RentEJB;
import entity.Rent;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@ManagedBean(name = "rentController", eager = true)
@RequestScoped
public class RentController {

    @EJB
    private RentEJB rentEJB;

    private Integer customerId;
    private List movieItemIds = new ArrayList<>();
    private List gameItemIds = new ArrayList<>();

    private Rent rent = new Rent();
    private List<Rent> rentList = new ArrayList<>();

    /**
     * do create rent
     *
     * @return
     */
    public String doCreateRent() {

        rentEJB.setCustomer(customerId);
        rentEJB.setGameItems(gameItemIds);
        rentEJB.setMovieItems(movieItemIds);

        rent = rentEJB.addRent(rent);

        return "rentList.xhtml";
    }

    public Rent getRent() {
        return rent;
    }

    public void setRent(Rent rent) {
        this.rent = rent;
    }

    public List<Rent> getRentList() {
        rentList = rentEJB.getAllRent();
        return rentList;
    }

    public void setRentList(List<Rent> rentList) {
        this.rentList = rentList;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public List getMovieItemIds() {
        return movieItemIds;
    }

    public void setMovieItemIds(List movieItemIds) {
        this.movieItemIds = movieItemIds;
    }

    public List getGameItemIds() {
        return gameItemIds;
    }

    public void setGameItemIds(List gameItemIds) {
        this.gameItemIds = gameItemIds;
    }

    /**
     * Creates a new instance of RentController
     */
    public RentController() {
    }

}
