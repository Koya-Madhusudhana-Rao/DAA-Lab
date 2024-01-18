import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner sc  = new Scanner(System.in);
        int nums[] = {1,2,3,4,5};
        System.out.println("Enter the target element between 1-10");
        int target = sc.nextInt();
        int result  = binarySearch(nums, target);
        if(result == -1){
            System.out.println("Element not found");
            
        }else{
        System.out.println("Index of the target element is "+result);}

        
    }
    public static int binarySearch(int nums[], int target){
        int start = 0;
        int end = nums.length-1;
        int steps = 0;

        while(start<=end){
            steps++;
            
            int mid = (start+end)/2;
            if(nums[mid]==target){
                System.out.println("Number of steps taken to search is "+ steps);
                return mid;
            }else if(nums[mid]>target){
                end =  mid-1;
            }
            else{
                start= mid +1;
            }
            
            

            }
            System.out.println("Number of steps taken to search is "+ steps);
            return -1;
            
        }
    }

