package com.FCI.SWE.ServicesModels;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;




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
public class UserEntity {
	public String name;
	public String email;
	private String password;
	private long id;
	private String timeline;

	
	
	private static UserEntity currentActiveUser;
//	private long sendId;
  
	
	/**
	 * Constructor accepts user data
	 * 
	 * @param name
	 *            user name
	 * @param email
	 *            user email
	 * @param password
	 *            user provided password
	 */
	public UserEntity(String name, String email, String password,String timeline) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.timeline=timeline;
		
	}
	public UserEntity(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
			
	}
	
	public UserEntity(long id){
		this.id=id;
	}
	
	public UserEntity() {
		// TODO Auto-generated constructor stub
	}
  
	public UserEntity(String string) {
		// TODO Auto-generated constructor stub
	}

	private void setId(long id){
		this.id = id;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public long getId(){
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPass() {
		return password;
	}
	public void setTimeline(String timeline){
		this.timeline=timeline;
	}
	public String getTimeline(){
		return timeline;
	}
	
	public static UserEntity getCurrentActiveUser(){
		return currentActiveUser;
	}
	public static void setCurrentActiveUser(UserEntity user){
		 currentActiveUser=user;
	}
	
	public static UserEntity getUserinActive(String json) {

		JSONParser parser = new JSONParser();
		try {
			JSONObject object = (JSONObject) parser.parse(json);
			currentActiveUser = new UserEntity(object.get("name").toString(), object.get(
					"email").toString(), object.get("id").toString());
			currentActiveUser.setId(Long.parseLong(object.get("id").toString()));
			return currentActiveUser;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
	
	/**
	 * 
	 * This static method will form UserEntity class using user name and
	 * password This method will serach for user in datastore
	 * 
	 * @param name
	 *            user name
	 * @param pass
	 *            user password
	 * @return Constructed user entity
	 */

	public static UserEntity getUser(String name, String pass) {
		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();

		Query gaeQuery = new Query("users");
		PreparedQuery pq = datastore.prepare(gaeQuery);
		for (Entity entity : pq.asIterable()) {
			if (entity.getProperty("name").toString().equals(name)
					&& entity.getProperty("password").toString().equals(pass)) {
				UserEntity returnedUser = new UserEntity(entity.getProperty(
						"name").toString(), entity.getProperty("email")
						.toString(), entity.getProperty("password").toString());
				returnedUser.setId(Integer.parseInt(entity.getProperty("ID").toString()));
				return returnedUser;
			}
		}

		return null;
	}
	
	//select matches names 
	
	public static UserEntity getUser(String name) {
		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService(); 
		Query gaeQuery = new Query("users");
		PreparedQuery pq = datastore.prepare(gaeQuery);
		System.out.println("name : "+name);
		for (Entity entity : pq.asIterable()) {
			System.out.println(entity.getProperty("name").toString());
			if (entity.getProperty("name").toString().equals(name)) {
				UserEntity returnedUser = new UserEntity(entity.getProperty(
						"name").toString(), entity.getProperty("email")
						.toString(), entity.getProperty("password").toString());
				returnedUser.setId(entity.getKey().getId());	
				return returnedUser;
			}
		}
		
        return null;
	}
	
	
	public static String getUserName(long id) {
		
		String owner;
		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService(); 
		Query gaeQuery = new Query("users");
		PreparedQuery pq = datastore.prepare(gaeQuery);
	//	System.out.println("name : "+name);
		for (Entity entity : pq.asIterable()) {
		//	System.out.println(entity.getProperty("name").toString());
			if (entity.getProperty("ID").equals(id)) {
				owner = entity.getProperty("name").toString();
				//returnedUser.setId(entity.getKey().getId());	
				return owner;
			}
		}
		
        return null;
	}
	
	
public static String getUsertime_line(long id) {
		
		String time_line;
		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService(); 
		Query gaeQuery = new Query("users");
		PreparedQuery pq = datastore.prepare(gaeQuery);
	//	System.out.println("name : "+name);
		for (Entity entity : pq.asIterable()) {
		//	System.out.println(entity.getProperty("name").toString());
			if (entity.getProperty("ID").equals(id)) {
				time_line =  entity.getProperty("timeline").toString();
				//returnedUser.setId(entity.getKey().getId());	
				return time_line;
			}
		}
		
        return  null;
	}
	
	
	public static ArrayList<UserEntity> getUsers(String json) {

		JSONParser parser = new JSONParser();
		try {
			JSONObject object = (JSONObject) parser.parse(json);
			ArrayList<UserEntity> users = new ArrayList<UserEntity>();
			
			for(int i=0;i<object.size();i++)
			{
				UserEntity user = new UserEntity(object.get("name"+i).toString());
				//user.setId(Long.parseLong(object.get("id").toString()));
				users.add(user);
			}
			
			return users;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	

	
	
	

	/**
	 * This method will be used to save user object in datastore
	 * 
	 * @return boolean if user is saved correctly or not
	 */
	public Boolean saveUser() {
		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();
		Query gaeQuery = new Query("users");
		PreparedQuery pq = datastore.prepare(gaeQuery);
		List<Entity> list = pq.asList(FetchOptions.Builder.withDefaults());

		Entity employee = new Entity("users");
		employee.setProperty("name", this.name);
		employee.setProperty("email", this.email);
		employee.setProperty("password", this.password);
		employee.setProperty("ID", list.size() + 1);
		Random rand = new Random();
		double selected = rand.nextInt(100);
		this.timeline=String.valueOf(selected);
		employee.setProperty("timeline", this.timeline);
		datastore.put(employee);

		return true;

	}

	public static ArrayList<UserEntity> searchforuser(String Name) {
		 System.out.println("enter datea "+Name);
		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();
		ArrayList<UserEntity> returnedUser = new ArrayList<UserEntity>();
		Query gaeQuery = new Query("users");
		PreparedQuery pq = datastore.prepare(gaeQuery);
		for (Entity entity : pq.asIterable()) {
			
			if (entity.getProperty("name").toString().contentEquals(Name)) {
				
				returnedUser.add(new UserEntity(entity.getProperty("name")
						.toString(), entity.getProperty("email").toString(),
						entity.getProperty("password").toString()));
				 System.out.println(returnedUser.size());
			}
		}
		
		return returnedUser;
	}
	
	
	
	public static UserEntity parseuserinfo(String json)
	{
		JSONParser parser = new JSONParser();
		UserEntity user=new UserEntity();
		try {
			JSONObject object = (JSONObject) parser.parse(json);
			
			user.setName(object.get("name").toString());
			user.setEmail(object.get("email").toString());
			user.setId(Long.parseLong(object.get("id").toString()));
			
			//return user;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;

	}
	
}

