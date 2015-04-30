package com.FCI.SWE.Services;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Vector;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.FCI.SWE.Controller.Command;
import com.FCI.SWE.Controller.GetMessageCommand;
import com.FCI.SWE.Controller.GetRequestCommand;
import com.FCI.SWE.Models.Msg;
import com.FCI.SWE.Models.Notify;
import com.FCI.SWE.Models.User;
import com.FCI.SWE.ServicesModels.NotificationEntity;
import com.FCI.SWE.ServicesModels.RequestEntity;
import com.FCI.SWE.ServicesModels.UserEntity;

import java.util.Vector;

import com.FCI.SWE.Models.Msg;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.sun.org.apache.xml.internal.serializer.utils.MsgKey;

import java.util.Vector;

import com.FCI.SWE.Models.Msg;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.sun.org.apache.xml.internal.serializer.utils.MsgKey;

/**
 * @description ViewNotification
 * @param rec_ID
 * @return json.toString()
 */

@Path("/")
@Produces(MediaType.TEXT_PLAIN)
public class NotificationsServices {

	@POST
	@Path("/ViewNotificationService")
	public String ViewNotifications (@FormParam("recID") long rec_ID) {
		Command Msgcommand=new GetMessageCommand ();
		Command Reqcommand=new GetRequestCommand ();
		Vector<Notify> results=new Vector<Notify> ();
		String Messages ="";
		String Requests ="";
        Timestamp time;
		long ID;
		
        JSONArray views=new JSONArray();
        JSONObject json = new JSONObject();
        NotificationEntity notification = null;
        results =notification.getnotification(rec_ID);
        for(int i=0; i<results.size(); i++){
        	
        	if(results.get(i).getType()=="Msg"){
        	   ID=results.get(i).getnotifyID();
        		Messages = Msgcommand.execute(ID);
        		json.put("notification"+i,Messages);
        		views.add(json);
        	}
        	else if (results.get(i).getType()=="Request"){
        		 ID=results.get(i).getnotifyID();
        		Requests = Reqcommand.execute(ID);
        		json.put("notification"+i,Requests);
        		views.add(json);
        	}
        	
        }
        
        
        
        
        
			return views.toString();
	
	
	}
		
	

}