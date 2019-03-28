package mum;

import org.atmosphere.config.service.Get;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Stateless
@LocalBean
@Path("/admin")
@Produces("application/json")
@Consumes("application/json; charset=UTF-8")

public class AdminService {
    @Get
    @Path("/content")
    public Response getContent() {
        return Response.status(200).entity("hi").build();
    }
}
