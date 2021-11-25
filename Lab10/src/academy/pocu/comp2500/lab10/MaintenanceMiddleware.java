package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.ResultBase;

import java.time.Duration;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public final class MaintenanceMiddleware implements IRequestHandler {
    private static final Duration MAINTENANCE_TIME = Duration.ofHours(1);

    // ---

    private final IRequestHandler requestHandler;
    private final OffsetDateTime startDateTime;
    private final OffsetDateTime endDateTime;

    // ---

    public MaintenanceMiddleware(final IRequestHandler requestHandler, final OffsetDateTime startDateTime) {
        this.requestHandler = requestHandler;

        this.startDateTime = startDateTime;
        this.endDateTime = startDateTime.plus(MAINTENANCE_TIME);
    }

    // ---

    @Override
    public final ResultBase handle(final Request request) {
        final OffsetDateTime now = OffsetDateTime.now(ZoneOffset.UTC);
        if (this.startDateTime.compareTo(now) <= 0 && now.compareTo(this.endDateTime) < 0) {
            return new ServiceUnavailableResult(this.startDateTime, this.endDateTime);
        }

        return requestHandler.handle(request);
    }
}
