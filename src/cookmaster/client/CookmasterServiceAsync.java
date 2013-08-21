package cookmaster.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

import cookmaster.client.TableWithCells.Recipe;

public interface CookmasterServiceAsync {
	void getContacts(AsyncCallback<Recipe[]> callback) throws IllegalArgumentException;
	void addContact(AsyncCallback<Boolean> callback);
}
