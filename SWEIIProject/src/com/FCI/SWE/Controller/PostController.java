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
@Path("/")
@Produces("text/html")
public class PostController {

	@GET
	@Path("/posts") 
	public Response friend() {


		return Response.ok(new Viewable("/jsp/timeLinePage")).build();
	}
	
	


	
	@POST
	@Path("/userpost")
	//@Produces("text/html")
	public String createPost(@FormParam("ownerId") long owner_id,@FormParam("content") String content,@FormParam("Privacy") String privacy,
			@FormParam("feeling") String feeling) {
    	owner_id=User.getCurrentActiveUser().getId();
		System.out.print("OwmerId"+ owner_id);
		String urlParameters = "ownerId="+ owner_id   +"&content="+content + "&privacy="+ privacy +"&feeling="+feeling;
		String serviceUrl = "http://localhost:8888/rest/createPostService";
		String retJson = Connection.connect(
				"http://localhost:8888/rest/createPostService", urlParameters,
				"POST", "application/x-www-form-urlencoded;charset=UTF-8");

		JSONParser parser = new JSONParser();
		Object obj;
		try {
			obj = parser.parse(retJson);
			JSONObject object = (JSONObject) obj;
			if (object.get("Status").equals("OK"))
				return "Post created Successfully";

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "Failed";
		

	}

	
	
	
	@POST
	@Path("/friendpost")
	//@Produces("text/html")
	public String createPost(@FormParam("ownerId") long owner_id,@FormParam("content") String content,@FormParam("recID") long rec_id) {
		String urlParameters = "ownerId="+ owner_id   +"&content="+content + "&recID="+rec_id;
		String serviceUrl = "http://localhost:8888/rest/friendPostService";
		String retJson = Connection.connect(
				"http://localhost:8888/rest/friendPostService", urlParameters,
				"POST", "application/x-www-form-urlencoded;charset=UTF-8");

		JSONParser parser = new JSONParser();
		Object obj;
		try {
			obj = parser.parse(retJson);
			JSONObject object = (JSONObject) obj;
			if (object.get("Status").equals("OK"))
				return "Post created Successfully";

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "Failed";
		

	}
	
	
	
	
	@POST
	@Path("/pagepost")
	//@Produces("text/html")
	public String createPost(@FormParam("ownerId") long owner_id,@FormParam("content") String content) {
		String urlParameters = "ownerId="+ owner_id   +"&content="+content ;
		String serviceUrl = "http://localhost:8888/rest/pagePostService";
		String retJson = Connection.connect(
				"http://localhost:8888/rest/pagePostService", urlParameters,
				"POST", "application/x-www-form-urlencoded;charset=UTF-8");

		JSONParser parser = new JSONParser();
		Object obj;
		try {
			obj = parser.parse(retJson);
			JSONObject object = (JSONObject) obj;
			if (object.get("Status").equals("OK"))
				return "Post created Successfully";

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "Failed";
		

	}	
	
	
	
	
	
	
}

