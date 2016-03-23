
package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

//defines rent as an entity
@Entity
@NamedQuery(name = "findAllRent", query = "SELECT r FROM Rent r")
public class Rent implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer numberOfDaysHired;
    private String dueDate;

    
    @OneToMany
    @JoinTable(
            name = "rent_items_game",
            joinColumns = @JoinColumn(name = "rent_id")
    )
    private List<Game> game;

    @OneToMany
    @JoinTable(
            name = "rent_items_movie",
            joinColumns = @JoinColumn(name = "rent_id")
    )
    private List<Movie> movie;

    public Integer getNumberOfDaysHired() {
        return numberOfDaysHired;
    }

    public void setNumberOfDaysHired(Integer numberOfDaysHired) {
        this.numberOfDaysHired = numberOfDaysHired;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public List<Movie> getMovie() {
        return movie;
    }

    public void setMovie(List<Movie> movie) {
        this.movie = movie;
    }

    public List<Game> getGame() {
        return game;
    }

    public void setGame(List<Game> game) {
        this.game = game;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rent)) {
            return false;
        }
        Rent other = (Rent) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.rental.Rent[ id=" + id + " ]";
    }

}
