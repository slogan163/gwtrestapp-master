package org.usesoft.gwtrestapp.server.interfaces.api;

import org.usesoft.gwtrestapp.shared.domain.Group;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.List;

@Path("groups")
public class GroupResource
{
    DataBase db;

    public GroupResource()
    {
        db = DataBase.getInstance();
    }

    @GET
    @Produces("application/json")
    public List<Group> getGroups()
    {
        return db.getGroups();
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Group getGroup(@PathParam("id") int id)
    {
        return db.getGroup(id);
    }
}
