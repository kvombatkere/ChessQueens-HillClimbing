import java.util.Arrays;

//Karan Vombatkere
//Write a function get_products_of_all_ints_except_at_index() that 
//takes a list of integers and returns a list of the products.

//April 04, 2017


public class IntegerProduct {
	
	static int [] get_products_of_all_ints_except_at_index(int [] NumArr){
		//Output array index = k
		//Input array index = i
		int [] IntegerProduct = new int[NumArr.length];
		int k = 0;
		
		while(k < NumArr.length){
			int i = 0;
			int product_val = 1;
			
			while(i < NumArr.length){
				if(k != i){ //Only multiply if the indices are different
					product_val *= NumArr[i];
				}
				i++;
			}
			IntegerProduct[k] = product_val;
			k++;
		}
			
		return IntegerProduct;
	}
	
	
	public static void main(String[] args) {
		int [] IntegerArr  = {3,4,5,1,8,7};
		int [] Output_Arr = get_products_of_all_ints_except_at_index(IntegerArr);
		
		System.out.println(Arrays.toString(IntegerArr));
		System.out.println(Arrays.toString(Output_Arr));
	}

}
