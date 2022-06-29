import java.util.Random;

public class MergeSortTest {
    public static void main(String[] args) {
        int[] listToSort = new int[100000];
        Random fillArray = new Random();

        for(int i = 0; i < listToSort.length; i++) {
            int fill = fillArray.nextInt(100000);
            listToSort[i] = fill;
        }

        MergeSort testMergeSort = new MergeSort(listToSort);

        testMergeSort.split();
        testMergeSort.sort();
        testMergeSort.printLists();
    }
}
