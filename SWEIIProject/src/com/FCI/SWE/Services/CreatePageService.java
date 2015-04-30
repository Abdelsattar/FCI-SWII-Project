package com.FCI.SWE.Services;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONObject;

import com.FCI.SWE.ServicesModels.GroupEntity;
import com.FCI.SWE.ServicesModels.PageEntity;

/**
 * @description create page 
 * @param name , category
 * @return json.toString()
 */

@Path("/")
@Produces(MediaType.TEXT_PLAIN)
public class CreatePageService {

	@POST
	@Path("/CreatePageService")
	public String createPage(@FormParam("name") String name,@FormParam("category") String category )
	{
		
		PageEntity page = new PageEntity(name,category);
		
	
		
		
		JSONObject json = new JSONObject();
		if(page.savePage())
			json.put("Status", "OK");
		else
			json.put("Status", "Failed");
		return json.toJSONString();
	}
	

}