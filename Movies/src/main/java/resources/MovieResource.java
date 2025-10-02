/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package resources;

import ejb.MovieBeanLocal;
import jakarta.ejb.EJB;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Acer
 */
@Path("movie")
public class MovieResource {

    @EJB
    private MovieBeanLocal mbl;
    /**
     * Retrieves representation of an instance of resources.MovieResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("get-all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMovies() {
        return Response.ok(mbl.getAllMovies()).build();
    }

}
