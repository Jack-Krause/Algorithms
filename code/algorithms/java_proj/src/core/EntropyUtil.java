package core;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EntropyUtil {

    public static <T> double entropy(List<T> data) {
        int n = data.size();
        if (n == 0) return 0.0;

        // 1. build frequency map
        Map<T, Integer> freq = new HashMap<>();
        for (T item : data) {
            int occ = freq.getOrDefault(item, 0) + 1;
            freq.put(item, occ);
        }

        // 2. Compute H (entropy) = - Summ (count / n) * log2(count / n)
        double h = 0.0;
        double invN = 1.0 / n;
        for (int count : freq.values()) {
            double p = count * invN;
            h -= p * (Math.log(p) / Math.log(2));
        }

        return h;
    }

    public static double entropy(int[] data) {
        return entropy(Arrays.stream(data).boxed().collect(Collectors.toList()));
    }

    public static boolean shouldUseDistributionSort(int[] data, double alpha) {
        int n = data.length;
        if (n < 2) return false;

        double h    = entropy(data);
        double logn = Math.log(n) / Math.log(2);

        // debug print
        System.out.printf("    H = %.4f, log2(n) = %.4f, α·log2(n) = %.4f%n",
                h, logn, alpha * logn);

        return h < alpha * logn;
    }

    public static <T> boolean shouldUseDistributionSort(List<T> data, double alpha) {
        int n = data.size();
        if (n < 2) return false;

        double h    = entropy(data);
        double logn = Math.log(n) / Math.log(2);

        System.out.printf("    H = %.4f, log2(n) = %.4f, α·log2(n) = %.4f%n",
                h, logn, alpha * logn);

        return h < alpha * logn;
    }
}

