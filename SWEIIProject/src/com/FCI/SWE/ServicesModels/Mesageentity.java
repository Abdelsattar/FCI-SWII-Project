package com.FCI.SWE.ServicesModels;

import java.util.Vector;

import com.FCI.SWE.Models.Msg;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.sun.org.apache.xml.internal.serializer.utils.MsgKey;

//Receiver 


public class Mesageentity {
	
	
	
	
public String getMessage(long ID){
		
		//Vector<Msg> Messages=new Vector<Msg> ();
		//Msg m=new Msg ();
	String msg = "";	
	DatastoreService datastore = DatastoreServiceFactory.getDatastoreService(); 
	    Query gaeQuery = new Query("Messages");
		PreparedQuery pq = datastore.prepare(gaeQuery);
			for (Entity entity : pq.asIterable()) {
				if (entity.getProperty("recID").equals(ID))
				{   
					msg=entity.getProperty("recname").toString() + "send" +  entity.getProperty("message").toString();
					//Messages.add(m);
				}
			}
		
			return msg;
		}
		
		
		
		
		
	
}
