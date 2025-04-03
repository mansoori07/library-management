package com.example.library.controller;
//
//import com.example.library.model.Shelf;
//import com.example.library.service.ShelfService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequiredArgsConstructor
//public class ShelfController {
//
//    private final ShelfService shelfService;
//
//    @PostMapping("/shelves/saveAll")
//    public ResponseEntity<?> saveAll(@RequestBody List<Shelf> shelves){
//        try {
//            if(shelves == null || shelves.isEmpty())
//                return new ResponseEntity<>("Book List cannot be empty", HttpStatus.BAD_REQUEST);
//            return new ResponseEntity<>(shelfService.saveAll(shelves), HttpStatus.CREATED);
//        } catch(Exception ex){
//            return new ResponseEntity<>(ex,HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @PostMapping("/shelves/save")
//    public ResponseEntity<?> save(@RequestBody Shelf shelf){
//        try {
//            if(shelf == null)
//                return new ResponseEntity<>("Book cannot be empty", HttpStatus.BAD_REQUEST);
//            return new ResponseEntity<>(shelfService.save(shelf), HttpStatus.CREATED);
//        } catch(Exception ex){
//            return new ResponseEntity<>(ex,HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @GetMapping("/shelves/get/{id}")
//    public ResponseEntity<?> findById(@PathVariable(name = "id") Long id){
//        try {
//            return new ResponseEntity<>(shelfService.findById(id), HttpStatus.FOUND);
//        } catch(Exception ex){
//            return new ResponseEntity<>(ex,HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @GetMapping("/shelves/getAll")
//    public ResponseEntity<?> findAll(){
//        try {
//            return new ResponseEntity<>(shelfService.findAll(), HttpStatus.FOUND);
//        } catch(Exception ex){
//            return new ResponseEntity<>(ex,HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
public class ShelfController {
}
