package main.CollectData;

import main.Data;

import java.util.Map;

public interface ICollector {
    public Map<String, Data> collectData(String name);
}
