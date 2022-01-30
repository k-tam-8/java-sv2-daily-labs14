package day05;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class StreetViewTest {
    @Test
    void name() throws IOException {
        StreetView sv = new StreetView();
        System.out.println(sv.makeMap(Path.of("src/main/resources/streets.txt")));

    }


}