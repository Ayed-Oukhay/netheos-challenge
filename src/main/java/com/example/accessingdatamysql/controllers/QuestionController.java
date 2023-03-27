package com.example.accessingdatamysql.controllers;

import com.example.accessingdatamysql.models.*;
import com.example.accessingdatamysql.payload.request.QuestionRequest;
import com.example.accessingdatamysql.payload.response.MessageResponse;
import com.example.accessingdatamysql.repositories.QuestionRepository;
import com.example.accessingdatamysql.repositories.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private TagRepository tagRepository;

    @GetMapping("/allQuestions")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<Question>> getAllQuestions(){
        List<Question> questions = null;
        try {
            questions = questionRepository.getAll();
        }catch(Exception ex) {
            ex.getMessage();
        }
        return new ResponseEntity<List<Question>>(questions, HttpStatus.OK);
    }

    @GetMapping("/SearchSpecific")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<List<Question>> getSpecificQuestion(@RequestParam String word){
        List<Question> questions = null;
    try {
        questions = questionRepository.findByLibelleContainingIgnoreCase(word);
        }catch(Exception ex) {
            ex.getMessage();
        }
    return new ResponseEntity<List<Question>>(questions, HttpStatus.OK);
    }


    @PostMapping("/addOrUpdate")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> addOrUpdateQuestion(@RequestBody QuestionRequest questionRequest){
        Question questions = new Question(questionRequest.getLibelle(), questionRequest.getReponse());
        Set<String> strTags = questionRequest.getTag();
        Set<Tag> tags = new HashSet<>();
        if (strTags == null) {
            Tag questionTag = tagRepository.findByLibelle(ETag.FINANCE)
                    .orElseThrow(() -> new RuntimeException("Error: Tag is not found."));
            tags.add(questionTag);
        } else {
            strTags.forEach(tag -> {
                switch (tag) {
                    case "finance":
                        Tag financeTag = tagRepository.findByLibelle(ETag.FINANCE)
                                .orElseThrow(() -> new RuntimeException("Error: Tag is not found."));
                        tags.add(financeTag);
                        break;

                    case "tech":
                        Tag techTag = tagRepository.findByLibelle(ETag.TECH)
                                .orElseThrow(() -> new RuntimeException("Error: Tag is not found."));
                        tags.add(techTag);
                        break;

                    case "health":
                        Tag healthTag = tagRepository.findByLibelle(ETag.HEALTH)
                                .orElseThrow(() -> new RuntimeException("Error: Tag is not found."));
                        tags.add(healthTag);
                        break;

                    default:
                        Tag socialTag = tagRepository.findByLibelle(ETag.SOCIAL)
                                .orElseThrow(() -> new RuntimeException("Error: Tag is not found."));
                        tags.add(socialTag);
                }
            });
        }
        questions.setTags(tags);
        questionRepository.save(questions);
        return ResponseEntity.ok(new MessageResponse("Question added successfully!"));
    }

}
