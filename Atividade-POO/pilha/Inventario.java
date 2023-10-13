package pilha;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Inventario implements InventarioIF {
    private List<ItemJogo> inventario;
    private int tamanho;

    public Inventario(int tamanho) {
        this.inventario = new ArrayList<>();
        this.tamanho = tamanho;
    }

    @Override
    public int getTamanho() {
        return tamanho;
    }

    @Override
    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    @Override
    public void adicionarItem(ItemJogo item) throws InventarioCheioException {
        if (inventario.size() < tamanho) {
            inventario.add(item);
        } else {
            throw new InventarioCheioException("O inventário está cheio. Não é possível adicionar mais itens.");
        }
    }

    @Override
    public void removerItem(int indice) {
        if (indice >= 0 && indice < inventario.size()) {
            inventario.remove(indice);
        }
    }

    @Override
    public boolean contemItem(ItemJogo item) {
        return inventario.contains(item);
    }

    @Override
    public List<ItemJogo> getInventario() {
        return inventario;
    }

    @Override
    public Iterator<ItemJogo> iterator() {
        return inventario.iterator();
    }

    @Override
    public void forEach(Consumer<? super ItemJogo> action) {
        // Deixe o corpo do método vazio
    }

    @Override
    public Spliterator<ItemJogo> spliterator() {
        // Deixe o corpo do método vazio e retorne null
        return null;
    }
}
