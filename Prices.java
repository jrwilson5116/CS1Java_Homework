/* Joey Wilson	
	2/21/2017
	Prices.java
	Takes up to 20 prices as input applies deviation formula
*/

import javax.swing.JOptionPane;

public class Prices	{
	public static void main (String args[]) {
		double[] prices = new double[20];
		double total = 0,mean =0,sum =0,root = 0;
		String out = "Values in array: ";
		String numString = "";
		int i,j;
		
		for (i = 0;i < prices.length;i++){
			numString = JOptionPane.showInputDialog(null,  "Enter an amount $$$ ", "Prices", JOptionPane.QUESTION_MESSAGE);
			prices[i] = Double.parseDouble(numString);
			if (prices[i] < 0){
				break;
			}else {
				total = (double)Math.round(total * 100) / 100;
				prices[i] = (double)Math.round(prices[i] * 100) / 100;
				total += prices[i];
				out += prices[i] + " ";
			}
		}
		mean = total/i;
		mean = (double)Math.round(mean * 100) / 100;
		out += " \nMean: ";
		out += mean;
		
		for (j = 0; j < i; j++){
			root = Math.pow((prices[j] - mean),2);
			sum +=  Math.sqrt(root);
		} 
		sum /= (i - 1);
		sum = (double)Math.round(sum * 100) / 100;
		out += " \nDeviation: ";
		out += sum;
		JOptionPane.showMessageDialog(null, out , "Prices", JOptionPane.INFORMATION_MESSAGE);
	}
}


/*	Sample output

*/