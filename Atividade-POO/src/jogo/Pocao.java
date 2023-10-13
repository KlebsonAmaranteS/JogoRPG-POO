package jogo;

public class Pocao extends Item {
    private int cura;

    public Pocao(String nome, int preco, int cura) {
        super(nome, preco);
        this.cura = cura;
    }

    public int getCura() {
        return cura;
    }

    public void setCura(int cura) {
        this.cura = cura;
    }
}
