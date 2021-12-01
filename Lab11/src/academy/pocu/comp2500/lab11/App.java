package academy.pocu.comp2500.lab11;

import academy.pocu.comp2500.lab11.pocu.Product;
import academy.pocu.comp2500.lab11.pocu.ProductNotFoundException;
import academy.pocu.comp2500.lab11.pocu.User;
import academy.pocu.comp2500.lab11.pocu.Warehouse;
import academy.pocu.comp2500.lab11.pocu.WarehouseType;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.ArrayList;

public final class App {
    private static final String APP_EXIT_TEXT = "exit";

    private static final String WAREHOUSE_START_TEXT = "WAREHOUSE: Choose your warehouse!";
    private static final String[] WAREHOUSE_TYPE_TEXTS = {"APPLE", "MICROSOFT", "SAMSUNG"};
    private static final WarehouseType[] WAREHOUSE_TYPES = {WarehouseType.APPLE, WarehouseType.MICROSOFT, WarehouseType.SAMSUNG};

    private static final String BALANCE_TEXT = "BALANCE: ";

    private static final String PRODUCT_LIST_START_TEXT = "PRODUCT_LIST: Choose the product you want to buy!";

    // ---

    public App() {
    }

    // ---

    public final void run(final BufferedReader in, final PrintStream out, final PrintStream err) {
        final User user = new User();
        Warehouse warehouse;
        final SafeWallet wallet;
        while (true) {
            out.println(WAREHOUSE_START_TEXT);
            for (int i = 0; i < WAREHOUSE_TYPE_TEXTS.length; ++i) {
                out.println(String.format("%d. %s", i + 1, WAREHOUSE_TYPE_TEXTS[i]));
            }

            int chooseWarehouseNum;
            try {
                final String read = in.readLine();
                if (read.equals(APP_EXIT_TEXT)) {
                    return;
                }

                chooseWarehouseNum = Integer.parseInt(read);
            } catch (Exception e) {
                continue;
            }

            if (1 <= chooseWarehouseNum && chooseWarehouseNum <= WAREHOUSE_TYPE_TEXTS.length) {
                warehouse = new Warehouse(WAREHOUSE_TYPES[chooseWarehouseNum - 1]);
                break;
            }
        }

        // get wallet
        try {
            wallet = new SafeWallet(user);
        } catch (IllegalAccessException e) {
            err.println("AUTH_ERROR");
            return;
        }

        // Choose the product
        while (true) {
            // print BALANCE
            out.println(String.format("%s%d", BALANCE_TEXT, wallet.getAmount()));

            // print product
            out.println(PRODUCT_LIST_START_TEXT);
            final ArrayList<Product> products = warehouse.getProducts();
            for (int i = 0; i < products.size(); ++i) {
                out.println(String.format("%d. %-20s%5d", i + 1, products.get(i).getName(), products.get(i).getPrice()));
            }

            int chooseProductNum;
            try {
                final String read = in.readLine();
                if (read.equals(APP_EXIT_TEXT)) {
                    return;
                }

                chooseProductNum = Integer.parseInt(read);
            } catch (Exception e) {
                continue;
            }

            if (1 <= chooseProductNum && chooseProductNum <= products.size()) {
                final Product product = products.get(chooseProductNum - 1);
                if (product.getPrice() > wallet.getAmount()) {
                    continue;
                }

                try {
                    warehouse.removeProduct(product.getId());
                } catch (ProductNotFoundException e) {
                    continue;
                }

                wallet.withdraw(product.getPrice());
            }
        }
    }

}
