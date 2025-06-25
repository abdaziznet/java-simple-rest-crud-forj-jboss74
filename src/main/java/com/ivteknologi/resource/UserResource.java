package com.ivteknologi.resource;

import com.ivteknologi.dao.UserDAO;
import com.ivteknologi.model.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {
    private UserDAO dao = new UserDAO();

    @GET
    public List<User> getUsers() {
        return dao.getAll();
    }

    @GET
    @Path("/{id}")
    public User getUser(@PathParam("id") int id) {
        return dao.get(id);
    }

    @POST
    public void createUser(User user) {
        dao.save(user);
    }

    @PUT
    @Path("/{id}")
    public void updateUser(@PathParam("id") int id, User user) {
        user.setId(id);
        dao.save(user);
    }

    @DELETE
    @Path("/{id}")
    public void deleteUser(@PathParam("id") int id) {
        dao.delete(id);
    }
}
