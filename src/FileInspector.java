import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileInspector {
    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser("./src");
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try (BufferedReader reader = new BufferedReader(new FileReader(selectedFile))) {
                int lineCount = 0, wordCount = 0, charCount = 0;
                String line;
                while ((line = reader.readLine()) != null) {
                    lineCount++;
                    wordCount += line.split("\\s+").length;
                    charCount += line.length();
                }
                System.out.println("File: " + selectedFile.getName());
                System.out.println("Lines: " + lineCount);
                System.out.println("Words: " + wordCount);
                System.out.println("Characters: " + charCount);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}