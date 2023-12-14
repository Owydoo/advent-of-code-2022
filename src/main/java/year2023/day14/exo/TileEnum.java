package year2023.day14.exo;


public enum TileEnum {
    ROUNDED_ROCK('O'), CUBE_SHAPED_ROCK('#'), EMPTY_SPACE('.');

    private final char character;

    TileEnum(char character) {
        this.character = character;
    }

    public char getCharacter() {
        return character;
    }
}
