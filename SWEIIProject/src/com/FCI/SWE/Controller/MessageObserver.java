package com.FCI.SWE.Controller;
import java.sql.Timestamp;
import java.util.Observable;
import java.util.Observer;

import com.FCI.SWE.Models.User;
import com.FCI.SWE.ServicesModels.Mesageentity;
import com.FCI.SWE.ServicesModels.MessageEntity;
import com.FCI.SWE.ServicesModels.NotificationEntity;

public class MessageObserver implements Observer{
	private long ID;
	private String recName;
	private Conversation conv;
	public MessageObserver (long ID,String recName)
	{
		this.ID=ID;
		this.recName=recName;
	}
	public void setConv(Conversation conv)
	{
		this.conv = conv;
		conv.attach(this);
	}

	public void Update(long SendId) {
		String message = conv.getUpdate();
	//	long sendID = User.getCurrentActiveUser().getId();
		MessageEntity msg = new MessageEntity(message,SendId,ID);
		msg.saveMessage();

		java.util.Date date = new java.util.Date();
		Timestamp time =new Timestamp(date.getTime());
	
		NotificationEntity notify=new NotificationEntity (recName,ID,"Msg","Not seen", time, msg.getmsgID());
		notify.savenotification();
	}

	@Override
	public void update(Observable o, Object arg) {
		
	}

}
