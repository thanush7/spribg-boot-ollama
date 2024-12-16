package com.kgisl.aidemo.Controllers;

import java.io.IOException;
import java.time.Duration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.ollama.OllamaChatModel;

@RestController
public class LangOllamaController {

    @Value("${spring.ai.ollama.chat.option.model}")
    String modelName;

    @GetMapping("/lang")
    public String getLangOllama(@RequestParam String userInput ) {
        ChatLanguageModel model
                = OllamaChatModel.builder()
                .baseUrl("http://Localhost:11434/")
                .modelName(modelName).timeout(Duration.ofSeconds(100))
                .build();
        String answer = model.generate(userInput);
        return answer;
    }
   
}
