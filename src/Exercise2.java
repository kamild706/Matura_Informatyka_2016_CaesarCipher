import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Exercise2 {

    public static void main(String[] args) throws Exception {
        String fileName = System.getProperty("user.dir") + "/files/dane_6_2.txt";

        Stream<String> stream = Files.lines(Paths.get(fileName));
        stream.forEach(Exercise2::process);
    }

    private static void process(String line) {
        String[] params = line.split(" ");
        CaesarCipher cipher = new CaesarCipher(
                params[0],
                (params.length == 2) ? Integer.parseInt(params[1]) : 0
        );
        cipher.decode();
        System.out.println(cipher);
    }
}