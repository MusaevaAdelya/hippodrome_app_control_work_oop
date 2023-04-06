package com.example.app.controller;

import com.example.app.dto.RegisterHorse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
@Slf4j
public class AdminController {

    @PostMapping("/add/horse")
    public ResponseEntity<Void> addNewHorse(@Valid @RequestBody RegisterHorse horse) {
        // add new horse
        return ResponseEntity.ok().build();
    }

}
