package model;

import lombok.*;

import java.util.List;
import java.util.Objects;

@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public final class Board {
    private String name;
    private double xSize;
    private double ySize;
    private List<PositionPart> partList;

    public Board(String name,
                 double xSize,
                 double ySize,
                 List<PositionPart> partList) {
        this.name = name;
        this.xSize = xSize;
        this.ySize = ySize;
        this.partList = partList;
    }



}
