package com.example.demo.Service;

import com.example.demo.DomainObject.SingerDomain;

import java.util.List;

public interface ISingerService {
    public SingerDomain createSinger(SingerDomain singer);
    public SingerDomain updateSinger(SingerDomain singer);
    public void deleteSinger(Long singerID);
    public SingerDomain getSingerByID(Long singerID);
    public SingerDomain getSinger(String singerName);
    public List<SingerDomain> getAllSingers();

}
