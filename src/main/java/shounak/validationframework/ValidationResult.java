package shounak.validationframework;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class ValidationResult<T> {
    final List<T> items;
    final List<ValidationError> errors;

    public boolean hasErrors() {
        return !errors.isEmpty();
    }
}

