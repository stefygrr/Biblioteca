package biblioteca;

import java.util.Scanner;
import java.util.ArrayList;

public class GestaoBiblioteca {
    private ArrayList<Livros> acervo;
    private Scanner sc;

    public GestaoBiblioteca() {
        acervo = new ArrayList<>();
        sc = new Scanner(System.in);
    }

    public void exibirMenu() {
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Adicionar livro");
            System.out.println("2. Mostrar todos os livros do acervo");
            System.out.println("3. Emprestar livro");
            System.out.println("4. Devolver livro");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    adicionarLivro();
                    break;
                case 2:
                    mostrarLivros();
                    break;
                case 3:
                    emprestarLivro();
                    break;
                case 4:
                    devolverLivro();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    sc.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

    private void adicionarLivro() {
        System.out.print("Digite o título do livro: ");
        String titulo = sc.nextLine(); 
        System.out.print("Digite o autor do livro: ");
        String autor = sc.nextLine(); 

        System.out.print("Digite o número de páginas do livro: ");
        int numPaginas = sc.nextInt();
        sc.nextLine(); 

        Livros livro = new Livros(titulo, autor, numPaginas);
        acervo.add(livro);
        System.out.println("Livro adicionado com sucesso!");
    }

    private void mostrarLivros() {
        System.out.println("Livros no acervo:");
        for (Livros livro : acervo) {
            System.out.println(livro);
        }
    }

    private void emprestarLivro() {
        System.out.print("Digite o título do livro que deseja emprestar: ");
        String titulo = sc.nextLine();
        boolean encontrado = false;
        for (Livros livro : acervo) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                if (livro.isDisponivel()) {
                    livro.emprestarLivro();
                    System.out.println("Livro emprestado com sucesso!");
                } else {
                    System.out.println("Livro indisponível para empréstimo.");
                }
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Livro não encontrado no acervo.");
        }
    }

    private void devolverLivro() {
        System.out.print("Digite o título do livro que deseja devolver: ");
        String titulo = sc.nextLine();
        boolean encontrado = false;
        for (Livros livro : acervo) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                if (!livro.isDisponivel()) {
                    livro.devolverLivro();
                    System.out.println("Livro devolvido com sucesso!");
                } else {
                    System.out.println("Este livro já está disponível na biblioteca.");
                }
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Livro não encontrado no acervo.");
        }
    }

    public static void main(String[] args) {
        GestaoBiblioteca biblioteca = new GestaoBiblioteca();
        biblioteca.exibirMenu();
    }
}