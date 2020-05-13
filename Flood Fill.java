/*An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).

Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.

To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on. Replace the color of all of the aforementioned pixels with the newColor.

At the end, return the modified image.

Example 1:
Input: 
image = [[1,1,1],[1,1,0],[1,0,1]]
sr = 1, sc = 1, newColor = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]
Explanation: 
From the center of the image (with position (sr, sc) = (1, 1)), all pixels connected 
by a path of the same color as the starting pixel are colored with the new color.
Note the bottom corner is not colored 2, because it is not 4-directionally connected
to the starting pixel.
Note:

The length of image and image[0] will be in the range [1, 50].
The given starting pixel will satisfy 0 <= sr < image.length and 0 <= sc < image[0].length.
The value of each color in image[i][j] and newColor will be an integer in [0, 65535].*/

class Solution {
    //int[][] x=  new int[1][1];
    static int e=0,c=0;
    static int o=0;
    //static int [][] array;
    void connected(int[][] image, int a, int b, int newColor, int i, int j,int k, int l )
    {
        //image[sr][sc]=newColor;
        //System.out.println("hello");
        
        if(a==k && b==l && o>1)
        {
            return;
        }
        //System.out.println("hello");
        int f=0;
        if(a>=0 && a<e)
        {
            f =image[a].length;
        }
        else
        {
            return;
        }
        //System.out.println("e is  "+e);
        if(a<0 || a>=e|| b <0 || b>=f)
        {
            return;
        }
        //System.out.println("hello");
        //System.out.println("c is"+c);
        if(image[a][b]!= c)
        {
            return;
        }
        //System.out.println("a is  "+a+" b is "+b+" i is "+i+"  j is "+j);
        //System.out.println("hello");
        image[a][b]=newColor;
        if(o==0||o==1)
        {
            o++;
        }
        //System.out.println("run");
        if(a==i )
        {
            if((b-1)==j)
            {
                connected(image, a-1, b, newColor, a, b, k, l);
                connected(image, a+1, b, newColor, a, b, k, l);
                //connected(image, a, b-1, newColor, a, b, k, l);
                connected(image, a, b+1, newColor, a, b, k, l);
            }
            else if((b+1)==j)
            {
                connected(image, a-1, b, newColor, a, b, k, l);
                connected(image, a+1, b, newColor, a, b, k, l);
                connected(image, a, b-1, newColor, a, b, k, l);
                //connected(image, a, b+1, newColor, a, b, k, l);
            }
        }
        else if(b==j)
        {
            if((a-1)==i)
            {
                //connected(image, a-1, b, newColor, a, b, k, l);
                connected(image, a+1, b, newColor, a, b, k, l);
                connected(image, a, b-1, newColor, a, b, k, l);
                connected(image, a, b+1, newColor, a, b, k, l);
            }
            else if((a+1)==i)
            {
                connected(image, a-1, b, newColor, a, b, k, l);
                //connected(image, a+1, b, newColor, a, b, k, l);
                connected(image, a, b-1, newColor, a, b, k, l);
                connected(image, a, b+1, newColor, a, b, k, l);
            }
        }
        else if((a-1)==i)
        {
            //connected(image, a-1, b, newColor, a, b, k, l, k, l);
            connected(image, a+1, b, newColor, a, b, k, l);
            connected(image, a, b-1, newColor, a, b, k, l);
            connected(image, a, b+1, newColor, a, b, k, l);
        }
        else if((a+1)==i)
        {
            connected(image, a-1, b, newColor, a, b, k, l);
            //connected(image, a+1, b, newColor, a, b, k, l);
            connected(image, a, b-1, newColor, a, b, k, l);
            connected(image, a, b+1, newColor, a, b, k, l); 
        }
        else if((b-1)==j)
        {
            connected(image, a-1, b, newColor, a, b, k, l);
            connected(image, a+1, b, newColor, a, b, k, l);
            //connected(image, a, b-1, newColor, a, b, k, l);
            connected(image, a, b+1, newColor, a, b, k, l);
        }
        else if((b+1)==j)
        {
            connected(image, a-1, b, newColor, i, j, k, l);
            connected(image, a+1, b, newColor,i, j, k, l);
            connected(image, a, b-1, newColor, i, j, k, l);
            //connected(image, a, b+1, newColor, i, j, k, l);
        }
        else
        {
            connected(image, a-1, b, newColor, a, b, k, l);
            connected(image, a+1, b, newColor, a, b, k, l);
            connected(image, a, b-1, newColor, a, b, k, l);
            connected(image, a, b+1, newColor, a, b, k, l);
        }
        //connected(image, a-1, b, newColor, i, j);
        //connected(image, a+1, b, newColor,i, j);
        //connected(image, a, b-1, newColor, i, j);
        //connected(image, a, b+1, newColor, i, j);
        
        
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        c=image[sr][sc];
        e=image.length;
        //array = new int [image.length][image[0].length];
 
        //array =image;
        //image[sr][sc]=newColor;
        //int[][] x=  new int[1][1];
        //System.out.println(e);
        /*for(int i=0;i<image.length;i++)
        {
            for(int j=0;j<image[i].length;j++)
            {
                //System.out.printf("%d",image[i][j]);
                array[i][j]=image[i][j];
            }
            //System.out.println();
        }*/
        connected(image, sr, sc, newColor, -2, -2, sr, sc);
        
        /*for(int i=0;i<image.length;i++)
        {
            for(int j=0;j<image[i].length;j++)
            {
                System.out.printf("%d",array[i][j]);
                //array[i][j]=image[i][j];
            }
            System.out.println();
        }*/
        c=0;
        e=0;
        o=0;
        return image;
    }
}
