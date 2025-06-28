package br.com.mrb.biblioteca.app;

import br.com.mrb.biblioteca.excecoes.BookNotFound;
import br.com.mrb.biblioteca.models.Library;
import br.com.mrb.biblioteca.models.Book;

public class Main {
    public static void main(String[] args) {

        try {
            System.out.println();

            Library.register(new Book("Meditações", "Marco Aurélio", 2010, "SLA0001"));
            Library.register(new Book("Java The Complete Reference", "Oracle", 2010, "SLA0002"));
            Library.register(new Book("Eu não sei", "Jonas Bullet", 2015, "SLA0003"));

            Library.list();

            System.out.println();

            Library.search("Jo");

            Library.remove("SLA0003");

            System.out.println();

            Library.list();

            Library.update("SLA0001", "Meditações", "Marco Aurélio", 170);

            System.out.println();

            Library.list();

            Library.update("ladfjfaasdlfaj", "jdfhadf", "alskdfaj", 1111);

        } catch (BookNotFound e) {
            System.out.println(e.getMessage());
        }
    }
}
