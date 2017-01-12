
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int data[] = {66, 10, 1, 34, 5, -10};
		
		Main quick = new Main();
		quick.quickSort(data, 0, data.length-1);
		
		for(int i=0; i<data.length; ++i){
			System.out.println("data[" + i + "] = " + data[i]);
		}
	}
	
	public void quickSort(int[] data, int le, int ri) {
		int left = le;
		int right = ri;
		int pivot = data[(le+ri) / 2];
		
		do{
			while(data[left] < pivot) left++;
			while(data[right] > pivot) right--;
			
			if(left <= right){	//오름차순
				int temp = data[left];
				data[left] = data[right];
				data[right] = temp;
				left++;
				right--;
			}
		}while(left<= right);
		
		if(le < right) quickSort(data, le, right);
		if(ri > left) quickSort(data, left, ri);
		
	}

}
