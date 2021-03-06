package com.example.demo.Service;


import com.example.demo.DomainObject.SongDomain;
import com.example.demo.DomainObject.SingerDomain;
import com.example.demo.Repository.SingerRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SingerService implements ISingerService {

    @Autowired
    private SingerRepository singerRepository;



    @Override
    public SingerDomain createSinger(SingerDomain singer) {
        return singerRepository.save(singer);
    }

    @Override
    public SingerDomain updateSinger(SingerDomain singer) {
        long singerId = singer.getId();
        Optional<SingerDomain> currentSinger = singerRepository.findById(singerId);
        if (currentSinger.isPresent()) {
            currentSinger.get().setName(singer.getName());
            currentSinger.get().setSurname(singer.getSurname());

            SongDomain singerSong = currentSinger.get().getSong();
            if (singerSong == null){
                singerSong = new SongDomain();
            }

            singerSong.setAlbum(singer.getSong().getAlbum());
            singerSong.setRelease_year(singer.getSong().getRelease_year());

            SingerDomain savedSinger = singerRepository.save(currentSinger.get());
            singerSong.setSongID(savedSinger.getSong().getSongID());
            currentSinger.get().setSong(singerSong);
            return savedSinger;
        }

        return null;
    }

    @Override
    public void deleteSinger(Long singerID) {
        Optional<SingerDomain> currentSinger = singerRepository.findById(singerID);
        if (currentSinger.isPresent()) {
            singerRepository.deleteById(singerID);
        }
    }

    @Override
    public SingerDomain getSingerByID(Long singerID) {
        Optional<SingerDomain> currentSinger = singerRepository.findById(singerID);
        return currentSinger.orElse(null);
    }

    @Override
    public SingerDomain getSinger(String singerName) {
        Optional<SingerDomain> currentSinger = singerRepository.findByName(singerName);
        return currentSinger.orElse(null);
    }

    @Override
    public List<SingerDomain> getAllSingers () {
        return singerRepository.findAll();
    }

}
