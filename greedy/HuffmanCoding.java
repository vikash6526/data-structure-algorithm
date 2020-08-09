package datastructure.greedy;

import java.util.HashMap;
import java.util.Map;

public class HuffmanCoding {
	public int numIdenticalPairs(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for(Integer data:nums){
            if(map.containsKey(data)){
                map.put(data,map.getOrDefault(data,1)+1);
            }else{
                map.put(data,1);
            }
        }
        for(Integer value:map.values()) {
        	
        }
        return 0;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
