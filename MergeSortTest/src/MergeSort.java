
import java.util.ArrayList;

public class MergeSort {
    int[] listToBeSorted;

    // stores the arrays of numbers that have been split and merged
    ArrayList<int[]> listsToBeMerged = new ArrayList<>();

    MergeSort(int[] listToBeSorted) {
        this.listToBeSorted = listToBeSorted;
    }

    public void split() {
        // takes every number from the original array and places it in an array of length one,
        // effectively splitting the array
        for(int i = 0; i < listToBeSorted.length; i++) {
            int[] splitList = {listToBeSorted[i]};
            listsToBeMerged.add(splitList);
        }
    }

    public void merge(int[] firstList, int[] secondList) {
        // takes the length of the two lists that are being merged and creates an array large enough to store all the numbers.
        int[] mergedList = new int[firstList.length + secondList.length];

        int checkFirst = 0;
        int checkSecond = 0;
        // iterates through both arrays separately, finding the smallest number and placing it in the merged array
        for(int i = 0; i < mergedList.length; i++) {
            if (checkFirst < firstList.length && checkSecond < secondList.length) {
                if (firstList[checkFirst] <= secondList[checkSecond]) {
                    mergedList[i] = firstList[checkFirst];
                    checkFirst++;
                    continue;
                }
                if (secondList[checkSecond] < firstList[checkFirst]) {
                    mergedList[i] = secondList[checkSecond];
                    checkSecond++;
                    continue;
                }
            }
            else if (checkFirst < firstList.length) {
                mergedList[i] = firstList[checkFirst];
                checkFirst++;
                continue;
            }
            else if (checkSecond < secondList.length) {
                mergedList[i] = secondList[checkSecond];
                checkSecond++;
                continue;
            }
        }

        // removes the original arrays and adds the merged one to the list containing all arrays
        listsToBeMerged.remove(firstList);
        listsToBeMerged.remove(secondList);
        listsToBeMerged.add(mergedList);
    }

    public void sort() {
        // as long as the array has not been completely merged and sorted, the first two elements will be merged.
        // because the merged arrays are placed at the back, only arrays of equal or very similar length will be merged.
        while(listsToBeMerged.size() > 1) {
            merge(listsToBeMerged.get(0), listsToBeMerged.get(1));
        }
    }


    public void printLists() {
        // prints all lists
        for(int i = 0; i < listsToBeMerged.size(); i++) {
            for(int k = 0; k < listsToBeMerged.get(i).length; k++) {
                System.out.print(listsToBeMerged.get(i)[k] + " ");
            }
            System.out.println();
        }
    }
}
