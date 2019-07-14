package com.springtraining.spring5webapp.bootstrap;

import com.springtraining.spring5webapp.model.Author;
import com.springtraining.spring5webapp.model.Book;
import com.springtraining.spring5webapp.model.Publisher;
import com.springtraining.spring5webapp.repositories.AuthorRepository;
import com.springtraining.spring5webapp.repositories.BookRepository;
import com.springtraining.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootStrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){

        Author eric = new Author("Eric", "evans");
        Publisher ericPublisher = new Publisher("The Eric publisher", "484 eric street");
        Book ericBook = new Book("Eric Book", "1235", ericPublisher);
        eric.getBooks().add(ericBook);
        ericBook.getAuthors().add(eric);

        authorRepository.save(eric);
        publisherRepository.save(ericPublisher);
        bookRepository.save(ericBook);

        Author rod = new Author("Rod", "johnson");
        Publisher rodPublisher = new Publisher("Rod publisher", "8448 weirdo street");
        Book rodBook = new Book("Rod Book", "12348785", rodPublisher);
        rod.getBooks().add(rodBook);
        rodBook.getAuthors().add(rod);

        authorRepository.save(rod);
        publisherRepository.save(rodPublisher);
        bookRepository.save(rodBook);
    }
}
