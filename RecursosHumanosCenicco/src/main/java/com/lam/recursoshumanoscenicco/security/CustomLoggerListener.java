package com.lam.recursoshumanoscenicco.security;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.access.event.AuthenticationCredentialsNotFoundEvent;
import org.springframework.security.access.event.AuthorizationFailureEvent;
import org.springframework.security.access.event.PublicInvocationEvent;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.Authentication;
import org.springframework.web.context.support.ServletRequestHandledEvent;

public class CustomLoggerListener implements ApplicationListener<ApplicationEvent>{
	private static Logger logger = LoggerFactory.getLogger(CustomLoggerListener.class);
	
	@Override
	public void onApplicationEvent(ApplicationEvent e) {
		if ( e instanceof AuthenticationCredentialsNotFoundEvent ) {
            logger.info( "AuthenticationCredentialsNotFoundEvent: " + e );
        }
        else if ( e instanceof AuthorizationFailureEvent ) {
            AuthorizationFailureEvent a = (AuthorizationFailureEvent)e;
            logger.info( "AUTH-FAIL [" + a.getSource() + "]");
        }
        else if ( e instanceof PublicInvocationEvent ) {
            logger.trace( "PublicInvocationEvent: " + e );
        }  
        else if ( e instanceof AuthenticationFailureBadCredentialsEvent ) {
            AuthenticationFailureBadCredentialsEvent f = (AuthenticationFailureBadCredentialsEvent)e;
            logger.info( "AUTH-FAIL BAD-CREDENTIALS [" + f.getSource() + "]" );
        }
        else if ( e instanceof AuthenticationSuccessEvent ) {
            AuthenticationSuccessEvent s = (AuthenticationSuccessEvent)e;
            Authentication a = s.getAuthentication();
            logger.info( "AUTH-SUCCESS [" + a + "]");
            
        }
        else if ( e instanceof ServletRequestHandledEvent ) {
            ServletRequestHandledEvent r = (ServletRequestHandledEvent)e;
            logger.trace( "request[ USR=" + r.getUserName() +", "+r.getMethod() +", URL="+r.getRequestUrl() + ", client="+r.getClientAddress() + "]" );
        }
        
        else {
            logger.trace( "evento ricevuto: " + e.getClass().getCanonicalName() );
            logger.trace( "event: "+e );
        }
	}

}
