package org.usesoft.gwtrestapp.client;

import java.util.List;

import org.fusesource.restygwt.client.Defaults;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;
import org.usesoft.gwtrestapp.client.api.client.GroupClient;
import org.usesoft.gwtrestapp.shared.domain.Group;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ClientApplication implements EntryPoint
{

    public void onModuleLoad()
    {
        Defaults.setServiceRoot(GWT.getHostPageBaseURL());

        final VerticalPanel panel = new VerticalPanel();
        RootLayoutPanel.get().add(panel);

        GroupClient groupClient = GWT.create(GroupClient.class);

        groupClient.getGroups(new MethodCallback<List<Group>>()
        {
            public void onFailure(Method method, Throwable throwable)
            {
                Label label = new Label("Error");
                RootLayoutPanel.get().add(label);
            }

            public void onSuccess(Method method, List<Group> groups)
            {
                for(Group group : groups)
                {
                    Label label = new Label(group.getName());
                    panel.add(label);
                }
            }
        });
    }
}
