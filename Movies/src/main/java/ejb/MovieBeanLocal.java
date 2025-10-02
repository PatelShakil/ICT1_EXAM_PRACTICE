/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package ejb;

import entity.Movie;
import entity.Theater;
import java.util.Collection;
import jakarta.ejb.Local;

/**
 *
 * @author M.SHAKIL PATEL
 */
@Local
public interface MovieBeanLocal {
    
    public Collection<Movie> getAllMovies();
    public Collection<Theater> getAllTheaters();
    
    public Movie getMovie(Long id);
    public Theater getTheater(Long id);
    
    public void addMovie(Movie m);
    public void addTheater(Theater t);
    
    public void deleteMovie(Long id);
    public void deleteTheater(Long id);
    
    public void addMovieToTheater(Long mId,Long tId);
    public void removeMovieToTheater(Long mId,Long tId);
    
}
