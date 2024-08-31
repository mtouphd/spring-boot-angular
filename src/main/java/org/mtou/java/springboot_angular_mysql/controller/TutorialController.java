package org.mtou.java.springboot_angular_mysql.controller;

import lombok.AllArgsConstructor;
import org.mtou.java.springboot_angular_mysql.model.Tutorial;
import org.mtou.java.springboot_angular_mysql.repository.TutorialRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class TutorialController {


        private final TutorialRepository tutorialRepository;

        @GetMapping("/tutorials")
        public ResponseEntity<List<Tutorial>> getAllTutorials(@RequestParam(required = false) String title) {
            return null;
        }

        @GetMapping("/tutorials/{id}")
        public ResponseEntity<Tutorial> getTutorialById(@PathVariable("id") long id) {
          return null;

        }

        @PostMapping("/tutorials")
        public ResponseEntity<Tutorial> createTutorial(@RequestBody Tutorial tutorial) {
            return null;
        }

        @PutMapping("/tutorials/{id}")
        public ResponseEntity<Tutorial> updateTutorial(@PathVariable("id") long id, @RequestBody Tutorial tutorial) {
            return null;
        }

        @DeleteMapping("/tutorials/{id}")
        public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
            return null;
        }

        @DeleteMapping("/tutorials")
        public ResponseEntity<HttpStatus> deleteAllTutorials() {
            return null;
        }

        @GetMapping("/tutorials/published")
        public ResponseEntity<List<Tutorial>> findByPublished() {
            return null;
        }

}
