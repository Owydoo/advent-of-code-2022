package year2023.day5.exo;

public enum MapperNameEnum {
    SEED_TO_SOIL("seed-to-soil map:"),
    SOIL_TO_FERTILIZER("soil-to-fertilizer map:"),
    FERTILIZER_TO_WATER("fertilizer-to-water map:"),
    WATER_TO_LIGHT("water-to-light map:"),
    LIGHT_TO_TEMPERATURE("light-to-temperature map:"),
    TEMPERATURE_TO_HUMIDITY("temperature-to-humidity map:"),
    HUMIDITY_TO_LOCATION("humidity-to-location map:");

    public final String label;


    MapperNameEnum(String label) {
        this.label = label;
    }

    public static MapperNameEnum valueOfLabel(String label){
        for (MapperNameEnum value : values()) {
            if (value.label.equals(label)){
                return value;
            }
        }
        return null;
    }

    public static boolean inEnum(String label) {
        MapperNameEnum mapperNameEnum = valueOfLabel(label);
        return mapperNameEnum != null;
    }
}
