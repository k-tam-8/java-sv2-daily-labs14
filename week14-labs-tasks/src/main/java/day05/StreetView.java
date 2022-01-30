package day05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class StreetView {
    public Map<String, List> makeMap(Path path) throws IOException {
        Map<String, List> returnMap = new TreeMap<>();
        List<String> readIn = Files.readAllLines(path);
        for (int i = 0; i < readIn.size(); i++) {
            String[] stringArr = readIn.get(i).trim().split(" ");
            if (!returnMap.containsKey(stringArr[0])){
                returnMap.put(stringArr[0], new ArrayList());
            }
        }
        return returnMap;
    }

}
