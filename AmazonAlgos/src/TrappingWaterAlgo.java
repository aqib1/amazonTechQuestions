/*
 * Given n non-negative integers 
 * representing an elevation map where the 
 * width of each bar is 1, compute how much 
 * water it is able to trap after raining.
 * 
 * */

public class TrappingWaterAlgo {

	
	static int getWaterVolume(int []arr) {
		int waterVolume = 0;
		int[] leftMax = new int[arr.length];
		int[] rightMax = new int[arr.length];
		
		
		leftMax[0] = arr[0];
		for(int x=1; x<arr.length ; x++) {
			leftMax[x] = Math.max(leftMax[x-1], arr[x]);
		}
		rightMax[arr.length-1] = arr[arr.length-1];
		
		for(int x = arr.length - 2; x >= 0; x--) {
			rightMax[x] = Math.max(rightMax[x+1], arr[x]);
		}
		
		
		
		for(int x=0; x < arr.length; x++) {
			waterVolume += Math.min(leftMax[x], rightMax[x]) - arr[x];
		}
		return waterVolume;
	}
	
	
	
	public static void main(String[] args) {
		int arr[]   = {2,0,2};
		System.out.println(getWaterVolume(arr));
		
	}
}
