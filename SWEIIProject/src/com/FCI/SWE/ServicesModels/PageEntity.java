package com.FCI.SWE.ServicesModels;

import java.util.List;
import java.util.Random;
import java.util.Vector;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;

public class PageEntity {
	
	String name;
	long id;
	int likes;
	String category;
	String timeline;
	//Vector<long>fans =new Vector<long>();
	//Vector<String>post =new Vector<String>();
	//3yza a3ml relation between el page wel post 
	
	public PageEntity(String name,long id,int likes,String category,String timeline){
		this.name=name;
		this.id=id;
		this.likes=likes;
		this.category=category;
		this.timeline=timeline;
	
	}
	
	public PageEntity(String name, String category) {
		// TODO Auto-generated constructor stub
	this.name=name;
	this.category=category;
	}

	public PageEntity() {
		// TODO Auto-generated constructor stub
	}

	public void setName(String name){
		this.name=name;
	}
	public void setId(long id){
		this.id=id;
	}
	public void setLikes(int likes){
		this.likes=likes;
	}
	public void setCategory(String category){
		this.category=category;
	}
	public String getName(){
		return name;
	}
	public long getId(){
		return id;
	}
	public int getLikes(){
		return likes;
	}
	public String getCategory(){
		return category;
	}
	public void setTimeline(String timeline){
		this.timeline=timeline;
	}
	public String getTimeline(){
		return timeline;
	}
	public Boolean savePage() {
		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();
		Query gaeQuery = new Query("Pages");
		PreparedQuery pq = datastore.prepare(gaeQuery);
		List<Entity> list = pq.asList(FetchOptions.Builder.withDefaults());

		Entity employee = new Entity("Pages", list.size() + 1);

		employee.setProperty("name", this.name);
		employee.setProperty("id",  list.size() + 1);
		this.likes=0;
		employee.setProperty("likes", this.likes);
		employee.setProperty("category", this.category);
		Random rand = new Random();
		double selected = rand.nextInt(100);
		this.timeline=String.valueOf(selected);
		employee.setProperty("timeline", this.timeline);
		datastore.put(employee);

		return true;

	}
	
	public Vector<String> getPosts(long id){
		 
		Vector<String>post=new Vector<String>();
		String temp = "";
		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService(); 
		Query gaeQuery = new Query("Pages");
		PreparedQuery pq = datastore.prepare(gaeQuery);
		for (Entity entity : pq.asIterable()) {
			if (entity.getProperty("id").equals(id))
			{   
				temp=entity.getProperty("owner").toString() + "\n" + entity.getProperty("content").toString();
				post.add(temp);
			}
		}
	
		return post;
	}
	
	
public static String getPagetime_line(long id) {
		
		String time_line;
		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService(); 
		Query gaeQuery = new Query("Pages");
		PreparedQuery pq = datastore.prepare(gaeQuery);
	//	System.out.println("name : "+name);
		for (Entity entity : pq.asIterable()) {
		//	System.out.println(entity.getProperty("name").toString());
			if (entity.getProperty("id").equals(id)) {
				time_line = entity.getProperty("timeline").toString();
				//returnedUser.setId(entity.getKey().getId());	
				return time_line;
			}
		}
		
        return  null;
	}
	
	
	
	

public boolean update(String name)
{

	//Vector<String>post=new Vector<String>();
	//String temp = "";
	DatastoreService datastore = DatastoreServiceFactory
			.getDatastoreService(); 
	Query gaeQuery = new Query("Pages");
	PreparedQuery pq = datastore.prepare(gaeQuery);
	for (Entity entity : pq.asIterable()) {
		if (entity.getProperty("name").equals(name))
		{   
			int likes = Integer.parseInt(entity.getProperty("likes").toString());
			entity.setProperty("likes", likes+1);
			datastore.put(entity);
		}
	}

	return true;
	
}
	
	
	
	
	
	
	

}
