public class CharExtrema {

    public char minimum;
    public char maximum;

    /**
     * Constructor for a character extrema representation to establish the range of characters.
     * @param min the minimum extremum for the range
     * @param max the maximum extremum for the range
     */
    CharExtrema(char min, char max) {

        // Anticipate if the maximum and minimum are in the wrong order, correct them
        if (max < min) {
            minimum = max;
            maximum = min;
            return;
        }

        minimum = min;
        maximum = max;

    }

    /**
     * rangeContains determines if a character is in a range between two extrema.
     * @param character the character to check
     * @return true or false whether the character is between the two extrema
     */
    public boolean rangeContains(char character) {

        return minimum <= character && maximum >= character;

    }

    /**
     * rangeSize calculates the size of the range, based to the two extrema.
     * @return the size of the range
     */
    public int rangeSize() {

        return (maximum - minimum) + 1;

    }

}
