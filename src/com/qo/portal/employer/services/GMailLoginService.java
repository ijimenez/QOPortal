package com.qo.portal.employer.services;

import org.apache.commons.httpclient.Credentials;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.httpclient.methods.GetMethod;

public class GMailLoginService
{
	private static String gmailFeedUrl = "https://mail.google.com/mail/feed/atom";

	public static void login(String user, char[] password) throws Exception
	{
		
		MultiThreadedHttpConnectionManager connectionManager =
      		new MultiThreadedHttpConnectionManager();
      	HttpClient client = new HttpClient(connectionManager);


        Credentials defaultcreds = new UsernamePasswordCredentials(user, new String(password));
        client.getState().setCredentials(AuthScope.ANY, defaultcreds);
        
        GetMethod get = new GetMethod(gmailFeedUrl);

        get.setDoAuthentication( true );
		 	
        try {
	        // execute the GET
	        int status = client.executeMethod( get );
	        System.out.println("HTTP code:"+status);
	        if (status!=200)
	        {
	        	throw new Exception("Authentication failed");
	        }
	    } finally {
	        // release any connection resources used by the method
	        get.releaseConnection();
	    }
		

	}
}
