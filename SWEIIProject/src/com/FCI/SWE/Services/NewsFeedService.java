package com.FCI.SWE.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.FCI.SWE.ServicesModels.GroupEntity;
import com.FCI.SWE.ServicesModels.HashtagEntity;
import com.FCI.SWE.ServicesModels.PostEntity;


/**
 * @description newsFeed
 * @param userNmae
 * @return json.toString()
 */

@Path("/")
@Produces(MediaType.TEXT_PLAIN)

public class NewsFeedService {
	
	@POST
	@Path("/newsFeedService")
	public String viewTimeline(@FormParam("user") String userName) {
		PostEntity post  = new PostEntity();
		Vector<PostEntity> posts = post.getHomePost(userName);
		
		JSONArray array = new JSONArray();
		
		//if(posts == null)
			//json.put("Status", "Failed");
		//else
		//{
			//json.put("Status", "OK");
			for(int i=0 ; i<posts.size() ; i++)
			{
				JSONObject json = new JSONObject();
				json.put("owner", posts.get(i).getOwner());
				json.put("content", posts.get(i).getContent());
				array.add(json);
			}
		//}
			
		return array.toJSONString();
	}
}
	