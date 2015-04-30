package com.FCI.SWE.Models;

import java.sql.Timestamp;


public class Notify{

    public String recName;
	public long recID;
	public String type;
	public long notifyID;
	public String status;
    public Timestamp time; 

	public Notify( String recName, long recID,String type,String status,Timestamp time,long notifyID ) {
		this.recID = recID;
		this.status=status;
		this.recName=recName;
		this.time=time;
		this.type=type;
		this.notifyID=notifyID;
		
	}
	public Notify (){
		
	}

	public String getType(){
		return type;
	}
	
	public Timestamp getTime(){
		return time;
	}
	public long getnotifyID(){
		return notifyID;
	}
}
