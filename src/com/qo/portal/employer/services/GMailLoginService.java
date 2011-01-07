package com.qo.portal.employer.services;

import java.util.List;

import com.googlecode.gmail4j.GmailMessage;
import com.googlecode.gmail4j.http.HttpGmailConnection;
import com.googlecode.gmail4j.rss.RssGmailClient;

public class GMailLoginService 
{

	public static void login(String user, char[] password) throws Exception
	{
		
		HttpGmailConnection connection = new HttpGmailConnection(user, password);
		RssGmailClient client = new RssGmailClient();
		client.setConnection(connection);
		try
		{
			List<GmailMessage> messages = client.getUnreadMessages();
			int messagesNumber = messages.size();
		}
		catch(Throwable t)
		{
			throw new Exception("Authentication failed");
		}
		
	}
}
