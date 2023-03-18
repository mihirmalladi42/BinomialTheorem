package allprograms;

import java.util.ArrayList;
import java.util.Scanner;

public class BinomialTheorem {
	public static ArrayList<Integer> pascalTriangleTerm(int num) {
		
        int[] nums = new int[1];
        ArrayList<Integer> returnVal = new ArrayList<>();
        ArrayList<Integer> prevNum = new ArrayList<>();
        num--;
        for (int i = 0; i < num; i++) {
            if (i == 0) {
                nums[0] = 1;
            } else {
                prevNum = new ArrayList<>();
                for (int k = 0; k < nums.length; k++) {
                    prevNum.add(nums[k]);
                }
                prevNum.add(1);
                nums = new int[i+1];
                nums[0] = 1;
                if (nums.length != 1) {
                    for (int j = 1; j < nums.length; j++) {
                        if (prevNum.size() != j) {
                            nums[j] = prevNum.get(j-1)+prevNum.get(j);
                        } else {
                            nums[nums.length-1] = 1;
                            break;
                        }
                    }   
                }
            }
        }
        for (int i = 1; i < nums.length; i++) {
        	returnVal.add(nums[i]);
        }
        return returnVal;
	}
	public static void calculate() {
		System.out.println("The binomial theorem is where you take (x+y)^n and calculate it without distributing. The formula is sum from k=0 to n of (n k)(x^(n-k))  * y^k.\n (n k) can be simplified as a Pascal triangle layer.");
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter 'n' in (x+y)^n: ");
		int n = scan.nextInt();
		ArrayList<Integer> pascalTriangle = pascalTriangleTerm(n+1);
		if (n == 2) {
			System.out.println("(x+y)^2 = x^2 + 2xy + y^2");
		} else {
			System.out.print("(x+y)^" + n + " = x^" + n + " + " + pascalTriangle.get(0) + "x^" + (n-1) + "*y + ");
			for (int i = 1; i < pascalTriangle.size()-1; i++) {
				System.out.print(pascalTriangle.get(i) + "x^" + (n-(i+1)) + "*y^" + (i+1) + " + ");
			}
			System.out.println(pascalTriangle.get(0) + "x*y^" + (n-1) + " + y^" + n);
		}
		
		System.out.println("Do you want to calculate another equation using the binomial theorem?");
		Scanner again = new Scanner(System.in);
		String yesorno = again.nextLine();
		if (yesorno.equalsIgnoreCase("yes")) {
			calculate();
		} else if (yesorno.equalsIgnoreCase("no")) {
			System.out.println("Thank you for using this calculator!");
		} else {
			System.out.println("Sorry, I don't understand what you are saying. Thank you for using this calculator!");
		}
	}
	public static void main(String[] args) {
		calculate();
	}
}
