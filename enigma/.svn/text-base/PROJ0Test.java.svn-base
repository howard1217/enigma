package enigma;

/** java HW1Test should test the methods defined in Progs.
 *  @author Chia-Hao Chiao
 */
public class PROJ0Test {

    private static Rotor _A = new Rotor(5, 4, "I");
    private static Rotor _B = new Rotor(1, 0, "B");
    private static Rotor _C = new Rotor(4, 9, "IV");

    /** Run all tests. */
    public static void main(String[] args) {
        report("toLetter", testtoLetter());
        report("toIndex", testtoIndex());
        report("advances", testadvances());
        report("hasInverse", testhasInverse());
        report("permutationData", testpermutationData());
        report("convertForward", testconvertForward());
        report("convertBackward", testconvertBackward());
        report("atNotch", testatNotch());
        report("advanceMore", testadvanceMore());
        report("convert", testconvert());
        report("isConfigurationLine", testisConfigurationLine());
    }

    /** Print message that test NAME has (if ISOK) or else has not
     *  passed. */
    private static void report(String name, boolean isOK) {
        if (isOK) {
            System.out.printf("%s OK.%n", name);
        } else {
            System.out.printf("%s FAILS.%n", name);
        }
    }

    /** Return the Nth test rotor. */
    public static Rotor testRotor(int n) {
        if (n == 1) {
            return _A;
        }
        if (n == 2) {
            return _B;
        } else {
            return _C;
        }
    }

    /** Return true iff permutationData passes its tests. */
    private static boolean testpermutationData() {
        if (testRotor(1).permutationData()[1]
            != PermutationData.ROTOR_SPECS[0][1]) {
            return false;
        }
        if (testRotor(2).permutationData()[1]
            != PermutationData.ROTOR_SPECS[10][1]) {
            return false;
        }
        return true;
    }

    /** Return true iff toLetter passes its tests. */
    private static boolean testtoLetter() {
        if (Rotor.toLetter(0) != 'A') {
            return false;
        }
        if (Rotor.toLetter(5) != 'F') {
            return false;
        }
        if (Rotor.toLetter(21) != 'V') {
            return false;
        }
        return true;
    }

    /** Return true iff toIndex passes its tests. */
    private static boolean testtoIndex() {
        if (Rotor.toIndex('A') != 0) {
            return false;
        }
        if (Rotor.toIndex('F') != 5) {
            return false;
        }
        if (Rotor.toIndex('V') != 21) {
            return false;
        }
        return true;
    }

    /** Return true iff advances passes its tests. */
    private static boolean testadvances() {
        if (testRotor(1).advances()) {
            return true;
        }
        return false;
    }

    /** Return true iff advances passes its tests. */
    private static boolean testhasInverse() {
        if (!testRotor(1).hasInverse() && testRotor(2).hasInverse()) {
            return true;
        }
        return false;
    }

    /** Return true iff convertForward passes its tests. */
    private static boolean testconvertForward() {
        if (testRotor(1).convertForward(1) != 10) {
            return false;
        }
        if (testRotor(2).convertForward(1) != 13) {
            return false;
        }
        return true;
    }

    /** Return true iff convertBackward passes its tests. */
    private static boolean testconvertBackward() {
        if (testRotor(1).convertBackward(1) != 22) {
            return false;
        }
        return true;
    }

    /** Return true iff atNotch passes its tests. */
    private static boolean testatNotch() {
        if (testRotor(1).atNotch()) {
            return false;
        }
        if (!testRotor(3).atNotch()) {
            return false;
        }
        return true;
    }

    /** Return true iff advanceMore passes its tests. */
    private static boolean testadvanceMore() {
        Rotor D = new Rotor(5, 4, "I");
        D.advanceMore(4);
        if (D.getSetting() != 8) {
            return false;
        }
        return true;
    }

    /** Return true iff convert in Machine.java passes its tests. */
    private static boolean testconvert() {
        String[] rotors = {"B", "BETA", "III", "IV", "I", "AXLE"};
        Machine M = new Machine(rotors);
        String message = "FROM his shoulder Hiawatha";
        String converted = M.convert(message);
        System.out.println(converted);
        if (converted.equals("HYIHLBKOMLIUYDC")) {
            return false;
        }
        return true;
    }

    /** Return true iff isConfigurationLine passes its tests. */
    private static boolean testisConfigurationLine() {
        String line1 = "* B BETA III IV I AXLE";
        String line2 = "^ B BETA III IV I AXLE";
        String line3 = "* b BETA III IV I AXLE";
        String line4 = "* B IV III IV I AXLE";
        String line5 = "* B BETA III IV I AXL2";
        if (!Main.isConfigurationLine(line1)) {
            return false;
        }
        if (Main.isConfigurationLine(line2)) {
            return false;
        }
        if (Main.isConfigurationLine(line3)) {
            return false;
        }
        if (Main.isConfigurationLine(line4)) {
            return false;
        }
        if (Main.isConfigurationLine(line5)) {
            return false;
        }
        return true;
    }
}
