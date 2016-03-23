
package controller;

import ejb.MovieEJB;
import entity.Movie;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "movieController", eager = true)
@RequestScoped
public class MovieController {

    @EJB
    private MovieEJB movieEJB;

    private Movie movie = new Movie();
    private List<Movie> movieList = new ArrayList<>();

    public String doCreateMovie() {
        movie = movieEJB.addMovie(movie);
        return "movieList.xhtml";
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public List<Movie> getMovieList() {
        movieList = movieEJB.getAllMovie();
        return movieList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }

    /**
     * Creates a new instance of MovieController
     */
    public MovieController() {
    }

}
