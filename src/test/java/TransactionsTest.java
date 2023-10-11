import Core.Customers;
import Service.Transactions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TransactionsTest {
    @Test
    public void debitTransaction(){
        Customers customers = new Customers("qwerty","12345");
        assertFalse(Transactions.debitTransaction(customers,100));
    }

    @Test
    public void creditTransaction(){
        Customers customers = new Customers("ivan","889912");
        assertTrue(Transactions.creditTransaction(customers,1000));
    }
}
