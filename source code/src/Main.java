import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int size =50000; // Array size

        // Create Arrays
        int[] arr_random = generateArray(size, "random");
        int[] arr_asc = generateArray(size, "ascending");
        int[] arr_desc = generateArray(size, "descending");
        
        System.out.println("Size of Arrays: "+ size +"\n");
        
        // Check the state of the arrays
        System.out.println("Random array sample: " + Arrays.toString(Arrays.copyOf(arr_random, 10)) + "...");
        System.out.println("Ascending array sample: " + Arrays.toString(Arrays.copyOf(arr_asc, 10)) + "...");
        System.out.println("Descending array sample: " + Arrays.toString(Arrays.copyOf(arr_desc, 10)) + "...");
        
        long id = 1008789881L; // ID to be used        
        
        // Test the sorting methods
        testSorts(arr_random, "Random Array", id);
        testSorts(arr_asc, "Ascending Array", id);
        testSorts(arr_desc, "Descending Array", id);
    }

    public static int[] generateArray(int size, String type) {
        switch (type.toLowerCase()) {
        case "ascending": {
            int[] array = new int[size];
            for (int i = 0; i < size; i++) {
                array[i] = i;
            }
            return array;
        }
        case "descending": {
            int[] array = new int[size];
            for (int i = 0; i < size; i++) {
                array[i] = size - 1 - i;
            }
            return array;

        }
        case "random": {
            Random rand = new Random();
            int[] array = new int[size];
            for (int i = 0; i < size; i++) {
                array[i] = rand.nextInt(size); // Values between 0 and size
            }
            return array;
        }
        default: {
            throw new IllegalArgumentException(
                    "Invalid type: " + type + ". Valid types are 'ascending', 'descending', 'random'.");
        }

        }
    }

    // Helper method to test all sorting methods
    public static void testSorts(int[] array, String arrayName, long id) {
        System.out.println("\nTesting with: " + arrayName);

        for (int i = 1; i <= 5; i++) {
            int[] copy = array.clone(); // Clone the array to avoid modifying the original, it is going to be tested with another sortings between 1-5.
            long start = System.currentTimeMillis(); // Start time
            callSortMethod(i, copy, id); // Call the sorting method
            long end = System.currentTimeMillis(); // End time
            System.out.println("Sort" + i + ": " + (end - start) + " ms");
        }
    }

    // Helper method to call the sorting methods
    public static void callSortMethod(int methodNumber, int[] array, long id) {
        switch (methodNumber) {
        case 1:
            SortingAlgorithms.sort1(array, id);
            break;
        case 2:
            SortingAlgorithms.sort2(array, id);
            break;
        case 3:
            SortingAlgorithms.sort3(array, id);
            break;
        case 4:
            SortingAlgorithms.sort4(array, id);
            break;
        case 5:
            SortingAlgorithms.sort5(array, id);
            break;
        default:
            throw new IllegalArgumentException("Invalid sort method number: " + methodNumber);
        }
    }
}
