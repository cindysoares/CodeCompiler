
package com.gteamtrials.soap.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8-b131 
 * Generated source version: 2.1
 * 
 */
@WebService(name = "CodeCompiler", targetNamespace = "http://service.soap.gteamtrials.com/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface CodeCompiler {


    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(partName = "return")
    public String compileAndRun(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

}
