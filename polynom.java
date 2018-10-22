package polynom_array;

import java.util.*;


public class polynom {
	
	public static String print_list_1d(int[] arr) {
		String x = "(";
		for(int i = 0; i<arr.length; i++) 
			x = x + " " + arr[i] + ", ";
		
		x = x + ")";
		return x; 
	}
	
	public static void print_list_2d(int[] arr) {
		System.out.println("--------------------------------------------");
		System.out.println("Multiplied Polynomial");
		System.out.println("--------------------------------------------");
		System.out.println("\nExponent: Coefficient");
		for (int i = 0; i< arr.length; i++) {
			System.out.println(i + "\t:\t"  + arr[i]);
		}
		System.out.println("");
	}
	public static String print_polynomial(int[] arr) {
		String x = ""; 
		for(int i = arr.length - 1; i>0; i-=2) {
			x+=(arr[i] + "X^" + arr[i-1]);
			if (i != 2) 
				x+= " + ";
		}
		return x; 
	}
	
	public static int poly_term_len(int[]arr_1, int[]arr_2) {
		ArrayList<Integer> unique_exp = new ArrayList<Integer>();  
		for(int i = 1; i < arr_1.length; i+=2) {
			if (!(unique_exp.contains(arr_1[i]))) 
				unique_exp.add(arr_1[i]); 
		}
		for(int j = 1; j < arr_2.length; j+=2) {
			if (!(unique_exp.contains(arr_2[j]))) 
				unique_exp.add(arr_2[j]); 
		}
		
		int len = unique_exp.size();
		return len; 
	}
	
	public static int[] add_poly(int[]arr_1, int[]arr_2) {
		System.out.println("--------------------------------------------");
		System.out.println("Added Polynomial");
		System.out.println("--------------------------------------------");
		int i = 1;
		int j = 1;int k = 1;
		int len = poly_term_len(arr_1, arr_2);
		int[]arr_new = new int[(len*2) + 1];
		arr_new[0] = len; 
		
		while (k<arr_new.length) {
			if (arr_1[i] < arr_2[j]) {
				arr_new[k] = arr_2[j];
				arr_new[k+1] = arr_2[j+1]; 
				j+=2;
				k+=2;	
			}
			if (arr_1[i] > arr_2[j]) {
				arr_new[k] = arr_1[i];
				arr_new[k+1] = arr_1[i+1]; 
				i+=2;
				k+=2;	
			}
			if (arr_1[i] == arr_2[j]) {
				arr_new[k] = arr_1[i];
				arr_new[k+1] = (arr_1[i+1] + arr_2[j+1]); 
				j+=2;
				i+=2;
				k+=2;	
			}
		}
		System.out.println(print_polynomial(arr_new));
		return arr_new;
	}
	
	public static int[] multi_poly(int[] arr_1, int[] arr_2) {
		int max = 0; 
		for (int i = 1; i<arr_1.length;i+=2) {
			for (int j = 1; j<arr_2.length;j+=2) {
				if (arr_1[i] * arr_2[j] > max) 
					max = arr_1[i] + arr_2[j];	
			}
		}
		int[] arr_exp = new int[max + 1]; 
		
		for(int i = 1; i < arr_1.length; i+=2) {
			for(int j = 1; j <arr_2.length; j+=2) 
				arr_exp[arr_1[i] + arr_2[j]] += arr_1[i+1] * arr_2[j+1];
			
		}
		int len = 0; 
		for (int i = 0; i < arr_exp.length; i++) {
			if (arr_exp[i] != 0)
					len+=2;
		}
		int[] arr_final = new int[len+1]; 
		arr_final[0] = len; 
		int k = 1; 
		for (int i = 0; i < arr_exp.length; i++) {
			if (arr_exp[i] != 0) {
				arr_final[k] = i;
				arr_final[k+1] = arr_exp[i]; 
				k+=2; 
			}
		}
		print_list_2d(arr_exp); 
		System.out.println(print_polynomial(arr_final) + "\n");
		return arr_final;
	}

	public static void main(String[] args) {
		int[] arr_1 = {3,2,1,1,4,0,-2};
		int[] arr_2 = {3,2,-2,1,1,0,8};
		
		System.out.println("Array 1: " + print_list_1d(arr_1)); 
		System.out.println("Array 2: " + print_list_1d(arr_2));
		System.out.println(print_list_1d(add_poly(arr_1,arr_2)));
		System.out.println(print_list_1d(multi_poly(arr_1, arr_2)));
		
		

	}

}
