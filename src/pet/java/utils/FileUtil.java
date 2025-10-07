package pet.java.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.List;

public class FileUtil {
    public FileUtil() {
    }

    public void updateContentInFile(Path path, List<String> lines) {
        try {
            Files.write(path, lines);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public String getPath(String getName) {
        LocalDateTime timeNow = LocalDateTime.now();
        String path = String.valueOf(
                timeNow.getYear()) +
                String.valueOf(timeNow.getMonth().getValue()) + String.valueOf(timeNow.getDayOfMonth() +
                "T" + String.valueOf(timeNow.getHour()) + String.valueOf(timeNow.getMinute()) +
                "-" + getName.replaceAll("\\s", "")
        );
        return path;
    }

    public void renameFile(Path oldPath, Path newPath) {
        try {
            Files.move(oldPath, newPath);
            System.out.println("Arquivo renomeado com sucesso!");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
