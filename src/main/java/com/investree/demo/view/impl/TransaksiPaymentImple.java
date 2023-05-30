package com.investree.demo.view.impl;

import com.investree.demo.model.Transaksi;
import com.investree.demo.model.User;
import com.investree.demo.repository.TransaksiRepo;
import com.investree.demo.repository.UserRepo;
import com.investree.demo.view.TransaksiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class TransaksiPaymentImple implements TransaksiService {
    @Autowired
    public TransaksiRepo transaksiRepo;

    @Autowired
    public UserRepo userRepo;

    @Override
    public Map save(Transaksi transaksi, Long idPeminjam,Long idMeminjam){
    Map map = new HashMap();
    try{
        User userPeminjam = userRepo.getById(idPeminjam);
        User userMeminjam = userRepo.getById(idMeminjam);

        if(userPeminjam==null){
            map.put("code","404");
            map.put("status","failed, user peminjam tidak ditemukan");
            return map;
        }

        if(userMeminjam==null){
            map.put("code","404");
            map.put("status","failed, user meminjam tidak ditemukan");
            return map;
        }

        transaksi.setUserPeminjam(userPeminjam);
        transaksi.setUserMeminjam(userMeminjam);
        Transaksi obj = transaksiRepo.save(transaksi);
        map.put("data",obj);
        map.put("code","200");
        map.put("status","success");
        return map;
    }catch(Exception e){
        map.put("code","500");
        map.put("status","failed");
        return map;
    }

    }

    @Override
    public Map updateStatus(Transaksi transaksi){
        Map map = new HashMap();
        try{
            Transaksi obj = transaksiRepo.getById(transaksi.getId());
            if(obj==null){
                map.put("code","404");
                map.put("status","failed, data transaksi tidak ditemukan");
                return map;
            }

            obj.setStatus("lunas");
            transaksiRepo.save(obj);
            map.put("data",obj);
            map.put("code","200");
            map.put("status","success");
            return map;
        }catch(Exception e){
            map.put("code","500");
            map.put("status","failed");
            return map;
        }
    }

}
