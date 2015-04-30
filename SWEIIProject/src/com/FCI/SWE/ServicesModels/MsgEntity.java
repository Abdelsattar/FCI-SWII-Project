package com.FCI.SWE.ServicesModels;

import java.util.List;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;

public class MsgEntity {
	private String sendName;
	private long sendID;
	private String recName;
	private long recID;
	private String Content;

	public MsgEntity(String sendName, long sendID,String recName, long recID,String Content) {
		this.sendName = sendName;
		this.sendID= sendID;
		this.recID = recID;
		this.Content=Content;
		this.recName=recName;
		
	}
	



	public void setrecName(String recName)
	{
		this.recName=recName;
	}
	public String getrecName()
	{
		return recName;
	}
	public String getsendName()
	{
		return sendName;
	}
	public void setsendName(String sendName)
	{
		this.sendName=sendName;
	}
	
	private void setSendId(long sendID){
		this.sendID = sendID;
	}
	
	public long getsendID(){
		return sendID;
	}

	private void setrecId(long recID){
		this.recID = recID;
	}
	
	public long getRecID(){
		return recID;
	}
	public void setStatus(String Status){
	this.Content=Status;
		
	}
	public String getStatus()
	{
		return Content;
	}
	
	public Boolean SaveMSg() {
		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();
		Query gaeQuery = new Query("MsG");
		PreparedQuery pq = datastore.prepare(gaeQuery);
		List<Entity> list = pq.asList(FetchOptions.Builder.withDefaults());

		Entity employee = new Entity("MSG", list.size() + 1);

		employee.setProperty("sendName", this.sendName);
		employee.setProperty("sendID", this.sendID);
		employee.setProperty("recID", this.recID);
		employee.setProperty("Content", this.Content);
		employee.setProperty("recname", this.recName);
		datastore.put(employee);

		return true;

	}
 
}
