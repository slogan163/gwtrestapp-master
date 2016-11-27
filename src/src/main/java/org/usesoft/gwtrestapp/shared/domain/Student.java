package org.usesoft.gwtrestapp.shared.domain;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

public class Student
{
    private int id;
    private String firstName;
    private int groupId;

    @JsonCreator
    public Student(@JsonProperty("id") int id, @JsonProperty("firstName") String firstName, @JsonProperty("groupId") int groupId)
    {
        this.id = id;
        this.firstName = firstName;
        this.groupId = groupId;
    }

    public int getId()
    {
        return id;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public int getGroupId()
    {
        return groupId;
    }
}
