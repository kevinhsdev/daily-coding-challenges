import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        String header;
        while ((header = in.readLine()) != null) {
            int n = parseCount(header);
            if (n < 0) continue; // linha que nao e o contador do caso: ignora

            for (int i = 0; i < n; i++) {
                String line = in.readLine();
                if (line == null) break;
                out.append(encrypt(line)).append('\n');
            }
        }

        System.out.print(out);
    }

    /** Retorna N se a linha for um inteiro valido; caso contrario, -1. */
    private static int parseCount(String line) {
        String value = line.trim();
        if (value.isEmpty()) return -1;

        for (int i = 0; i < value.length(); i++) {
            if (!Character.isDigit(value.charAt(i))) return -1;
        }

        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static String encrypt(String line) {
        char[] chars = line.toCharArray();

        // Parte 1: desloca cada letra 3 posicoes a direita na tabela ASCII.
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                chars[i] += 3;
            }
        }

        // Parte 2a: inverte a linha.
        for (int i = 0, j = chars.length - 1; i < j; i++, j--) {
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
        }

        // Parte 2b: da metade (truncada) em diante, desloca 1 posicao a esquerda.
        for (int i = chars.length / 2; i < chars.length; i++) {
            chars[i] -= 1;
        }

        return new String(chars);
    }
}