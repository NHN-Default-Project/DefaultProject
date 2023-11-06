package org.example.yunhwa.dict;

import java.util.List;
import java.util.Map;

public interface Parser {
    public Map<String, List<String>> parse(String path);
}
