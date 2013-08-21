package cookmaster.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import cookmaster.client.TableWithCells.Recipe;;

@RemoteServiceRelativePath("contacts")
public interface CookmasterService extends RemoteService{
	Recipe[] getContacts() throws IllegalArgumentException;
	Boolean addContact();
}
