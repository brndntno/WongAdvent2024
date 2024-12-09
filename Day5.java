import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day5 {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/Day5Input.txt");
        ArrayList<String> fileData2 = getFileData("src/Day5Input2.txt");
        ArrayList<String> matches = new ArrayList<>();

        for (int i = 0; i < fileData2.size(); i++) {
            int incorrect = 0;
            for (int j = 0; j < fileData.size(); j++) {
                String[] splitSample = fileData.get(j).split("|");
                String num1 = splitSample[0] + splitSample[1];
                String num2 = splitSample[2] + splitSample[3];
                if (fileData2.get(i).contains(num1) && fileData2.get(i).contains(num2)) {
                    if (fileData2.get(i).indexOf(num1) > fileData2.get(i).indexOf(num2)) {
                        incorrect++;
                    }
                }
            }
            if (incorrect == 0) {
                matches.add(fileData2.get(i));
            }
        }

        for (int i = 0; i < matches.size(); i++) {
            System.out.println(matches.get(i));
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