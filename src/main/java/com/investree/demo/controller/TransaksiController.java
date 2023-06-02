package com.investree.demo.controller;

import com.investree.demo.model.Transaksi;
import com.investree.demo.repository.TransaksiRepo;
import com.investree.demo.view.TransaksiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/v1/transaksi")
public class TransaksiController {
    @Autowired
    TransaksiService transaksiService;

    @Autowired
    TransaksiRepo transaksiRepo;
    @PostMapping("")
    public ResponseEntity<Map> save(
            @RequestBody Transaksi objModel){
        System.out.println(objModel);
        Map obj = transaksiService.save(objModel);
        return new ResponseEntity<Map>(obj, HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<Map> updateStatus(@RequestBody Transaksi objModel){
        Map obj = transaksiService.updateStatus(objModel);
        return new ResponseEntity<Map>(obj,HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<Page<Transaksi>> list(
            @RequestParam() Integer page,
            @RequestParam() Integer size,
            @RequestParam(required = false) String status){
        Pageable showData = PageRequest.of(page,size);
        Page<Transaksi> list = null;
        if(status!=null){
            list = transaksiRepo.getByStatusLike("%"+status+"%",showData);
        }else{
            list = transaksiRepo.getAllData(showData);
        }
        return new ResponseEntity<Page<Transaksi>>(list,HttpStatus.OK);
    }
}
