package example.springframework.spring5webapp.bootstrap;

import example.springframework.spring5webapp.model.Author;
import example.springframework.spring5webapp.model.Book;
import example.springframework.spring5webapp.repository.AuthorRepository;
import example.springframework.spring5webapp.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started");

        Author firstA = new Author("Nadir", "Jabbarli");
        Book firstB = new Book("Lucky Man", "12123");

        System.out.println("1111" + firstA);

        firstA.getBooks().add(firstB);
        firstB.getAuthors().add(firstA);
        System.out.println("2222   " + firstA);
        authorRepository.save(firstA);
        bookRepository.save(firstB);

        System.out.println("Number of books" + bookRepository);
    }
}
