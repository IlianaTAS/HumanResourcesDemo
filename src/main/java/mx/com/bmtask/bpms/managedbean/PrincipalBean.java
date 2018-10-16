package mx.com.bmtask.bpms.managedbean;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.imageio.stream.FileImageOutputStream;
import mx.com.mbtask.bpms.to.ProcesosPendientesTO;
import org.primefaces.context.RequestContext;
import org.primefaces.event.CaptureEvent;

/**
 *
 * @author BMTHP02
 */
@ManagedBean(name = "principalBean")
public class PrincipalBean implements Serializable {

    protected List<ProcesosPendientesTO> procesosPendientesAnalistas;

     @PostConstruct
    public void init() {
       
        this.findBandejaEntrada();
       
        if (this.procesosPendientesAnalistas == null) {
            this.procesosPendientesAnalistas = new ArrayList<>();
        }
    }

    public void limpiar() {
       
    }

    public void oncapture(CaptureEvent captureEvent) {
        byte[] dataImagen = captureEvent.getData();
        String fileName = "";
        FileImageOutputStream imageOutput = null;
        try {
            imageOutput = new FileImageOutputStream(new File(fileName));
            imageOutput.write(dataImagen, 0, dataImagen.length);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (imageOutput != null) {
                    imageOutput.flush();
                    imageOutput.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public void generarMsg(FacesMessage msg, boolean isValidate) {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesContext.getCurrentInstance().addMessage(null, msg);
        context.addCallbackParam("isValidate", isValidate);
        if (isValidate) {
            this.limpiar();
        }
    }

    public void findBandejaEntrada() {
       this.procesosPendientesAnalistas = new ArrayList<>();
       ProcesosPendientesTO proceso = new ProcesosPendientesTO();
       proceso.setCliente("IBM");
       proceso.setPosicion("Analista de Sistemas");
       proceso.setCandidato("Raúl García");
       proceso.setProcesoPendiente("Entrevista con el cliente");
       proceso.setFechaUltimoProceso(new Date());
       
       this.procesosPendientesAnalistas.add(proceso);
    }

    public List<ProcesosPendientesTO> getProcesosPendientesAnalistas() {
        return procesosPendientesAnalistas;
    }

  

}
