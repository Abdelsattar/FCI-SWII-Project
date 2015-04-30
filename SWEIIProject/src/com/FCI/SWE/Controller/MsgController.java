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

import com.FCI.SWE.ServicesModels.UserEntity;
@Path("/")
@Produces("text/html")
public class MsgController {

	


		@GET
		@Path("MSg")
		public Response MSG() {


			return Response.ok(new Viewable("/jsp/viewUsers")).build();
		}
		

		@POST
		@Path("/SengMsg")
		
		public String SendMsg(@FormParam("uname") String uname,@FormParam("content") String Content) {
			String uname2 = UserEntity.getCurrentActiveUser().getName();
			String urlParameters = "uname=" + uname2 +"&uname2="+uname +"&content="+Content;
	
			
			String retJson = Connection.connect(
					"http://localhost:8888/rest/MsgService", urlParameters,
					"POST", "application/x-www-form-urlencoded;charset=UTF-8");

			JSONParser parser = new JSONParser();
			Object obj;
			try {
				obj = parser.parse(retJson);
				JSONObject object = (JSONObject) obj;
				if (object.get("Status").equals("OK"))
					return "Msg sent Successfully";

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return "Failed";
			

		}

		
			
		
}
