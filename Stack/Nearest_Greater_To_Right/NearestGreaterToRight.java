import java.util.*;
 
class NextGreaterToRight {
 
    public static void printNGE(int[] arr)
    {
        Stack<Integer> s = new Stack<>();
        int nge[] = new int[arr.length];
 
        // iterate for rest of the elements
        for (int i = arr.length - 1; i >= 0; i--)
        {
            
            if (!s.empty())
            {
                while (!s.empty()
                       && s.peek() <= arr[i])
                {
                    s.pop();
                }
            }
            nge[i] = s.empty() ? -1 : s.peek();
            s.push(arr[i]);
        }
        for (int i = 0; i < arr.length; i++)
            System.out.println(arr[i] +
                               " --> " + nge[i]);
    }
 
    /* Driver Code */
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        int arr[]=new int[n];

        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        System.out.println(printNGE(arr));
    }
}