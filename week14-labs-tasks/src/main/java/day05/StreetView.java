package day05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class StreetView {
    public Map<String, List> makeMap(Path path) throws IOException {
        Map<String, List> returnMap = new TreeMap<>();
        List<String> readIn = Files.readAllLines(path);
        for (int i = 0; i < readIn.size(); i++) {
            String[] stringArr = readIn.get(i).trim().split(" ");
            if (!returnMap.containsKey(stringArr[0])) {
                returnMap.put(stringArr[0], new ArrayList());
            }
            switch (stringArr[1]) {
                case "0":
                    if (!returnMap.get(stringArr[0]).contains(2)) {
                        returnMap.get(stringArr[0]).add(2);
                    } else {
                        returnMap.get(stringArr[0]).add(calculateHouseNumber(stringArr[0], returnMap, 0));
                    }
                    break;

                case "1":
                    if (!returnMap.get(stringArr[0]).contains(1)) {
                        returnMap.get(stringArr[0]).add(1);
                    } else {
                        returnMap.get(stringArr[0]).add(calculateHouseNumber(stringArr[0], returnMap, 1));
                    }
            }
        }
        return returnMap;
    }

    public int calculateHouseNumber(String value, Map<String, List> returnMap, int divisor) {
        for (int j = returnMap.get(value).size() - 1; j >= 0; j--) {
            if (Integer.parseInt(returnMap.get(value).get(j).toString()) % 2 == divisor) {
                return Integer.parseInt(returnMap.get(value).get(j).toString()) + 2;
            }
        }
        return 0;
    }

}
