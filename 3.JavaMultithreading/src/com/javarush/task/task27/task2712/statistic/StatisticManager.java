package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.text.SimpleDateFormat;
import java.util.*;

public class StatisticManager {
    private static final StatisticManager ourInstance = new StatisticManager();

    public static StatisticManager getInstance() {
        return ourInstance;
    }

    private StatisticManager() {
    }

    public void register(EventDataRow data) {
        statisticStorage.put(data);
    }

    private class StatisticStorage {
        Map<EventType, List<EventDataRow>> storage = new HashMap<>();

        public StatisticStorage() {
            for (EventType type : EventType.values()) {
                storage.put(type, new ArrayList<EventDataRow>());
            }
        }

        private void put(EventDataRow data) {
            if (!this.storage.containsKey(data.getType()))
                throw new UnsupportedOperationException();
            this.storage.get(data.getType()).add(data);
        }

        private List<EventDataRow> get(EventType type) {
            return storage.get(type);
        }
    }

    ;
    private StatisticStorage statisticStorage = new StatisticStorage();
    SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

    public Map<String, Double> profit() {
        Map<String, Double> map = new HashMap();
        List<EventDataRow> rows = statisticStorage.get(EventType.SELECTED_VIDEOS);
        double total = 0;
        for (EventDataRow row : rows) {
            VideoSelectedEventDataRow dataRow = (VideoSelectedEventDataRow) row;
            String date = format.format(dataRow.getDate());
            if (!map.containsKey(date)) {
                map.put(date, 0d);
            }
            total += dataRow.getAmount();
            map.put(date, map.get(date) + dataRow.getAmount());
        }
        map.put("Total", total);
        return map;
    }

    public Map<String, Map<String, Integer>> cookWorkloading() {
        Map<String, Map<String, Integer>> map = new HashMap();
        List<EventDataRow> rows = statisticStorage.get(EventType.COOKED_ORDER);
        for (EventDataRow row : rows) {
            CookedOrderEventDataRow dataRow = (CookedOrderEventDataRow) row;
            String date = format.format(dataRow.getDate());
            if (!map.containsKey(date)) {
                map.put(date, new HashMap<String, Integer>());
            }
            Map<String, Integer> cookMap = map.get(date);
            String cookName = dataRow.getCookName();
            if (!cookMap.containsKey(cookName)) {
                cookMap.put(cookName, 0);
            }
            Integer totalTime = cookMap.get(cookName);
            cookMap.put(cookName, totalTime + dataRow.getTime());
        }
        return map;
    }
}