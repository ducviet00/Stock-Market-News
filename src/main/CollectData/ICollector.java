package main.CollectData;

import main.Data.StkData;

import java.util.List;

public interface ICollector {
    List<StkData> collectData(String name);
}
