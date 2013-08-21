package cookmaster.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.VerticalPanel;

import cookmaster.client.TableWithCells.Recipe;

public class CookReceipeForm {
	
	public static CookReceipeForm CreateCookReceipeForm(){
		return new CookReceipeForm();
	}
	
	private final CookmasterServiceAsync contactsService = GWT.create(CookmasterService.class);
	
	private Button refreshContactskButton = new Button("Refresh");
	private TableWithCells m_table = new TableWithCells();
	
	Panel m_receipeform = new VerticalPanel();
	
	public CookReceipeForm(){
		
	    refreshContactskButton.addClickHandler( new ClickHandler() {

	    	@Override
			public void onClick(ClickEvent event) {
				//addStock();
	    		refreshContactskButton.setText("Working...");
	    		refreshContactskButton.setEnabled(false);
	    		AsyncCallback<Recipe []> callback = new AsyncCallback<Recipe []>() {

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
					}

					@Override
					public void onSuccess(Recipe []result) {
						// TODO Auto-generated method stub
						m_table.clear();
						for (Recipe c: result)
						{
							m_table.addContact(c);
						}
						refreshContactskButton.setText("Refresh");
						refreshContactskButton.setEnabled(true);
					}
	    			
				};
				
				contactsService.getContacts(callback);
				}
		} );

		m_receipeform.add( m_table.getTable() );
		m_receipeform.add(refreshContactskButton);
		m_table.addContact(new Recipe("exa", "mple"));
	}
	
	Panel getForm() { return m_receipeform; }
	
	
}
