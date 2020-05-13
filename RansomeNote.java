/*Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

Each letter in the magazine string can only be used once in your ransom note.

 

Example 1:

Input: ransomNote = "a", magazine = "b"
Output: false
Example 2:

Input: ransomNote = "aa", magazine = "ab"
Output: false
Example 3:

Input: ransomNote = "aa", magazine = "aab"
Output: true
 

Constraints:

You may assume that both strings contain only lowercase letters.*/

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int x=0;
        int a=0;
        String J=ransomNote;
        String S=magazine;
        for(int i=0;i<J.length();i++)
        {
            x=0;
            int j=0;
            char c =J.charAt(i);
            for( j=0;j<S.length();j++)
            {
                if(c==S.charAt(j))
                {
                    //S=charRemoveAt(S,j);
                    x++;
                    a++;
                    break;
                }
            }
            if(x==1)
            {
                S=charRemoveAt(S,j);
            }
        }
        
        if(a==J.length())
        {
            return true;
        }
        else{
            return false;
        }
        
        
        
    }
     public static String charRemoveAt(String str, int p) {  
              return str.substring(0, p) + str.substring(p + 1);  
           }  
}
