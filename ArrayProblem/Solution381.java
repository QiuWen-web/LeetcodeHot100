package ArrayProblem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution381 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RandomizedCollection collection = new RandomizedCollection();
		System.out.println(collection.insert(1));
		System.out.println(collection.insert(1));
		System.out.println(collection.insert(2));
		System.out.println(collection.remove(1));
//		System.out.println(collection.remove(1));
//		System.out.println(collection.getRandom());
		
		
	}

}
class RandomizedCollection {
	private ArrayList<Integer> arr;
	private Map<Integer,Integer> map;
    /** Initialize your data structure here. */
    public RandomizedCollection() {
    	ArrayList<Integer> arr = new ArrayList<Integer>();
    	this.arr = arr;
    	Map<Integer,Integer> map = new HashMap<>();
    	this.map = map;
    } 
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
    	this.arr.add(val);
    	if(!this.map.containsKey(val) || this.map.get(val) == 0) {
    		this.map.put(val, 1);
    		return true;
    	}else {
    		this.map.put(val, this.map.get(val)+1);
    		return false;
    	}
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
    	for(int i = 0;i<this.arr.size();i++) {
    		if(this.arr.get(i) == val) {
    			this.arr.remove(i);
    		}
    	}
    	if(!this.map.containsKey(val)) {    		
    		return false;
    	}else {
    		if(this.map.get(val) == 0) {
    			return false;
    			
    		}else {
    			this.map.put(val, this.map.get(val)-1);
    			return true;
    		}
    		
    	}
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
    	int i = (int)(Math.random() * (this.arr.size()));
    	return this.arr.get(i);
    }
}