package enigma;

/** Class that represents a complete enigma machine.
 *  @author Chia-Hao Chiao
 */
class Machine {

    /** Represent all the rotors. */
    private Rotor[] _machine = new Rotor[5];

    /** A machine with 5 ROTORS and 1 configuration (ex. {"B",
     *  "BETA", "III", "IV", "I", "AXLE"}). */
    public Machine(String[] rotors) {
        int setting1 = Rotor.toIndex(rotors[5].charAt(0));
        int setting2 = Rotor.toIndex(rotors[5].charAt(1));
        int setting3 = Rotor.toIndex(rotors[5].charAt(2));
        int setting4 = Rotor.toIndex(rotors[5].charAt(3));
        _machine[0] = new Reflector(0, rotors[0]);
        _machine[1] = new FixedRotor(1, setting1, rotors[1]);
        _machine[2] = new Rotor(2, setting2, rotors[2]);
        _machine[3] = new Rotor(3, setting3, rotors[3]);
        _machine[4] = new Rotor(4, setting4, rotors[4]);
    }

    /** Return the I th rotor in the machine. */
    public Rotor getMachine(int i) {
        return _machine[i];
    }

    /** Set my rotors to (from left to right) ROTORS.  Initially, the rotor
     *  settings are all 'A'. */
    void replaceRotors(Rotor[] rotors) {
    }

    /** Set my rotors according to SETTING, which must be a string of four
     *  upper-case letters. The first letter refers to the leftmost
     *  rotor setting.  */
    void setRotors(String setting) {
    }

    /** Completes movements due to notches if there is any. */
    void moveNotch() {
        boolean atNotch4 = ((Rotor) _machine[4]).atNotch();
        boolean atNotch3 = ((Rotor) _machine[3]).atNotch();
        if (atNotch3) {
            ((Rotor) _machine[3]).advance();
            ((Rotor) _machine[2]).advance();
        } else if (atNotch4) {
            ((Rotor) _machine[3]).advance();
        }
    }

    /** The divider of the modular. */
    public static final int DIVIDER = 26;

    /** Returns the encoding/decoding of MSG, updating the state of
     *  the rotors accordingly. */
    String convert(String msg) {
        if (msg.matches(".*\\d.*")) {
            throw new IllegalArgumentException("Message has to be all letters");
        }
        String uppermsg = msg.toUpperCase();
        char[] result =  uppermsg.replaceAll("[^a-z^A-Z]", "").toCharArray();
        int temp = 0;
        for (int i = 0; i < result.length; i += 1) {
            moveNotch();
            _machine[4].advance();
            temp = Rotor.toIndex(result[i]);
            for (int j = 4; j >= 1; j -= 1) {
                temp = (temp + ((Rotor) _machine[j]).getSetting()) % DIVIDER;
                temp = ((Rotor) _machine[j]).convertForward(temp);
                temp -= ((Rotor) _machine[j]).getSetting();
                if (temp < 0) {
                    temp += DIVIDER;
                }
            }
            temp = ((Rotor) _machine[0]).convertForward(temp);
            for (int k = 1; k <= 4; k += 1) {
                temp = (temp + ((Rotor) _machine[k]).getSetting()) % DIVIDER;
                temp = ((Rotor) _machine[k]).convertBackward(temp);
                temp -= ((Rotor) _machine[k]).getSetting();
                if (temp < 0) {
                    temp += DIVIDER;
                }
            }
            result[i] = Rotor.toLetter(temp);
        }
        return new String(result);
    }
}
