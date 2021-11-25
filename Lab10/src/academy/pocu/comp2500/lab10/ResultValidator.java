package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.ResultBase;
import academy.pocu.comp2500.lab10.pocuflix.ResultCode;

public final class ResultValidator {
    private final ResultBase resultBase;

    // ---

    public ResultValidator(final ResultBase resultBase) {
        this.resultBase = resultBase;
    }

    // ---

    public final boolean isValid(final ResultCode resultCode) {
        return this.resultBase.getCode() == resultCode;
    }
}
