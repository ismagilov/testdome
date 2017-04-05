import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TwoSum {
    public static int[] findTwoSum(int[] list, int sum) {
        Map<Integer, Integer> allNums = new HashMap<>();

        for (int i = 0; i < list.length; i++)
            allNums.put(list[i], i);


        Set<Integer> ns = allNums.keySet();
        for (int n1 : ns) {
            int n2 = sum - n1;

            if (ns.contains(n2)) {
                int[] result = new int[2];
                result[0] = allNums.get(n1);
                result[1] = allNums.get(n2);

                return result;
            }

        }

        return null;
    }

    public static void main(String[] args) {
        int[] indices = findTwoSum(new int[] { 1, 3, 5, 7, 9 }, 12);
        System.out.println(indices[0] + " " + indices[1]);
    }
}