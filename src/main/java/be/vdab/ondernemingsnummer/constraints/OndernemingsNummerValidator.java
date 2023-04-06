package be.vdab.ondernemingsnummer.constraints;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class OndernemingsNummerValidator
        implements ConstraintValidator<OndernemingsNummer, Long> {
    @Override
    public void initialize(OndernemingsNummer constraintAnnotation) {

    }
    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        if (value <= 0) {
            return false;
        }
        var getal = value / 100;
        var rest = getal % 97;
        return (97 - rest) == (value % 100);
    }
}
