package be.vdab.ondernemingsnummer.domain;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class FirmaTest {
    private Validator validator;
    private Firma firma;
    @BeforeEach
    void beforeEach() {
        var factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        firma = new Firma();
    }
    @Test
    void correcteFirma() {
        firma.setOndernemingsNummer(426388541);
        assertThat(validator.validate(firma)).isEmpty();
    }
    @ParameterizedTest
    @ValueSource(longs = {0, -1, 426388540, 426388542})
    void verkeerdeOndernemingsNummers(long nummer) {
        firma.setOndernemingsNummer(nummer);
        assertThat(validator.validate(firma)).isNotEmpty();
    }
}
