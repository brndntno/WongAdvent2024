import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Scanner;

public class Day1 {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Day1Input.txt");

        ArrayList<Integer> ints = new ArrayList<>();
        ArrayList<Integer> ints2 = new ArrayList<>();

        for (int i = 0; i < fileData.size(); i++) {
            String sample = fileData.get(i);
            String[] splitSample = sample.split("   ");
            String first = splitSample[0];
            String second = splitSample[1];
            ints.add(Integer.parseInt(first));
            ints2.add(Integer.parseInt(second));
        }

        int sum = 0;
        for (int i = 0; i < ints.size(); i++) {
            int occur = 0;
            for (int j = 0; j < ints2.size(); j++) {
                if (Objects.equals(ints.get(i), ints2.get(j))) {
                    occur++;
                }
            }
            sum += ints.get(i) * occur;
        }

        System.out.println(sum);

        Collections.sort(ints);
        Collections.sort(ints2);

        int sum2 = 0;
        for (int i = 0; i < fileData.size(); i++) {
            int diff = Math.abs(ints.get(i) - ints2.get(i));
            sum2 += diff;
        }

        System.out.println(sum2);


    }

    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals(""))
                    fileData.add(line);
            }
            return fileData;
        } catch (FileNotFoundException e) {
            return fileData;
        }
    }
}