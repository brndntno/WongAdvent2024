import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
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

        Collections.sort(ints);
        Collections.sort(ints2);

        int sum = 0;
        for (int i = 0; i < fileData.size(); i++) {
            int diff = Math.abs(ints.get(i) - ints2.get(i));
            sum += diff;
        }

        System.out.println(sum);
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