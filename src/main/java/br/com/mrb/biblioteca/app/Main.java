package br.com.mrb.biblioteca.app;

import br.com.mrb.biblioteca.excecoes.BookNotFound;
import br.com.mrb.biblioteca.models.Library;
import br.com.mrb.biblioteca.models.Book;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            Library.register(new Book("Meditações", "Marco Aurélio", 2010, "SLA0001"));
            Library.register(new Book("Java The Complete Reference", "Oracle", 2010, "SLA0002"));
            Library.register(new Book("Eu não sei", "Jonas Bullet", 2011, "SLA0003"));
            Library.register(new Book("Alguma Autoajuda", "Bonis Fried", 2012, "SLA0004"));
            Library.register(new Book("Alguém sabe?", "Jonas Bullet", 2013, "SLA0005"));
            Library.register(new Book("Outro livro", "João Pitangas", 2020, "SLA0006"));
            Library.register(new Book("Livro Verde", "Chico Coin", 2012, "SLA0007"));
            Library.register(new Book("Livrinho", "Marcos Silva", 2015, "SLA0008"));
            Library.register(new Book("Livraralho", "Machado de Assis", 1997, "SLA0009"));
            Library.register(new Book("O grande Livro", "Rent Jackson", 2015, "SLA0010"));
            Library.register(new Book("O mágico livro", "Rent Jackson", 2015, "SLA0011"));

            int menu_control = -1;
            while (menu_control != 0) {
                String menu = """
                        +-----------------------+
                        |  B I B L I O T E C A  |
                        +-----------------------+
                        |  0. Sair              |
                        |  1. Listar Livros     |
                        |  2. Buscar Livros     |
                        |  3. Remover Livro     |
                        |  4. Atualizar Livro   |
                        +-----------------------+
                        """;

                System.out.print(menu);
                menu_control = sc.nextInt();
                sc.nextLine();

                switch (menu_control) {
                    case 0:
                        System.out.print("Obrigado por usar o aplicativo, tenha um ótimo dia.");
                        break;
                    case 1:
                        Library.list();
                        break;
                    case 2:
                        System.out.print("Digite o nome do autor ou título:");
                        Library.search(sc.nextLine());
                        break;
                    case 3:
                        System.out.print("Digite o ISBN: ");
                        Library.remove(sc.nextLine());
                        break;
                    case 4:
                        System.out.print("Digite o ISBN: ");
                        String isbn = sc.nextLine();
                        System.out.print("Digite o título do livro: ");
                        String title = sc.nextLine();
                        System.out.print("Digite o nome do autor: ");
                        String author = sc.nextLine();
                        System.out.print("Digite o ano de publicação: ");
                        break;
                    default:
                        System.out.println("Entrada inválida, tente novamente.");
                }
            }
        } catch (BookNotFound e) {
            System.out.println(e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Entradas não numéricas não são válidas no menu, reinicie o aplicativo." + "\n" + e);
        }
    }
}
