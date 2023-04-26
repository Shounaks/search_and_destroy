package shounak.validationframework;

import lombok.Getter;
import shounak.entity.Policy;

import java.util.Collection;
import java.util.List;

@Getter
public class SNDResponse {
    final List<Policy> policies;
    final List<ValidationError> errors;

    private SNDResponse(List<Policy> policies, List<ValidationError> errors) {
        this.policies = policies;
        this.errors = errors;
    }

    public static SNDResponse buildSNDErrorResponse(List<ValidationResult<Policy>> validationResults){
        List<ValidationError> errorList = validationResults.stream().map(ValidationResult::getErrors).flatMap(Collection::stream).toList();
        return new SNDResponse(null,errorList);
    }

    public static SNDResponse buildSNDSuccessResponse(List<ValidationResult<Policy>> validationResults){
        List<Policy> policyList = validationResults.stream().map(ValidationResult::getItems).flatMap(Collection::stream).toList();
        return new SNDResponse(policyList,null);
    }
}
