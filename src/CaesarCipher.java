import java.util.Arrays;
import java.util.List;

class CaesarCipher {

    private final static List alphabet = Arrays.asList("ABCDEFGHIJKLMNOPQRSTUVWXYZ".split(""));
    private String[] word;
    private int key;

    /**
     * @param word string to be proceeded
     * @param key offset value
     */
    CaesarCipher(String word, int key) {
        this.word = word.toUpperCase().split("");
        this.key = key;
    }

    void encode() {
        String[] encoded = new String[this.word.length]; // array to store the result
        int i = 0;

        for (String s : this.word) {
            int index = alphabet.indexOf(s); // get index of single character of word in alphabet
            int offset = (index + this.key) % alphabet.size(); // add key value and do modulo operation to get index of encoded character
            encoded[i] = (String) alphabet.get(offset); // append encoded character to result

            i++;
        }

        this.word = encoded;
    }

    void decode() {
        String[] decoded = new String[this.word.length]; // array to store the result
        int i = 0;

        for (String s : this.word) {
            int index = alphabet.indexOf(s); // get index of single character of word in alphabet

            // add key value and do modulo operation to get index of decoded character
            int offset = (index - this.key) % alphabet.size();
            // modulo of negative number is also negative so we must cast it to positive
            if (offset < 0) offset += alphabet.size();

            decoded[i] = (String) alphabet.get(offset); // append decoded character to result

            i++;
        }

        this.word = decoded;
    }

    static boolean isCipheredCorrectly(String word, String cipher) {
        // ciphers word with all keys and checks if any result is equaled to given cipher
        for (int i = 0; i < alphabet.size(); i++) {
            CaesarCipher ciphered = new CaesarCipher(word, i);
            ciphered.encode();
            if (ciphered.toString().equals(cipher)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String s : this.word) {
            sb.append(s);
        }

        return sb.toString();
    }
}
