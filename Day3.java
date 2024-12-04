import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.StringUTF16.charAt;

public class Day3 {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/Day3Input.txt");
        String gibberish = fileData.get(0);
        ArrayList<String> allMatches = new ArrayList<>();
        String regex = "mul\\([1-99],[1-99]\\)";
        Matcher m = Pattern.compile(regex).matcher(gibberish);
        while (m.find()) {
            allMatches.add(m.group());
        }
        System.out.println(allMatches);
        for (int i = 0; i < allMatches.size(); i++) {
            for (int j = 0; j < allMatches.get(i).length(); j++) {
                if (charAt(j).is)
            }
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