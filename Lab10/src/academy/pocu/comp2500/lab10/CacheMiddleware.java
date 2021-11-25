package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.ResultBase;
import academy.pocu.comp2500.lab10.pocuflix.ResultCode;

import java.util.HashMap;

public final class CacheMiddleware implements IRequestHandler {
    private final IRequestHandler requestHandler;
    private final int startExpiryCount;
    private final HashMap<Request, Integer> cachedExpiryCounts;

    // ---

    public CacheMiddleware(final IRequestHandler requestHandler, final int startExpiryCount) {
        this.requestHandler = requestHandler;
        this.startExpiryCount = startExpiryCount;
        this.cachedExpiryCounts = new HashMap<>();
    }

    // ---

    @Override
    public final ResultBase handle(final Request request) {
        if (this.cachedExpiryCounts.containsKey(request)) {
            int expiryCount = this.cachedExpiryCounts.get(request);
            --expiryCount;

            if (expiryCount > 0) {
                this.cachedExpiryCounts.put(request, expiryCount);
                return new CachedResult(expiryCount);
            } else {
                this.cachedExpiryCounts.remove(request);
            }
        }


        final ResultBase resultBase = requestHandler.handle(request);
        if (resultBase.getCode() == ResultCode.OK) {
            this.cachedExpiryCounts.put(request, this.startExpiryCount);
        }

        return resultBase;
    }
}
