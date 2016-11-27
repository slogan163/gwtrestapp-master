package org.usesoft.gwtrestapp.server.interfaces.api;

import org.usesoft.gwtrestapp.shared.domain.Student;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.List;

@Path("students")
public class StudentResource
{
    DataBase db;

    public StudentResource()
    {
        db = DataBase.getInstance();
    }

    @GET
    @Produces("application/json")
    public List<Student> getStudents()
    {
        return db.getStudents();
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Student getStudent(@PathParam("id") int id)
    {
        return db.getStudent(id);
    }
}
