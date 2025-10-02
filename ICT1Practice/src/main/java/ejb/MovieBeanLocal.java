/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/SessionLocal.java to edit this template
 */
package ejb;

import entity.Movie;
import entity.Theater;
import jakarta.ejb.Local;
import java.util.Collection;

/**
 *
 * @author Acer
 */
@Local
public interface MovieBeanLocal {
    
    void addMovie(Movie movie);
//    void addTheater(Theater theater);
    
    void deleteMovie(int id);
    void deleteTheater(int id);
    
    Collection<Movie> getAllMovies();
    Collection<Theater> getAllTheaters();
    
    void assignMovieToTheater(int mId,int tId);
    void deleteMovieFromTheater(int mId,int tId);
    
    
}
