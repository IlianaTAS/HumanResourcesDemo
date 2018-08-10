package mx.com.bmtask.bpms.managedbean;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import mx.com.mbtask.bpms.to.CandidatoTO;
import mx.com.mbtask.bpms.to.VacanteTO;

/**
 *
 * @author BMT
 */
@ManagedBean(name = "procesoRegistradoBean")
public class ProcesoRegistradoBean {

    private List<String> clientesVacante;
    private List<String> puestosVacante;
    private List<VacanteTO> list;
    protected Integer clienteVacante;

    protected Integer puestoVacante;
    protected Integer divisionVacante;
    protected int nombreSeleccionado;
    protected int estatusSeleccionado;
    protected int motivoSeleccionado;
    protected int analistaSeleccionado;

    @PostConstruct
    public void init() {

        this.clientesVacante = new ArrayList<>();
        this.puestosVacante = new ArrayList<>();

        this.clienteVacante = null;
        this.puestoVacante = null;
        this.divisionVacante = null;
        nombreSeleccionado = 0;
        estatusSeleccionado = 0;
        motivoSeleccionado = 0;
        this.analistaSeleccionado = 0;
        consultar();
    }

    public void consultar() {
        this.clientesVacante.add("IBM");
        this.clientesVacante.add("Neoris");
        this.clientesVacante.add("TATA");
        //
        this.puestosVacante.add("Analista de sistemas");
        this.puestosVacante.add("Desarrollador Java SR.");
        this.puestosVacante.add("Desarrollador .NET");
        this.puestosVacante.add("Cobol");
        //
        this.list = this.llenarVacantes();

    }

    public boolean validarNombreSeleccionado(int id) {
        if (nombreSeleccionado == id) {
            return false;
        } else {
            nombreSeleccionado = id;
            return true;
        }
    }

    public boolean validarEstatusSeleccionado(int id) {
        if (estatusSeleccionado == id) {
            return false;
        } else {
            estatusSeleccionado = id;
            return true;
        }
    }

    public boolean validarMotivoSeleccionado(int id) {
        if (motivoSeleccionado == id) {
            return false;
        } else {
            motivoSeleccionado = id;
            return true;
        }
    }

    public boolean validarAnalistaSeleccionado(int id) {
        if (this.analistaSeleccionado == id) {
            return false;
        } else {
            this.analistaSeleccionado = id;
            return true;
        }
    }

    public String getEstatus(Integer estatus) {
        switch (estatus) {
            case 1:
                return "En proceso";
            case 2:
                return "Por ofertar";
            case 3:
                return "Oferta aceptada";
            case 4:
                return "Enviado a cliente";
            case 5:
                return "Ingreso";
            case 6:
                return "On hold";
            case 7:
                return "Oferta declinada";
            case 8:
                return "Rechazado";
            case 9:
                return "Proceso declinado";
            default:
                return "Posición cancelada";
        }
    }

    private List<VacanteTO> llenarVacantes() {
        List<VacanteTO> vacantes = new ArrayList<>();
        VacanteTO vacanteUno = new VacanteTO();
        VacanteTO vacanteDos = new VacanteTO();
        VacanteTO vacanteTres = new VacanteTO();

        vacanteUno.setNumeroVacante("1");
        vacanteUno.setEstatus("1");
        vacanteUno.setNombreComercial("IBM");
        vacanteUno.setPuestoNivel("Tester Selenium");
        vacanteUno.setCiudad("Guadalajara");
        vacanteUno.setCantidadProcesados("3");
        vacanteUno.setCantidadRechazados("1");
        vacanteUno.setCandidatos(this.llenarCandidatosUno());

        vacanteDos.setNumeroVacante("2");
        vacanteDos.setEstatus("2");
        vacanteDos.setNombreComercial("IBM");
        vacanteDos.setPuestoNivel("Project Manager");
        vacanteDos.setCiudad("Queretaro");
        vacanteDos.setCantidadProcesados("2");
        vacanteDos.setCantidadRechazados("2");
        vacanteDos.setCandidatos(this.llenarCandidatosDos());

        vacanteTres.setNumeroVacante("3");
        vacanteTres.setEstatus("1");
        vacanteTres.setNombreComercial("TATA");
        vacanteTres.setPuestoNivel("Agile Lead");
        vacanteTres.setCiudad("Ciudad de México");
        vacanteTres.setCantidadProcesados("1");
        vacanteTres.setCantidadRechazados("0");
        vacanteTres.setCandidatos(this.llenarCandidatosTres());

        vacantes.add(vacanteUno);
        vacantes.add(vacanteDos);
        vacantes.add(vacanteTres);

        return vacantes;
    }

