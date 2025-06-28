package br.com.mrb.biblioteca.excecoes;

public class BookNotFound extends Exception {
    public BookNotFound() {
        super("Livro não encontrado.");
    }
}
