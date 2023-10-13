package jogo;
public class Arma extends Item {
    private int dano;

    public Arma(String nome, int preco, int dano) {
        super(nome, preco);
        this.dano = dano;
    }

    public int getDano() {
        return dano;
    }
}
