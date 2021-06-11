package hot100;

import java.util.Collection;

public class Solution208 {
	public static void main(String[] args) {
		
	}
}
class Trie {
    Collection c = new Collection<String>();
    /** Initialize your data structure here. */
    public Trie() {
    	
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
    	c.add(word);
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
    	return c.contains(word);
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
    	
    }
}
