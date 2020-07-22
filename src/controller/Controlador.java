package controller;

import clases.Deportista;
import clases.Entrenador;
import clases.Gimnasio;
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
    PersonasXml deportista = new PersonasXml();
    JTable tablaDeportista;

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
        ventana2.dispose(); //elimina la ventana de la memoria, incluyendo datos
        //el dispose() garantiza que no dejes ventanas ejecutándose
        //no se almacenan datos en este ejemplo
    }

    public void activaTabla(JFrame ventana) {

        ventana.dispose(); //elimina la ventana de la memoria, incluyendo datos
        //el dispose() garantiza que no dejes ventanas ejecutándose
        //no se almacenan datos en este ejemplo
    }

    //Llena el JTable exclusivo de deportista
    public void llenarTablaDepo(JTable tablaDeportista) {
        int i = 0;
        String[] columna = {"Nombre", "Cedula", "Edad", "Sexo", "Dirección", "Peso", "Altura", "Frecuencia Cardíaca", "Entrenamiento", "Ejercicio"};
        DefaultTableModel dtm = new DefaultTableModel(null, columna);

        while (gym.verTamaño() > i) {
            if (gym.getListaPersonas().get(i).getClass().getSimpleName().equals("Deportista")) {
                Deportista dep = (Deportista) gym.getListaPersonas().get(i);
                String[] row = {dep.getNombre(), Integer.toString(dep.getCedula()), Integer.toString(dep.getEdad()), dep.getSexo(), dep.getDireccion(), Double.toString(dep.getPeso()), Double.toString(dep.getAltura()), Integer.toString(dep.getRitmoCardiaco()), dep.getFrecuenciaEntrenamiento(), dep.getTipoEjercicio()};
                dtm.addRow(row);
            }
            i++;
        }
        tablaDeportista.setModel(dtm);

    }

    //Llena el JTable exclusivo de entrenador
    public void llenarTablaEnt(JTable tablaEntrenador) {
        int i = 0;
        String[] columna = {"Nombre", "Cedula", "Edad", "Sexo", "Dirección", "Peso", "Altura", "Experiencia laboral", "Especialidad"};
        DefaultTableModel dtm = new DefaultTableModel(null, columna);

        while (gym.verTamaño() > i) {
            if (gym.getListaPersonas().get(i).getClass().getSimpleName().equals("Entrenador")) {
                Entrenador ent = (Entrenador) gym.getListaPersonas().get(i);
                String[] row = {ent.getNombre(), Integer.toString(ent.getCedula()), Integer.toString(ent.getEdad()), ent.getSexo(), ent.getDireccion(), Double.toString(ent.getPeso()), Double.toString(ent.getAltura()), Integer.toString(ent.getExperienciaLaboral()), ent.getEspecialidad()};
                dtm.addRow(row);
            }
            i++;
        }
        tablaEntrenador.setModel(dtm);

    }
    
        public void llenarTablaDepo(PersonasXml depo) {
        int i = 0;
        String[] columna = {"Nombre", "Cedula", "Edad", "Sexo", "Dirección", "Peso", "Altura", "Frecuencia Cardíaca", "Entrenamiento", "Ejercicio"};
        DefaultTableModel dtm = new DefaultTableModel(null, columna);

        while (gym.verTamaño() > i) {
            if (gym.getListaPersonas().get(i).getClass().getSimpleName().equals("Deportista")) {
                Deportista dep = (Deportista) gym.getListaPersonas().get(i);
                String[] row = {dep.getNombre(), Integer.toString(dep.getCedula()), Integer.toString(dep.getEdad()), dep.getSexo(), dep.getDireccion(), Double.toString(dep.getPeso()), Double.toString(dep.getAltura()), Integer.toString(dep.getRitmoCardiaco()), dep.getFrecuenciaEntrenamiento(), dep.getTipoEjercicio()};
                dtm.addRow(row);
            }
            i++;
        }
        tablaDeportista.setModel(dtm);

    }
    public void eliminarElemento(String nombreDepo) {
        int i = 0;
        while (gym.verTamaño() > i) {
            Deportista dep = (Deportista) gym.getListaPersonas().get(i);
            if (gym.getListaPersonas().get(i).getClass().getSimpleName().equals("Deportista") && nombreDepo == dep.getNombre()) {
                gym.getListaPersonas().remove(i);
            }
            i++;
        }
    }

    public void modificarElemento(String nombreDepo) {
        int i = 0;

        while (gym.verTamaño() > i) {
            Deportista dep = (Deportista) gym.getListaPersonas().get(i);
            if (gym.getListaPersonas().get(i).getClass().getSimpleName().equals("Deportista") && nombreDepo == dep.getNombre()) {
                VentanaDeportista depo = new VentanaDeportista();
                depo.modificacionDepo(dep);
                gym.getListaPersonas().remove(i);
                

            }
            i++;
        }
    }

    public void eliminarElementoEntrenador(String nombreDepo) {
        int i = 0;
        while (gym.verTamaño() > i) {
            Entrenador dep = (Entrenador) gym.getListaPersonas().get(i);
            if (gym.getListaPersonas().get(i).getClass().getSimpleName().equals("Entrenador") && nombreDepo == dep.getNombre()) {
                gym.getListaPersonas().remove(i);
            }
            i++;
        }
    }

    public void modificarElementoEntrenador(String nombreDepo) {
        int i = 0;

        while (gym.verTamaño() > i) {
            Entrenador dep = (Entrenador) gym.getListaPersonas().get(i);
            if (gym.getListaPersonas().get(i).getClass().getSimpleName().equals("Entrenador") && nombreDepo == dep.getNombre()) {
                VentanaEntrenador depo = new VentanaEntrenador();
                depo.modificacionEnte(dep);
                gym.getListaPersonas().remove(i);

            }
            i++;
        }
    }

    public void datosDeportista( JTextField cedulaTxt, JTextField nombreTxt, JTextField edadTxt, JTextField pesoTxt, JTextField alturaTxt, JTextArea direccionTxt, JTextField frecuenciaCardiacaTxt, JComboBox sexoJcombo, JComboBox tipoEjercicioJcombo, JComboBox frecuenciaEntrenamientoJcombo) {
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
        deportista.actualizarDeportista(dep);
        gym.registrarDeportista(dep);
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
        gym.registrarEntrenador(ent);
    }

}
