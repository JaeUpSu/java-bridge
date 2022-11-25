package bridge.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Bridge {
    List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public String get(int index) {
        return bridge.get(index);
    }

    @Override
    public String toString() {
        return bridge.stream()
                .collect(Collectors.joining( " | ", "[ ", " ]"));
    }
}