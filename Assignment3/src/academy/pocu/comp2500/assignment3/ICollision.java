package academy.pocu.comp2500.assignment3;

public interface ICollision {
    void onCollision(final Unit unit);

    ImmutableIntVector2D getCollisionPosition();
}
