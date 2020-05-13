/*Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:

Input: [3,2,3]
Output: 3
Example 2:

Input: [2,2,1,1,1,2,2]
Output: 2*/


/*class Store{
    int i,element;
    protected Store(int x)
    {
        this.i=1;
        this.element=x;
    }
    protected void increase (){
        this.i++;
    }
    
}*/
class Solution {
    //static int y=0;
    //static int e=0;
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map =new HashMap<Integer, Integer>();
        /*if(nums.length==1)
        {
            return nums[0];
        }*/
        for(int i=0;i < nums.length ;i++)
        {
            if(map.containsKey(nums[i]))
            {
                int c=map.get(nums[i])+1;
                if (c>nums.length/2)
                    return nums[i];
                else
                    map.put(nums[i],c);
            }
            else
            {
                map.put(nums[i], 1);
            }
        }
        //System.out.println(map);
        /*for(int i : map.keySet())
        {
            
            Store s = map.get(i);
            //System.out.println("element is"+s.element+"  with no."+s.i);
            if(s.i > y)
            {
                y=s.i;
                e=s.element;
            }
        }*/
        return nums[0];
        
    }
}
