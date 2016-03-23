
package ejb;

import entity.Customer;
import entity.Game;
import entity.Movie;
import entity.Rent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class RentEJB {

    @PersistenceContext(unitName = "rimsPU")
    private EntityManager entityManager;

    private List<Movie> movieItems = new ArrayList<>();

    private List<Game> gameItems = new ArrayList<>();

    private Customer customer;

    public void setCustomer(Integer customerId) {
        customer = entityManager.find(Customer.class, customerId.longValue());
    }

    public void setMovieItems(List movieItemIds) {
        Iterator<String> movieIterator = movieItemIds.iterator();
        while (movieIterator.hasNext()) {
            movieItems.add(entityManager.find(Movie.class, Long.parseLong(movieIterator.next())));
        }

    }

    public void setGameItems(List gameItemIds) {
        Iterator<String> gameIterator = gameItemIds.iterator();
        while (gameIterator.hasNext()) {
            gameItems.add(entityManager.find(Game.class, Long.parseLong(gameIterator.next())));
        }

    }

   //add rent details
    public Rent addRent(Rent rent) {

        List<Rent> a = new ArrayList<>();
        a.add(rent);
        customer.setRent(a);

        rent.setGame(gameItems);
        rent.setMovie(movieItems);

        entityManager.persist(rent);

        return rent;
    }

    //get rent details
    public List<Rent> getAllRent() {
        TypedQuery<Rent> query = entityManager.createNamedQuery("findAllRent", Rent.class);
        return query.getResultList();
    }
}
