package org.example;

import java.util.HashMap;
import java.util.List;

public interface FileObject {

    HashMap<String, List<String>> loadFile(String path);
}
