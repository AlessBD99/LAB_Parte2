package controller;

import modelo.Deportista;
import modelo.Entrenador;
import modelo.Gimnasio;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.table.DefaultTableModel;
import persistencia.PersonasXml;
import vista.VentanaDeportista;
import vista.VentanaEntrenador;

/**
 *
 * @author Alessandro
 */
public class Controlador {

    JFrame ventana;
    JTextField txtCedula;
    JTextField txtNombre;
    JTextField txtEdad;
    JTextField txtPeso;
    JTextField txtAltura;
    JTextArea txtDireccion;
    JTextField txtFrecuenciaCardiaca;
    JComboBox comboSexo;
    JComboBox comboTipoEjercicio;
    JComboBox comboFrecuenciaEntrenamiento;
    JTextField txtEspecialidad;
    JTextField txtExperiencia;
    PersonasXml depo = new PersonasXml();
   

    public static Gimnasio gym = new Gimnasio();

    public Controlador(JFrame ventana) {
        this.ventana = ventana;
    }

    public Controlador(JTextField txtCedula, JTextField txtNombre, JTextField txtEdad, JTextField txtPeso, JTextField txtAltura, JTextArea txtDireccion, JTextField txtFrecuenciaCardiaca, JComboBox comboSexo, JComboBox comboTipoEjercicio, JComboBox comboFrecuenciaEntrenamiento, JTextField txtEspecialidad, JTextField txtExperiencia) {
        this.txtCedula = txtCedula;
        this.txtNombre = txtNombre;
        this.txtEdad = txtEdad;
        this.txtPeso = txtPeso;
        this.txtAltura = txtAltura;
        this.txtDireccion = txtDireccion;
        this.txtFrecuenciaCardiaca = txtFrecuenciaCardiaca;
        this.comboSexo = comboSexo;
        this.comboTipoEjercicio = comboTipoEjercicio;
        this.comboFrecuenciaEntrenamiento = comboFrecuenciaEntrenamiento;
        this.txtEspecialidad = txtEspecialidad;
        this.txtExperiencia = txtExperiencia;
    }

    public void activaVentana(JFrame ventana, JFrame ventana2) {
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        ventana2.dispose();
        //elimina la ventana de la memoria, incluyendo datos
        //el dispose() garantiza que no dejes ventanas ejecutándose
        //no se almacenan datos en este ejemplo
    }

    public void activaTabla(JFrame ventana) {

        ventana.dispose(); //elimina la ventana de la memoria, incluyendo datos
        //el dispose() garantiza que no dejes ventanas ejecutándose
        //no se almacenan datos en este ejemplo
    }

    public void traerDatosDeportista(Deportista est) {
        VentanaDeportista ventana = new VentanaDeportista();
        ventana.modificacionDepo(est);
    }

    public void traerDatosEntrenador(Entrenador est) {
        VentanaEntrenador ventana = new VentanaEntrenador();
        ventana.modificacionEnte(est);
    }

    //Llena el JTable exclusivo de deportista
    public void llenarTablaDepo(JTable tablaDeportista) {
        String[] columna = {"Nombre", "Cedula", "Edad", "Sexo", "Dirección", "Peso", "Altura", "Frecuencia Cardíaca", "Entrenamiento", "Ejercicio"};
        DefaultTableModel tabla = new DefaultTableModel(null, columna);
        ArrayList<Deportista> Lista = depo.todosLosDeportistas();
        for (Deportista dep : Lista) {
            String[] row = {dep.getNombre(), Integer.toString(dep.getCedula()), Integer.toString(dep.getEdad()), dep.getSexo(), dep.getDireccion(), Double.toString(dep.getPeso()), Double.toString(dep.getAltura()), Integer.toString(dep.getRitmoCardiaco()), dep.getFrecuenciaEntrenamiento(), dep.getTipoEjercicio()};
            tabla.addRow(row);

        }
        tablaDeportista.setModel(tabla);

    }

    //Llena el JTable exclusivo de entrenador
    public void llenarTablaEnt(JTable tablaEntrenador) {
        String[] columna = {"Nombre", "Cedula", "Edad", "Sexo", "Dirección", "Peso", "Altura", "Experiencia laboral", "Especialidad"};
        DefaultTableModel tabla = new DefaultTableModel(null, columna);
        ArrayList<Entrenador> Lista = depo.todosLosEntrenadores();
        for (Entrenador ent : Lista) {
            String[] row = {ent.getNombre(), Integer.toString(ent.getCedula()), Integer.toString(ent.getEdad()), ent.getSexo(), ent.getDireccion(), Double.toString(ent.getPeso()), Double.toString(ent.getAltura()), Integer.toString(ent.getExperienciaLaboral()), ent.getEspecialidad()};
            tabla.addRow(row);

        }
        tablaEntrenador.setModel(tabla);
    }

