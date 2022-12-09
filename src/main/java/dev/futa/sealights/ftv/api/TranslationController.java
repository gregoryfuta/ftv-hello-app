package dev.futa.sealights.ftv.api;

import dev.futa.sealights.ftv.model.TranslationEntry;
import dev.futa.sealights.ftv.service.TranslateService;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TranslationController {

    private final TranslateService translateService;

    public TranslationController(TranslateService translateService) {
        this.translateService = translateService;
    }

    @GetMapping("/translate/{phrase}")
    public String translate(@PathVariable("phrase") String phrase) {

        final TranslationEntry translate = translateService.translate(phrase);
        return "The \"" + translate.getFrom() + "\" means: \"" + translate.getTo() + "\"";
    }

    @GetMapping("/translate/hello")
    public String unusedEndpoint() {
        return "Hello World!";
    }

    @GetMapping("/translate/date")
    public String echoDate() {
        return LocalDate.now().format(DateTimeFormatter.ISO_DATE);
    }
}
