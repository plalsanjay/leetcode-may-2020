/*You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point. Check if these points make a straight line in the XY plane.

 

 

Example 1:



Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
Output: true
Example 2:



Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
Output: false
 

Constraints:

2 <= coordinates.length <= 1000
coordinates[i].length == 2
-10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
coordinates contains no duplicate point.*/
class Solution {
    public float getSlope(int a, int b, int c, int d)
    {
        if((c-a) ==0){
             return 0;
        }
           
        float j = (float)(d-b)/(c-a);
        return j;
        
    }
    public boolean checkStraightLine(int[][] coordinates) {
        if(coordinates.length ==2)
        {
            return true;
        }
        boolean line=false;
        int[] x =coordinates[0];
        int[] y= coordinates[1];
        float slope1= getSlope(x[0],x[1],y[0],y[1]);
        for(int i =1;i<coordinates.length;i++)
        {
            int [] k =coordinates[i];
            float slope2 =getSlope(x[0],x[1],k[0],k[1]);
            if(slope2==slope1)
            {
                line =true;
            }
            else
            {
                return false;
                //break;
            }
        }
        return line;
        
    }
}
