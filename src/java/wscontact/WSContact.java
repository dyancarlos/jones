package wscontact;

import core.Contact;
import core.ContactList;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


@Path("contact")
public class WSContact {

  @Context
  private UriInfo context;

  public WSContact() {
  }

  @GET
  @Produces(MediaType.APPLICATION_XML)
  public ArrayList<Contact> all() {
    return ContactList.contactList;
  }
  
  @GET
  @Path("/allJson")
  @Produces(MediaType.APPLICATION_JSON)
  public ArrayList<Contact> allJSON() {
    return ContactList.contactList;
  }
  
  @GET
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_XML)
  public Contact find(@PathParam("id") Integer id) {
    for (Contact contactList : ContactList.contactList) {
      if (contactList.getId().equals(id)) {
        return contactList;
      }
    }
    return null;
  }
  
  @POST
  @Produces(MediaType.TEXT_PLAIN)
  public boolean create(@QueryParam("id") Integer id,
                        @QueryParam("name") String name,
                        @QueryParam("email") String email,
                        @QueryParam("phone") String phone) {
    
    Contact c = new Contact(id, name, email, phone);
    return ContactList.contactList.add(c);
  }
  
  @PUT
  @Produces(MediaType.TEXT_PLAIN)
  public boolean update(@QueryParam("id") Integer id,
                       @QueryParam("name") String name,
                       @QueryParam("email") String email,
                       @QueryParam("phone") String phone) {
    
    for (Contact contactList : ContactList.contactList) {
      if (contactList.getId().equals(id)) {
        contactList.setName(name);
        contactList.setEmail(email);
        contactList.setPhone(phone);
        return true;
      }
    }
    return false;
  }

  @DELETE
  @Path("/{id}")
  @Produces(MediaType.TEXT_PLAIN)
  @Consumes(MediaType.TEXT_PLAIN)
  public boolean destroy(@PathParam("id") Integer id) {
    for (Contact contactList : ContactList.contactList) {
      if (contactList.getId().equals(id)) {
        return ContactList.contactList.remove(contactList);
      }
    }
    return false;
  }
  
}