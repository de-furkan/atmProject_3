package unitTesting.bank;

import com.atm.bank.Bank;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BankTest {

    //test the getBankName() method
    @Test
    public void testGetBankName() {
        Bank bank = new Bank();
        Assert.assertEquals("XBankUniversal", bank.getBankName() );
    }

    //test the getBankBranchId() method
    @Test
    public void testGetBankBranchId() {
        Bank bank = new Bank();
        Assert.assertEquals("XB13541", bank.getBankBranchId() );
    }

    //test the getAddress() method
    @Test
    public void testGetAddress() {
        Bank bank = new Bank();
        Assert.assertEquals("6595 Breitenberg Orchard, New Margo, MO 81496", bank.getAddress() );
    }

    //test the getContactNumber() method
    @Test
    public void testGetContactNumber() {
        Bank bank = new Bank();
        Assert.assertEquals("850-615-1458", bank.getContactNumber() );
    }
}
