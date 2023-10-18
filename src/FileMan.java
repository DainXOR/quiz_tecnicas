import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class FileMan {
    private static Path PATH;

    public static void setFile(Path path){
        PATH = path;
    }

    public static String readFile() throws IOException {
        //Delimitado por espacios por defecto
        //s.useDelimiter(",\\s*");
        //s.useDelimiter("\\t");
        StringBuilder data = new StringBuilder();

        try (Scanner s = new Scanner(new BufferedReader(new FileReader(PATH.toString())))) {
            while (s.hasNext()) {
                data.append(s.next());
            }
        }

        return data.toString();
    }
}
