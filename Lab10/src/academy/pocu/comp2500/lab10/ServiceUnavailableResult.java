package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.ResultBase;
import academy.pocu.comp2500.lab10.pocuflix.ResultCode;

import java.time.OffsetDateTime;

public final class ServiceUnavailableResult extends ResultBase {
    private final OffsetDateTime startDateTime;
    private final OffsetDateTime endDateTime;

    // ---

    public ServiceUnavailableResult(final OffsetDateTime startDateTime, final OffsetDateTime endDateTime) {
        super(ResultCode.SERVICE_UNAVAILABLE);

        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
    }

    // ---


    public final OffsetDateTime getStartDateTime() {
        return startDateTime;
    }

    public final OffsetDateTime getEndDateTime() {
        return endDateTime;
    }
}
