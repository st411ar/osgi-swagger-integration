package io.swagger.api.impl;

import java.util.ArrayList;
import java.util.List;

import io.swagger.model.Author;
import io.swagger.model.Book;


public class Util {
	public static List<Book> books = new ArrayList<>();
	public static List<Author> authors = new ArrayList<>();

	static {
		Author author1 = new Author().id(1).name("name 1").surname("surname 1");
		Author author2 = new Author().id(2).name("name 2").surname("surname 2");
		Author author3 = new Author().id(3).name("name 3").surname("surname 3");

		authors.add(author1);
		authors.add(author2);
		authors.add(author3);

		books.add(new Book().id(1).title("title 1").author(author1));
		books.add(new Book().id(2).title("title 2").author(author2));
		books.add(new Book().id(3).title("title 3").author(author3));
	}


	public static List<Book> getBooks() {
		return books;
	}

	public static Book getBook(int id) {
		for (Book book : books) {
			if (book.getId() == id) {
				return book;
			}
		}
		return null;
	}

	public static boolean addBook(int id, String title, int authorId) {
		Author author = getAuthor(authorId);
		if (author == null) {
			return false;
		}
		if (getBook(id) != null) {
			return false;
		}
		books.add(new Book().id(id).title(title).author(author));
		return true;
	}


	public static List<Author> getAuthors() {
		return authors;
	}

	public static Author getAuthor(int id) {
		for (Author author : authors) {
			if (author.getId() == id) {
				return author;
			}
		}
		return null;
	}

	public static boolean addAuthor(int id, String surname, String name) {
		if (getAuthor(id) != null) {
			return false;
		}
		authors.add(new Author().id(id).surname(surname).name(name));
		return true;
	}
}