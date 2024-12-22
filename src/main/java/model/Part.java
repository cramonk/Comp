package model;

import lombok.Builder;

import javax.swing.*;

@Builder
public record Part(int partNumber,
                   String name,
                   String packageName) {
}
