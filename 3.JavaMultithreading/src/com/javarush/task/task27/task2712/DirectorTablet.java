package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.Advertisement;
import com.javarush.task.task27.task2712.ad.AdvertisementStorage;
import com.javarush.task.task27.task2712.ad.StatisticAdvertisementManager;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.util.*;

public class DirectorTablet {
    public void printAdvertisementProfit(){
        Map<String, Double> map = StatisticManager.getInstance().profit();
        ArrayList<String> list = new ArrayList(map.keySet());
        Collections.sort(list);
        for (String key : list) {
            double amount = map.get(key) / 100;
            System.out.println(key + " - " + String.format(Locale.ENGLISH, "%.2f", amount));
        }
    }
    public void printCookWorkloading() {
        Map<String, Map<String, Integer>> map = StatisticManager.getInstance().cookWorkloading();
        ArrayList<String> list = new ArrayList(map.keySet());
        Collections.sort(list);
        for (String key : list) {
            Map<String, Integer> cookMap = map.get(key);
            System.out.println(key);
            ArrayList<String> cookNames = new ArrayList(cookMap.keySet());
            Collections.sort(cookNames);
            for (String cookName : cookNames) {
                System.out.println(cookName + " - " + ((cookMap.get(cookName) + 59) / 60) + " min");
            }
            System.out.println();
        }
    }
    public void printActiveVideoSet(){
        List<Advertisement> set = StatisticAdvertisementManager.getInstance().activeVideoSet();
        Collections.sort(set, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                return (o1.getName().toLowerCase()).compareTo(o2.getName().toLowerCase());
            }
        });
        for (Advertisement advertisement : set) {
            System.out.println(advertisement.getName() + " - " + advertisement.getHits());
        }
    }
    public void printArchivedVideoSet(){
        List<Advertisement> set = StatisticAdvertisementManager.getInstance().archivedVideoSet();
        Collections.sort(set, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                return (o1.getName().toLowerCase()).compareTo(o2.getName().toLowerCase());
            }
        });
        for (Advertisement advertisement : set) {
            System.out.println(advertisement.getName());
        }
    }
}
