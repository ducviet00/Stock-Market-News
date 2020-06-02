package main.CollectData;

import main.Data;

import java.util.List;

public interface ICollector {
    public List<Data> collectData(String name);
}
