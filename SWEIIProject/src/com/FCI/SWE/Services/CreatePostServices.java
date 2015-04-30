package com.FCI.SWE.Services;

import java.sql.Timestamp;
import java.util.ArrayList;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONObject;

import com.FCI.SWE.Models.User;
import com.FCI.SWE.ServicesModels.NotificationEntity;
import com.FCI.SWE.ServicesModels.PostEntity;
import com.FCI.SWE.ServicesModels.RequestEntity;
import com.FCI.SWE.ServicesModels.UserEntity;

/**
 * @description create post on user timeline
 * @param owner_id , content , privacy , feeling
 * @return json.toString()
 */

@Path("/")
@Produces(MediaType.TEXT_PLAIN)
public class CreatePostServices {

	@POST
	@Path("/createPostService")
	public String createPost(@FormParam("ownerId") long owner_id,@FormParam("content") String content,@FormParam("privacy") String privacy,
			@FormParam("feeling") String feeling) {
		System.out.print("OwmerId"+ owner_id);
        JSONObject json = new JSONObject();
        UserEntity userEntity;
        String type="User Post";
        String timeline;
        String Owner = UserEntity.getUserName(owner_id);
        
        
        if(content.contains("#")){
        	int Indx=content.indexOf('#');
        	int Indx2 = 0;
        	for(int i=Indx; i<content.length(); i++){
        		if(content.charAt(i)==' ')
        			 Indx2=i;
        	}
        	String hashtag=content.substring(Indx, Indx2);
        	
        	timeline=hashtag;
        }
        else
        	timeline=UserEntity.getUsertime_line(owner_id);
        
        
    	json.put("Status", "OK");
        PostEntity post=new PostEntity(Owner,owner_id,content,type,timeline,privacy,feeling);
        post.savePost();
        
			return json.toString();
	
	
	}
		
	

}