import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day4 {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/Day4Input.txt");

        int rows = fileData.size();
        int columns = fileData.get(0).length();
        String[][] grid = new String[rows][columns];

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                grid[r][c] = fileData.get(r).substring(c, c+1);
                System.out.print(grid[r][c]);
            }
            System.out.println();
        }

    }

    public boolean east(String[][] grid, int r, int c) {
        if (grid[r][c].equals("X")) {
            if (grid[r][c+1].equals("M")) {
                if (grid[r][c+2].equals("A")) {
                    if (grid[r][c+3].equals("S")) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean northEast(String[][] grid, int r, int c) {
        if (grid[r][c].equals("X")) {
            if (grid[r-1][c+1].equals("M")) {
                if (grid[r-2][c+2].equals("A")) {
                    if (grid[r-3][c+3].equals("S")) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean west(String[][] grid, int r, int c) {
        if (grid[r][c].equals("X")) {
            if (grid[r][c-1].equals("M")) {
                if (grid[r][c-2].equals("A")) {
                    if (grid[r][c-3].equals("S")) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean north(String[][] grid, int r, int c) {
        if (grid[r][c].equals("X")) {
            if (grid[r-1][c].equals("M")) {
                if (grid[r-2][c].equals("A")) {
                    if (grid[r-3][c].equals("S")) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean south(String[][] grid, int r, int c) {
        if (grid[r][c].equals("X")) {
            if (grid[r+1][c].equals("M")) {
                if (grid[r+2][c].equals("A")) {
                    if (grid[r+3][c].equals("S")) {
                        return true;
                    }
                }
            }
        }
        return false;
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