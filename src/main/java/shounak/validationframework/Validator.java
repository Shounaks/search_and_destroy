package shounak.validationframework;

import java.util.List;

public interface Validator<T> {
    List<ValidationResult<T>> validate(T t);
}
