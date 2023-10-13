package jogo;

public class Inimigo extends Personagem implements Ataque {
    private int vida;
    private int dano;

    public Inimigo(String nome, int vida, int dano) {
        super(nome);
        this.vida = vida;
        this.dano = dano;
    }

    @Override
    public void atacar(Personagem personagem) {
        int dano = this.dano;
        personagem.receberDano(dano);
        System.out.println("O inimigo " + getNome() + " atacou você causando " + dano + " de dano.");
    }

    public void receberDano(int dano) {
        vida -= dano;
        System.out.println("O inimigo " + getNome() + " recebeu " + dano + " de dano. Vida restante: " + vida);
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    @Override
    public void exibir() {

    }
}