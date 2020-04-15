/**
 * EventLoggingServiceSoapControllerCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.9  Built on : Nov 16, 2018 (12:05:37 GMT)
 */
package wrestler.clients.soap;


/**
 *  EventLoggingServiceSoapControllerCallbackHandler Callback class, Users can extend this class and implement
 *  their own receiveResult and receiveError methods.
 */
public abstract class EventLoggingServiceSoapControllerCallbackHandler {
    protected Object clientData;

    /**
     * User can pass in any object that needs to be accessed once the NonBlocking
     * Web service call is finished and appropriate method of this CallBack is called.
     * @param clientData Object mechanism by which the user can pass in user data
     * that will be avilable at the time this callback is called.
     */
    public EventLoggingServiceSoapControllerCallbackHandler(Object clientData) {
        this.clientData = clientData;
    }

    /**
     * Please use this constructor if you don't want to set any clientData
     */
    public EventLoggingServiceSoapControllerCallbackHandler() {
        this.clientData = null;
    }

    /**
     * Get the client data
     */
    public Object getClientData() {
        return clientData;
    }

    /**
     * auto generated Axis2 call back method for getEvents method
     * override this method for handling normal response from getEvents operation
     */
    public void receiveResultgetEvents(
        wrestler.clients.soap.EventLoggingServiceSoapControllerStub.GetEventsResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getEvents operation
     */
    public void receiveErrorgetEvents(Exception e) {
    }

    /**
     * auto generated Axis2 call back method for createError method
     * override this method for handling normal response from createError operation
     */
    public void receiveResultcreateError(
        wrestler.clients.soap.EventLoggingServiceSoapControllerStub.CreateErrorResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from createError operation
     */
    public void receiveErrorcreateError(Exception e) {
    }

    /**
     * auto generated Axis2 call back method for createInfo method
     * override this method for handling normal response from createInfo operation
     */
    public void receiveResultcreateInfo(
        wrestler.clients.soap.EventLoggingServiceSoapControllerStub.CreateInfoResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from createInfo operation
     */
    public void receiveErrorcreateInfo(Exception e) {
    }

    /**
     * auto generated Axis2 call back method for createWarn method
     * override this method for handling normal response from createWarn operation
     */
    public void receiveResultcreateWarn(
        wrestler.clients.soap.EventLoggingServiceSoapControllerStub.CreateWarnResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from createWarn operation
     */
    public void receiveErrorcreateWarn(Exception e) {
    }
}
