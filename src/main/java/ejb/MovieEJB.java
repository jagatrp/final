/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Movie;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


@Stateless
public class MovieEJB {

    @PersistenceContext(unitName = "rimsPU")
    private EntityManager entityManager;

  
    public Movie addMovie(Movie movie) {
        entityManager.persist(movie);
        return movie;
    }

    
    public List<Movie> getAllMovie() {
        TypedQuery<Movie> query = entityManager.createNamedQuery("findAllMovie", Movie.class);
        return query.getResultList();
    }
}
