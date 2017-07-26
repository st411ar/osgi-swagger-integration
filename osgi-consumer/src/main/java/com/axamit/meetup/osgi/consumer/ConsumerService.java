package com.axamit.meetup.osgi.consumer;


import java.util.List;


import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;

import org.osgi.service.component.ComponentContext;


import com.axamit.meetup.api.*;
import com.axamit.meetup.model.*;


@Component
public class ConsumerService {
    
	@Reference
	AuthorsApi authorsApi;
	@Reference
	BooksApi booksApi;

    protected void activate(ComponentContext ctx) throws InterruptedException {
		System.out.println("Service com.axamit.meetup.osgi.consumer.SimpleDSComponent is activating");

		System.out.println(authorsApi.getAuthors().toBlocking().first());
		Thread.sleep(1000);

		System.out.println(authorsApi.addAuthor(4, "surname 4", "name 4").toBlocking().first());
		Thread.sleep(1000);

		List<Author> authors = authorsApi.getAuthors().toBlocking().first();
		System.out.println(authors);
		Thread.sleep(1000);

		Author author = authors.get(2);
		System.out.println(booksApi.getBooks().toBlocking().first());
		Thread.sleep(1000);

		System.out.println(booksApi.addBook(4, "title 4", author.getId()).toBlocking().first());
		
		
		System.out.println("Service com.axamit.meetup.osgi.consumer.SimpleDSComponent has been activated");
    }
    
    protected void deactivate(ComponentContext ctx) {
		System.out.println("Service com.axamit.meetup.osgi.consumer.SimpleDSComponent is deactivating");
		System.out.println("Service com.axamit.meetup.osgi.consumer.SimpleDSComponent has been deactivated");
    }

}

