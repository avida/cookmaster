package cookmaster.client;

import java.io.Serializable;

import com.google.gwt.user.client.rpc.AsyncCallback;

import cookmaster.client.TableWithCells.Recipe;

public interface CookmasterServiceAsync {
	public class RecipeRResponceData implements Serializable{
		public RecipeRResponceData() {}
		public RecipeRResponceData( Recipe[] _recipes, String _cursor ){
			recipes = _recipes;
			nextCursor = _cursor;
		}
		Recipe[] recipes;
		String nextCursor;
	}
	void getContacts(String cursor, AsyncCallback<RecipeRResponceData> callback) throws IllegalArgumentException;
	void addContact(AsyncCallback<Boolean> callback);
}
