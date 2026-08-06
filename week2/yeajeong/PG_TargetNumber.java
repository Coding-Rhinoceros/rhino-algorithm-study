import java.util.*;
class Solution {

    public int solution(int[] numbers, int target) {
        int count = 0;
        
        int len =  numbers.length;
        
        int [] arr = new int[len];
        //인덱스, 고칠배열 , 합계
        Queue<int[]> q=new ArrayDeque<int[]>();
        int sum= 0;
        
        //q에 들어갈 초기값.
        q.offer(new int[] {0, sum + numbers[0]});
        q.offer(new int[] {0, sum - numbers[0]});
        
        while(!q.isEmpty()){
            int[] qc= q.poll();    
            int index = qc[0];
            int currentSum = qc[1];

                
            //base condition
            if(index == len-1) {//index 3 == 4 이면 최종임
                if(target == currentSum) count++;
                continue;
            }
            q.offer(new int[] {index+1, currentSum + numbers[index+1]});
            
            q.offer(new int[] {index+1,currentSum - numbers[index+1]});
            
        }
            
            
        return count;
    }
}