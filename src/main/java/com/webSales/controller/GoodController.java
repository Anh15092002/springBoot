package com.webSales.controller;

import com.webSales.dto.GoodDto;
import com.webSales.service.GoodService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/goods")
public class GoodController {
    private GoodService goodService;
    @PostMapping
    public ResponseEntity<GoodDto> createGood(@RequestBody GoodDto goodDto) {
        GoodDto savedGood = goodService.createGood(goodDto);
        return new ResponseEntity<>(savedGood, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<GoodDto> getGoodById(@PathVariable("id") Integer goodId) {
        GoodDto goodDto = goodService.getGoodById(goodId);
        return ResponseEntity.ok(goodDto);
    }

    @GetMapping
    public ResponseEntity<List<GoodDto>> getAllGood() {
        List<GoodDto> goods = goodService.getAllGood();
        return ResponseEntity.ok(goods);
    }

    @PutMapping("{id}")
    public ResponseEntity<GoodDto> updateGood(@PathVariable("id") Integer goodId,
                                              @RequestBody GoodDto updateGood) {
        GoodDto goodDto = goodService.updateGood(goodId, updateGood);
        return ResponseEntity.ok(goodDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteGood(@PathVariable("id") Integer goodId) {
        goodService.deleteGood(goodId);
        return ResponseEntity.ok("Good deleted successfully!.");
    }
}
