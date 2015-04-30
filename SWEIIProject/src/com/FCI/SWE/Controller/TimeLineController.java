package com.FCI.SWE.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.mvc.Viewable;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.FCI.SWE.Models.User;
import com.FCI.SWE.Services.AddServices;
import com.FCI.SWE.ServicesModels.HashtagEntity;
import com.FCI.SWE.ServicesModels.PostEntity;
import com.FCI.SWE.ServicesModels.UserEntity;
import com.google.appengine.labs.repackaged.org.json.JSONArray;
import com.google.appengine.labs.repackaged.org.json.JSONException;
@Path("/")
@Produces("text/html")
public class TimeLineController {

	@GET
	@Path("/NewFeed") 
	public Response friend() {


		return Response.ok(new Viewable("/jsp/home")).build();
	}
	
	


	
	@POST
	@Path("/newsFeed2")
	//@Produces("text/html")
	public Response viewPost(@FormParam("user") String userName) throws JSONException {
		String urlParameters = "user="+ userName ;
		String serviceUrl = "http://localhost:8888/rest/newsFeedService";
		String retJson = Connection.connect(
				"http://localhost:8888/rest/newsFeedService", urlParameters,
				"POST", "application/x-www-form-urlencoded;charset=UTF-8");

		JSONParser parser = new JSONParser();
		Object obj;
		Map<String, ArrayList<PostEntity>> map = new HashMap<String, ArrayList<PostEntity>>();
		try {
			obj = parser.parse(retJson);
			 JSONArray array = (JSONArray) obj;
			 
			
			
			ArrayList<PostEntity> Posts = new ArrayList<PostEntity>();
			
		    for(int i=0; i<array.length(); i++)
		    {
		    	JSONObject object;
		    	
		    	object = (JSONObject) array.get(i);
		    	Posts.add(PostEntity.parsePostinfo(object.toString()));
		    	
		    	
		    }
			map.put("posts", Posts);
			
	} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response.ok(new Viewable("/jsp/HomePosts",map )).build();

	}

	

	
	
	
	@GET
	@Path("/Profile") 
	public Response profile() {


		return Response.ok(new Viewable("/jsp/home")).build();
	}
	
	


	
	@POST
	@Path("/profile2")
	//@Produces("text/html")
	public Response viewProfilePost(@FormParam("timeline") String timeline) throws JSONException {
		String urlParameters = "timeline="+ timeline ;
		String serviceUrl = "http://localhost:8888/rest/TimeLineService";
		String retJson = Connection.connect(
				"http://localhost:8888/rest/TimeLineService", urlParameters,
				"POST", "application/x-www-form-urlencoded;charset=UTF-8");

		JSONParser parser = new JSONParser();
		Object obj;
		Map<String, ArrayList<PostEntity>> map = new HashMap<String, ArrayList<PostEntity>>();
		try {
			obj = parser.parse(retJson);
			 JSONArray array = (JSONArray) obj;
			 
			
			
			ArrayList<PostEntity> Posts = new ArrayList<PostEntity>();
			
		    for(int i=0; i<array.length(); i++)
		    {
		    	JSONObject object;
		    	
		    	object = (JSONObject) array.get(i);
		    	Posts.add(PostEntity.parsePostinfo(object.toString()));
		    	
		    	
		    }
			map.put("posts", Posts);
			
	} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response.ok(new Viewable("/jsp/TimeLinePosts",map )).build();

	}

	

	
	
	@GET
	@Path("/Page1") 
	public Response page() {


		return Response.ok(new Viewable("/jsp/home")).build();
	}
	
	


	
	@POST
	@Path("/PagePost2")
	//@Produces("text/html")
	public Response PagePost2(@FormParam("timeline") String timeline) throws JSONException {
		String urlParameters = "timeline="+ timeline ;
		String serviceUrl = "http://localhost:8888/rest/PageTimeLineService";
		String retJson = Connection.connect(
				"http://localhost:8888/rest/PageTimeLineService", urlParameters,
				"POST", "application/x-www-form-urlencoded;charset=UTF-8");

		JSONParser parser = new JSONParser();
		Object obj;
		Map<String, ArrayList<PostEntity>> map = new HashMap<String, ArrayList<PostEntity>>();
		try {
			obj = parser.parse(retJson);
			 JSONArray array = (JSONArray) obj;
			 
			
			
			ArrayList<PostEntity> Posts = new ArrayList<PostEntity>();
			
		    for(int i=0; i<array.length(); i++)
		    {
		    	JSONObject object;
		    	
		    	object = (JSONObject) array.get(i);
		    	Posts.add(PostEntity.parsePostinfo(object.toString()));
		    	
		    	
		    }
			map.put("posts", Posts);
			
	} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response.ok(new Viewable("/jsp/PageTimeLinePosts",map )).build();

	}

	

	
	
	
	
	
	
	
	
}

