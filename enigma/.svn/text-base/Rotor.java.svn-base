package enigma;

/** Class that represents a rotor in the enigma machine.
 *  @author Chia-Hao Chiao
 */
class Rotor {
    /** The position of the rotor. **/
    private int _position;

    /** The type of the rotor. **/
    private String _type;

    /** The length of the the array of all types of rotors. */
    public static final int ROTORSLEN = 12;

    /** Returns the permutation data of the rotor. **/
    public String[] permutationData() {
        for (int i = 0; i < ROTORSLEN; i += 1) {
            if (_type.equals(PermutationData.ROTOR_SPECS[i][0])) {
                return PermutationData.ROTOR_SPECS[i];
            }
        }
        throw new IllegalArgumentException("Can't find permutation");
    }

    /** A Rotor with position POSITION0, setting SETTING0, type TYPE0. **/
    public Rotor(int position0, int setting0, String type0) {
        _position = position0;
        _setting = setting0;
        _type = type0;
    }

    /** Size of alphabet used for plaintext and ciphertext. */
    static final int ALPHABET_SIZE = 26;

    /** Assuming that P is an integer in the range 0..25, returns the
     *  corresponding upper-case letter in the range A..Z. */
    static char toLetter(int p) {
        return (char) (p + 'A');
    }

    /** Assuming that C is an upper-case letter in the range A-Z, return the
     *  corresponding index in the range 0..25. Inverse of toLetter. */
    static int toIndex(char c) {
        return c - 'A';
    }

    /** Returns true iff this rotor has a ratchet and can advance. */
    boolean advances() {
        if (getPosition() >= 3) {
            return true;
        }
        return false;
    }

    /** Returns true iff this rotor has a left-to-right inverse. */
    boolean hasInverse() {
        for (int i = 0; i < 10; i += 1) {
            if (PermutationData.ROTOR_SPECS[i][0] == _type) {
                return true;
            }
        }
        return false;
    }

    /** Return my current rotational setting as an integer between 0
     *  and 25 (corresponding to letters 'A' to 'Z').  */
    int getSetting() {
        return _setting;
    }

    /** Return my current position which is unchanged. */
    int getPosition() {
        return _position;
    }

    /** Return my current type which is unchanged. */
    String getType() {
        return _type;
    }

    /** Set getSetting() to POSN.  */
    void set(int posn) {
        assert 0 <= posn && posn < ALPHABET_SIZE;
        _setting = posn;
    }

    /** Return the conversion of P (an integer in the range 0..25)
     *  according to my permutation. */
    int convertForward(int p) {
        String permutation = permutationData()[1];
        return toIndex(permutation.charAt(p));
    }

    /** Return the conversion of E (an integer in the range 0..25)
     *  according to the inverse of my permutation. */
    int convertBackward(int e) {
        String permutation = permutationData()[2];
        return toIndex(permutation.charAt(e));
    }

    /** Returns true iff I am positioned to allow the rotor to my left
     *  to advance. */
    boolean atNotch() {
        if (permutationData()[3].length() == 1) {
            if (toIndex(permutationData()[3].charAt(0)) == getSetting()) {
                return true;
            }
            return false;
        } else if (toIndex(permutationData()[3].charAt(0)) == getSetting()
            || toIndex(permutationData()[3].charAt(1)) == getSetting()) {
            return true;
        }
        return false;
    }

    /** The length of the the array of all alphabets. */
    public static final int ALPHA = 25;

    /** Advance me one position. */
    void advance() {
        if (_setting == ALPHA) {
            _setting = 0;
        } else {
            _setting += 1;
        }
    }

    /** Advance me K position. */
    void advanceMore(int k) {
        for (int i = 0; i < k; i += 1) {
            _setting += 1;
        }
    }

    /** My current setting (index 0..25, with 0 indicating that 'A'
     *  is showing). */
    private int _setting;

}
