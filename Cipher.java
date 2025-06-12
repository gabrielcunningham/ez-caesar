public class Cipher {

    public static CharExtrema aToz = new CharExtrema('a', 'z');

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

    /**
     * shiftString handles shifting every single character in the string based on the provided information.
     * @param string the string to shift
     * @param offset how far each character needs to be shifted
     * @param extrema the endpoints defining the range where each character shift loops around
     * @return the shifted string
     */
    public static String shiftString(String string, int offset, CharExtrema extrema) {

        StringBuilder shiftedString = new StringBuilder();

        // For every character of the provided string, shift the character and add to the final string
        for (char c : string.toLowerCase().toCharArray()) {
            shiftedString.append(shiftCharacter(c, offset, extrema));
        }

        return shiftedString.toString();

    }
    
}