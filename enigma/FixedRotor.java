package enigma;

/** Class that represents a rotor that has no ratchet and does not advance.
 *  @author Chia-Hao Chiao
 */
class FixedRotor extends Rotor {

    /** The position of the rotor. **/
    private int _position;

    /** The type of the rotor. **/
    private String _type;

    /** My current setting (index 0..25, with 0 indicating that 'A'
    /*  is showing). */
    private int _setting;

    /** A FixedRotor with position POSITION0, setting SETTING0, type TYPE0. **/
    public FixedRotor(int position0, int setting0, String type0) {
        super(position0, setting0, type0);
        _position = position0;
        _setting = setting0;
        _type = type0;
    }

    @Override
    boolean advances() {
        return false;
    }

    @Override
    boolean atNotch() {
        return false;
    }

    /** Fixed rotors do not advance. */
    @Override
    void advance() {
    }

}
