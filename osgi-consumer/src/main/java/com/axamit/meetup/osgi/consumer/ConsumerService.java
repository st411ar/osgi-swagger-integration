package com.axamit.meetup.osgi.consumer;


import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;

import org.osgi.service.component.ComponentContext;


import com.axamit.meetup.api.*;


@Component
public class ConsumerService {
    
	@Reference
	AuthorsApi authorsApi;
	@Reference
	BooksApi booksApi;

    protected void activate(ComponentContext ctx) {
		System.out.println("Service com.axamit.meetup.osgi.consumer.SimpleDSComponent is activating");

		System.out.println(authorsApi.getAuthors().toBlocking().first());
		System.out.println(authorsApi.addAuthor(5, "surname 5", "name 5").toBlocking().first());
//		System.out.println(authorsApi.getAuthors().toBlocking().first());
		System.out.println(booksApi.getBooks().toBlocking().first());
		
		System.out.println("Service com.axamit.meetup.osgi.consumer.SimpleDSComponent has been activated");
    }
    
    protected void deactivate(ComponentContext ctx) {
		System.out.println("Service com.axamit.meetup.osgi.consumer.SimpleDSComponent is deactivating");
		System.out.println("Service com.axamit.meetup.osgi.consumer.SimpleDSComponent has been deactivated");
    }

}

