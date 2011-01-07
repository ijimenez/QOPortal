package com.qo.portal.employer.services;

public class LdapService
{
	public static void login(String user, byte[] password) throws Exception
	{
		if(!user.equals("123"))
		{
			throw new Exception("User doesn't exists");
		}
		
		return;
	}
}
