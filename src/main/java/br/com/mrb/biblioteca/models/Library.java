package br.com.mrb.biblioteca.models;

import br.com.mrb.biblioteca.excecoes.BookNotFound;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Library
{
    static private final List<Book> collection = new ArrayList<>();

    private Library(){}

    static public void register(Book book) {
        collection.add(book);
    }

    static public void list() {
        collection.forEach(System.out::println);
    }

    static public void search(String search) {
        collection.stream().filter(book -> {
            if(book.getTitle().toLowerCase().startsWith(search.toLowerCase())) return true;
            else return book.getAuthor().toLowerCase().startsWith(search.toLowerCase());
        }).forEach(System.out::println);
    }

    static public void remove(String isbn) throws BookNotFound {
        Optional<Book> rmBook = collection.stream().filter(book -> book.getIsbn().equalsIgnoreCase(isbn)).findAny();
        if (rmBook.isPresent()) collection.remove(rmBook.orElseThrow(BookNotFound::new));
    }

    static public void update(String isbn, String title, String author, int edition) throws BookNotFound {
        Optional<Book> findBook = collection.stream().filter(book -> book.getIsbn().equalsIgnoreCase(isbn)).findAny();
        int index = collection.indexOf(findBook.orElseThrow(BookNotFound::new));
        collection.get(index).setTitle(title);
        collection.get(index).setAuthor(author);
        collection.get(index).setEdition(edition);
    }
}
