package com.FCI.SWE.Controller;

import java.util.Vector;

import com.FCI.SWE.Models.Msg;
import com.FCI.SWE.ServicesModels.Mesageentity;

//concrete command

public class GetMessageCommand implements Command {

	Mesageentity message;
    long recID;
	
    public GetMessageCommand (){
    	
    }
    
	public GetMessageCommand (Mesageentity message){
		this.message=message;
	}
	
	public String execute (long ID) {
	
		return message.getMessage(ID);
		
	}
	

}
