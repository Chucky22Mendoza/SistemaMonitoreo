/*
 * @version: 1.0 
 * @author: Jesús Mendoza Verduzco 11/2018.
 * @email contact: loginlock22@gmail.com
 */
package com.service.monitoreo.services;

import com.service.monitoreo.models.fn_actualizar_impresoraModel;
import com.service.monitoreo.models.fn_registrar_fondo_revolventeModel;
import com.service.monitoreo.models.return_messageModel;
import com.service.monitoreo.models.fn_registrar_alertaModel;
import com.service.monitoreo.models.fn_registrar_alerta_enviadaModel;
import com.service.monitoreo.models.fn_registrar_corte_cajaModel;
import com.service.monitoreo.models.fn_registrar_denominacion_transaccionModel;
import com.service.monitoreo.models.fn_sincronizar_agenciaModel;
import com.service.monitoreo.models.fn_sincronizar_archivoModel;
import com.service.monitoreo.models.fn_sincronizar_configuracion_envioModel;
import com.service.monitoreo.models.fn_sincronizar_det_lista_archivoModel;
import com.service.monitoreo.models.fn_sincronizar_dispositivo_vendingModel;
import com.service.monitoreo.models.fn_sincronizar_dispositivo_vending_kioscoModel;
import com.service.monitoreo.models.fn_sincronizar_impresoraModel;
import com.service.monitoreo.models.fn_sincronizar_kioscoModel;
import com.service.monitoreo.models.fn_sincronizar_lista_programadaModel;
import com.service.monitoreo.models.fn_sincronizar_lista_reproduccionModel;
import com.service.monitoreo.models.fn_sincronizar_permiso_alerta_kioscoModel;
import com.service.monitoreo.models.fn_sincronizar_rolModel;
import com.service.monitoreo.models.fn_sincronizar_statusModel;
import com.service.monitoreo.models.fn_sincronizar_tipo_archivoModel;
import com.service.monitoreo.models.fn_sincronizar_usuarioModel;

/**
 *
 * @author Jesús Mendoza
 */
public interface Interface_FunctionsFromDB {
    
    return_messageModel fn_registrar_fondo_revolvente(fn_registrar_fondo_revolventeModel inputParams);
    
    return_messageModel fn_registrar_alerta(fn_registrar_alertaModel inputParams);
    
    return_messageModel fn_registrar_alerta_enviada(fn_registrar_alerta_enviadaModel inputParams);
    
    return_messageModel fn_registrar_corte_caja(fn_registrar_corte_cajaModel inputParams);
    
    return_messageModel fn_registrar_denominacion_transaccion(fn_registrar_denominacion_transaccionModel inputParams);
    
    return_messageModel fn_actualizar_impresora(fn_actualizar_impresoraModel inputParams);
    
    return_messageModel fn_sincronizar_impresora(fn_sincronizar_impresoraModel inputParams);
    
    return_messageModel fn_sincronizar_agencia(fn_sincronizar_agenciaModel inputParams);
    
    return_messageModel fn_sincronizar_archivo(fn_sincronizar_archivoModel inputParams);
    
    return_messageModel fn_sincronizar_configuracion_envio(fn_sincronizar_configuracion_envioModel inputParams);
    
    return_messageModel fn_sincronizar_det_lista_archivo(fn_sincronizar_det_lista_archivoModel inputParams);
    
    return_messageModel fn_sincronizar_dispositivo_vending(fn_sincronizar_dispositivo_vendingModel inputParams);
    
    return_messageModel fn_sincronizar_dispositivo_vending_kiosco(fn_sincronizar_dispositivo_vending_kioscoModel inputParams);
    
    return_messageModel fn_sincronizar_kiosco(fn_sincronizar_kioscoModel inputParams);
    
    return_messageModel fn_sincronizar_lista_programada(fn_sincronizar_lista_programadaModel inputParams);
    
    return_messageModel fn_sincronizar_lista_reproduccion(fn_sincronizar_lista_reproduccionModel inputParams);
    
    return_messageModel fn_sincronizar_permiso_alerta_kiosco(fn_sincronizar_permiso_alerta_kioscoModel inputParams);
    
    return_messageModel fn_sincronizar_rol(fn_sincronizar_rolModel inputParams);
    
    return_messageModel fn_sincronizar_status(fn_sincronizar_statusModel inputParams);
    
    return_messageModel fn_sincronizar_tipo_archivo(fn_sincronizar_tipo_archivoModel inputParams);
    
    return_messageModel fn_sincronizar_usuario(fn_sincronizar_usuarioModel inputParams);
    
}
