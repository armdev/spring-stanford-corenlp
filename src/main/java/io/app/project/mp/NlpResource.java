package io.app.project.mp;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/nlp")
public class NlpResource {

    @Autowired
    private SentimentAnalyzerService sentimentAnalyzerService;

    @CrossOrigin
    @PostMapping(value = "/analyse")
    @ResponseBody
    public ResponseEntity<?> analyse(@Valid @RequestBody String text
    ) {
        int analyse = sentimentAnalyzerService.analyse(text);
        final SentimentType fromValue = SentimentType.fromValue(analyse);
        return ResponseEntity.ok(fromValue);
    }
}
