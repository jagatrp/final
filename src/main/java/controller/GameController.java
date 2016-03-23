
package controller;

import ejb.GameEJB;
import entity.Game;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "gameController", eager = true)
@RequestScoped
public class GameController {

    @EJB
    private GameEJB gameEJB;

    private Game game = new Game();
    private List<Game> gameList = new ArrayList<>();

    public String doCreateGame() {
        game = gameEJB.addGame(game);
        return "gameList.xhtml";
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public List<Game> getGameList() {
        gameList = gameEJB.getAllGame();
        return gameList;
    }

    public void setGameList(List<Game> gameList) {
        this.gameList = gameList;
    }

    /**
     * Creates a new instance of GameController
     */
    public GameController() {
    }

}
