package com.example.demo.Controller;

import com.example.demo.DomainObject.SingerDomain;
import com.example.demo.DomainObject.SongDomain;
import com.example.demo.Service.ISingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/FinalProject/v1")
public class Controller {

    @Autowired
    private ISingerService singerService;


    @GetMapping("/index")
    String index() {
        return "Kodluyoruz[İstanbul, Ankara & Adana - Java SQL BOOTCAMP (EnerjiSA)]";
    }

    @PostMapping(path = "/singers", consumes = "application/json", produces = "application/json")
    public ResponseEntity<SingerDomain> createSinger(@RequestBody SingerDomain singerDomain) {
        SingerDomain createdSinger = singerService.createSinger(singerDomain);
        return new ResponseEntity<>(createdSinger, HttpStatus.CREATED);
    }


    @PutMapping(path = "/singers", consumes = "application/json", produces = "application/json")
    public ResponseEntity<SingerDomain> updateSinger(@RequestBody SingerDomain singerDomain) {
        SingerDomain updatedCustomer = singerService.updateSinger(singerDomain);
        return new ResponseEntity<>(updatedCustomer, HttpStatus.CREATED);
    }


    @GetMapping("/singers/{singerID}")
    public ResponseEntity<SingerDomain> getSingerByID (@PathVariable(value="singerID") Long singerID){
        SingerDomain singer = singerService.getSingerByID(singerID);
        return new ResponseEntity<>(singer, HttpStatus.OK);
        }


    @GetMapping("/singer-by-name/{singerName}")
    public ResponseEntity<SingerDomain> getSinger (@PathVariable(value="singerName") String singerName){
        SingerDomain singer = singerService.getSinger(singerName);
        return new ResponseEntity<>(singer, HttpStatus.OK);
    }


    @GetMapping("/singers")
    public ResponseEntity<List<SingerDomain>> getAllSingers(){
        List<SingerDomain> allCustomers = singerService.getAllSingers();
        return new ResponseEntity<>(allCustomers, HttpStatus.OK);
    }


    @DeleteMapping("/singers/{singerID}")
    public ResponseEntity<String> deleteSinger(@PathVariable(value="singerID") Long singerID){
        singerService.deleteSinger(singerID);
        return new ResponseEntity<>("Singer with id:" +  singerID +" is deleted", HttpStatus.OK);
    }

}
