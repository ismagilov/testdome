public class SortedSearch {
    public static int countNumbers(int[] sortedArray, int lessThan) {
        int b = 0;
        int e = sortedArray.length - 1;

        int result = -1;
        while(b <= e) {
            int mid = b + (e - b) / 2;

            if (sortedArray[mid] < lessThan) {
                result = mid;
                b = mid + 1;
            } else {
                e = mid - 1;
            }
        }

        return result + 1;
    }

    public static void main(String[] args) {
        System.out.println(SortedSearch.countNumbers(new int[] { 1, 3, 5, 7 }, 4));
        System.out.println(SortedSearch.countNumbers(new int[] { 1, 4, 5, 7 }, 4));
        System.out.println(SortedSearch.countNumbers(new int[] { 1, 3, 3, 4 }, 4));
    }
}