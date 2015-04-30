package com.FCI.SWE.ServicesModels;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.FCI.SWE.Models.Notify;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;

/**
 * <h1>User Entity class</h1>
 * <p>
 * This class will act as a model for user, it will holds user data
 * </p>
 *
 * @author Mohamed Samir
 * @version 1.0
 * @since 2014-02-12
 */
public class NotificationEntity {
	

    private String recName;
	private long recID;
	private String type;
	private long notifyID;
	private String status;
    private Timestamp time; 


	/**
	 * Constructor accepts user data
	 * 
	 * @param sendName
	 *            user sendName
	 * @param email
	 *            user email
	 * @param password
	 *            user provided password
	 */
	public NotificationEntity( String recName, long recID,String type,String status,Timestamp time, long notifyID ) {
		this.recID = recID;
		this.status=status;
		this.recName=recName;
		this.time=time;
		this.type=type;
		this.notifyID=notifyID;
	}
 
	public NotificationEntity(String string) {
	// TODO Auto-generated constructor stub
}
	public NotificationEntity(String send_name, String rec_name) {
		// TODO Auto-generated constructor stub
		this.recName=rec_name;
		//this.sendName=send_name;
	}

	public void setrecName(String recName)
	{
		this.recName=recName;
	}
	public String getrecName()
	{
		return recName;
	}
	
	
	
		private void setrecId(long recID){
		this.recID = recID;
	}
	
	public long getRecID(){
		return recID;
	}
	public void setStatus(String Status){
	this.status=Status;
		
	}
	public String getStatus()
	{
		return status;
	}
	
	public void setType(String type){
		this.type=type;
	}
	public String getType(){
		return type;
	}
	public void setTime(Timestamp time){
		this.time=time;
	}
	public Timestamp getTime(){
		return time;
	}
	
	public void setNotifyID(long notifyID){
		this.notifyID=notifyID;
	}
	public long getNotifyID(){
		return notifyID;
	}
	public Boolean savenotification() {
		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();
		Query gaeQuery = new Query("Notifications");
		PreparedQuery pq = datastore.prepare(gaeQuery);
		List<Entity> list = pq.asList(FetchOptions.Builder.withDefaults());

		Entity employee = new Entity("Notifications", list.size() + 1);

		
		employee.setProperty("recname", this.recName);
		employee.setProperty("recID", this.recID);
		employee.setProperty("type", this.type);
		employee.setProperty("status", this.status);
		employee.setProperty("time", this.time);
		employee.setProperty("notifyID", this.notifyID);
		datastore.put(employee);

		return true;

	}
	
	//return vector of notifications

	public Vector<Notify> getnotification(long recID){
		
		Vector<Notify> result=new Vector<Notify> (); 
		
		Notify output=new Notify ();
		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService(); 
		Query gaeQuery = new Query("Notifications");
		PreparedQuery pq = datastore.prepare(gaeQuery);
		for (Entity entity : pq.asIterable()) {
			if (entity.getProperty("recID").equals(recID))
			{   
				output.recName=entity.getProperty("recname").toString();
				output.recID=(long) entity.getProperty("recID");
				output.type=entity.getProperty("type").toString();
				output.status=entity.getProperty("status").toString();
				output.time=(Timestamp) entity.getProperty("time");
				output.notifyID=(long) entity.getProperty("notifyID");
				
				result.add(output);
			}
		}
	
		return result;
	}
	
	}