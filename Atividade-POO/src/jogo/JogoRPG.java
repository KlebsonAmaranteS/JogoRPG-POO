package jogo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JogoRPG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Cria o personagem do jogador
        System.out.print("Digite o nome do seu personagem: ");
        String nomePersonagem = scanner.nextLine();
        Personagem jogador = new Personagem(nomePersonagem);

        // Cria um inimigo
        Personagem inimigo = new Inimigo("Patrulha Alemã", 50, 10);

        // Cria territórios
        Territorio territorio1 = new Territorio("Território Alemão");
        Territorio territorio2 = new Territorio("Território Francês");
        Territorio territorio3 = new Territorio("Território Britânico");

        // Adiciona algumas armas à loja
        List<Arma> lojaArmas = new ArrayList<>();
        lojaArmas.add(new Arma("Pistola", 20, 20));
        lojaArmas.add(new Arma("Fuzil", 40, 40));
        lojaArmas.add(new Arma("Granada", 20, 40));

        // Adiciona poções de cura à loja
        List<Pocao> lojaPocoes = new ArrayList<>();
        lojaPocoes.add(new Pocao("Poção de Cura Fraca", 10, 10));
        lojaPocoes.add(new Pocao("Poção de Cura Forte", 20, 30));

        System.out.println("Bem-vindo ao Jogo de RPG - Guerra na Década de 40!");
        System.out.println("Você está enfrentando a Patrulha Alemã.");
        jogador.exibir();

        while (true) {
            System.out.println("\nAções disponíveis:");
            System.out.println("1. Atacar");
            System.out.println("2. Listar Itens");
            System.out.println("3. Comprar Armas");
            System.out.println("4. Comprar Poções");
            System.out.println("5. Usar Poção");
            System.out.println("6. Sair do Jogo");

            System.out.print("Escolha uma ação: ");
            int escolha = scanner.nextInt();

            if (inimigo.getVida() <= 0) {

            }

            switch (escolha) {
                case 1:
                    jogador.atacar(inimigo);
                    if (inimigo.getVida() <= 0) {
                        System.out.println("Você derrotou a Patrulha Alemã e conquistou o território!");
                        int aumentarMoedas = jogador.getVida() + 10;
                        System.out.printf("Suas moedas foram aumentadas por derrotar o inimigo, agora você tem %d de moedas\n", aumentarMoedas);
                        System.out.println("Fim do jogo.");
                        scanner.close();
                        return;
                    }
                    inimigo.atacar(jogador);
                    if (jogador.getVida() <= 0) {
                        System.out.println("Você foi derrotado pela Patrulha Alemã.");
                        System.out.println("Fim do jogo.");
                        scanner.close();
                        return;
                    }
                    break;
                case 2:
                    jogador.listarItens();
                    break;
                case 3:
                    System.out.println("Armas disponíveis na loja:");
                    for (int i = 0; i < lojaArmas.size(); i++) {
                        Arma arma = lojaArmas.get(i);
                        System.out.println((i + 1) + ". " + arma.getNome() + " (Preço: " + arma.getPreco() + ")  (Dano : " +  arma.getDano()+ ")");
                    }
                    System.out.print("Escolha uma arma para comprar (0 para sair): ");
                    int escolhaArma = scanner.nextInt();
                    if (escolhaArma > 0 && escolhaArma <= lojaArmas.size()) {
                        Arma armaSelecionada = lojaArmas.get(escolhaArma - 1);
                        jogador.comprar(armaSelecionada);
                    }
                    break;
                case 4:
                    System.out.println("Poções disponíveis na loja:");
                    for (int i = 0; i < lojaPocoes.size(); i++) {
                        Pocao pocao = lojaPocoes.get(i);
                        System.out.println((i + 1) + ". " + pocao.getNome() + " (Preço: " + pocao.getPreco() + ")");
                    }
                    System.out.print("Escolha uma poção para comprar (0 para sair): ");
                    int escolhaPocao = scanner.nextInt();
                    if (escolhaPocao > 0 && escolhaPocao <= lojaPocoes.size()) {
                        Pocao pocaoSelecionada = lojaPocoes.get(escolhaPocao - 1);
                        jogador.comprarPocao(pocaoSelecionada);
                    }
                    break;
                case 5:
                    jogador.usarPocao();
                    break;
                case 6:
                    System.out.println("Você desistiu da batalha.");
                    System.out.println("Fim do jogo.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Escolha uma ação válida!");
            }
        }
    }
}
