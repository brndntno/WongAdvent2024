import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day6 {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/Day6Input.txt");
        int rows = fileData.size();
        int columns = fileData.get(0).length();
        String[][] puzzle = new String[rows][columns];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                puzzle[r][c] = fileData.get(r).substring(c, c + 1);
            }
        }
        int guardRow = 0;
        int guardColumn = 0;
        for (int r = 0; r < puzzle.length; r++) {
            for (int c = 0; c < puzzle[0].length; c++) {
                if (puzzle[r][c].equals("^") || puzzle[r][c].equals("v")) {
                    guardRow = r;
                    guardColumn = c;
                }
                if (puzzle[r][c].equals(">") || puzzle[r][c].equals("<")) {
                    guardRow = r;
                    guardColumn = c;
                }
            }
        }
        int r = guardRow;
        int c = guardColumn;
        String temp = puzzle[r][c];
        while (rowInBounds(r,puzzle) && columnInBounds(c,puzzle)) {
            if (temp.equals("^")) {
                if (puzzle[r][c].equals("#")) {
                    temp = changeDirection("^");
                } else {
                    puzzle[r][c] = "X";
                    r--;
                }
            }
            if (temp.equals("v")) {
                if (puzzle[r][c].equals("#")) {
                    temp = changeDirection("v");
                } else {
                    puzzle[r][c] = "X";
                    r++;
                }
            }
            if (temp.equals(">")) {
                if (puzzle[r][c].equals("#")) {
                    temp = changeDirection(">");
                } else {
                    puzzle[r][c] = "X";
                    c++;
                }
            }
            if (temp.equals("<")) {
                if (puzzle[r][c].equals("#")) {
                    temp = changeDirection("<");
                } else {
                    puzzle[r][c] = "X";
                    c--;
                }
            }
        }
        for (int i = 0; i < puzzle.length; i++) {
            for (int j = 0; j < puzzle[0].length; j++) {
                System.out.print(puzzle[i][j]);
            }
            System.out.println();
        }
    }

    public static boolean rowInBounds(int row, String[][] puzzle) {
        if (row >= 0 && row < puzzle.length) {
            return true;
        }
        return false;
    }

    public static boolean columnInBounds(int column, String[][] puzzle) {
        if (column >= 0 && column < puzzle[0].length) {
            return true;
        }
        return false;
    }

    public static String changeDirection(String direction) {
        if (direction.equals("^")) {
            return ">";
        }
        if (direction.equals("v")) {
            return "<";
        }
        if (direction.equals(">")) {
            return "v";
        }
        return "^";
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