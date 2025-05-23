package ed.lab;

import java.util.HashMap;
import java.util.Map;

public class E02Logger {
    private Map<String, Integer> map;

    public E02Logger() {
        map = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if (map.containsKey(message) && timestamp - map.get(message) < 10) {
            return false;
        }
        map.put(message, timestamp);
        return true;

    }
}

