import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day7 {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/Day7Input.txt");
        System.out.println(fileData);

        int sum = 0;

        for (int i = 0; i < fileData.size(); i++) {
            String sample = fileData.get(i);
            String[] splitSample = sample.split(" ");
            sum += result(splitSample);
        }

        System.out.println(sum);
    }

    public static int result(String[] splitSample) {
        int sum = 0;
        for (int i = 1; i < splitSample.length; i++) {
            sum += Integer.parseInt(splitSample[i]);
        }
        if (sum == Integer.parseInt(splitSample[0].substring(0, splitSample[0].length() - 1))) {
            return sum;
        } else {
            sum = 1;
        }
        for (int i = 1; i < splitSample.length; i++) {
            sum *= Integer.parseInt(splitSample[i]);
        }
        if (sum == Integer.parseInt(splitSample[0].substring(0, splitSample[0].length() - 1))) {
            return sum;
        } else {
            sum = 0;
        }
        for (int i = 1; i < splitSample.length; i++) {
            if (Integer.parseInt(splitSample[i]) % 2 == 1) {
                sum += Integer.parseInt(splitSample[i]);
            } else {
                sum *= Integer.parseInt(splitSample[i]);
            }
        }
        if (sum == Integer.parseInt(splitSample[0].substring(0, splitSample[0].length() - 1))) {
            return sum;
        } else {
            sum = 1;
        }
        for (int i = 1; i < splitSample.length; i++) {
            if (Integer.parseInt(splitSample[i]) % 2 == 1) {
                sum *= Integer.parseInt(splitSample[i]);
            } else {
                sum += Integer.parseInt(splitSample[i]);
            }
        }
        if (sum == Integer.parseInt(splitSample[0].substring(0, splitSample[0].length() - 1))) {
            return sum;
        } else {
            return 0;
        }
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