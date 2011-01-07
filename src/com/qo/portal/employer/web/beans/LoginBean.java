/**
 * LoginBean.java
 * 
 */

package com.qo.portal.employer.web.beans;

import com.qo.portal.employer.services.LdapService;

public class LoginBean
{
    private String name;
    private String password;


    public String getName ()
    {
        return name;
    }


    public void setName (final String name)
    {
        this.name = name;
    }


    public String getPassword ()
    {
        return password;
    }


    public void setPassword (final String password)
    {
        this.password = password;
    }
    
    public String login()
    {
    	System.out.println("LoginBean@login - start: "+this);
    	try
		{
			LdapService.login(name, password.getBytes());
			return "loginOk";
		} 
    	catch (Exception e)
		{
			e.printStackTrace();
			return "loginFailed";
		}
    	finally
    	{
    		System.out.println("LoginBean@login - end: "+this);
    	}
    	
    }
    
    @Override
    public String toString()
    {
    	return "name="+name+" password="+password;
    }
}