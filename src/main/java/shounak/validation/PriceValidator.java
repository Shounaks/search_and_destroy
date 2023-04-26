package shounak.validation;

import shounak.entity.Policy;
import shounak.validationframework.ErrorEnum;
import shounak.validationframework.ValidationResult;
import shounak.validationframework.Validator;
import shounak.validationframework.ValidatorUtils;

import java.util.List;
import java.util.function.Predicate;

public class PriceValidator implements Validator<Policy> {
    public static final PriceValidator INSTANCE = new PriceValidator();
    Predicate<Policy> isPolicyValid = x -> x.getPrice() > 1500;
    ErrorEnum priceError = ErrorEnum.PRICE_INVALID;

    private PriceValidator() {
    }

    @Override
    public List<ValidationResult<Policy>> validate(Policy policy) {
        return isPolicyValid.test(policy)
                ? List.of(ValidatorUtils.success())
                : List.of(ValidatorUtils.error(priceError.getErrorId(), String.format(priceError.getErrorMessage(),policy.getPrice())));
    }
}
