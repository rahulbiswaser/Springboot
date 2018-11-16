package com.example.demo.Filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class CustomFilter extends ZuulFilter{
	
	private static Logger log= LoggerFactory.getLogger(CustomFilter.class);

	@Override
	public Object run() {
		
		RequestContext rt = RequestContext.getCurrentContext();
		HttpServletRequest request= rt.getRequest();
		log.info(request.getMethod() + "Inside CustomFIlter");
		System.out.println("OK");
		return null;
	}

	@Override
	public boolean shouldFilter() {
		
		return true;
	}

	@Override
	public int filterOrder() {
		
		return 1;
	}

	@Override
	public String filterType() {
		
		return "pre";
	}

}
