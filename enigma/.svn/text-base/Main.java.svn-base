package enigma;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/** Enigma simulator.
 *  @author Chia-Hao Chiao
 */
public final class Main {

    /** Process a sequence of encryptions and decryptions, as
     *  specified in the input from the standard input.  Print the
     *  results on the standard output. Exits normally if there are
     *  no errors in the input; otherwise with code 1. */
    public static void main(String[] unused) {
        Machine M;
        BufferedReader input =
            new BufferedReader(new InputStreamReader(System.in));

        M = null;

        try {
            while (true) {
                String line = input.readLine();
                if (line == null) {
                    break;
                }
                String[] line1 = line.split(" ");
                String[] config = Arrays.copyOfRange(line1, 1, line1.length);
                if (isConfigurationLine(line)) {
                    M = new Machine(config);
                } else {
                    printMessageLine(M.convert(line));
                }
            }
        } catch (IOException excp) {
            System.err.printf("Error: %s%n", excp.getMessage());
            System.exit(1);
        } catch (java.lang.ArrayIndexOutOfBoundsException excp) {
            System.err.printf("Error: %s%n", excp.getMessage());
            System.exit(1);
        } catch (IllegalArgumentException excp) {
            System.err.printf("Error: %s%n", excp.getMessage());
            System.exit(1);
        } catch (java.lang.NullPointerException excp) {
            System.err.printf("Error: %s%n", excp.getMessage());
            System.exit(1);
        }
    }

    /** The length of the the array of all types of rotors. */
    public static final int ROTORSLEN = 12;

    /** Return true iff LINE is an Enigma configuration line. */
    public static boolean isConfigurationLine(String line) {
        if (line.length() == 0 || line.equals("")) {
            return false;
        }
        if (line != line.toUpperCase()) {
            return false;
        }
        String[] config = line.split(" ");
        if (!config[0].equals("*")) {
            return false;
        }
        String[] rotors = new String[ROTORSLEN];
        String[] usedrotors = new String[3];
        for (int i = 0; i < ROTORSLEN; i += 1) {
            rotors[i] = PermutationData.ROTOR_SPECS[i][0];
        }
        List<String> list = Arrays.asList(rotors);
        List<String> sublist1 = list.subList(10, ROTORSLEN);
        List<String> sublist2 = list.subList(8, 10);
        List<String> sublist3 = list.subList(0, 8);
        for (int l = 1; l < 7; l += 1) {
            for (int k = 0; k < config[l].length(); k += 1) {
                if (Character.isDigit(config[l].charAt(k))) {
                    return false;
                }
            }
        }
        if (!sublist1.contains(config[1])) {
            return false;
        } else if (!sublist2.contains(config[2])) {
            return false;
        }
        for (int j = 3; j < 6; j += 1) {
            for (int k = 0; k < j - 3; k += 1) {
                if (usedrotors[k].equals(config[j])) {
                    return false;
                }
            }
            usedrotors[j - 3] = config[j];
            if (!sublist3.contains(config[j])) {
                return false;
            }
        }
        if (!config[6].matches("\\A\\p{ASCII}*\\z")) {
            return false;
        }
        if (config[6].length() != 4) {
            return false;
        }
        return true;
    }


    /** Print MSG in groups of five (except that the last group may
     *  have fewer letters). */
    private static void printMessageLine(String msg) {
        int temp = 0;
        if (msg.length() <= 5) {
            System.out.println(msg);
        } else {
            for (int i = 0; i < msg.length() - 5; i += 5) {
                System.out.print(msg.substring(i, i + 5));
                System.out.print(" ");
                temp = i;
            }
            System.out.println(msg.substring(temp + 5, msg.length()));
        }
    }
}

