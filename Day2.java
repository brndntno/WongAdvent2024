
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Day2 {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Day2Input.txt");

        System.out.println(fileData);

        int numSafe = 0;
        for (int i = 0; i < fileData.size(); i++) {
            String sample = fileData.get(i);
            String[] splitSample = sample.split(" ");
            int numUnsafe = 0;
            int numIncrease = 0;
            int numDecrease = 0;
            for (int j = 0; j < splitSample.length - 1; j++) {
                int first = Integer.parseInt(splitSample[j]);
                int second = Integer.parseInt(splitSample[j + 1]);
                if (first > second) {
                    numDecrease++;
                }
                if (second > first) {
                    numIncrease++;
                }
                int diff = Math.abs(first - second);
                if (diff > 3 || diff == 0) {
                    numUnsafe++;
                }
                if (numIncrease != 0 && numDecrease != 0) {
                    numUnsafe++;
                }
            }
            if (numUnsafe == 0) {
                numSafe++;
            }
        }

        System.out.println(numSafe);
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
