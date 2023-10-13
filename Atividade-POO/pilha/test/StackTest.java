package pilha.test;

import org.junit.jupiter.api.Test;
import pilha.Pilha;
import pilha.Stack;

import static org.junit.jupiter.api.Assertions.*;


public class StackTest {

    @Test
    void testPushPeek() {
        Stack stack = new Pilha(10);
        assertNull(stack.peek());
        assertTrue(stack.isEmpty());
        stack.push("a");
        assertEquals("a", stack.peek());
        stack.push("b");
        assertEquals("b", stack.peek());
        stack.push("c");
        assertEquals("c", stack.peek());
        stack.push("d");
        assertEquals("d", stack.peek());
        stack.push("e");
        assertEquals("e", stack.peek());
        stack.push("f");
        assertEquals("f", stack.peek());
        stack.push("g");
        assertEquals("g", stack.peek());
        stack.push("h");
        assertEquals("h", stack.peek());
        stack.push("i");
        assertEquals("i", stack.peek());
        stack.push("j");
        assertEquals("j", stack.peek());
        stack.push("k");
        assertEquals("j", stack.peek());
        stack.push("l");
        assertEquals("j", stack.peek());
        assertTrue(stack.isFull());
    }

    @Test
    void testPushPop() {
        Stack stack = new Pilha(10);
        stack.push("a");
        stack.push("b");
        stack.push("c");
        assertEquals("c", stack.pop());
        assertEquals("b", stack.peek());
        stack.push("d");
        stack.push("e");
        assertEquals("e", stack.pop());
        assertEquals("d", stack.pop());
        assertEquals("b", stack.pop());
        assertEquals("a", stack.peek());
        assertEquals("a", stack.pop());
        assertNull(stack.peek());
    }
}