import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GFG {

// Driver program 
public static void main(String[] args) 
{ 
		Scanner in = new Scanner(System.in); 
		int matrixRow = in.nextInt();
		int matrixCol = matrixRow;
		int[][] matrix = new int[matrixRow][matrixCol];
		enterMatrixData(in, matrix, matrixRow, matrixCol);

		
		int restrictions = in.nextInt();
		Map<Integer, Integer> restrictionsL = new HashMap<>();
		if(restrictions > 0){
			for(int i = 0; i < restrictions ; i++){
				restrictionsL.put(in.nextInt(), in.nextInt());
			}
		}

		minimumStationsReq(matrix, restrictionsL);
		
	
	}

	public static void enterMatrixData(Scanner scan, int[][] matrix, int matrixRow, int matrixCol){
	         
	         for (int i = 0; i < matrixRow; i++)
	         {
	             for (int j = 0; j < matrixCol; j++)
	             {
	                 matrix[i][j] = scan.nextInt();
	             }
	         }
	 }
	
	private static void minimumStationsReq(int[][] l1,Map<Integer, Integer>  restrictionsL) {
		int sum = l1[0][1];
		for(int i = 1; i < l1.length - 1;i++){
			if(restrictionsL.size() > 0){
				if(restrictionsL.get(l1[i-1][i]) == (l1[i][i+1])){
					sum += l1[i][i+1];
				}
			} else
				sum += l1[i][i+1]; 
		}
		System.out.println(sum);
	} 
} 