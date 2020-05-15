/*Implement a trie with insert, search, and startsWith methods.

Example:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");   
trie.search("app");     // returns true
Note:

You may assume that all inputs are consist of lowercase letters a-z.
All inputs are guaranteed to be non-empty strings.*/



class Node{
        Node [] children;
        Boolean end;
        Node ()
        {
            end=false;
            this.children = new Node[26];
        }
    }
class Trie {
    //static final int Size=26;
    //Trie[] children ;
    Node root;
    

    /** Initialize your data structure here. */
    public Trie() {
        root= new Node();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node p=root;
        for(int i=0;i<word.length();i++)
        {
            char c=word.charAt(i);
            int index= c-'a';
            if(p.children[index]==null)
            {
                Node temp= new Node();
                p.children[index]=temp;
                p=temp;
            }
            else
            {
                p=p.children[index];
            }
        }
        p.end=true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node p=searchNode(word);
        if(p==null)
        {
            return false;
        }
        else
        {
            if(p.end)
            {
                return true;
            }
        }
        return false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node p=searchNode(prefix);
        if(p==null)
        {
            return false;
        }
        else 
        {
            return true;
        }
        
    }
    public Node searchNode(String s)
    {
        Node p=root;
        for(int i=0;i<s.length();i++)
        {
            int index=s.charAt(i)-'a';
            if(p.children[index]!=null)
            {
                p=p.children[index];
            }
            else
            {
                return null;
            }
            
        }
        if(p==root)
        {
            return null;
        }
        return p;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
