/*In a town, there are N people labelled from 1 to N.  There is a rumor that one of these people is secretly the town judge.

If the town judge exists, then:

The town judge trusts nobody.
Everybody (except for the town judge) trusts the town judge.
There is exactly one person that satisfies properties 1 and 2.
You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.

If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.

 

Example 1:

Input: N = 2, trust = [[1,2]]
Output: 2
Example 2:

Input: N = 3, trust = [[1,3],[2,3]]
Output: 3
Example 3:

Input: N = 3, trust = [[1,3],[2,3],[3,1]]
Output: -1
Example 4:

Input: N = 3, trust = [[1,2],[2,3]]
Output: -1
Example 5:

Input: N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
Output: 3
 

Note:

1 <= N <= 1000
trust.length <= 10000
trust[i] are all different
trust[i][0] != trust[i][1]
1 <= trust[i][0], trust[i][1] <= N*/



class Solution {
    static HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
    public int findJudge(int N, int[][] trust) {
        if(trust.length==1)
        {
            return trust[0][1];
        }
        if(N==1)
        {
            return 1;
        }
        for(int i=1;i<=N;i++)
        {
            map.put(i,i);
        }
        int x=0;
        for(int a=0;a<trust.length;a++)
        {
            
            int[] k= trust[a];
            if(map.containsKey(k[0]))
            {
                map.remove(k[0]);
            }
            //x++;
        }
        //int b=0;
        if(map.size()==0)
        {
            //b=map.get(map.keySet().toArray()[0]);
            return -1;
        }
           int b=map.get(map.keySet().toArray()[0]);
        
        for(int a=0;a<trust.length;a++)
        {
            int[] k =trust[a];
            if(k[1]==b)
            {
                x++;
            }
        }
        //System.out.println(map);
        if(map.size()==1 && x==N-1)
        {
            //int a=map.get(map.keySet().toArray()[0]);
            return b;
            //Set l=map.keySet();
            //System.out.println(l);
            //Integer first = l.stream().findFirst().get();
            //int setint = *l.begin();
            //int[] a= new int[l.size()];
            //l.toArray(a);
            //System.out.println(a);
        }
        return -1;
    }
}
