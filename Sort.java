/* Joey Wilson	
	2/27/2017
	Sort.java
	Sorts 15 random numbers in acending order using loops and arrays
*/


public class Sort {
	public static void main (String args[]) {
		int[] numbers = new int[15];
		int i, j, temp;
		String before = "Before sorting:"; 
		String after = "After sorting:";
		
		for (i = 0; i < numbers.length; i++){ 
			numbers[i] = (int) (Math.random() * 100 + 1);
			before += " " + numbers[i];
			}
		for (i = 0; i < numbers.length; i++){
			for (j = (i+1); j < numbers.length; j++ ){
				if (numbers[i] > numbers[j]){
					temp = numbers[i];
					numbers[i] = numbers[j];
					numbers[j] = temp;
				}
			}
			after += " " + numbers[i];
		} 
		System.out.println(before);
		System.out.println(after);
	}
}


/*	Sample output
	Before sorting: 68 23 98 31 9 12 53 27 55 92 36 7 58 100 60
	After sorting: 7 9 12 23 27 31 36 53 55 58 60 68 92 98 100
*/