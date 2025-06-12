public class Cipher {

    static CharExtrema aToz = new CharExtrema('a', 'z');
    static CharExtrema AToZ = new CharExtrema('A', 'Z');

    /**
     * shiftCharacter handles shifting an individual character forwards or backwards while simultaneously handling edge
     * cases where the character shift exits the range defined by the character extrema.
     * @param character the character to base the shift off of
     * @param offset how far the character needs to be shifted
     * @param extrema the endpoints defining the range whare the character shift loops around
     * @return the shifted character
     */
    public static char shiftCharacter(char character, int offset, CharExtrema extrema) {

        // If the character doesnt belong in the range, don't modify it
        if (!extrema.rangeContains(character)) return character;

        // Force the offset to not go more than 1 full range away and add the offset to the character
        offset %= extrema.rangeSize();
        character += (char) offset;

        // If the character goes below the minimum extremum
        if (character < extrema.minimum) {
            // Get the difference, and loop it back from the maximum extremum
            int difference = extrema.minimum - character;
            character = (char)(extrema.maximum - (difference - 1));
        }

        // If the character goes above the maximum extremum
        if (character > extrema.maximum) {
            // Get the difference, and loop it back from the minimum extremum
            int difference = character - extrema.maximum;
            character = (char)(extrema.minimum + (difference - 1));
        }

        // Return the shifted character
        return character;
    }

    public static void main(String[] args) {

        System.out.println(shiftCharacter('f', -5, aToz));

    }

}

class CharExtrema {

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