    public void datosDeportista(JTextField cedulaTxt, JTextField nombreTxt, JTextField edadTxt, JTextField pesoTxt, JTextField alturaTxt, JTextArea direccionTxt, JTextField frecuenciaCardiacaTxt, JComboBox sexoJcombo, JComboBox tipoEjercicioJcombo, JComboBox frecuenciaEntrenamientoJcombo) {
        int numEntero;
        double numDouble;
        Deportista dep = new Deportista();
        dep.setNombre(nombreTxt.getText());
        dep.setCedula(numEntero = Integer.parseInt(cedulaTxt.getText()));;
        dep.setEdad(numEntero = Integer.parseInt(edadTxt.getText()));
        dep.setSexo((String) sexoJcombo.getSelectedItem());
        dep.setPeso(numDouble = Double.parseDouble(pesoTxt.getText()));
        dep.setAltura(numDouble = Double.parseDouble(alturaTxt.getText()));
        dep.setDireccion(direccionTxt.getText());
        dep.setRitmoCardiaco(numEntero = Integer.parseInt(frecuenciaCardiacaTxt.getText()));
        dep.setFrecuenciaEntrenamiento((String) frecuenciaEntrenamientoJcombo.getSelectedItem());
        dep.setTipoEjercicio((String) tipoEjercicioJcombo.getSelectedItem());
        depo.actualizarDeportista(dep);
    }
    public void datosDeportistaMod(Deportista dep,JTextField cedulaTxt, JTextField nombreTxt, JTextField edadTxt, JTextField pesoTxt, JTextField alturaTxt, JTextArea direccionTxt, JTextField frecuenciaCardiacaTxt, JComboBox sexoJcombo, JComboBox tipoEjercicioJcombo, JComboBox frecuenciaEntrenamientoJcombo) {
        int numEntero;
        double numDouble;

        dep.setNombre(nombreTxt.getText());
        dep.setCedula(numEntero = Integer.parseInt(cedulaTxt.getText()));;
        dep.setEdad(numEntero = Integer.parseInt(edadTxt.getText()));
        dep.setSexo((String) sexoJcombo.getSelectedItem());
        dep.setPeso(numDouble = Double.parseDouble(pesoTxt.getText()));
        dep.setAltura(numDouble = Double.parseDouble(alturaTxt.getText()));
        dep.setDireccion(direccionTxt.getText());
        dep.setRitmoCardiaco(numEntero = Integer.parseInt(frecuenciaCardiacaTxt.getText()));
        dep.setFrecuenciaEntrenamiento((String) frecuenciaEntrenamientoJcombo.getSelectedItem());
        dep.setTipoEjercicio((String) tipoEjercicioJcombo.getSelectedItem());
        depo.actualizarDeportista(dep);
    }

    public void datosEntrenador(JTextField cedulaTxt, JTextField nombreTxt, JTextField edadTxt, JTextField pesoTxt, JTextField alturaTxt, JTextArea direccionTxt, JTextField txtEspecialidad, JComboBox sexoJcombo, JTextField txtExperiencia) {
        int numEntero;
        double numDouble;
        Entrenador ent = new Entrenador();
        ent.setNombre(nombreTxt.getText());
        ent.setCedula(numEntero = Integer.parseInt(cedulaTxt.getText()));
        ent.setEdad(numEntero = Integer.parseInt(edadTxt.getText()));
        ent.setSexo((String) sexoJcombo.getSelectedItem());
        ent.setPeso(numDouble = Double.parseDouble(pesoTxt.getText()));
        ent.setAltura(numDouble = Double.parseDouble(alturaTxt.getText()));
        ent.setDireccion(direccionTxt.getText());
        ent.setEspecialidad(txtEspecialidad.getText());
        ent.setExperienciaLaboral(numEntero = Integer.parseInt(txtExperiencia.getText()));
        depo.actualizarEntrenador(ent);
    }
    
        public void datosEntrenadorMod(Entrenador ent,JTextField cedulaTxt, JTextField nombreTxt, JTextField edadTxt, JTextField pesoTxt, JTextField alturaTxt, JTextArea direccionTxt, JTextField txtEspecialidad, JComboBox sexoJcombo, JTextField txtExperiencia) {
        int numEntero;
        double numDouble;
 
        ent.setNombre(nombreTxt.getText());
        ent.setCedula(numEntero = Integer.parseInt(cedulaTxt.getText()));
        ent.setEdad(numEntero = Integer.parseInt(edadTxt.getText()));
        ent.setSexo((String) sexoJcombo.getSelectedItem());
        ent.setPeso(numDouble = Double.parseDouble(pesoTxt.getText()));
        ent.setAltura(numDouble = Double.parseDouble(alturaTxt.getText()));
        ent.setDireccion(direccionTxt.getText());
        ent.setEspecialidad(txtEspecialidad.getText());
        ent.setExperienciaLaboral(numEntero = Integer.parseInt(txtExperiencia.getText()));
        depo.actualizarEntrenador(ent);
    }

}
