/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integration;

import integration_client.Enabledproperties;
import integration_client.FindAllResponse;
import integration_client.FindRangeResponse;
import integration_client.WebServiceSNR;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

/**
 * REST Web Service
 *
 * @author sala_a
 */
@Path("webservicesnrport")
public class WebServiceSNRPort {
    private WebServiceSNR port;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of WebServiceSNRPort
     */
    public WebServiceSNRPort() {
        port = getPort();
    }

    /**
     * Invokes the SOAP method remove
     * @param entity resource URI parameter
     */
    @PUT
    @Consumes("application/xml")
    @Path("remove/")
    public void putRemove(JAXBElement<Enabledproperties> entity) {
        try {
            // Call Web Service Operation
            if (port != null) {
                port.remove(entity.getValue());
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
    }

    /**
     * Invokes the SOAP method count
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("text/plain")
    @Consumes("text/plain")
    @Path("count/")
    public String getCount() {
        try {
            // Call Web Service Operation
            if (port != null) {
                int result = port.count();
                return new java.lang.Integer(result).toString();
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }

    /**
     * Invokes the SOAP method find
     * @param id resource URI parameter
     * @return an instance of javax.xml.bind.JAXBElement<integration_client.Enabledproperties>
     */
    @POST
    @Produces("application/xml")
    @Consumes("application/xml")
    @Path("find/")
    public JAXBElement<Enabledproperties> postFind(JAXBElement<Object> id) {
        try {
            // Call Web Service Operation
            if (port != null) {
                integration_client.Enabledproperties result = port.find(id.getValue());
                return new JAXBElement<integration_client.Enabledproperties>(new QName("http//integration_client/", "enabledproperties"), integration_client.Enabledproperties.class, result);
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }

    /**
     * Invokes the SOAP method create
     * @param entity resource URI parameter
     */
    @PUT
    @Consumes("application/xml")
    @Path("create/")
    public void putCreate(JAXBElement<Enabledproperties> entity) {
        try {
            // Call Web Service Operation
            if (port != null) {
                port.create(entity.getValue());
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
    }

    /**
     * Invokes the SOAP method findAll
     * @return an instance of javax.xml.bind.JAXBElement<integration_client.FindAllResponse>
     */
    @GET
    @Produces("application/xml")
    @Consumes("text/plain")
    @Path("findall/")
    public JAXBElement<FindAllResponse> getFindAll() {
        try {
            // Call Web Service Operation
            if (port != null) {
                java.util.List<integration_client.Enabledproperties> result = port.findAll();

                class FindAllResponse_1 extends integration_client.FindAllResponse {

                    FindAllResponse_1(java.util.List<integration_client.Enabledproperties> _return) {
                        this._return = _return;
                    }
                }
                integration_client.FindAllResponse response = new FindAllResponse_1(result);
                return new integration_client.ObjectFactory().createFindAllResponse(response);
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }

    /**
     * Invokes the SOAP method edit
     * @param entity resource URI parameter
     */
    @PUT
    @Consumes("application/xml")
    @Path("edit/")
    public void putEdit(JAXBElement<Enabledproperties> entity) {
        try {
            // Call Web Service Operation
            if (port != null) {
                port.edit(entity.getValue());
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
    }

    /**
     * Invokes the SOAP method findRange
     * @param range resource URI parameter
     * @return an instance of javax.xml.bind.JAXBElement<integration_client.FindRangeResponse>
     */
    @POST
    @Produces("application/xml")
    @Consumes("application/xml")
    @Path("findrange/")
    public JAXBElement<FindRangeResponse> postFindRange(JAXBElement<List<Integer>> range) {
        try {
            // Call Web Service Operation
            if (port != null) {
                java.util.List<integration_client.Enabledproperties> result = port.findRange(range.getValue());

                class FindRangeResponse_1 extends integration_client.FindRangeResponse {

                    FindRangeResponse_1(java.util.List<integration_client.Enabledproperties> _return) {
                        this._return = _return;
                    }
                }
                integration_client.FindRangeResponse response = new FindRangeResponse_1(result);
                return new integration_client.ObjectFactory().createFindRangeResponse(response);
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }

    /**
     *
     */
    private WebServiceSNR getPort() {
        try {
            // Call Web Service Operation
            integration_client.WebServiceSNR_Service service = new integration_client.WebServiceSNR_Service();
            integration_client.WebServiceSNR p = service.getWebServiceSNRPort();
            return p;
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }
}
