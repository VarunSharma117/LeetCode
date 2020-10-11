import java.util.Comparator;
import java.util.Stack;

import static java.util.Arrays.sort;

public class RemoveCoveredIntervals {

    static class Comp implements Comparator<int[]> {
        @Override
        public int compare(int[] o1, int[] o2) {
            return (o1[1] - o2[1]);
        }
    }

    public static int removeCoveredIntervals(int[][] intervals) {
        Stack<int[]> st = new Stack<>();
        int len = intervals.length;

        sort(intervals, new Comp());
        for (int[] interval : intervals) {
            if (st.isEmpty() || !doesCover(st.peek(), interval))
                st.push(interval);
            else {
                while (!st.isEmpty() && doesCover(st.peek(), interval))
                    st.pop();
                st.push(interval);
            }
        }
        return st.size();
    }

    public static boolean doesCover(int[] a, int[] b){
        return (a[0] <= b[0] && a[1] >= b[1]) || (b[0] <= a[0] && b[1] >= a[1]);
    }
}
