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
