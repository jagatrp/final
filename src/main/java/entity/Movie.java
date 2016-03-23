
package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
//defines movie as an entity
@Entity
@NamedQuery(name = "findAllMovie", query = "SELECT m FROM Movie m")
public class Movie extends Product implements Serializable {// inherits attributes from product

    private static final long serialVersionUID = 1L;
    private String directorName;
    private Integer runningLength;
    private String movieLanguage;

    public String getMovieLanguage() {
        return movieLanguage;
    }

    public void setMovieLanguage(String movieLanguage) {
        this.movieLanguage = movieLanguage;
    }

    public Integer getRunningLength() {
        return runningLength;
    }

    public void setRunningLength(Integer runningLength) {
        this.runningLength = runningLength;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getDirectorName() {
        return directorName;
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
        if (!(object instanceof Movie)) {
            return false;
        }
        Movie other = (Movie) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.rental.Movie[ id=" + id + " ]";
    }

}
