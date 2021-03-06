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
 * @description like page
 * @param name
 * @return json.toString()
 */

@Path("/")
@Produces(MediaType.TEXT_PLAIN)
public class likesService {

	@POST
	@Path("/LikePageService")
	public String likePage(@FormParam("name") String name ){
		
		PageEntity page = new PageEntity();
		JSONObject json = new JSONObject();
		if(page.update(name))
			json.put("Status", "OK");
		else
			json.put("Status", "Failed");
		return json.toJSONString();
	}
	

}