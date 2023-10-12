package org.example.parkminsu.dict;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface Parser {
    Map<String, List<String>> parse(String path) throws IOException;
}
