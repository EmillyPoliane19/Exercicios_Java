package Faculdade;

import java.util.Scanner;

public class Contato {
    String nome;
    String numero;
    String email;

    Contato () {}

    Contato (String nome, String numero, String email) {
        this.nome = nome;
        this.numero = numero;
        this.email = email;
    }

    String buscarContato (Contato [] agenda, String nome,Scanner sc) {
        for (Contato contato : agenda) {
            if (contato != null && contato.nome.contains(nome)) {
                return contato.status();
            } else if (agenda[0] == null) {
                return "Agenda vazia!\nQue tal escolher outra opção?";
            }
        }
        return null;
    }

    String adicionarContato (Contato [] agenda, Contato pessoa) {
        for (int i = 0; i < agenda.length; i++) {
            if (agenda[i] == null) {
                agenda[i] = pessoa;
                return "Contato adicionado!";
            }
        }
        return "A agenda está cheia!";
    }

    String status () {
        return "Nome: " + nome + "\nNúmero: " + numero + "\nEmail: " + email + "\n";
    }

    boolean verificarDigito (String numero){
        int contagemLetra = 0;
        for (int i = 0; i < numero.length(); i++) {
            char letra = numero.charAt(i);

            if(!Character.isDigit(letra)) {
                contagemLetra ++;
            }
        }

        if (contagemLetra > 0){
            return false;
        }

        return true;
    }
    boolean verificarCaracter (String palavra){
        int contagemDigito = 0;

        for (int i = 0; i < palavra.length(); i++) {
            char letra = palavra.charAt(i);
            if(Character.isDigit(letra)) {
                contagemDigito ++;
            }
        }

        if (contagemDigito > 0){
            return false;
        }

        return true;
    }

    boolean verificarEmail(String email) {
        String teste = "@";
        if (email.contains(teste)) {
            return true;
        }
        return false;
    }
}
