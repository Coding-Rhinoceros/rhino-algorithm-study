import java.math.*;


class Solution {
    
    
     
    
    public int[] solution(int rows, int cols, int[][] queries) {
        int[] answer = new int[queries.length];
        
        int [][] brd =  new int[rows][cols];
        
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                brd[i][j] = i*cols+j+1;
            }
        }
        
        int cnt =0;
        for(int [] cmd : queries){
            int ans = 0x3f3f3f3f;
            for(int i=0; i<4; i++) cmd[i]--;
            int x1 = cmd[0], y1 = cmd[1] , x2 = cmd[2], y2 =cmd[3];
            int tmp  = brd[x1][y1];
            // 땡겨오는 로직
            for(int i = x1 ; i<x2; i++){
                brd[i][y1] = brd[i+1][y1];
                ans =Math.min(ans, brd[i][y1]);
            }
            
             for(int i = y1 ; i<y2; i++){
                brd[x2][i] = brd[x2][i+1];
                ans =Math.min(ans, brd[x2][i]);
            }
            
            
            
            for(int i = x2 ; i>x1; i--){
                brd[i][y2] = brd[i-1][y2];
                ans =Math.min(ans, brd[i][y2]);
            }
            
            for(int i = y2 ; i>y1; i--){
                brd[x1][i] = brd[x1][i-1];
                ans =Math.min(ans, brd[x1][i]);
            }
            brd[x1][y1+1] = tmp;
            ans =Math.min(ans, tmp);
            answer[cnt++]= ans;
            
        }
        
        
        
        
        return answer;
    }
}