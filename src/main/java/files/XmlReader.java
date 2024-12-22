package files;

import model.Board;
import model.Part;
import model.PositionPart;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class XmlReader {

    public Board getBoard(Path file) {

        LinkedHashMap<Integer, Part> parts = new LinkedHashMap<>();
        List<PositionPart> partList = new ArrayList<>();
        Board board = getBoardInfo(file);


        try (Stream<String> lines = Files.lines(file)) {
            String reduce = lines.filter(s ->
                            s.contains("<Part No=") || s.contains("<Part_001")
                    )
                    .reduce("", String::concat);
            String[] split = reduce.split("/>");
            List<Part> list = Arrays.stream(split)
                    .map(s -> Part.builder()
                            .partNumber(Integer.parseInt(s.split("\"")[1]))
                            .name(s.split("=")[2].replaceAll("\"", "").replaceAll(" Comment", ""))
                            .packageName(s.split("=")[3].replaceAll("\"", "").replaceAll(" DatabaseNo", ""))
                            .build())
                    .toList();
            System.out.println(list);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return board;
    }

    private Board getBoardInfo(Path file) {
        String fileName;
        double xSize = 0;
        double ySize = 0;
        Board board = new Board();
        try {
            fileName = file.getFileName().toString().split("\\.")[0];
            String boardInfo = Files.lines(file)
                    .filter(s -> s.contains("<Board_000"))
                    .findFirst()
                    .orElseThrow(RuntimeException::new);

            String[] array = boardInfo.split("\"");
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i].contains("SizeX")) {
                    xSize = Double.parseDouble(array[i + 1].substring(0, array[i + 1].length() - 1));
                }
                if (array[i].contains("SizeY")) {
                    ySize = Double.parseDouble(array[i + 1].substring(0, array[i + 1].length() - 1));
                }
            }
            board.setName(fileName);
            board.setXSize(xSize);
            board.setYSize(ySize);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return board;
    }
}
