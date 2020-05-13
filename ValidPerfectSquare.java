/*Given a positive integer num, write a function which returns True if num is a perfect square else False.

Note: Do not use any built-in library function such as sqrt.

Example 1:

Input: 16
Output: true
Example 2:

Input: 14
Output: false*/

class Solution {
    public int perfectSquare(int num)
    {
        int start =1, end=num/2,  ans =0;
        while(start<=end)
        {
            int mid= start+(end -start)/2;
            long k =(long)mid*(long)mid;
            if(k==num)
            {
                return mid;
            }
            if(k>num)
            {
                end=mid-1;
                ans=mid;
            }
            else
            {
                start=mid+1;
            }
        }
        return ans;
    }
    public boolean isPerfectSquare(int num) {
        if(num<1)
        {
            return false;
        }
        if( num==1)
        {
            return true;
        }
        int x=perfectSquare(num);
        //System.out.println(x);
        if(x*x==num)
        {
            return true;
        }
        return false;
        
        
    }
}
