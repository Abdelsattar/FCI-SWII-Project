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
import com.FCI.SWE.ServicesModels.UserEntity;
import com.google.appengine.labs.repackaged.org.json.JSONArray;
import com.google.appengine.labs.repackaged.org.json.JSONException;
@Path("/")
@Produces("text/html")
public class showNotificationsController {

	@POST
	@Path("/show")
public Response home(@FormParam("recID") long recID) throws JSONException  {
		
		String urlParameters = "recID=" + recID ;
		//String urlParameters = "searchname=" + uname ;

		String retJson = Connection.connect(
				"http://localhost:8888/rest/ViewNotificationService", urlParameters,
				"POST", "application/x-www-form-urlencoded;charset=UTF-8");

		//System.out.println("servvices");
		
		JSONParser parser = new JSONParser();
		Object obj;
		Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		try {
			obj = parser.parse(retJson);
			 JSONArray array = (JSONArray) obj;
			 
			
			
			ArrayList<String> output = new ArrayList<String>();
			
		    for(int i=0; i<array.length(); i++)
		    {
		    	JSONObject object;
		    	
		    	object = (JSONObject) array.get(i);
		    	output.add(object.get("notification"+i).toString());
		    	
		    	
		    }
			map.put("Notifications", output);
			
	} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response.ok(new Viewable("/jsp/notifications",map )).build();
	/*
	 * UserEntity user = new UserEntity(uname, email, pass);
	 * user.saveUser(); return uname;
	 */
	//	return null;

	}
}
	
	
	
	
	
	
	
	
	
	
