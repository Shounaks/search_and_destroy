package shounak.validationframework;

import lombok.experimental.UtilityClass;

import java.util.Collection;
import java.util.List;

@UtilityClass
public class ValidatorUtils {
    public static <T> List<ValidationResult<T>> validateUntilFirstFailure(List<Validator<T>> validators,T t){
        return validators.stream()
                .map(x -> x.validate(t))
                .flatMap(Collection::stream)
                .filter(ValidationResult::hasErrors)
                .toList();
    }

    public <T> ValidationResult<T> success() {
        return new ValidationResult<>(null, List.of());
    }

    public <T> ValidationResult<T> error(Long errorId, String errorMessage) {
        return new ValidationResult<>(null, List.of(new ValidationError(errorId, errorMessage)));
    }
}
