/*You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.

Example:

Given n = 5, and version = 4 is the first bad version.

call isBadVersion(3) -> false
call isBadVersion(5) -> true
call isBadVersion(4) -> true

Then 4 is the first bad version. */


/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        //int x=0;
        //int a=n;
        //int m=0;
        
        /*for(x=1;x<n+1;x++)
        {
            if(isBadVersion(x)==true)
            {
                break;
            }
        }
        //turn 1;*/
        /*
        while(x<=n)
        {
            if(m>1 && isBadVersion(m)==true && isBadVersion(m-1)==false)
            {
                //x=m+1;
                break;
            }
            m=x+(a-x)/2;
            
            
            if (isBadVersion(x)==false)
            {
                x=m+1;
            }
            else
                a=m-1;
        }*/
        return search(0,n);
    }
    public int search(int s,int e)
    {
        if(e>=s)
        {
            int m=s+(e-s)/2;
            if(isBadVersion(m)==true && isBadVersion(m-1)==false)
            {
                return m;
            }
            else if(isBadVersion(m)==false && isBadVersion(m+1)==true)
            {
                return m+1;
            }
            else if(isBadVersion(1)==true)
            {
                return 1;
            }
            else if(isBadVersion(m)==false)
            {
                return search(m+1,e);
            }
            else
            {
                return search(s,m-1);
            }
        }
        return 1;
    }
    
}
