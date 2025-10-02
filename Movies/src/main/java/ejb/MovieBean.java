/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package ejb;

import entity.Movie;
import entity.Theater;
import java.util.ArrayList;
import java.util.Collection;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 *
 * @author M.SHAKIL PATEL
 */
@Stateless
public class MovieBean implements MovieBeanLocal {

    @PersistenceContext(name = "movies_pu")
    private EntityManager em;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public Collection<Movie> getAllMovies() {
        Collection<Movie> movies = em.createQuery("select m from Movie m").getResultList();
        return movies;
    }

    @Override
    public Collection<Theater> getAllTheaters() {

        Collection<Theater> movies = em.createQuery("select m from Theater m").getResultList();
        return movies;
    }

    @Override
    public Movie getMovie(Long id) {
        Movie m = em.find(Movie.class, id.intValue());
        return m;
    }

    @Override
    public Theater getTheater(Long id) {
        Theater m = em.find(Theater.class, id.intValue());
        return m;
    }

    @Override
    public void addMovie(Movie m) {
        em.persist(m);
    }

    @Override
    public void addTheater(Theater t) {
        em.persist(t);
    }

    @Override
    public void deleteMovie(Long id) {
        Movie m = em.find(Movie.class,id.intValue());
        m.setTheaters(new ArrayList<>());
        em.merge(m);
        em.remove(m);

    }

    @Override
    public void deleteTheater(Long id) {
        Theater m = getTheater(id);
        m.setMovies(new ArrayList<>());
        em.merge(m);
        em.remove(m);
    }

    @Override
    public void addMovieToTheater(Long mId, Long tId) {
        Movie m = getMovie(mId);
        Theater t = getTheater(tId);
        if (!m.getTheaters().contains(t)) {
            m.getTheaters().add(t);
            Collection<Theater> theaters = m.getTheaters();
            theaters.add(t);
            m.setTheaters(theaters);
            em.merge(m);
        }
    }

    @Override
    public void removeMovieToTheater(Long mId, Long tId) {
        Movie m = getMovie(mId);
        Theater t = getTheater(tId);
        if (m.getTheaters().contains(t)) {
            m.getTheaters().remove(t);
            Collection<Theater> theaters = m.getTheaters();
            theaters.remove(t);
            m.setTheaters(theaters);
            em.merge(m);
        }
    }
}
