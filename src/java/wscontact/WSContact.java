package wscontact;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;


@Path("contact")
public class WSContact {

  @Context
  private UriInfo context;

  public WSContact() {
  }

  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String all() {
    return null;
  }
  
  @GET
  @Path("/{id}")
  @Produces(MediaType.TEXT_PLAIN)
  public String find(@PathParam("id") Integer id) {
    return null;
  }
  
  @POST
  @Path("/create")
  @Produces(MediaType.TEXT_PLAIN)
  public String create() {
    return null;
  }
  
  @PUT
  @Path("/update")
  @Produces(MediaType.TEXT_PLAIN)
  public String update() {
    return null;
  }

  @DELETE
  @Path("/{id}")
  @Produces(MediaType.TEXT_PLAIN)
  public String destroy() {
    return null;
  }
  
}