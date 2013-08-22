package cookmaster.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;


@RemoteServiceRelativePath("contacts")
public interface CookmasterService extends RemoteService{
	CookmasterServiceAsync.RecipeRResponceData getContacts(String cursor) throws IllegalArgumentException;
	Boolean addContact();
}
