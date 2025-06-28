package br.com.mrb.biblioteca.models;

import java.util.Objects;

public class Book {
    private String title;
    private String author;
    private int edition;
    private final String isbn;

    public Book(String title, String author, int edition, String isbn) {
        this.title = title;
        this.author = author;
        this.edition = edition;
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public int getEdition() {
        return edition;
    }
    public String getIsbn() {
        return isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    @Override
    public String toString() {
        return "\u001B[1m" + getTitle() +  "\u001B[0m" +
                ", ano de publicação: " + getEdition() + "/ Autor: " + getAuthor() +
                "\u001B[1m" + "\u001B[32m" +" / ISBN: " + getIsbn() + "\u001B[0m";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return edition == book.edition && Objects.equals(title, book.title) && Objects.equals(author, book.author) && Objects.equals(isbn, book.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, edition, isbn);
    }
}
