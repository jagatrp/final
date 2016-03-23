/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Game;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


@Stateless
public class GameEJB {

    @PersistenceContext(unitName = "rimsPU")
    private EntityManager entityManager;

 
    public Game addGame(Game game) {
        entityManager.persist(game);
        return game;
    }

   
    public List<Game> getAllGame() {
        TypedQuery<Game> query = entityManager.createNamedQuery("findAllGame", Game.class);
        return query.getResultList();
    }
}
