package com.FCI.SWE.Services;

import java.util.ArrayList;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONObject;


import com.FCI.SWE.ServicesModels.MsgEntity;
import com.FCI.SWE.ServicesModels.RequestEntity;
import com.FCI.SWE.ServicesModels.UserEntity;

/**
 * @description send message
 * @param send_name,rec_name,content
 * @return json.toString()
 */

@Path("/")
@Produces(MediaType.TEXT_PLAIN)
public class MsgService {

	@POST
	@Path("/MsgService")
	public String MSG(@FormParam("uname") String send_name,@FormParam("uname2") String rec_name,@FormParam("content") String Content) {
		
        JSONObject json = new JSONObject();
        UserEntity userEntity =  new UserEntity(); 
       userEntity = userEntity.getUser(send_name);
       // userEntity = User.getCurrentActiveUser();
        
        UserEntity userEntity2 =   new UserEntity();
        userEntity2= userEntity2.getUser(rec_name);
        
        if (userEntity==null && userEntity2==null && Content==null) {
			json.put("Status", "Failed");
		}
		else {
			json.put("Status", "OK");
			MsgEntity Msg= new MsgEntity 
					(send_name,userEntity.getId(),rec_name,userEntity2.getId(),Content);
			Msg.SaveMSg();
		}
		
			return json.toString();
	
}
}