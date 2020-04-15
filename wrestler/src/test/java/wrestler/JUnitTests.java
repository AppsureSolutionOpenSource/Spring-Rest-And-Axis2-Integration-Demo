package wrestler;


import org.junit.jupiter.api.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import wrestler.clients.soap.EventLoggingServiceSoapControllerStub;

import java.rmi.RemoteException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JUnitTests {
    @Test
    @Order(1)
    public void CreateInfoTest() throws RemoteException {
        EventLoggingServiceSoapControllerStub.CreateInfo info = new EventLoggingServiceSoapControllerStub.CreateInfo();
        EventLoggingServiceSoapControllerStub soapControllerStub = new EventLoggingServiceSoapControllerStub("http://localhost:8080/axis2/services/EventLoggingServiceSoapController");
        info.setUser("unit-test");
        info.setDescription("sample call");
        EventLoggingServiceSoapControllerStub.CreateInfoResponse response = soapControllerStub.createInfo(info);
        long returnedId = response.get_return();
        Assertions.assertTrue(returnedId > 0,"Invalid event id.");
    }

    @Test
    @Order(2)
    public void CreateErrorTest() throws RemoteException {
        EventLoggingServiceSoapControllerStub.CreateError info = new EventLoggingServiceSoapControllerStub.CreateError();
        EventLoggingServiceSoapControllerStub soapControllerStub = new EventLoggingServiceSoapControllerStub("http://localhost:8080/axis2/services/EventLoggingServiceSoapController");
        info.setUser("unit-test");
        info.setDescription("sample call");
        EventLoggingServiceSoapControllerStub.CreateErrorResponse response = soapControllerStub.createError(info);
        long returnedId = response.get_return();
        Assertions.assertTrue(returnedId > 0,"Invalid event id.");
    }

    @Test
    @Order(3)
    public void CreateWarnTest() throws RemoteException {
        EventLoggingServiceSoapControllerStub.CreateWarn info = new EventLoggingServiceSoapControllerStub.CreateWarn();
        EventLoggingServiceSoapControllerStub soapControllerStub = new EventLoggingServiceSoapControllerStub("http://localhost:8080/axis2/services/EventLoggingServiceSoapController");
        info.setUser("unit-test");
        info.setDescription("sample call");
        EventLoggingServiceSoapControllerStub.CreateWarnResponse response = soapControllerStub.createWarn(info);
        long returnedId = response.get_return();
        Assertions.assertTrue(returnedId > 0,"Invalid event id.");
    }

    @Test
    @Order(4)
    public void GetRandomTests() throws RemoteException {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Integer> random = restTemplate.getForEntity("http://localhost:8080/api/rest/getRandom", Integer.class);
        Assertions.assertEquals(random.getStatusCode(), HttpStatus.OK);
    }
}
