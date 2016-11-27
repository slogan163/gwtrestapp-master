package org.usesoft.gwtrestapp.client.api.client;

import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;
import org.usesoft.gwtrestapp.shared.domain.Student;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.List;

@Path("api/students")
public interface StudentClient extends RestService
{
    @GET
    public void getStudents(MethodCallback<List<Student>> callback);

    @GET
    @Path("/{id}")
    public void getStudent(@PathParam("id") int id, MethodCallback<Student> callback);
}
