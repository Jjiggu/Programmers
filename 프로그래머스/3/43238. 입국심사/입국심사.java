import java.util.*;

 class Solution {

     private static final long SIZE = 1000000000;

     public long solution(int n, int[] times) {

         Arrays.sort(times);
         long min = 1, max = SIZE*SIZE;

         long cnt = max;

         while(min <= max){

             long mid = (min+max)/2;

             if(check(mid,times) >= n){
                 max = mid-1;
                 cnt = Math.min(mid,cnt);
             }
             else{
                 min = mid+1;
             }
         }

         return min;

     }

     private static long check(long mid, int [] times){

         long sum = 0;

         for(int t : times){
             sum += mid/t;
         }

         return sum;

     }
 }