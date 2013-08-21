package cookmaster.server;

import java.util.ArrayList;
import java.util.List;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.QueryResultList;
import com.google.appengine.api.datastore.Text;
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.api.datastore.Query.FilterPredicate;
import com.google.apphosting.api.DatastorePb.QueryResult;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import java.util.logging.Logger;


import cookmaster.client.CookmasterService;
import cookmaster.client.TableWithCells.Recipe;

import cookmaster.server.DBInterface;

public class CookmasterServiceImpl extends RemoteServiceServlet implements CookmasterService{
	private int count = 0;
	private DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
	
	public Recipe[] getContacts()
	{
		FetchOptions fo = FetchOptions.Builder.withLimit(10);
		Query query = new Query(DBInterface.RecipeKey);
		PreparedQuery pq = datastore.prepare(query);
		List<Recipe> recipes = new ArrayList<Recipe>();
		QueryResultList<Entity> results  = pq.asQueryResultList(fo);
		
		for (Entity result: pq.asList(fo))
		{
			String name = (String) result.getProperty(DBInterface.captionProp);
			String manual = ((Text) result.getProperty(DBInterface.manualProp)).getValue();
			recipes.add( new Recipe(name, manual) );		
		};
		Recipe []array = new Recipe[ recipes.size()];
		array = recipes.toArray(array);
		Logger.getLogger(this.getClass().getName()).info("Array len is " +  array.length );
		return array;
	}
	public Boolean addContact()
	{
		return true;
	}
}
