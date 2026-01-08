class Node 
{
    int data;
    Node next;
    
    Node(int data) 
    {
        this.data = data;
        this.next = null;
    }
}

class Stack 
{
    private Node top;
    
    public Stack() {
        this.top = null;
    }
    
    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
        System.out.println(data + " pushed to stack");
    }
    
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        int popped = top.data;
        top = top.next;
        return popped;
    }
    
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return top.data;
    }
    
    public boolean isEmpty() {
        return top == null;
    }
    
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        Node temp = top;
        System.out.print("Stack: ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

public class StackUsingLinkedList 
{
    public static void main(String[] args) 
    {
        Stack stack = new Stack();


        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        
        stack.display();
        
        System.out.println("Top element: " + stack.peek());
        
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Popped element: " + stack.pop());
        
        stack.display();
        
        System.out.println("Is stack empty? " + stack.isEmpty());
    }
}