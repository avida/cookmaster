package cookmaster.client;

import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter;
import com.google.gwt.user.client.ui.TextBox;


public class UsersForm {
	public static UsersForm CreatedUserForm()
	{
		return new UsersForm();
	}
	
		  
	private Panel m_userform;
	
	public UsersForm()
	{
		FlexTable layout = new FlexTable();
		FlexCellFormatter formatter = layout.getFlexCellFormatter();
		layout.setHTML(0, 0, "Title");
		layout.setHTML(1, 0, "Name");
		layout.setWidget(0, 1, new TextBox());
		layout.setWidget(1, 1, new TextBox());
		DecoratorPanel dc_panel = new DecoratorPanel();
		dc_panel.setWidget(layout);
		m_userform = dc_panel;
	}
	public Panel getForm() { return m_userform; }
}
