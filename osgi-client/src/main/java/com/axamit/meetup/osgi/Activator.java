package com.axamit.meetup.osgi;


import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;


import com.axamit.meetup.api.*;
import com.axamit.meetup.invoke.ApiClient;


public class Activator implements BundleActivator {

    @Override
    public void start(final BundleContext context) throws Exception {
		System.out.println("Bundle com.axamit.meetup.osgi.client is starting");

		final ApiClient client = new ApiClient();
		context.registerService(ApiClient.class.getName(), client, null);
		context.registerService(AuthorsApi.class.getName(), client.createService(AuthorsApi.class), null);
		context.registerService(BooksApi.class.getName(), client.createService(BooksApi.class), null);

		System.out.println("Bundle com.axamit.meetup.osgi.client has been started");
    }

    @Override
    public void stop(BundleContext context) throws Exception {
		System.out.println("Bundle com.axamit.meetup.osgi.client is stopping");
		System.out.println("Bundle com.axamit.meetup.osgi.client has been stopped");
    }

}
