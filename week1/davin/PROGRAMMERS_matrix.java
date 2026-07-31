import java.util.*;

public class PROGRAMMERS_matrix {	
    public int[] solution(int rows, int columns, int[][] queries) {
        
        int initial = 1;
        int[][] nums = new int[rows+1][columns+1] ;
        for(int i=1; i<=rows; i++){
            for(int j=1; j<=columns; j++){
                nums[i][j]=initial++;
            }
        }
        
        ArrayList <Integer> mins = new ArrayList <>();
       
        for(int[] query: queries){
            int x1= query[0];
            int y1= query[1];
            int x2= query[2];
            int y2= query[3];
            
            int save = nums[x1][y1];
            int min = nums[x1][y1];
            
            for(int i=x1;i<=x2-1;i++){
                nums[i][y1]=nums[i+1][y1];
                min = Math.min(min, nums[i][y1] );
            }
            
            for(int j=y1;j<=y2-1;j++){
                nums[x2][j]=nums[x2][j+1];
                min = Math.min(min, nums[x2][j]);
            }
            
            for(int i=x2;i>=x1+1;i--){
                nums[i][y2]=nums[i-1][y2];
                min = Math.min(min, nums[i][y2]);
            }
            
            for(int j=y2;j>=y1+1;j--){
                nums[x1][j]=nums[x1][j-1];
                min = Math.min(min, nums[x1][j]);
            }
            
            nums[x1][y1+1] = save;
            
            mins.add(min);
        }
             
        return mins.stream().mapToInt(i -> i).toArray();
    }
}
