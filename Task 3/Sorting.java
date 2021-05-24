import java.util.*;
interface Sort
{
    public int[] sort(int a[],int n);
}
interface Sort1
{
    public int[] sort(int a[],int l,int r);
}
class SelectionSort implements Sort
{
    public int[] sort(int a[],int n)
    {   int min,temp;
        for(int i=0;i<n;i++)
        {
            min=i;
            for(int j=i+1;j<n;j++)
            {
                if(a[j]<a[min])
                {
                    min=j;
                }
            }
            temp=a[i];
            a[i]=a[min];
            a[min]=temp;
            
        }
        return a;
    }
}
class BubbleSort implements Sort
{
    public int[] sort(int a[],int n)
    {   int temp;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n-i-1;j++)
            {
                if(a[j+1]<a[j])
                {
                    temp=a[j+1];
                    a[j+1]=a[j];
                    a[j]=temp;
                }
            }
        }
        return a;
    }
}
class InsertionSort implements Sort
{
    public int[] sort(int a[],int n)
    {
        int j,key;
        for(int i=1;i<n;i++)
        {
            key=a[i];
            j=i-1;
            while(j>=0 && key<a[j])
            {
                a[j+1]=a[j];
                j-=1;
            }
            a[j+1]=key;
        }
        return a;
    }
}
class MergeSort implements Sort1
{
    void merge(int a[], int l, int m, int r)
    {
        int i=l,j=m+1,k,index=l;
        int z[]=new int[100];
        while(i<=m && j<=r)
        {
            if(a[i]<a[j])
            {
                z[index++]=a[i];
                i++;
            }
            else
            {
                z[index++]=a[j];
                j++;
            }
        }
        while(i<=m)
        {
            z[index++]=a[i];
            i++;
        }
        while(j<=r)
        {
            z[index++]=a[j];
            j++;
        }
        k=l;
        while(k<index)
        {
            a[k]=z[k];
            k++;
        }

    }
 
    public int[] sort(int a[], int l, int r)
    {
        if (l < r) {
            int m =(l+r)/2;
            sort(a, l, m);
            sort(a, m + 1, r);
            merge(a, l, m, r);
        }
        return a;
    }
}
class QuickSort implements Sort1
{
    int partition(int a[], int low, int high) { 
        int p = a[high];  
        int i = (low-1);   
        for (int j=low; j<high; j++) { 
            if (a[j] <= p) { 
                i++;
                int temp = a[i]; 
                a[i] = a[j]; 
                a[j] = temp; 
            } 
        }
        int temp = a[i+1]; 
        a[i+1] = a[high]; 
        a[high] = temp; 
        return i+1; 
    } 
   
    public int[] sort(int a[], int low, int high) { 
        if (low < high) { 
            int pi = partition(a, low, high);  
            sort(a, low, pi-1); 
            sort(a, pi+1, high); 
        } 
        return a;
    } 
}
public class Sorting
{
    public static void main(String[] args) {
        int n;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        n=sc.nextInt();
        int a[]= new int[n];
        System.out.println("Enter the Elements");
        for(int i=0;i<n;i++)
        {
            a[i]=sc.nextInt();
        }
        System.out.println("Enter your choice:\n1.Selection Sort\n2.Bubble Sort\n3.Insertion Sort\n4.Merge Sort\n5.Quick Sort");
        int ch=sc.nextInt();
        int[] l={};
        switch(ch)
        {
            case 1: SelectionSort s=new SelectionSort();l=s.sort(a,n);break;
            case 2: BubbleSort b=new BubbleSort();l=b.sort(a,n);break;
            case 3: InsertionSort i=new InsertionSort();l=i.sort(a,n);break;
            case 4: MergeSort m=new MergeSort();l=m.sort(a,0,n-1);break;
            case 5: QuickSort q=new QuickSort();l=q.sort(a,0,n-1);break; 
            default: System.out.println("Wrong Choice"); 
        }
        
        display(l,n);

        
    }
    public static void display(int a[],int n)
    {
        System.out.println("The Sorted array is:");
        for(int i=0;i<n;i++)
        {
            System.out.print(a[i]+" ");
        }
    }
}