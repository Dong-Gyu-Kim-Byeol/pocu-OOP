package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.OkResult;
import academy.pocu.comp2500.lab10.pocuflix.ResultBase;
import academy.pocu.comp2500.lab10.pocuflix.ResultCode;

import java.util.HashMap;

public final class CacheMiddleware implements IRequestHandler {
    private final IRequestHandler requestHandler;
    private final int startExpiryCount;
    private final HashMap<Request, CachedRequest> cachedExpiryCounts;

    // ---

    public CacheMiddleware(final IRequestHandler requestHandler, final int startExpiryCount) {
        this.requestHandler = requestHandler;
        this.startExpiryCount = startExpiryCount;
        this.cachedExpiryCounts = new HashMap<>();
    }

    // ---

    @Override
    public final ResultBase handle(final Request request) {
        final ResultBase resultBase = requestHandler.handle(request);
        final ResultValidator validator = new ResultValidator(resultBase);
        if (!validator.isValid(ResultCode.OK)) {
            return resultBase;
        }

        final OkResult okResult = (OkResult) resultBase;

//        final ResultBase resultBase = requestHandler.handle(request);
//        final ResultValidator validator = new ResultValidator(resultBase);
//        if (validator.isValid(ResultCode.OK)) {
//            this.cachedExpiryCounts.put(request, this.startExpiryCount);
//        }

        if (!this.cachedExpiryCounts.containsKey(request)) {
            this.cachedExpiryCounts.put(request, new CachedRequest(request, okResult.getMovie(), this.startExpiryCount));
            return resultBase;
        }

        CachedRequest cachedRequest = this.cachedExpiryCounts.get(request);
        cachedRequest.subExpiryCount();

        if (!cachedRequest.getMovie().equals(okResult.getMovie())) {
            this.cachedExpiryCounts.put(request, new CachedRequest(request, okResult.getMovie(), this.startExpiryCount));
            return resultBase;
        }

        if (cachedRequest.getExpiryCount() <= 0) {
            this.cachedExpiryCounts.remove(request);
            return resultBase;
        }

        this.cachedExpiryCounts.put(request, cachedRequest);
        return new CachedResult(cachedRequest.getExpiryCount());
    }
}
