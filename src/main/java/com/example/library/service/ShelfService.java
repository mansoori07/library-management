package com.example.library.service;

//import com.example.library.model.Shelf;
//import com.example.library.repository.ShelfRepository;
//import com.example.library.utils.JsonUtils;
//import lombok.RequiredArgsConstructor;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Service;
//
//import java.io.IOException;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//@RequiredArgsConstructor
public class ShelfService {

//    private final ShelfRepository shelfRepository;
//
//    public Shelf save(Shelf shelf){
//        return shelfRepository.save(shelf);
//    }
//
//    public List<Shelf> saveAll(List<Shelf> shelf){
//        return shelfRepository.saveAll(shelf);
//    }
//
//    public Shelf findById(Long id){
//        return shelfRepository.findById(id);
//    }
//
//    public List<Shelf> findAll() {
//
//        List<Shelf> shelves = shelfRepository.findAll();
//
//        if(shelves.isEmpty()){
//            try {
//                shelves = JsonUtils.convertJson("src/main/resources/dataFile/shelf.json", Shelf.class);
//                if(!shelves.isEmpty())
//                    shelfRepository.saveAll(shelves);
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }
//        return shelves;
//    }
}
