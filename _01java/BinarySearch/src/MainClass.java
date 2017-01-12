
public class MainClass {
	public static void main(String[] args) {
		int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		binarySearch(3, arr);
	}
	
	public static void binarySearch(int iKey, int arr[]) {
		
		int mid;
		int left = 0;
		int right= arr.length -1;
		
		while(right >= left){
			mid = (right + left) / 2;
			
			System.out.println(" left : " + left);
			System.out.println(" right : " + right);
			System.out.println(" mid : " + mid);
			
			if(iKey > arr[mid]){
				left = mid + 1;
			}else if(iKey < arr[mid]){
				right = mid -1;
			}
			else{
				System.out.println("찾으려는 " + iKey + "는 " + mid + "에 있습니다.");
				break;
				
			}
		}
		
	}
}
