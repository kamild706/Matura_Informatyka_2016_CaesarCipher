import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Exercise3 {

    public static void main(String[] args) throws Exception {
        String fileName = System.getProperty("user.dir") + "/files/dane_6_3.txt";

        Stream<String> stream = Files.lines(Paths.get(fileName));
        stream.forEach(Exercise3::process);
    }

    private static void process(String line) {
        String[] params = line.split(" ");

        if (!CaesarCipher.isCipheredCorrectly(params[0], params[1]))
            System.out.println(params[0]);
    }
}
