package Resource;

import model.Address;
import org.jboss.resteasy.plugins.guice.RequestScoped;
import sessionFacadeBean.BaseService;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/address")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
@RequestScoped
public class AddressResource {
    @EJB
    private BaseService<Address> addressService;

    @GET
    public Address getAddress() {
        return addressService.findAllOrderById(Address.class, true).get(0);
    }

}
