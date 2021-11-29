package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.ResultBase;
import academy.pocu.comp2500.lab10.pocuflix.ResultCode;

import java.util.HashMap;

//        김동규 개체 어제, 오전 12:02
//        책임 연쇄 패턴이라 항상 뒤에 미들웨어들의 값을 참고하는 방법이 안되면
//        아래의 명세는 구현할 방법이 없는 걸로 보이는데요
//        방법이 있나요?
//        "하지만 영화 데이터가 바뀌었다면(예: 자막 등이 바뀜) 그건 다시 받아야 할 겁니다.
//        이런 일을 처리해 주는 게 CacheMiddleware 입니다."
//
//        [조교]queue  14시간 전
//        캐시를 할 때 자주 변경되는 데이터와 자주 변경되지 않는 데이터 두 가지에 따라 캐시 전략을 다르게 가지고 갈 수 있습니다.
//        우선 자주 변경되는 데이터를 캐시 할 때는 데이터의 해시 값이란 것을 사용해서 데이터가 변경되면 이 해시 값도 같이 바꿉니다.
//        해시 값이 변경되면 요청도 같이 변경됩니다.
//
//        예를 들어, 사용자가 포큐 1편이란 영화를 보고 싶다면, 실제 서비스는 0000 이란 해시 값이 포함된 포큐 1편-0000을 요청하고,
//        자막이 바뀌었다면 해시 값도 0001로 바뀌어 포큐 1편-0001란 데이터를 요청하게 됩니다.
//        그렇기 때문에 CacheMiddleware에서는 포큐 1편-0000이란 이름을 가진 데이터가 포큐 1편-0001의 데이터로 변경 되었는지 신경 쓸 필요가 없는 것입니다.
//
//        자주 변경되지 않는 데이터의 경우 expiry count 를 사용하기 때문에 이 역시도 CacheMiddleware에서는 데이터가 변경 되었는지 확인하지 않습니다.
//        expiry count 를 넘지 않으면 캐시된 데이터를 넘겨주고, 넘지 않았다면 MovieStore에 가서 데이터를 가지고 옵니다.
//
//        결론적으로 자주 변경되는 데이터와 변경되지 않는 데이터 모두에 대해서 CacheMiddleware는 변경 되었는지 뒤에 있는 미들웨어를 참고 할 필요가 없는 것입니다.

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

        final ResultBase resultBase = this.requestHandler.handle(request);
        final ResultValidator validator = new ResultValidator(resultBase);
        if (validator.isValid(ResultCode.OK)) {
            this.cacheUsedCounts.put(request, 0);
        }

        return resultBase;
    }
}
