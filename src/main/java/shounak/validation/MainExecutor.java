package shounak.validation;

import org.springframework.stereotype.Component;
import shounak.entity.Policy;
import shounak.validationframework.*;

import java.util.List;

@Component
public class MainExecutor implements Executor<Policy, SNDResponse> {
    List<Validator<Policy>> validators = List.of(
            //ADD CUSTOM Validators here, and nested validators are allowed
            //to create cascading logical groups with serial error checking.
            PriceValidator.INSTANCE,
            NameValidator.INSTANCE
    );

    @Override
    public SNDResponse execute(Policy policy) {
        //TODO: <- This should return List<PolicyDTO> in future
        List<ValidationResult<Policy>> validationResults = this.validate(policy);
        return validationResults.stream().anyMatch(ValidationResult::hasErrors)
                ? SNDResponse.buildSNDErrorResponse(validationResults)
                : SNDResponse.buildSNDSuccessResponse(validationResults);

    }

    @Override
    public List<ValidationResult<Policy>> validate(Policy policy) {
        return ValidatorUtils.validateUntilFirstFailure(validators, policy);
    }
}
