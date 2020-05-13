/*You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once. Find this single element that appears only once.

 

Example 1:

Input: [1,1,2,3,3,4,4,8,8]
Output: 2
Example 2:

Input: [3,3,7,7,10,11,11]
Output: 10
 

Note: Your solution should run in O(log n) time and O(1) space.*/

class Solution {
    static int x=0;
    void search(int[] array, int start, int end)
    {
        if(start>end)
        {
            return;
        }
        if(start==end)
        {
            x=array[start];
            return;
        }
        int mid=(start+end)/2;
        //System.out.println("start is "+start+"  end is "+ end+ " mid is "+mid);
        if(mid%2==0)
        {
            if(array[mid]==array[mid+1])
            {
                search(array, mid+2, end);
            }
            else
            {
                search(array, start, mid);
            }
        }
        else
        {
            if(array[mid]==array[mid-1])
            {
                search(array, mid+1, end);
            }
            else
            {
                search(array, start, mid-1);
            }
        }
    }
    public int singleNonDuplicate(int[] nums) {
        search (nums, 0, nums.length-1);
        int y=0;
        y=x;
        x=0;
        return y;
        
    }
}
