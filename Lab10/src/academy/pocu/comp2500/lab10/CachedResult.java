package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.ResultBase;
import academy.pocu.comp2500.lab10.pocuflix.ResultCode;

public final class CachedResult extends ResultBase {
    private final int expiryCount;

    // ---

    public CachedResult(final int expiryCount) {
        super(ResultCode.NOT_MODIFIED);
        this.expiryCount = expiryCount;
    }

    // ---

    public final int getExpiryCount() {
        return expiryCount;
    }
}
