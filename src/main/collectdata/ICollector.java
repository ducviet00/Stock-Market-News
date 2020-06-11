package main.collectdata;

import main.data.StkData;

import java.util.List;

public interface ICollector {
    List<StkData> collectData(String name);
}
