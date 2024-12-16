
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3Pt2 {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/Day3Input.txt");
        String gibberish = fileData.get(0);
        ArrayList<String> allMatches = new ArrayList<>();

        String regex = "mul\\([0-9]{1,3},[0-9]{1,3}\\)";
        String yes = "do()";
        String no = "don't()";
        Matcher m = Pattern.compile(regex).matcher(gibberish);
        Matcher n = Pattern.compile(yes).matcher(gibberish);
        Matcher o = Pattern.compile(no).matcher(gibberish);

        while (m.find() && n.find() && o.find()) {
            allMatches.add(m.group());
            allMatches.add(n.group());
            allMatches.add(o.group());
        }

        System.out.println(allMatches);

        int sum = 0;

        for (int i = 0; i < allMatches.size(); i++) {
            String[] splitSample = allMatches.get(i).split(",");
            int num = Integer.parseInt(splitSample[0].substring(4));
            int index = splitSample[1].indexOf(")");
            int num2 = Integer.parseInt(splitSample[1].substring(0, index));
            sum += num * num2;
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