package unitTesting.bank;

import com.atm.bank.Customer;
import org.junit.Assert;
import org.testng.annotations.Test;

import java.sql.Date;

public class CustomerTest {

    //check that user data is created
    @Test
    public void checkCustomerDataCreated() {
        Customer customer = new Customer();
        customer.createUserData();

        //firstname
        Assert.assertNotNull(customer.getFirstName());

        //lastname
        Assert.assertNotNull(customer.getLastName());

        //dateOfBirth
        Assert.assertNotNull(customer.getDateOfBirth());

        //gender
        Assert.assertNotNull(customer.getGender());

        //countryOfBirth
        Assert.assertNotNull(customer.getCountryOfBirth());

        //address
        Assert.assertNotNull(customer.getAddress());

        //socialSecurityNumber
        Assert.assertNotNull(customer.getSocialSecurityNumber());

        //phoneNumber
        Assert.assertNotNull(customer.getPhone());

        //username
        Assert.assertNotNull(customer.getUsername());

        //password
        Assert.assertNotNull(customer.getPassword());

        //currentAmount
        Assert.assertNotNull(customer.getCurrentAmount());

        //pin
        Assert.assertNotNull(customer.getPin());

        //cardNumber
        Assert.assertNotNull(customer.getCardNumber());

        //sortCode
        Assert.assertNotNull(customer.getSortCode());

        //accountNumber
        Assert.assertNotNull(customer.getAccountNumber());
    }

    //check that user data can be updated
    @Test
    public void checkCustomerDataUpdated() {
        Customer customer = new Customer();

        //firstname
        customer.setFirstName("Changed First Name");
        Assert.assertEquals("Changed First Name", customer.getFirstName());

        //lastname
        customer.setLastName("Changed Last Name");
        Assert.assertEquals("Changed Last Name", customer.getLastName());

        //dateOfBirth
        Date dateOfBirth = Date.valueOf("2023-01-01");
        customer.setDateOfBirth(dateOfBirth);
        Date getNewDateOfBirth = customer.getDateOfBirth();
        Assert.assertEquals(dateOfBirth, getNewDateOfBirth);

        //gender
        customer.setGender("Changed Gender");
        Assert.assertEquals("Changed Gender", customer.getGender());

        //countryOfBirth
        customer.setCountryOfBirth("Changed Country of Birth");
        Assert.assertEquals("Changed Country of Birth", customer.getCountryOfBirth());

        //address
        customer.setAddress("Changed Address");
        Assert.assertEquals("Changed Address", customer.getAddress());

        //socialSecurityNumber
        customer.setSocialSecurityNumber("Changed Social Security Number");
        Assert.assertEquals("Changed Social Security Number", customer.getSocialSecurityNumber());

        //phoneNumber
        customer.setPhone("Changed Phone Number");
        Assert.assertEquals("Changed Phone Number", customer.getPhone());

        //username
        customer.setUsername("Changed Username");
        Assert.assertEquals("Changed Username", customer.getUsername());

        //password
        customer.setPassword("Changed Password");
        Assert.assertEquals("Changed Password", customer.getPassword());

        //pin
        customer.setPin(1234);
        Assert.assertEquals(1234, customer.getPin());

        //cardNumber
        customer.setCardNumber("Changed Card Number");
        Assert.assertEquals("Changed Card Number", customer.getCardNumber());

        //sortCode
        customer.setSortCode("Changed Sort Code");
        Assert.assertEquals("Changed Sort Code", customer.getSortCode());

        //accountNumber
        customer.setAccountNumber("Changed Account Number");
        Assert.assertEquals("Changed Account Number", customer.getAccountNumber());
    }
}
