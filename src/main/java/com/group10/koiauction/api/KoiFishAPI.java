package com.group10.koiauction.api;

import com.group10.koiauction.entity.KoiFish;
import com.group10.koiauction.model.request.KoiFishRequest;
import com.group10.koiauction.repository.KoiFishRepository;
import com.group10.koiauction.service.KoiFishService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/koiFish")
public class KoiFishAPI {
    @Autowired
    KoiFishService koiFishService;
    @Autowired
    KoiFishRepository koiFishRepository;
    @PostMapping()
    public ResponseEntity<KoiFish> createKoiFish(@Valid @RequestBody KoiFishRequest koiFishRequest) {
        KoiFish koiFish = koiFishService.createKoiFish(koiFishRequest);
        return ResponseEntity.ok(koiFish);
    }
    @GetMapping("/all")
    public  ResponseEntity<List<KoiFish>> getAllKoiFish (){
        List<KoiFish> koiFishList = koiFishRepository.findAll();
        return ResponseEntity.ok(koiFishList);
    }
    @GetMapping("/{koi_id}")
    public ResponseEntity<KoiFish> getKoiFish(@PathVariable Long koi_id){
        KoiFish koiFish = koiFishRepository.findByKoiId(koi_id);
        return ResponseEntity.ok(koiFish);

    }

    @GetMapping("/getKoiByName/{name}")
    public ResponseEntity<List<KoiFish>> getKoiFishByKoiName(@PathVariable String name){
        List<KoiFish> koiFishList = koiFishRepository.findKoiFishByName(name);
        return ResponseEntity.ok(koiFishList);
    }
    @DeleteMapping("/{koi_id}")
    public ResponseEntity<KoiFish> deleteKoiFish(@PathVariable Long koi_id){
        KoiFish deleteKoi = koiFishService.deleteKoiFish(koi_id);
        return ResponseEntity.ok(deleteKoi);
    }
    @DeleteMapping("/deleteDB/{koi_id}")
    public ResponseEntity<String> deleteKoiFishDB(@PathVariable Long koi_id){
        String msg = koiFishService.deleteKoiFishDB(koi_id);
        return ResponseEntity.ok(msg);
    }

    @PutMapping("/{koi_id}")
    public ResponseEntity<KoiFish> updateKoiFish( @PathVariable Long koi_id,
                                            @Valid @RequestBody KoiFishRequest koiFishRequest) {
        KoiFish updated_koi = koiFishService.updateKoiFish(koi_id, koiFishRequest);
        return ResponseEntity.ok(updated_koi);
    }


}
