package algorythms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TrialDivision {

    public static void main(String[] args) throws IOException {
        Long inputNumber = inputNumber();
        List<Long> divisors = getAllDivisorsOfNumber(inputNumber);
        System.out.println(divisors);
    }

    private static Long inputNumber() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return Long.parseLong(reader.readLine());
    }

    private static List<Long> getAllDivisorsOfNumber(Long number) {
        Set<Long> divisors = new TreeSet<>();
        for (long i = 1; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                divisors.add(i);
                divisors.add(number / i);
            }
        }
        return new ArrayList<>(divisors);
    }
}
