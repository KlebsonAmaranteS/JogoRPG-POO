package pilha;

import java.util.Arrays;

public class Pilha implements Stack {
    private int capacity;
    private String[] stackArray;
    private int top;

    public Pilha(int capacity) {
        this.capacity = capacity;
        this.stackArray = new String[capacity];
        this.top = -1;
    }

    @Override
    public void push(String item) {
        if (isFull()) {
            System.out.println("A pilha está cheia. Não é possível adicionar mais elementos.");
        } else {
            stackArray[++top] = item;
        }
    }

    @Override
    public String pop() {
        if (isEmpty()) {
            System.out.println("A pilha está vazia. Não é possível remover elementos.");
            return null;
        } else {
            String poppedItem = stackArray[top];
            stackArray[top--] = null; // Limpa o item removido
            return poppedItem;
        }
    }

    @Override
    public String peek() {
        if (isEmpty()) {
            return null;
        } else {
            return stackArray[top];
        }
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public boolean isFull() {
        return top == capacity - 1;
    }

    @Override
    public String toString() {
        return "Pilha{" +
                "stackArray=" + Arrays.toString(stackArray) +
                '}';
    }
}
