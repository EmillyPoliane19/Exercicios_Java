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
                boolean i = false;
                Contato verificar = new Contato();

                String nome = "";
                String numero = "";
                String email = "";

                while (i == false) {

                    System.out.print("Nome:");
                    nome = sc.nextLine();
                    boolean testeNome = verificar.verificarCaracter(nome);

                    if (!testeNome) {
                        System.out.println("Hmmm...Parece que o nome possuie números, escreva novamente:");
                        nome = sc.nextLine();
                        testeNome = verificar.verificarCaracter(nome);
                    }

                    System.out.print("Telefone:");
                    numero = sc.nextLine();
                    boolean testeNumero = verificar.verificarDigito(numero);

                    if (!testeNumero) {
                        System.out.println("Hmmm...Parece que o numero possuie letras, escreva novamente:");
                        numero = sc.nextLine();
                        testeNumero = verificar.verificarDigito(numero);
                    }

                    System.out.print("Email:");
                    email = sc.nextLine();
                    boolean testeEmail = verificar.verificarEmail(email);

                    if (!testeEmail) {
                        System.out.println("Hmmm...Parece que o email não possuie @, escreva novamente:");
                        email = sc.nextLine();
                        testeEmail = verificar.verificarEmail(email);
                    }

                    if (testeNome && testeNumero && testeEmail) {
                        i = true;
                        System.out.println("Verificando...");

                    } else if (!i) {
                        System.out.println("Hmmm...Parece que tem algo errado, tente novamente!");
                    }

                }

                Contato pessoa = new Contato(nome, numero, email);

                String adicionar = pessoa.adicionarContato(agenda, pessoa);
                System.out.println(adicionar);

                continue;
            }
            sc.nextLine();
        }
    }
}
