package shounak.validation;

import shounak.entity.Policy;
import shounak.validationframework.ValidationResult;
import shounak.validationframework.Validator;
import shounak.validationframework.ValidatorUtils;

import java.util.List;
import java.util.function.Predicate;

public class PriceValidator implements Validator<Policy> {
    Predicate<Policy> isPolicyValid = x -> x.getPrice() > 1500;


    @Override
    public List<ValidationResult<Policy>> validate(Policy policy) {
        return isPolicyValid.test(policy)
                ? List.of(ValidatorUtils.success())
                : List.of(ValidatorUtils.error(11L,"Policy is Invalid"));
    }
}
