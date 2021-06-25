import java.util.Scanner;


public class StackJava {

    static Scanner sc=new Scanner(System.in);
    static int stack[],top=-1,size;
    static
    {
        StackJava.create();
    }
    public static void main(String[] args) {
   
        int ch;
        int item;
        while(true)
        {
            System.out.println("1.Push\n2.Pop\n3.Peek\n4.Traverse\n5.Quit");
            System.out.println("Enter Your Choice: ");
            ch=StackJava.sc.nextInt();
            
            switch(ch)
            {
                case 1: 
                        System.out.println("Enter element to insert in a stack: ");
                        item=StackJava.sc.nextInt();
                        push(item);
                        break;
                case 2: item=pop();
                        if(item==0)
                        {
                            System.out.println("Stack is empty");
                        }
                        else{
                            System.out.println("Popped item :"+item);
                        }
                        break;
                case 3: item=peek();
                        if(item==0)
                        {
                            System.out.println("Stack is empty");
                        }
                        else{
                            System.out.println("Top element is:"+item);
                        }
                        break;
                case 4: traverse();
                        break;
                case 5: System.exit(1);
                default: System.out.println("Invalid Chaoice...");
            }
        }
    }
    static void create(){
        
        System.out.println("Enter size of stack: ");
        size=StackJava.sc.nextInt();
        StackJava.stack=new int[size];
        System.out.println("Stack created with a size of "+size);
    }
    static void push(int element)
    {
        if(StackJava.isFull())
        {
            System.out.println("Stack is overflow\n");  
        }
        else
        {
            stack[++top]=element;
        }
    }
    static boolean isFull()
    {
        if(top==size-1)
            return true;
        else
            return false;
    }
    static int pop()
    {
        if(isEmpty())
        {
            return 0; 
        }
        else
        {
          return stack[top--];  
        }
    }
    static int peek()
    {
        if(isEmpty())
        {
            return 0; 
        }
        else
        {
          return stack[top];  
        }
    }
    static boolean isEmpty()
    {
        if(top==-1)
            return true;
        else
            return false;
    }
    static void traverse()
    {
        if(isEmpty())
        {
            System.out.println("Stack is empty");
        }
        else
        {
            System.out.println("Elements in stack :");
            for(int i=top;i>=0;i--)
            {
                System.out.println(stack[i]);
            }
        }
    }
}
