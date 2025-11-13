import java.io.*;
import java.nio.file.*;
import java.util.regex.*;

public class ResumeExtractor {
    public static void main(String[] args) {
        String inputDir = "input_resumes";
        String outputDir = "output_resumes";

        try {
            Files.createDirectories(Paths.get(outputDir));
            File[] files = new File(inputDir).listFiles((dir, name) -> name.endsWith(".txt"));

            if (files != null) {
                for (File file : files) {
                    String content = new String(Files.readAllBytes(file.toPath()));

                    String name = extractName(content);
                    String email = extractEmail(content);
                    String skills = extractSkills(content);

                    String formatted = "Name: " + name + "\n" +
                                       "Email: " + email + "\n" +
                                       "Skills: " + skills + "\n";

                    String outputFileName = outputDir + "/" + file.getName();
                    Files.write(Paths.get(outputFileName), formatted.getBytes());
                    System.out.println("Processed: " + file.getName());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String extractName(String text) {
        Pattern p = Pattern.compile("Name\\s*[:\\-]?\\s*(\\w+\\s\\w+)", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(text);
        return m.find() ? m.group(1) : "Not Found";
    }

    private static String extractEmail(String text) {
        Pattern p = Pattern.compile("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-z]{2,}", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(text);
        return m.find() ? m.group() : "Not Found";
    }

    private static String extractSkills(String text) {
        Pattern p = Pattern.compile("Skills\\s*[:\\-]?\\s*(.+)", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(text);
        return m.find() ? m.group(1).trim() : "Not Found";
    }
}

