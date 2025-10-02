/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package cdi;

import ejb.MovieBeanLocal;
import entity.Movie;
import entity.Theater;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Collection;
import jakarta.ejb.EJB;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;
import resources.MovieClient;

/**
 *
 * @author M.SHAKIL PATEL
 */
@Named(value = "home")
@SessionScoped
public class Home implements Serializable {
    
    
    @EJB
    private MovieBeanLocal mbl;
    
    MovieClient client;
    private Collection<Movie> movies;
    private Collection<Theater> theaters;
    
    private Collection<Movie> rptMovies;
    private Integer rptId;
    
    private Theater th;
    private String thname;
    private String city;
    private String state;
    private String location;
    
    private Movie mv;
    private String mvname;
    
    private Long thId;
    private Long mvId;
    
    
    

    /**
     * Creates a new instance of Home
     */
    public Home() {
        mv = new Movie();
        th = new Theater();
        client = new MovieClient();
    }
    
    public void fetchReport(){
        rptMovies = mbl.getTheater(rptId.longValue()).getMovies();
//        return "DisplayReport.jsf";
    }
    
    public String gotoReports(){
        rptMovies = new ArrayList<Movie>();
        return "Report.jsf";
    }

    public Collection<Movie> getRptMovies() {
        return rptMovies;
    }

    public void setRptMovies(Collection<Movie> rptMovies) {
        this.rptMovies = rptMovies;
    }

    public Integer getRptId() {
        return rptId;
    }

    public void setRptId(Integer rptId) {
        this.rptId = rptId;
    }
    
    
    public String addMovie(){
        Movie m = new Movie();
        mv.setName(mvname);
        mbl.addMovie(mv);
        mv = new Movie();
        return "Movies.jsf";
    }
    
    public String addTheater(){
        Theater th = new Theater();
        th.setName(thname);
        th.setCity(city);
        th.setLocation(location);
        th.setState(state);
        mbl.addTheater(th);
        th = new Theater();
        return "Theaters.jsf";
    }
    
    public String deleteMovie(Long id){
        mbl.deleteMovie(id);
        return "Movies.jsf";
    }
    
    public String deleteTheater(Long id){
        mbl.deleteTheater(id);
        return "Theaters.jsf";
    }
    
    public String addMovieTheater(Long mId,Long tId){
        mbl.addMovieToTheater(mId, tId);
        return "index.jsf";
    }
    
    public String addTToM(Long mId,Long tId){
        mbl.removeMovieToTheater(mId, tId);
        return "index.jsf";
    }

    public Collection<Movie> getMovies() {
        movies = client.getMovies(Response.class).readEntity(new GenericType<Collection<Movie>>() {});
        return movies;
    }

    public void setMovies(Collection<Movie> movies) {
        this.movies = movies;
    }

    public Collection<Theater> getTheaters() {
        theaters = mbl.getAllTheaters();
        return theaters;
    }

    public void setTheaters(Collection<Theater> theaters) {
        this.theaters = theaters;
    }

    public Theater getTh() {
        return th;
    }

    public void setTh(Theater th) {
        this.th = th;
    }

    public String getThname() {
        return thname;
    }

    public void setThname(String thname) {
        this.thname = thname;
    }

    public Movie getMv() {
        return mv;
    }

    public void setMv(Movie mv) {
        this.mv = mv;
    }

    public String getMvname() {
        return mvname;
    }

    public void setMvname(String mvname) {
        this.mvname = mvname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Long getThId() {
        return thId;
    }

    public void setThId(Long thId) {
        this.thId = thId;
    }

    public Long getMvId() {
        return mvId;
    }

    public void setMvId(Long mvId) {
        this.mvId = mvId;
    }
    
    
    
    
}