    private List<CandidatoTO> llenarCandidatosUno() {
        List<CandidatoTO> candidatos = new ArrayList<>();
        CandidatoTO candidatoUno = new CandidatoTO();
        CandidatoTO candidatoDos = new CandidatoTO();
        CandidatoTO candidatoTres = new CandidatoTO();
        CandidatoTO candidatoCuatro = new CandidatoTO();

        candidatoUno.setNombre("Karla");
        candidatoUno.setApellidoPaterno("Pérez");
        candidatoUno.setApellidoMaterno("García");
        candidatoUno.setEstatus("En proceso");
        candidatoUno.setAnalista("Marysol Jiménez");

        candidatoDos.setNombre("Luis");
        candidatoDos.setApellidoPaterno("Pérez");
        candidatoDos.setApellidoMaterno("García");
        candidatoDos.setEstatus("En proceso");
        candidatoDos.setAnalista("Gerardo Ortiz");

        candidatoTres.setNombre("Mario");
        candidatoTres.setApellidoPaterno("Pérez");
        candidatoTres.setApellidoMaterno("Gómez");
        candidatoTres.setEstatus("En proceso");
        candidatoTres.setAnalista("Gerardo Ortiz");

        candidatoCuatro.setNombre("Margarita");
        candidatoCuatro.setApellidoPaterno("García");
        candidatoCuatro.setApellidoMaterno("Alonso");
        candidatoCuatro.setCriterioRechazo("Declino la oferta");
        candidatoCuatro.setEstatus("Rechazado");
        candidatoCuatro.setAnalista("Rafael Marquez");

        candidatos.add(candidatoUno);
        candidatos.add(candidatoDos);
        candidatos.add(candidatoTres);
        candidatos.add(candidatoCuatro);

        return candidatos;
    }

    private List<CandidatoTO> llenarCandidatosDos() {
        List<CandidatoTO> candidatos = new ArrayList<>();

        CandidatoTO candidatoUno = new CandidatoTO();
        CandidatoTO candidatoDos = new CandidatoTO();
        CandidatoTO candidatoTres = new CandidatoTO();
        CandidatoTO candidatoCuatro = new CandidatoTO();

        candidatoUno.setNombre("Sergio");
        candidatoUno.setApellidoPaterno("Morales");
        candidatoUno.setApellidoMaterno("Valencia");
        candidatoUno.setEstatus("En proceso");
        candidatoUno.setAnalista("Marysol Jiménez");

        candidatoDos.setNombre("Liliana");
        candidatoDos.setApellidoPaterno("Orozco");
        candidatoDos.setApellidoMaterno("Fávila");
        candidatoDos.setEstatus("En proceso");
        candidatoDos.setAnalista("Marysol Jiménez");

        candidatoTres.setNombre("Raúl");
        candidatoTres.setApellidoPaterno("García");
        candidatoTres.setApellidoMaterno("Saldivar");
        candidatoTres.setCriterioRechazo("No asistió a entrevista con el cliente");
        candidatoTres.setEstatus("Rechazado");
        candidatoTres.setAnalista("Gerardo Ortíz");

        candidatoCuatro.setNombre("Juan");
        candidatoCuatro.setApellidoPaterno("Pérez");
        candidatoCuatro.setApellidoMaterno("Alonso");
        candidatoCuatro.setCriterioRechazo("No cumple con los skills");
        candidatoCuatro.setEstatus("Rechazado");
        candidatoCuatro.setAnalista("Romel Pacheco");

        candidatos.add(candidatoUno);
        candidatos.add(candidatoDos);
        candidatos.add(candidatoTres);
        candidatos.add(candidatoCuatro);

        return candidatos;
    }

    private List<CandidatoTO> llenarCandidatosTres() {
        List<CandidatoTO> candidatos = new ArrayList<>();

        CandidatoTO candidatoUno = new CandidatoTO();

        candidatoUno.setNombre("David");
        candidatoUno.setApellidoPaterno("Moreno");
        candidatoUno.setApellidoMaterno("Valencia");
        candidatoUno.setEstatus("En proceso");
        candidatoUno.setAnalista("Romel Pacheco");

        candidatos.add(candidatoUno);

        return candidatos;
    }

    public Integer getClienteVacante() {
        return clienteVacante;
    }

    public void setClienteVacante(Integer clienteVacante) {
        this.clienteVacante = clienteVacante;
    }

    public Integer getPuestoVacante() {
        return puestoVacante;
    }

    public void setPuestoVacante(Integer puestoVacante) {
        this.puestoVacante = puestoVacante;
    }

    public Integer getDivisionVacante() {
        return divisionVacante;
    }

    public void setDivisionVacante(Integer divisionVacante) {
        this.divisionVacante = divisionVacante;
    }

    public List<String> getClientesVacante() {
        return clientesVacante;
    }

    public void setClientesVacante(List<String> clientesVacante) {
        this.clientesVacante = clientesVacante;
    }

    public List<VacanteTO> getList() {
        return list;
    }

    public void setList(List<VacanteTO> list) {
        this.list = list;
    }

}
