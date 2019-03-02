/**
 * 
 */
package arrays;

import java.util.Arrays;
import java.util.List;

/**
 * @author deepchandswami
 *
 */
public class MaxProductSubArray {

	 public static int maxProduct(final List<Integer> list) {
	        
	        int globalMax = 1;
	        int max = 1;
	        int min = 1;
	        
	        for(Integer ele : list){
	            
	            if(ele>0){
	                max  = max*ele;
	                min = Math.min(min*ele, 1);
	            }
	            else if(ele ==0 ){
	                max = 1;
	                min = 1;
	            }
	            
	            else{
	                int temp = max;
	                max = Math.max(min*ele,1);
	                min = temp*ele;
	            }
	            
	            if(globalMax < max){
	                globalMax = max;
	            }
	        }
	        return globalMax;
	    }
	 
	 public static void main(String[] args) {
		List<Integer> li = Arrays.asList(2,3,-2,4);
		System.out.println(maxProduct(li));
	}
}
