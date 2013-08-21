package cookmaster.client;

import java.io.Serializable;
import java.util.*;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.view.client.CellPreviewEvent;
import com.google.gwt.view.client.DefaultSelectionEventManager;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.NoSelectionModel;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SelectionModel;
import com.google.gwt.view.client.SingleSelectionModel;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.PopupPanel;

public class TableWithCells  {
	
	public static class Recipe implements Serializable {
		private String caption;
		private String manual;
		public Recipe(){
			this("default", "default");
		}
		public Recipe (String caption, String manual)
		{
			this.caption = caption;
			this.manual = manual;
		}
	}
	
	private CellTable<Recipe> m_table = null;
	ListDataProvider<Recipe> dataProvider;
	
	public CellTable<Recipe> getTable(){ 
		if (  m_table == null ){
			m_table = new CellTable<Recipe>();
			initTable();
		}
		return m_table;
	}
	
	public void addContact(Recipe contact){
		dataProvider.getList().add(contact);
	}
	
	public void clear(){
		dataProvider.getList().clear();
	}
	
	private void initTable(){
		CellTable<Recipe> table = this.m_table;
		TextColumn<Recipe> newColumn = new TextColumn<Recipe> (){
			@Override
			public  String getValue(Recipe recipe){
				return recipe.caption;
			}
		};
		
		table.addColumn(newColumn, "Dish");
		
		dataProvider = new ListDataProvider<Recipe>();
		
		dataProvider.addDataDisplay(table);

		table.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.DISABLED);
		
		table.addCellPreviewHandler(new CellPreviewEvent.Handler<TableWithCells.Recipe>() {
			public void onCellPreview(final CellPreviewEvent<TableWithCells.Recipe> event) {
					if (Event.getTypeInt( event.getNativeEvent().getType() ) == Event.ONCLICK){
						Recipe val = event.getValue();
						final PopupPanel pop = new PopupPanel(true);
						pop.setAnimationEnabled(true);
						HTML content = new HTML(val.manual);
						pop.add(content);
						content.addClickHandler(new ClickHandler() {
							@Override
							public void onClick(ClickEvent event) {
								pop.hide();
							}
						});
						pop.center();
					}
			}
		} );		
		
	}
	
}
