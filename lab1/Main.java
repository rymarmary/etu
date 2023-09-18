import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = {14, 31, 70, 5, 64, 28, 67};

        System.out.printf("До сортировки: ");
        for (int i: array) System.out.print(i + " ");
        System.out.printf("\n");

        Arrays.sort(array);

        System.out.printf("После сортировки: ");
        for (int i: array) System.out.print(i + " ");
    }
}