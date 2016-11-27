package org.usesoft.gwtrestapp.shared.domain;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

public class Student
{
    private Long id;
    private String firstName;
    private Long groupId;

    @JsonCreator
    public Student(@JsonProperty("id") Long id, @JsonProperty("firstName") String firstName, @JsonProperty("groupId") Long groupId)
    {
        this.id = id;
        this.firstName = firstName;
        this.groupId = groupId;
    }

    public Long getId()
    {
        return id;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public Long getGroupId()
    {
        return groupId;
    }
}
