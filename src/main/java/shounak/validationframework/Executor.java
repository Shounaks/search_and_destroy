package shounak.validationframework;

import java.util.List;

public interface Executor<T, K>{
    K execute(T t);

    List<ValidationResult<T>> validate(T t);
}

