package academy.pocu.comp2500.lab9;

import java.util.ArrayList;

public interface IPricingModel {
    int getTotalPrice(final ArrayList<Book> books);
}
