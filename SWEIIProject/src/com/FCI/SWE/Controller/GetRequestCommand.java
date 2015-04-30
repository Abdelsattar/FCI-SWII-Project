package com.FCI.SWE.Controller;

import java.util.Vector;

import com.FCI.SWE.ServicesModels.RequestEntity;

//concrete command

public class GetRequestCommand implements Command{

	RequestEntity request;
	long recID;
	
	public GetRequestCommand(){
		
	}
	public GetRequestCommand (RequestEntity request){
		this.request=request;
	}
	
	public String execute(long ID) {
	   return request.getRequest(ID);
		
	}

}
