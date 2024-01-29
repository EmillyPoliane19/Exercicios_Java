package Faculdade;

import java.util.Scanner;

public class Agenda {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System .in);
        System.out.println("Bem Vindo a Agenda");
        System.out.println("Escolha uma das opções, utilize os números para escolher:");

        int opcao = 1; 
        Contato[] agenda = new Contato[50];

        while (opcao != 3) {
            System.out.println("[1] Buscar contato.\n[2] Adicionar novo contato.\n[3] Sair");
            opcao = sc.nextInt();
            sc.nextLine();

            if (opcao == 1) {
                System.out.println("Qual o nome?");
                String escolha = sc.next();
                sc.nextLine();

                Contato busca = new Contato();
                String buscar = busca.buscarContato(agenda,escolha,sc);

                if (buscar == null) {
                    System.out.println("Contato não encontrado!\n");

                } else {
                    System.out.println(buscar);
                    continue;
                }

            } if (opcao == 2) {
                System.out.print("Nome:");
                String nome = sc.nextLine();

                System.out.print("Telefone:");
                String numero = sc.nextLine();

                System.out.print("Email:");
                String email = sc.nextLine();

                Contato pessoa = new Contato(nome, numero, email);
                String adicionar = pessoa.adicionarContato(agenda,pessoa);

                System.out.println(adicionar);
                continue;
            }
            sc.nextLine();
        }
    }
}
