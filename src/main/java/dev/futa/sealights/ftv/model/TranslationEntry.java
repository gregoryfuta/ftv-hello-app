package dev.futa.sealights.ftv.model;

import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@RequiredArgsConstructor
public class TranslationEntry {

    String from;
    String to;
}
