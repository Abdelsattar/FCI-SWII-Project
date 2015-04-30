package com.FCI.SWE.Services;

import java.util.ArrayList;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;



import com.FCI.SWE.ServicesModels.UserEntity;

/**
 * @description search for user
 * @param sname
 * @return json.toString()
 */


@Path("/")
@Produces(MediaType.TEXT_PLAIN)
public class SearchServices {
	
	
	
@POST
@Path("/Searchsrvices")
public String searchService(@FormParam("uname") String sname) {
	JSONObject object = new JSONObject();
	JSONArray array = new JSONArray();
	System.out.println("servvices");
	ArrayList<UserEntity> user = UserEntity.searchforuser(sname);
	 System.out.println(user.size());
	
	if (user.size() == 0) {
		System.out.println("null");
		object.put("Status", "Failed");
		array.add(object);
	} else {

		for (int i = 0; i < user.size(); i++) {
			// object.put("name", user.get(i));
			JSONObject user1 = new JSONObject();
			user1.put("Status", "OK");
			user1.put("name", user.get(i).getName());
			user1.put("email", user.get(i).getEmail());
			user1.put("password", user.get(i).getPass());
			user1.put("ID", user.get(i).getId());
			array.add(user1);
			System.out.println("ser " + user.get(i).getName());
		}

	}
	System.out.println("size " + array.size());
	return array.toJSONString();

}



}