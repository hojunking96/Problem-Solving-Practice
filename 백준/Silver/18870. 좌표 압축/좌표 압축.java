import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void quickSort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int low, int high) {
        if (low >= high)
            return;

        int mid = partition(arr, low, high);
        sort(arr, low, mid - 1);
        sort(arr, mid, high);
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[(low + high) / 2];
        while (low <= high) {
            while (arr[low] < pivot) {
                low++;
            }
            while (arr[high] > pivot) {
                high--;
            }
            if (low <= high) {
                swap(arr, low, high);
                low++;
                high--;
            }
        }
        return low;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

        int N = Integer.parseInt(br.readLine());
        int X[] = new int[N];
        int R[] = new int[N];
        int rank = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            X[i] = Integer.parseInt(st.nextToken());
            R[i] = X[i];
        }
        quickSort(R);
        for (int v : R) {
            if (!hm.containsKey(v)) { // v에 대한 key값이 없으면
                hm.put(v, rank); // v에다가 rank를 넣어
                rank++; // 정렬된 순서대로 v를 뽑으니까 0순위부터 차례대로 대입
            }
        }
        for (int v : X) {
            sb.append(hm.get(v) + " ");
        }
        System.out.println(sb);
        br.close();
    }
}
