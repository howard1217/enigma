package enigma;

/** Class that represents a reflector in the enigma.
 *  @author Chia-Hao Chiao
 */
class Reflector extends Rotor {

    /** The position of the rotor. **/
    private int _position;

    /** The type of the rotor. **/
    private String _type;

    /** A Reflector with position POSITION0, setting SETTING0, type TYPE0. **/
    public Reflector(int position0, String type0) {
        super(position0, 'A', type0);
        _position = position0;
        _type = type0;
    }

    @Override
    boolean hasInverse() {
        return false;
    }

    /** Returns a useless value; should never be called. */
    @Override
    int convertBackward(int unused) {
        throw new UnsupportedOperationException("No backward.");
    }
}
