package engine;

import org.springframework.web.bind.annotation.*;

@RestController
public class QuizController {

    @GetMapping("/api/quizzes/{id}")
    public Quiz getResponse() {
        String[] options = {"Robot", "Tea leaf", "Cup of coffee", "Bug"};
        Quiz r = new Quiz("The Java Logo",
                "What is depicted on the Java logo?",
                options);
        return r;
    }

    @PostMapping(path = "/api/quiz")
    public Answer getLine(@RequestParam("answer") int answer) {
        Answer r;
        switch (answer) {
            case 2:
                r = new Answer(true, "Congratulations, you're right!");
                break;
            default:
                r =  new Answer(false, "Wrong answer! Please, try again.");
                break;
        }
        return r;
    }

}
