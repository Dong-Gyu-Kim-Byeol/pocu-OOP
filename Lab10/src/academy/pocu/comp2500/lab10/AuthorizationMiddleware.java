package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.ResultBase;
import academy.pocu.comp2500.lab10.pocuflix.User;

import java.util.HashSet;

public final class AuthorizationMiddleware implements IRequestHandler {
    private final IRequestHandler requestHandler;
    private final HashSet<User> canAccessUsers;

    // ---

    public AuthorizationMiddleware(final IRequestHandler requestHandler, final HashSet<User> canAccessUsers) {
        this.requestHandler = requestHandler;
        this.canAccessUsers = canAccessUsers;
    }

    // ---

    @Override
    public final ResultBase handle(final Request request) {
        if (!canAccessUsers.contains(request.getUser())) {
            return new UnauthorizedResult();
        }

        return requestHandler.handle(request);
    }
}
