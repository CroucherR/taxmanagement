package com.example.taxmanagementrest;
import com.example.taxmanagementrest.models.*;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.Objects;

/**
 * TAX MANAGEMENT APPLICATION TESTS -
 *
 * Class containing the Junit tests for this application, these tests ensure that the POST, GET and DELETE methods for each of the entities within the application
 * It also tests that a user cannot enter an incorrect type into the URL for each of the repos including the DTOs
 *
 * FOR THESE TESTS TO RUN CORRECTLY THE KEYCLOAK SETTINGS MUST BE OFF, PLEASE REFER TO THE TaxManagementServiceConfig CLASS TO TOGGLE KEYCLOAK
 */


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TaxManagementApplicationTests
{

    @LocalServerPort
    private int port;

    @Test
    void contextLoads() {
    }

    @Autowired
    private TestRestTemplate restTemplate;

    private String GetURL(String... params)
    {
        String url = "http://localhost:"+ port;

        for(String p :params)
        {
            url += "/"+p;

        }
        return url;
    }

    @Test
    @Order(1)
    public void TestIncorrectTypeOwnerGet() throws IOException {
        HttpUriRequest request = new HttpGet(GetURL("owner", "hello"));
        HttpResponse response = HttpClientBuilder.create().build().execute(request);

        Assert.assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatusLine().getStatusCode());
    }

    @Test
    @Order(2)
    public void TestOwnerPostSuccessfulHttpCode() throws URISyntaxException
    {
        URI uri = new URI(GetURL("owner"));
        Owner owner = new Owner();
        owner.setFirstname("Riley");
        owner.setSecondname("Croucher");
        owner.setAddress("Cardiff");

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-PERSIST","true");
        HttpEntity<Owner> request = new HttpEntity<>(owner, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(uri,request, String.class);

        Assert.assertEquals(HttpStatus.SC_CREATED, response.getStatusCodeValue());
    }

    @Test
    @Order(3)
    public void TestOwnerGetDataSuccessful() throws URISyntaxException
    {
        URI uri = new URI(GetURL("owner", "1"));

        ResponseEntity<Owner> response = restTemplate.getForEntity(uri, Owner.class);

        Assert.assertEquals(HttpStatus.SC_OK, response.getStatusCodeValue());
        Assert.assertEquals("Riley", response.getBody().getFirstname());
        Assert.assertEquals("Croucher", response.getBody().getSecondname());
        Assert.assertEquals("Cardiff", response.getBody().getAddress());
    }

    @Test
    @Order(4)
    public void TestOwnerDeleteSuccessfulHttpCode() throws URISyntaxException
    {
        URI uri = new URI(GetURL("owner","1"));
        Owner owner = new Owner();
        ResponseEntity<String> response  = restTemplate.exchange(uri, HttpMethod.DELETE, new HttpEntity<>(owner), String.class);
        Assert.assertEquals(HttpStatus.SC_NO_CONTENT, response.getStatusCodeValue());
    }

    @Test
    @Order(5)
    public void TestIncorrectTypeVehicleGet() throws IOException {
        HttpUriRequest request = new HttpGet(GetURL("vehicle", "hello"));
        HttpResponse response = HttpClientBuilder.create().build().execute(request);

        Assert.assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatusLine().getStatusCode());
    }

    @Test
    @Order(6)
    public void TestVehiclePostSuccessfulHttpCode() throws URISyntaxException
    {
        URI uri = new URI(GetURL("vehicle"));
        Vehicle vehicle = new Vehicle();
        vehicle.setYear(2020);
        vehicle.setRegno("BA20 MSC");
        vehicle.setMake("VW");
        vehicle.setModel("POLO");
        vehicle.setValue(25000);
        vehicle.setEnginestats(250);
        vehicle.setFueltype("Petrol");

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-PERSIST","true");
        HttpEntity<Vehicle> request = new HttpEntity<>(vehicle, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(uri,request, String.class);

        Assert.assertEquals(HttpStatus.SC_CREATED, response.getStatusCodeValue());
    }

    @Test
    @Order(7)
    public void TestVehicleGetDataSuccessful() throws URISyntaxException
    {
        URI uri = new URI(GetURL("vehicle", "1"));

        ResponseEntity<Vehicle> response = restTemplate.getForEntity(uri, Vehicle.class);

        Assert.assertEquals(HttpStatus.SC_OK, response.getStatusCodeValue());
        Assert.assertEquals(2020, response.getBody().getYear());
        Assert.assertEquals("BA20 MSC", response.getBody().getRegno());
        Assert.assertEquals("VW", response.getBody().getMake());
        Assert.assertEquals("POLO", response.getBody().getModel());
        Assert.assertEquals(25000, response.getBody().getValue(),1);
        Assert.assertEquals(250, response.getBody().getEnginestats(),1);
        Assert.assertEquals("Petrol", response.getBody().getFueltype());
    }

    @Test
    @Order(8)
    public void TestVehicleDeleteSuccessfulHttpCode() throws URISyntaxException
    {
        URI uri = new URI(GetURL("vehicle","1"));
        Vehicle vehicle = new Vehicle();
        ResponseEntity<String> response  = restTemplate.exchange(uri, HttpMethod.DELETE, new HttpEntity<>(vehicle), String.class);
        Assert.assertEquals(HttpStatus.SC_NO_CONTENT, response.getStatusCodeValue());
    }

    @Test
    @Order(9)
    public void TestIncorrectTypeVehicleRegGet() throws IOException {
        HttpUriRequest request = new HttpGet(GetURL("vehicle", "hello"));
        HttpResponse response = HttpClientBuilder.create().build().execute(request);

        Assert.assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatusLine().getStatusCode());
    }

    @Test
    @Order(10)
    public void TestVehicleRegPostSuccessfulHttpCode() throws URISyntaxException
    {
        URI uri = new URI(GetURL("vehicleRegistration"));
        VehicleRegistration vehicleRegistration = new VehicleRegistration();
        vehicleRegistration.setRegistrationdate(LocalDate.parse("2020-12-31"));

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-PERSIST","true");
        HttpEntity<VehicleRegistration> request = new HttpEntity<>(vehicleRegistration, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(uri,request, String.class);
        Assert.assertEquals(HttpStatus.SC_CREATED, response.getStatusCodeValue());
    }

    @Test
    @Order(11)
    public void TestVehicleRegGetDataSuccessful() throws URISyntaxException
    {
        URI uri = new URI(GetURL("vehicleRegistration", "1"));

        ResponseEntity<VehicleRegistration> response = restTemplate.getForEntity(uri, VehicleRegistration.class);

        Assert.assertEquals(HttpStatus.SC_OK, response.getStatusCodeValue());
        Assert.assertEquals(LocalDate.parse("2020-12-31"), Objects.requireNonNull(response.getBody()).getRegistrationdate());
    }

    @Test
    @Order(12)
    public void TestVehicleRegDeleteSuccessfulHttpCode() throws URISyntaxException
    {
        URI uri = new URI(GetURL("vehicleRegistration","1"));
        VehicleRegistration vehicleRegistration = new VehicleRegistration();
        ResponseEntity<String> response  = restTemplate.exchange(uri, HttpMethod.DELETE, new HttpEntity<>(vehicleRegistration), String.class);
        Assert.assertEquals(HttpStatus.SC_NO_CONTENT, response.getStatusCodeValue());
    }
    @Test
    @Order(13)
    public void TestIncorrectTypeTaxInfoGet() throws IOException {
        HttpUriRequest request = new HttpGet(GetURL("taxInformation", "hello"));
        HttpResponse response = HttpClientBuilder.create().build().execute(request);

        Assert.assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatusLine().getStatusCode());
    }

    @Test
    @Order(14)
    public void TestTaxInfoPostSuccessfulHttpCode() throws URISyntaxException
    {
        URI uri = new URI(GetURL("taxInformation"));
        TaxInformation taxInformation = new TaxInformation();
        taxInformation.setEnginestatsband("A1");
        taxInformation.setIsclassic(true);
        taxInformation.setIsvalue(false);

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-PERSIST","true");
        HttpEntity<TaxInformation> request = new HttpEntity<>(taxInformation, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(uri,request, String.class);
        Assert.assertEquals(HttpStatus.SC_CREATED, response.getStatusCodeValue());
    }

    @Test
    @Order(15)
    public void TestTaxInfoGetDataSuccessful() throws URISyntaxException
    {
        URI uri = new URI(GetURL("taxInformation", "1"));

        ResponseEntity<TaxInformation> response = restTemplate.getForEntity(uri, TaxInformation.class);

        Assert.assertEquals(HttpStatus.SC_OK, response.getStatusCodeValue());
        Assert.assertEquals("A1", Objects.requireNonNull(response.getBody()).getEnginestatsband());
        Assert.assertTrue(Objects.requireNonNull(response.getBody()).isIsclassic());
        Assert.assertFalse(Objects.requireNonNull(response.getBody()).isIsvalue());

    }

    @Test
    @Order(16)
    public void TestTaxInfoDeleteSuccessfulHttpCode() throws URISyntaxException
    {
        URI uri = new URI(GetURL("taxInformation","1"));
        TaxInformation taxInformation = new TaxInformation();
        ResponseEntity<String> response  = restTemplate.exchange(uri, HttpMethod.DELETE, new HttpEntity<>(taxInformation), String.class);
        Assert.assertEquals(HttpStatus.SC_NO_CONTENT, response.getStatusCodeValue());
    }

    @Test
    @Order(17)
    public void TestIncorrectTypeTaxPaymentsGet() throws IOException {
        HttpUriRequest request = new HttpGet(GetURL("taxPayment", "hello"));
        HttpResponse response = HttpClientBuilder.create().build().execute(request);

        Assert.assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatusLine().getStatusCode());
    }

    @Test
    @Order(18)
    public void TestTaxPaymentsPostSuccessfulHttpCode() throws URISyntaxException
    {
        URI uri = new URI(GetURL("taxPayment"));
        TaxPayment taxPayment = new TaxPayment();
        taxPayment.setCost(340);
        taxPayment.setPaymentmethod("CARD");
        taxPayment.setPaymentdate(LocalDate.parse("2020-12-31"));

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-PERSIST","true");
        HttpEntity<TaxPayment> request = new HttpEntity<>(taxPayment, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(uri,request, String.class);
        Assert.assertEquals(HttpStatus.SC_CREATED, response.getStatusCodeValue());
    }

    @Test
    @Order(19)
    public void TestTaxPaymentsGetDataSuccessful() throws URISyntaxException
    {
        URI uri = new URI(GetURL("taxPayment", "1"));

        ResponseEntity<TaxPayment> response = restTemplate.getForEntity(uri, TaxPayment.class);

        Assert.assertEquals(HttpStatus.SC_OK, response.getStatusCodeValue());
        Assert.assertEquals(340, response.getBody().getCost(),1);
        Assert.assertEquals("CARD", response.getBody().getPaymentmethod());
        Assert.assertEquals(LocalDate.parse("2020-12-31"), response.getBody().getPaymentdate());
    }

    @Test
    @Order(20)
    public void TestTaxPaymentsDeleteSuccessfulHttpCode() throws URISyntaxException
    {
        URI uri = new URI(GetURL("taxPayment","1"));
        TaxPayment taxPayment = new TaxPayment();
        ResponseEntity<String> response  = restTemplate.exchange(uri, HttpMethod.DELETE, new HttpEntity<>(taxPayment), String.class);
        Assert.assertEquals(HttpStatus.SC_NO_CONTENT, response.getStatusCodeValue());
    }

    @Test
    @Order(21)
    public void TestTaxPaymentDTOIncorrectHttpCode() throws IOException {
        HttpUriRequest request = new HttpGet(GetURL("paymentdetails", "hello"));
        HttpResponse response = HttpClientBuilder.create().build().execute(request);

        Assert.assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatusLine().getStatusCode());
    }

    @Test
    @Order(22)
    public void TestTaxInfoDTOIncorrectHttpCode() throws IOException {
        HttpUriRequest request = new HttpGet(GetURL("taxdetails", "hello"));
        HttpResponse response = HttpClientBuilder.create().build().execute(request);

        Assert.assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatusLine().getStatusCode());
    }

    @Test
    @Order(23)
    public void TestVehicleRegDTOIncorrectHttpCode() throws IOException {
        HttpUriRequest request = new HttpGet(GetURL("registrationdetails", "hello"));
        HttpResponse response = HttpClientBuilder.create().build().execute(request);

        Assert.assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatusLine().getStatusCode());
    }
}
