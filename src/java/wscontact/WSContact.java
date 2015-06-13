package wscontact;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;


@Path("contact")
public class WSContact {

  @Context
  private UriInfo context;

  public WSContact() {
  }

  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String getXml() {
    return "Dyan";
  }

  @PUT
  @Consumes("application/xml")
  public void putXml(String content) {
  }
  
}