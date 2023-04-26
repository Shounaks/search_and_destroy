package shounak.validation;

import shounak.entity.Policy;
import shounak.validationframework.ErrorEnum;
import shounak.validationframework.ValidationResult;
import shounak.validationframework.Validator;
import shounak.validationframework.ValidatorUtils;

import java.util.List;
import java.util.function.Predicate;

/**
 * @author Shounak
 * <p>This is a sample Validator which consists of a single predicate (multiple can be added and checked as per our requirement.
 * Each validator should consist of 2 things, Predicate (item it is checking) and Error Data (although you can use a enum/hashmap/record list,
 * etc to collect this and centralize it for better DX (Developer experience).
 * </p>
 * @see Validator
 * @see ValidatorUtils#success()
 * @see ValidatorUtils#error(Long, String)
 */
public class NameValidator implements Validator<Policy> {
    Predicate<Policy> isNameMinLength = x -> x.getTitle().length() > 30;

    //TODO: It is not required to store this data but just to conform with standard
    ErrorEnum errorData = ErrorEnum.NAME_INVALID;

    /**
     * @param policy an object of Policy
     * @return The Validate Function will take in the object and test for all the predicates, and depending on the outcome, we can return respective {@link ValidationResult}
     */
    @Override
    public List<ValidationResult<Policy>> validate(Policy policy) {
        return isNameMinLength.test(policy)
                ? List.of(ValidatorUtils.success())
                : List.of(ValidatorUtils.error(errorData.getErrorId(), errorData.getErrorMessage()));
    }
}
