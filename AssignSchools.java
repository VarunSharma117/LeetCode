import java.util.*;

public class AssignSchools {

    static List<Integer> allocateSchools(List<Integer> schoolSeatsArray, List<Integer> studentScoreArray, List<List<Integer>> studentSchoolPreferencesArray) {

        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
        for (int i = 0; i < studentScoreArray.size(); i++) {
            map.put(studentScoreArray.get(i), i);
        }

        int studentsLeft = 0;
        for (Map.Entry<Integer, Integer> stu : map.entrySet()) {
            for (int j = 0; j < studentSchoolPreferencesArray.get(0).size(); j++) {
                int schoolPrefInd = studentSchoolPreferencesArray.get(stu.getValue()).get(j);
                int school = schoolSeatsArray.get(schoolPrefInd);
                if (school > 0) {
                    schoolSeatsArray.set(schoolPrefInd, --school);
                    break;
                }
                if (j == 2)
                    studentsLeft++;
            }
        }
        int seatsLeft = 0;
        for (int k = 0; k < schoolSeatsArray.size(); k++) {
            if (schoolSeatsArray.get(k) > 0)
                seatsLeft += schoolSeatsArray.get(k);
        }
        List<Integer> list = new LinkedList<Integer>();
        list.add(seatsLeft);
        list.add(studentsLeft);
        return list;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int m, n;
        List<Integer> schoolSeatsArray = new ArrayList<>();
        List<Integer> studentScoreArray = new ArrayList<>();
        List<List<Integer>> studentSchoolPreferencesArray = new ArrayList<>();


        m = s.nextInt();
        for(int i = 0; i < m; i++) {
            schoolSeatsArray.add(s.nextInt());
        }

        m = s.nextInt();
        for(int i = 0; i < m; i++) {
            studentScoreArray.add(s.nextInt());
        }

        m = s.nextInt();
        n = s.nextInt();
        for(int i = 0; i < m; i++) {
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j < n; j++)
                list.add(s.nextInt());
            studentSchoolPreferencesArray.add(list);
        }
        System.out.println(allocateSchools(schoolSeatsArray, studentScoreArray, studentSchoolPreferencesArray));
        s.close();
    }
}
