import java.util.*;

class LargestRectangle{

    //main method.....
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();

        int h[]=new int[n];

        for(int i=0;i<n;i++)
        {
            h[i]=sc.nextInt();
        }

        int max=largestRectangleArea(h);
        System.out.println(max);
    }

    //pair class....
    public class Pair
    {
        int item;
        int idx;
        
        Pair(int item, int idx)
        {
            this.item=item;
            this.idx=idx;
        }
    }

    //to find largest rectangle area method.....
    public static int largestRectangleArea(int[] heights) {
        int left[]=NSTL(heights);
        int right[]=NSTR(heights);
        for(int i=0;i<heights.length;i++)
        {
            right[i] = ((right[i]-1) - (left[i]+1) + 1) * heights[i];
        }
        int max = right[0];
        for(int i=1;i<right.length;i++){
            if(right[i] > max){
                max = right[i];
            }
        }
        return max;
    }
    
    //next smaller to left method...
    private int[] NSTL(int[] arr)
    {
        int ng[]=new int[arr.length];
        Pair p;
        Stack<Pair> stack=new Stack<>();
        for(int i=0;i<arr.length;i++)
        {
            if(!stack.empty())
            {
                while(!stack.empty() && stack.peek().item>=arr[i])
                   stack.pop();
            }
            
            ng[i]=stack.empty()?-1:stack.peek().idx;
            
            stack.push(new Pair(arr[i],i));
        }
        
        return ng;
    }
    
    //next smaller to right method....
    private int[] NSTR(int[] arr)
    {
        Stack<Pair> s = new Stack<>();
        int nge[] = new int[arr.length];
        Pair temp=new Pair(-1,-1);
        for (int i = arr.length - 1; i >= 0; i--)
        {
            
            if (!s.empty())
            {
                while (!s.empty()
                       && s.peek().item >= arr[i])
                {
                    s.pop();
                }
            }
            nge[i] = s.empty() ? arr.length : s.peek().idx;
            s.push(new Pair(arr[i],i));
        }
        
        return nge;
    }
}