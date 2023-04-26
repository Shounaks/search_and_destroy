package shounak.validationframework;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ValidationError {
    public final Long errorId;
    public final String errorMessage;
}
