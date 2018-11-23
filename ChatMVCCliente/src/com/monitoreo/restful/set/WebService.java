/*
 * @version: 1.0 
 * @author: Jesús Mendoza Verduzco 11/2018.
 * @email contact: loginlock22@gmail.com
 */
package com.monitoreo.restful.set;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

/**
 * Jersey REST client generated for REST resource:RESTLocal [LocalService]<br>
 * USAGE:
 * <pre>
 *        WebService client = new WebService();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author Jesús Mendoza Verduzco
 */
public class WebService {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/RestFulServiceMonitoreo/services";

    public WebService() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("LocalService");
    }

    public Response fn_sincronizar_configuracion_envio(Object requestEntity) throws ClientErrorException {
        return webTarget.path("POST_fn_sincronizar_configuracion_envio").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), Response.class);
    }

    public Response DecryptPost(Object requestEntity, String texto) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("POST_Decrypt/{0}", new Object[]{texto})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), Response.class);
    }

    public Response fn_sincronizar_kiosco(Object requestEntity) throws ClientErrorException {
        return webTarget.path("POST_fn_sincronizar_kiosco").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), Response.class);
    }

    public Response fn_sincronizar_tipo_archivo(Object requestEntity) throws ClientErrorException {
        return webTarget.path("POST_fn_sincronizar_tipo_archivo").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), Response.class);
    }

    /*public <T> T infoServicio(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("GET_infoServicio");
        return resource.get(responseType);
    }

    public <T> T encryptionGet(Class<T> responseType, String texto) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("GET_encryption/{0}", new Object[]{texto}));
        return resource.get(responseType);
    }*/

    public Response fn_sincronizar_rol(Object requestEntity) throws ClientErrorException {
        return webTarget.path("POST_fn_sincronizar_rol").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), Response.class);
    }

    public Response fn_sincronizar_lista_programada(Object requestEntity) throws ClientErrorException {
        return webTarget.path("POST_fn_sincronizar_lista_programada").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), Response.class);
    }

    public Response fn_sincronizar_usuario(Object requestEntity) throws ClientErrorException {
        return webTarget.path("POST_fn_sincronizar_usuario").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), Response.class);
    }

    public Response fn_sincronizar_permiso_alerta_kiosco(Object requestEntity) throws ClientErrorException {
        return webTarget.path("POST_fn_sincronizar_permiso_alerta_kiosco").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), Response.class);
    }

    public Response encryptionPost(Object requestEntity, String texto) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("POST_encryption/{0}", new Object[]{texto})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), Response.class);
    }

    public Response fn_registrar_denominacion_transaccion(Object requestEntity) throws ClientErrorException {
        return webTarget.path("POST_fn_registrar_denominacion_transaccion").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), Response.class);
    }

    public Response fn_actualizar_impresora(Object requestEntity) throws ClientErrorException {
        return webTarget.path("POST_fn_actualizar_impresora").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), Response.class);
    }

    /*public <T> T DecryptGet(Class<T> responseType, String texto) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("GET_Decrypt/{0}", new Object[]{texto}));
        return resource.get(responseType);
    }*/

    public Response fn_sincronizar_impresora(Object requestEntity) throws ClientErrorException {
        return webTarget.path("POST_fn_sincronizar_impresora").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), Response.class);
    }

    public Response fn_sincronizar_agencia(Object requestEntity) throws ClientErrorException {
        return webTarget.path("POST_fn_sincronizar_agencia").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), Response.class);
    }

    public Response fn_sincronizar_det_lista_archivo(Object requestEntity) throws ClientErrorException {
        return webTarget.path("POST_fn_sincronizar_det_lista_archivo").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), Response.class);
    }

    public Response fn_sincronizar_dispositivo_vending(Object requestEntity) throws ClientErrorException {
        return webTarget.path("POST_fn_sincronizar_dispositivo_vending").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), Response.class);
    }

    public Response fn_registrar_alerta(Object requestEntity) throws ClientErrorException {
        return webTarget.path("POST_fn_registrar_alerta").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), Response.class);
    }

    public Response fn_sincronizar_dispositivo_vending_kiosco(Object requestEntity) throws ClientErrorException {
        return webTarget.path("POST_fn_sincronizar_dispositivo_vending_kiosco").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), Response.class);
    }

    public Response fn_registrar_corte_caja(Object requestEntity) throws ClientErrorException {
        return webTarget.path("POST_fn_registrar_corte_caja").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), Response.class);
    }

    public Response fn_sincronizar_lista_reproduccion(Object requestEntity) throws ClientErrorException {
        return webTarget.path("POST_fn_sincronizar_lista_reproduccion").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), Response.class);
    }

    public Response fn_registrar_fondo_revolvente(Object requestEntity) throws ClientErrorException {
        return webTarget.path("POST_fn_registrar_fondo_revolvente").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), Response.class);
    }

    public Response fn_registrar_alerta_enviada(Object requestEntity) throws ClientErrorException {
        return webTarget.path("POST_fn_registrar_alerta_enviada").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), Response.class);
    }

    public Response fn_sincronizar_status(Object requestEntity) throws ClientErrorException {
        return webTarget.path("POST_fn_sincronizar_status").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), Response.class);
    }

    public Response fn_sincronizar_archivo(Object requestEntity) throws ClientErrorException {
        return webTarget.path("POST_fn_sincronizar_archivo").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), Response.class);
    }

    public void close() {
        client.close();
    }
    
}
