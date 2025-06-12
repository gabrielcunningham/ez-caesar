public class Cipher {

    CharExtrema aToz = new CharExtrema('a', 'z');
    CharExtrema AToZ = new CharExtrema('A', 'Z');

    public char shiftCharacter(char character, int offset, CharExtrema extrema) {

        if (!extrema.rangeContains(character)) return character;

        return 'c';

    }

}

class CharExtrema {

    public char minimum;
    public char maximum;

    CharExtrema(char min, char max) {

        if (max < min) {
            minimum = max;
            maximum = min;
            return;
        }

        minimum = min;
        maximum = max;

    }

    public boolean rangeContains(char character) {

        return minimum <= character && maximum >= character;

    }

}
