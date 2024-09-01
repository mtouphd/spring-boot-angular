package org.mtou.java.springboot_angular_mysql.service;

import lombok.AllArgsConstructor;
import org.mtou.java.springboot_angular_mysql.model.Tutorial;
import org.mtou.java.springboot_angular_mysql.repository.TutorialRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class TutorialService {

    private final TutorialRepository tutorialRepository;

    public List<Tutorial> listAllToturials() {
        return tutorialRepository.findAll();
    }

    public Optional<Tutorial> getTutorialById(Long id) {
        return tutorialRepository.findById(id);
    }

    public Tutorial addTutorial(Tutorial tutorial) {
        return tutorialRepository.save(tutorial);
    }

    public void deleteTutorial(Long id) {
        tutorialRepository.deleteById(id);
    }



}
