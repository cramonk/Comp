package model;

import lombok.Builder;

@Builder
public record PositionPart(String position,
                           double x,
                           double y,
                           Part part) {
}
