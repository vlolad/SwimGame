package engine;

import entity.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Arrays;

@Getter
@NoArgsConstructor
public class SeaMap {

    private final Entity[][] seaMap = new Entity[10][10];
    private final String wave = "~~~";

    public void setField(Entity entity) {
        seaMap[entity.getCord().x()][entity.getCord().y()] = entity;
    }
}
