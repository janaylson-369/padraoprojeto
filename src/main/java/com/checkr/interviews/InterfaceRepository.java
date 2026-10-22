package com.checkr.interviews;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface  InterfaceRepository {
    List<Map<String, String>> where(Map<String, String> options) throws IOException;
    Map<String, String> findBy(Map<String, String> options) throws NoSuchEntryException;
}
