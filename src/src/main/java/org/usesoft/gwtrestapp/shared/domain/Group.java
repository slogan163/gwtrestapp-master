package org.usesoft.gwtrestapp.shared.domain;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

public class Group
{
    private Long id;
    private String name;
    private List<Student> students;

    @JsonCreator
    public Group(@JsonProperty("id") Long id, @JsonProperty("name") String name, @JsonProperty("students") List<Student> students)
    {
        this.id = id;
        this.name = name;
        this.students = students;
    }

    public Long getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public List<Student> getStudents()
    {
        return students;
    }

}
