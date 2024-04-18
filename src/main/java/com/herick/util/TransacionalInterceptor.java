package com.herick.util;

import java.io.Serializable;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.interceptor.AroundInvoke;

@Interceptor
@Transacional
@Priority(Interceptor.Priority.APPLICATION)
public class TransacionalInterceptor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager manager;
    
    @AroundInvoke
    private Object invoke(InvocationContext context) throws Exception {
    	EntityTransaction trx = manager.getTransaction();
    	boolean criador = false;
    	
    	try {
    		if (!trx.isActive()) {
    			trx.begin();
    			trx.rollback();
    			
    			trx.begin();
    			
    			criador = true;
    		}
    		
    		return context.proceed();
    	} catch (Exception error) {
    		if (trx != null &&  criador) {
    			trx.rollback();
    		}
    		
    		throw error;
    	} finally {
    		if (trx != null && trx.isActive() && criador) {
    			trx.commit();
    		}
    	}
    }

}