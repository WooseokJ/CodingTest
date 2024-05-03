package killingcamp.큐스택그래프.example;

import java.util.ArrayDeque;
import java.util.Deque;

public class daily_temperatures {
    public static void main(String[] args) {
        int[] arr = {73,74,75,71,69,72,76,73};
        System.out.println(dailyTemperatures(arr));
    }
    public static int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> q = new ArrayDeque<>();
        int n = temperatures.length;
        int[] ans = new int[n];

        for(int day = 0; day < n; day ++) {
            while((!q.isEmpty()) &&(temperatures[q.peek()] < temperatures[day])) {
                int preDay = q.pop();
                ans[preDay] = day - preDay;
            }
            q.push(day);
        }
        return ans;
    }

}
