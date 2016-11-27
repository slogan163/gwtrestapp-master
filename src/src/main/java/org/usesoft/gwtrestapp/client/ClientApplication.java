package org.usesoft.gwtrestapp.client;

import java.util.List;

import com.google.gwt.dom.client.Style;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.view.client.ListDataProvider;
import org.fusesource.restygwt.client.Defaults;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;
import org.usesoft.gwtrestapp.client.api.client.GroupClient;
import org.usesoft.gwtrestapp.client.api.client.StudentClient;
import org.usesoft.gwtrestapp.shared.domain.Group;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import org.usesoft.gwtrestapp.shared.domain.Student;

public class ClientApplication implements EntryPoint
{
    TabLayoutPanel tabPanel;
    GroupClient groupClient = GWT.create(GroupClient.class);
    StudentClient studentClient = GWT.create(StudentClient.class);
    final ListDataProvider<Group> groupDataProvider = new ListDataProvider<Group>();
    final ListDataProvider<Student> studentDataProvider = new ListDataProvider<Student>();

    public void onModuleLoad()
    {
        Defaults.setServiceRoot(GWT.getHostPageBaseURL());

        tabPanel = new TabLayoutPanel(2.5, Style.Unit.EM);
//        tabPanel.setAnimationDuration(1000);
        RootLayoutPanel.get().add(tabPanel);

        setGroupTab();
        setStudentTab();
    }

    private void setStudentTab()
    {
        VerticalPanel studentPanel = new VerticalPanel();
        CellTable<Student> studentTable = new CellTable<Student>();
        studentPanel.add(studentTable);
        tabPanel.add(studentPanel, "Students");
        setStudentColumns(studentTable);

        studentDataProvider.addDataDisplay(studentTable);
        loadStudents();
    }

    private void setGroupTab()
    {
        VerticalPanel groupPanel = new VerticalPanel();

        CellTable<Group> groupTable = new CellTable<Group>();
        groupPanel.add(new Label("Here will be groups..."));
        groupPanel.add(groupTable);
        tabPanel.add(groupPanel, "Groups");
        setGroupColumns(groupTable);

        // Connect the table to the data provider.
        groupDataProvider.addDataDisplay(groupTable);
        loadGroups();
    }

    private void setStudentColumns(CellTable<Student> studentColumns)
    {
        TextColumn<Student> idColumn = new TextColumn<Student>() {
            @Override
            public String getValue(Student student)
            {
                return String.valueOf(student.getId());
            }
        };

        TextColumn<Student> firstNameColumn = new TextColumn<Student>() {
            @Override
            public String getValue(Student student)
            {
                return student.getFirstName();
            }
        };

        TextColumn<Student> groupIdColumn = new TextColumn<Student>() {
            @Override
            public String getValue(Student student)
            {
                return String.valueOf(student.getGroupId());
            }
        };

        studentColumns.addColumn(idColumn, "ID");
        studentColumns.addColumn(firstNameColumn, "First Name");
        studentColumns.addColumn(groupIdColumn, "Group Id");
    }

    private void setGroupColumns(CellTable<Group> groupTable)
    {
        TextColumn<Group> idColumn = new TextColumn<Group>()
        {
            public String getValue(Group group)
            {
                return String.valueOf(group.getId());
            }
        };

        TextColumn<Group> nameColumn = new TextColumn<Group>()
        {
            public String getValue(Group group)
            {
                return group.getName();
            }
        };

        groupTable.addColumn(idColumn, "ID");
        groupTable.addColumn(nameColumn, "Group name");
    }

    private void loadGroups()
    {
        groupClient.getGroups(new MethodCallback<List<Group>>()
        {
            public void onFailure(Method method, Throwable throwable)
            {
                Window.alert("Error getGroups!!!");
            }

            public void onSuccess(Method method, List<Group> groups)
            {
                groupDataProvider.setList(groups);
            }
        });
    }

    private void loadStudents()
    {
        studentClient.getStudents(new MethodCallback<List<Student>>() {
            public void onFailure(Method method, Throwable throwable)
            {
                Window.alert("Error getStudents!!!");
            }

            public void onSuccess(Method method, List<Student> students)
            {
                studentDataProvider.setList(students);
            }
        });
    }
}
