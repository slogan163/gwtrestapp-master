package org.usesoft.gwtrestapp.client.api.client;

import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;
import org.usesoft.gwtrestapp.shared.domain.Group;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.List;

@Path("api/groups")
public interface GroupClient extends RestService
{
    @GET
    public void getGroups(MethodCallback<List<Group>> callback);

    @GET
    @Path("/{id}")
    public void getGroup(@PathParam("id") Long id, MethodCallback<Group> callback);
}
