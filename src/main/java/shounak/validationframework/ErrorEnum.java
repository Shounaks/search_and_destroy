package shounak.validationframework;

import lombok.Getter;

@Getter
public enum ErrorEnum {
    NAME_INVALID(4001L, "Name Field is Invalid"),
    PRICE_INVALID(4002L, "Price Field is Invalid: %s is invalid");// can send formatted text! and using String.format() will produce correct error message

    final Long errorId;
    final String errorMessage;

    ErrorEnum(Long errorId, String errorMessage) {
        this.errorId = errorId;
        this.errorMessage = errorMessage;
    }
}