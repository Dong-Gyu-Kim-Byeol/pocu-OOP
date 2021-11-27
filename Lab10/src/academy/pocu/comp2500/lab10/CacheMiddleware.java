package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.ResultBase;
import academy.pocu.comp2500.lab10.pocuflix.ResultCode;

import java.util.HashMap;

public final class CacheMiddleware implements IRequestHandler {
    private final IRequestHandler requestHandler;
    private final int expiryCount;
    private final HashMap<Request, Integer> cacheUsedCounts;

    // ---

    public CacheMiddleware(final IRequestHandler requestHandler, final int expiryCount) {
        this.requestHandler = requestHandler;
        this.expiryCount = expiryCount;
        this.cacheUsedCounts = new HashMap<>();
    }

    // ---

    @Override
    public final ResultBase handle(final Request request) {
        if (this.cacheUsedCounts.containsKey(request)) {
            int usedCount = this.cacheUsedCounts.get(request);
            ++usedCount;

            if (usedCount < this.expiryCount) {
                this.cacheUsedCounts.put(request, usedCount);
                return new CachedResult(this.expiryCount - usedCount);
            } else {
                this.cacheUsedCounts.remove(request);
            }
        }

        final ResultBase resultBase = requestHandler.handle(request);
        final ResultValidator validator = new ResultValidator(resultBase);
        if (validator.isValid(ResultCode.OK)) {
            this.cacheUsedCounts.put(request, 0);
        }

        return resultBase;
    }
}
