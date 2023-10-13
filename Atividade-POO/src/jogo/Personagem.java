package jogo;

import java.util.*;

public class Personagem implements Ataque, InventarioComerciante {
    private String nome;
    private int vida;
    private int moedas;
    List<Arma> inventarioArmas;
    List<Pocao> inventarioPocoes;
    Set<Territorio> territoriosConquistados;

    public Personagem(String nome) {
        this.nome = nome;
        this.vida = 100;
        this.moedas = 50;
        this.inventarioArmas = new ArrayList<>();
        this.inventarioPocoes = new ArrayList<>();
        this.territoriosConquistados = new HashSet<>();
    }

    @Override
    public void atacar(Personagem inimigo) {
        if (inventarioArmas.isEmpty()) {
            System.out.println("Você não tem armas para atacar!");
            return;
        }

        Arma armaEscolhida = escolherArma();
        int dano = armaEscolhida.getDano();
        inimigo.receberDano(dano);
        System.out.println("Você atacou o inimigo com " + armaEscolhida.getNome() + " causando " + dano + " de dano.");
    }

    @Override
    public void comprar(Item item) {
        if (moedas >= item.getPreco()) {
            moedas -= item.getPreco();
            if (item instanceof Arma) {
                inventarioArmas.add((Arma) item);
                System.out.println("Você comprou " + item.getNome() + ".");
            } else if (item instanceof Pocao) {
                inventarioPocoes.add((Pocao) item);
                System.out.println("Você comprou uma " + item.getNome() + ".");
            }
        } else {
            System.out.println("Você não tem moedas suficientes para comprar " + item.getNome() + ".");
        }
    }

    @Override
    public void exibir() {
        System.out.printf("Você inicia o jogo com %d mooedas\n", this.getMoedas());
        System.out.printf("Você inicia o jogo com %d de vida\n", this.getVida());
    }

    // Método para comprar poções de cura
    public void comprarPocao(Pocao pocao) {
        comprar(pocao);
    }

    // Método para usar uma poção de cura
    public void usarPocao() {
        if (!inventarioPocoes.isEmpty()) {
            Pocao pocao = inventarioPocoes.get(0); // Assume que o jogador usa a primeira poção no inventário
            int cura = pocao.getCura();
            vida += cura;
            inventarioPocoes.remove(pocao);
            System.out.println("Você usou uma " + pocao.getNome() + " e recuperou " + cura + " de vida.");
        } else {
            System.out.println("Você não tem poções de cura no inventário.");
        }
    }

    // Método para conquistar um território
    public void conquistarTerritorio(Territorio territorio) {
        territoriosConquistados.add(territorio);
        System.out.println("Você conquistou o território de " + territorio.getNome() + "!");
    }

    public void receberDano(int dano) {
        vida -= dano;
        System.out.println("Você recebeu " + dano + " de dano. Vida restante: " + vida);
    }

    public void listarItens() {
        System.out.println("Inventário de Armas:");
        for (int i = 0; i < inventarioArmas.size(); i++) {
            Arma arma = inventarioArmas.get(i);
            System.out.println((i + 1) + ". " + arma.getNome() + " (Dano: " + arma.getDano() + ")");
        }
        System.out.println("Inventário de Poções:");
        for (int i = 0; i < inventarioPocoes.size(); i++) {
            Pocao pocao = inventarioPocoes.get(i);
            System.out.println((i + 1) + ". " + pocao.getNome() + " (Cura: " + pocao.getCura() + ")");
        }
    }

    public Arma escolherArma() {
        Scanner scanner = new Scanner(System.in);
        listarItens();
        System.out.print("Escolha uma arma: ");
        int escolha = scanner.nextInt();
        return inventarioArmas.get(escolha - 1);
    }

    public String getNome() {
        return nome;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getMoedas() {
        return moedas;
    }

    public void setMoedas(int moedas) {
        this.moedas = moedas;
    }

}
