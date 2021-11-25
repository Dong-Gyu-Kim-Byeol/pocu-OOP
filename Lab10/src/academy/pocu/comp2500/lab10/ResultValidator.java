package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.NotFoundResult;
import academy.pocu.comp2500.lab10.pocuflix.OkResult;
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
        switch (resultCode) {
            case OK:
                return this.resultBase instanceof OkResult;
            case NOT_FOUND:
                return this.resultBase instanceof NotFoundResult;
            case SERVICE_UNAVAILABLE:
                return this.resultBase instanceof ServiceUnavailableResult;
            case UNAUTHORIZED:
                return this.resultBase instanceof UnauthorizedResult;
            case NOT_MODIFIED:
                return this.resultBase instanceof CachedResult;
            default:
                throw new IllegalArgumentException("unknown enum type");
        }
    }
}
