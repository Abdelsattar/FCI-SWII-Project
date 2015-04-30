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



import com.FCI.SWE.ServicesModels.UserEntity;
import com.google.appengine.labs.repackaged.org.json.JSONArray;
import com.google.appengine.labs.repackaged.org.json.JSONException;
@Path("/")
@Produces("text/html")
public class SearchController {
	
	@GET
	@Path("/SearchF")
	public Response friend() {

		if (UserEntity.getCurrentActiveUser() == null) {
			System.out.print("lool");
			return Response.serverError().build();
		}
		return Response.ok(new Viewable("/jsp/SearchWindow")).build();
	}
	
	@POST
	@Path("/searchUser")
	public Response home(@FormParam("uname") String uname) throws JSONException  {
		
		String urlParameters = "uname=" + uname ;
		//String urlParameters = "searchname=" + uname ;

		String retJson = Connection.connect(
				"http://localhost:8888/rest/Searchsrvices", urlParameters,
				"POST", "application/x-www-form-urlencoded;charset=UTF-8");

		System.out.println("servvices");
		
		JSONParser parser = new JSONParser();
		Object obj;
		Map<String, ArrayList<UserEntity>> map = new HashMap<String, ArrayList<UserEntity>>();
		try {
			obj = parser.parse(retJson);
			 JSONArray array = (JSONArray) obj;
			 
			
			
			ArrayList<UserEntity> matches = new ArrayList<UserEntity>();
			
		    for(int i=0; i<array.length(); i++)
		    {
		    	JSONObject object;
		    	
		    	object = (JSONObject) array.get(i);
		    	matches.add(UserEntity.parseuserinfo(object.toString()));
		    	
		    	
		    }
			map.put("users", matches);
			
	} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response.ok(new Viewable("/jsp/viewUsers",map )).build();
	/*
	 * UserEntity user = new UserEntity(uname, email, pass);
	 * user.saveUser(); return uname;
	 */
	//	return null;

	}
}
	//O.o O.o
	//hna kan feh function wa7da bs :D
	
	//d2e2a wgya ok :D looool 7lw 7lw :D 
//AWEEEEE








