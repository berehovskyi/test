import java.io.*;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException {
        generateRandomBitSequence();
        String result = getResult();
        writeResult(result);
    }

    private static void generateRandomBitSequence() throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("input.txt", false));
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            stringBuilder.append(random.nextInt(2));
        }
        bufferedWriter.write(stringBuilder.toString());
        bufferedWriter.close();
    }

    private static String getResult() throws IOException {
        var result = 0;
        var temp = 0;
        BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));
        String read = bufferedReader.readLine();
        char[] chars = read.toCharArray();
        for (char tempChar : chars) {
            if (tempChar == '1') {
                temp += 1;
            } else {
                if (temp > result) {
                    result = temp;
                }
                temp = 0;
            }
        }
        return String.valueOf(result);
    }

    private static void writeResult(String result) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt", false));
        bufferedWriter.write(result);
        bufferedWriter.close();
    }
}