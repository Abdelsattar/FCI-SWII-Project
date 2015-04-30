package com.FCI.SWE.Controller;

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
@Path("/")
@Produces("text/html")

public class CreatePageController {
	
	

		@GET
		@Path("/CreatePage")
		public Response CreatePage() {


			return Response.ok(new Viewable("/jsp/CreatePage")).build();
		}
		
		
		@POST
		@Path("/page")
		//@Produces("text/html")
		public String view(@FormParam("name") String name,@FormParam("category") String category) {
			String urlParameters = "name=" + name +"&category="+category;
			String serviceUrl = "http://localhost:8888/rest/CreatePageService";
			String retJson = Connection.connect(
					"http://localhost:8888/rest/CreatePageService", urlParameters,
					"POST", "application/x-www-form-urlencoded;charset=UTF-8");

			JSONParser parser = new JSONParser();
			Object obj;
			try {
				obj = parser.parse(retJson);
				JSONObject object = (JSONObject) obj;
				if (object.get("Status").equals("OK"))
					return "page Created Successfully";

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return "Failed";
			

		}

		
		
		
		
		


}