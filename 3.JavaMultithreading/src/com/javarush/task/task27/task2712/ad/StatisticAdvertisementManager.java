package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StatisticAdvertisementManager {
    private static final StatisticAdvertisementManager ourInstance = new StatisticAdvertisementManager();
    private StatisticAdvertisementManager(){
    }
    public static StatisticAdvertisementManager getInstance(){
        return ourInstance;
    }
    private AdvertisementStorage advertisementStorage = AdvertisementStorage.getInstance();
    public List<Advertisement> activeVideoSet(){
        List<Advertisement> set = new ArrayList<>();
        for(Advertisement advertisement: advertisementStorage.list()){
            if(advertisement.isActive())
                set.add(advertisement);
        }
        return set;
    }
    public List<Advertisement> archivedVideoSet(){
        List<Advertisement> set = new ArrayList<>();
        for(Advertisement advertisement: advertisementStorage.list()){
            if(!advertisement.isActive())
                set.add(advertisement);
        }
        return set;
    }
}
