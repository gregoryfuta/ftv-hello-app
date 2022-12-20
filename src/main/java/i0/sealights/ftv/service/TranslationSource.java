package i0.sealights.ftv.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;
import org.springframework.stereotype.Service;

@Service
public class TranslationSource {

    private Map<String, String> translations;

    public TranslationSource() {
        initDictionary();
    }

    public Optional<String> fetchEntry(final String from) {
        String value = translations.get(from);
        return Optional.ofNullable(value);
    }

    public void initDictionary() { // should be private
        final Properties properties = new Properties();
        try {
            properties.load(getClass().getResourceAsStream("/translations/dictionary.file"));
        } catch (IOException e) {
            translations = new HashMap<>();
        }
        translations = new HashMap<>(properties.size());

        properties.stringPropertyNames().forEach(key -> {
            translations.put(key, properties.getProperty(key));
        });
    }

}
