package org.usesoft.gwtrestapp.server.interfaces.api;

import org.usesoft.gwtrestapp.shared.domain.Group;
import org.usesoft.gwtrestapp.shared.domain.Student;

import java.util.ArrayList;
import java.util.List;

public class DataBase
{
    private List<Group> groups = new ArrayList<Group>();
    private List<Student> students = new ArrayList<Student>();

    private DataBase()
    {
        List<Student> g1 = new ArrayList<Student>();
        List<Student> g2 = new ArrayList<Student>();
        g1.add(new Student(1, "John", 1));
        g1.add(new Student(2, "John", 1));
        g2.add(new Student(3, "John", 2));
        g2.add(new Student(4, "John", 2));

        groups.add(new Group(1, "G1", g1));
        groups.add(new Group(2, "G2", g2));

        students.addAll(g1);
        students.addAll(g2);
    }

    private static class DataBaseHolder
    {
        public static final DataBase INSTANCE = new DataBase();
    }

    public static DataBase getInstance()
    {
        return DataBaseHolder.INSTANCE;
    }

    public List<Group> getGroups()
    {
        return groups;
    }

    public Group getGroup(int id)
    {
        for(Group group : groups)
        {
            if(group.getId() == id)
                return  group;
        }

        return null;
    }

    public List<Student> getStudents()
    {
        return students;
    }

    public Student getStudent(int id)
    {
        for(Student student : students)
        {
            if(student.getId() == id)
                return  student;
        }

        return null;
    }
}
