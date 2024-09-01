package org.mtou.java.springboot_angular_mysql.controller;

import lombok.AllArgsConstructor;
import org.mtou.java.springboot_angular_mysql.model.Tutorial;
import org.mtou.java.springboot_angular_mysql.service.TutorialService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class TutorialController {


        private final TutorialService tutorialService;

        @GetMapping("/tutorials")
        public ResponseEntity<List<Tutorial>> getAllTutorials(@RequestParam(required = false) String title) {
            List<Tutorial>  tutorails = tutorialService.listAllToturials();
            return new ResponseEntity<>(tutorails, HttpStatus.OK);
        }

        @GetMapping("/tutorials/{id}")
        public ResponseEntity<Tutorial> getTutorialById(@PathVariable("id") long id) {
            return tutorialService.getTutorialById(id)
                    .map(ResponseEntity::ok)
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        }

        @PostMapping("/tutorials")
        public ResponseEntity<Tutorial> createTutorial(@RequestBody Tutorial tutorial) {

            Tutorial savedItem = tutorialService.addTutorial(tutorial);
            return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
        }

        @PutMapping("/tutorials/{id}")
        public ResponseEntity<Tutorial> updateTutorial(@PathVariable("id") long id, @RequestBody Tutorial tutorial) {
            return tutorialService.getTutorialById(id)
                    .map(existingItem -> {
                        existingItem.setId(tutorial.getId());
                        Tutorial updatedItem = tutorialService.addTutorial(existingItem);
                        return new ResponseEntity<>(updatedItem, HttpStatus.OK);
                    })
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
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
