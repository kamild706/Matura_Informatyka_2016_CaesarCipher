import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Exercise1 {

    public static void main(String[] args) throws Exception {
        String fileName = System.getProperty("user.dir") + "/files/dane_6_1.txt";

        Stream<String> stream = Files.lines(Paths.get(fileName));
        stream.forEach(Exercise1::process);
    }

    private static void process(String line) {
        CaesarCipher cipher = new CaesarCipher(line, 107);
        cipher.encode();
        System.out.println(cipher);
    }
}
