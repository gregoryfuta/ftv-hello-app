package i0.sealights.ftv.service;

import i0.sealights.ftv.model.TranslationEntry;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class TranslateService {

    private final TranslationSource source;

    public TranslateService(TranslationSource source) {
        this.source = source;
    }

    public TranslationEntry translate(final String from) {
        Optional<String> translated = source.fetchEntry(from);

        return translated.map(translation -> new TranslationEntry(from, translation))
            .orElse(new TranslationEntry(from,"UNKNOWN"));

    }

    public int intentionallyUnusedMethod() {
        return 13;
    }
}
