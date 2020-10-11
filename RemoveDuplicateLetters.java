import java.util.*;

public class RemoveDuplicateLetters {

    static class Comp implements Comparator<int[]> {
        @Override
        public int compare(int[] o1, int[] o2) {
            return (o1[0] - o2[0]);
        }
    }

    public String removeDuplicateLetters(String s) {
        HashMap<Character, List<Integer>> hm = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            List<Integer> temp = hm.containsKey(ch)? hm.get(ch) : new ArrayList<>();
            temp.add(i);
            hm.put(ch, temp);
        }

        int ind = -1;
        int[][] resultArr = new int[26][2];
        for(char j = 'a'; j <= 'z'; j++) {
            List<Integer> indexes= hm.get(j);
            if(indexes == null) {
                continue;
            }
            int k = 0;
            for(k = 0; k < indexes.size(); k++) {
                if(indexes.get(k) > ind) {
                    ind = indexes.get(k);
                    break;
                }
            }
            if (k == indexes.size()) {
                --k;
                ind = indexes.get(k);
            }

            int ch = j - 96;
            resultArr[ch][1] = ch;
            resultArr[ch][0] = indexes.get(k);
        }
        Arrays.sort(resultArr, new Comp());
        StringBuilder res = new StringBuilder();
        for (int[] ints : resultArr)
            if(ints[1] != 0)
                res.append((char)(ints[1] + 96));
        return new String(res);
    }
}
