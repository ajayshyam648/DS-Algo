public class NearestSmallerToLeft {

    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        
        int array[]=NSTL(arr);
        for(int i:array)
            System.out.print(i+" ");
    }

    private static int[] NSTL(int[] arr) {
        int ng[]=new int[arr.length];
        Stack<Integer> stack=new Stack<>();
        
        for(int i=0;i<arr.length;i++)
        {
            if(!stack.empty())
            {
                while(!stack.empty() && stack.peek()>=arr[i])
                    stack.pop();
            }
            
            ng[i]=stack.isEmpty()?-1:stack.peek();
            
            stack.push(arr[i]);
        }
        
        return ng;
    }
    
}