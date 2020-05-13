/*Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.*/

class Count{
    int index, i;
    public Count(int index){
      this.index=index;
      this.i=1;
    }
    void counter()
    {
      this.i++;
    }
  }
class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Count> map = new HashMap<Character, Count>();
          for(int i=0;i<s.length();i++)
          {
              if(map.containsKey(s.charAt(i)))
              {
                Count c=map.get(s.charAt(i));
                c.counter();
                  //map.put(s.charAt(i),map.get(s.charAt(i))+1);
              }
              else
              {
                map.put(s.charAt(i), new Count(i));
              }
          }
        for(int i=0;i<s.length();i++)
        {
          if(map.get(s.charAt(i)).i==1)
          {
            return i;
          }
            
        
        }
        return -1;
        
        
    }
}
