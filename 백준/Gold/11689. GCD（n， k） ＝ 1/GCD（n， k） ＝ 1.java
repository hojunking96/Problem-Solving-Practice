import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long pi = n;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                pi = pi / i * (i - 1);
            }
            while (n % i == 0) {
                n /= i;
            }
        }
        if (n != 1) {
            pi = pi / n * (n - 1);
        }
        System.out.println(pi);
    }
}