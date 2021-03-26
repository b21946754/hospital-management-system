import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.Files;

// Returns the file's lines as array elements
public class Input {
    public static String[] readFile (String path) {
        try {
            int length = 0;
            int i = 0;
            for (String line : Files.readAllLines(Paths.get(path))) {
                if (line.length() > 0)
                    length++;
            }
            String[] results = new String[length];
            for (String line : Files.readAllLines(Paths.get(path))) {
                if (line.length() > 0)
                    results[i++] = line;
            }
            return results;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to read the input file");
            return null;
        }
    }
    // Splits the readFile method's output lines to elements
    public static String[][] splitReadFile (String path, String splitChar) {
        String[] inputFile = readFile(path);
        assert inputFile != null;
        int lineLength = inputFile[0].split(splitChar).length;
        String[][] outputFile = new String[inputFile.length][lineLength];
        int i = 0;
        for (String line : inputFile) {
            String[] splitLine = line.split(splitChar);
            outputFile[i++] = splitLine;
        }

        return outputFile;
    }
}