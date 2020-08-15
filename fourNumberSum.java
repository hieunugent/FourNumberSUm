import java.util.*;

class Program {
  public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {
    // Write your code here.
		List<Integer[]> quadruplet = new ArrayList<Integer[]>();
		Map<Integer, List<Integer[]>> allpairSum = new HashMap<>();
		for(int i = 1; i < array.length -1; i++){
			for(int j = i+1; j < array.length; j++){
				int currentSum = array[i] + array[j];
				int difference = targetSum - currentSum;
				if(allpairSum.containsKey(difference)){
					for(Integer[] pair : allpairSum.get(difference)){
						Integer[] newquadruplet = {pair[0], pair[1], array[i], array[j]};
						quadruplet.add(newquadruplet);
					}
				}
			}
			for(int k = 0 ; k < i; k++){
				int currentSum = array[i] +array[k];
				Integer[] pair = {array[k], array[i]};
				if(!allpairSum.containsKey(currentSum)){
					List<Integer[]> pairGroup = new ArrayList<Integer[]>();
					pairGroup.add(pair);
					allpairSum.put(currentSum, pairGroup);
				}else{
					allpairSum.get(currentSum).add(pair);
				}
			}
		}
		 
		
    return quadruplet;
  }
}
