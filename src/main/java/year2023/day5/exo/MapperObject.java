package year2023.day5.exo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class MapperObject {
    MapperNameEnum id;
    List<MapperLine> mapperLines;

    public MapperObject(MapperNameEnum id) {
        this.id = id;
        mapperLines = new ArrayList<>();
    }

    public Long mapSeed(Long seed) {
        for (MapperLine mapperLine : mapperLines) {
            if (seed >= mapperLine.getSourceRangeStart() && seed < mapperLine.getSourceRangeStart() + mapperLine.getRangeLength()) {
                return mapperLine.getDestinationRangeStart() + seed - mapperLine.getSourceRangeStart();
            }
        }
        return seed;
    }
}
