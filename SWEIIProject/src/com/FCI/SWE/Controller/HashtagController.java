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






import com.FCI.SWE.ServicesModels.HashtagEntity;
import com.FCI.SWE.ServicesModels.PostEntity;
import com.FCI.SWE.ServicesModels.UserEntity;
import com.google.appengine.labs.repackaged.org.json.JSONArray;
import com.google.appengine.labs.repackaged.org.json.JSONException;
@Path("/")
@Produces("text/html")
public class HashtagController {
	/*
	@GET
	@Path("/hashtag")
	public Response friend() {

		if (UserEntity.getCurrentActiveUser() == null) {
			System.out.print("lool");
			return Response.serverError().build();
		}
		return Response.ok(new Viewable("/jsp/blabla.jsp  ")).build();
	}*/
	/*
	@GET
	@Path("/viewTimeline/{hashTagName}")
	public Response viewTimeline(@FormParam("hashTagName") String hashTagName) throws JSONException{
      
		String urlParameters = "hashTagName="+hashTagName ;
		//String urlParameters = "searchname=" + uname ;

		String retJson = Connection.connect(
				"http://localhost:8888/rest/viewTimelineService", urlParameters,
				"POST", "application/x-www-form-urlencoded;charset=UTF-8");

		JSONParser parser = new JSONParser();
		Object obj;
		Map<String, ArrayList<PostEntity>> map = new HashMap<String, ArrayList<PostEntity>>();
		try {
			obj = parser.parse(retJson);
			 JSONArray array = (JSONArray) obj;
			 
			
			
			ArrayList<PostEntity> posts = new ArrayList<PostEntity>();
			
		    for(int i=0; i<array.length(); i++)
		    {
		    	JSONObject object;
		    	
		    	object = (JSONObject) array.get(i);
		    	posts.add(PostEntity.parsePostinfo(object.toString()));
		    	
		    	
		    }
			map.put("posts", posts);
			
	} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response.ok(new Viewable("/jsp/hashtagTimeline",map )).build();

	}

		
		
		*/
	
	
	
	
	
	
	@POST
	@Path("/toptrends")
	public Response home () throws JSONException {
		
		String urlParameters = "" ;
		//String urlParameters = "searchname=" + uname ;

		String retJson = Connection.connect(
				"http://localhost:8888/rest/viewTopTrendsService", urlParameters,
				"POST", "application/x-www-form-urlencoded;charset=UTF-8");

		System.out.println("servvices");
		
		JSONParser parser = new JSONParser();
		Object obj;
		Map<String, ArrayList<HashtagEntity>> map = new HashMap<String, ArrayList<HashtagEntity>>();
		try {
			obj = parser.parse(retJson);
			 JSONArray array = (JSONArray) obj;
			 
			
			
			ArrayList<HashtagEntity> hashtags = new ArrayList<HashtagEntity>();
			
		    for(int i=0; i<array.length(); i++)
		    {
		    	JSONObject object;
		    	
		    	object = (JSONObject) array.get(i);
		    	hashtags.add(HashtagEntity.parsehashtaginfo(object.toString()));
		    	
		    	
		    }
			map.put("Hashtags", hashtags);
			
	} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response.ok(new Viewable("/jsp/TopTrends",map )).build();

	}
}








