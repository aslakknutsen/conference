package com.prodyna.conference;

import javax.ejb.Local;
import javax.ws.rs.*;
import java.util.List;

@Local
@Path("/conferences")
@Consumes("application/json")
@Produces("application/json")
public interface ConferenceService {

    @POST
    public Conference create(Conference conf);

    @GET
    public List<Conference> readAll();

    @GET
    @Path("{id}")
    public Conference readById(@PathParam("id") String id);

    @GET
    @Path("name/{name}")
    public Conference readByName(@PathParam("name") String name);

    @PUT
    @Path("{id}")
    public void update(@PathParam("id") String id, Conference conf);

    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") String id);

}
