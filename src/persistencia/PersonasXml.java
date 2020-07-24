/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import modelo.Deportista;
import modelo.Entrenador;
import modelo.Gimnasio;
import static controller.Controlador.gym;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;

/**
 *
 * @author Alessandro
 */
public class PersonasXml {

    Gimnasio gym = new Gimnasio();
    private Element root;/* variable que contiene la raiz del documento Xml*/
    private String fileLocation = "src//archivoXML//personas.xml";

    /* variable que contiene la localizacion del archivo xml*/
    public PersonasXml() {
        /*  constructor por defecto que inicia los valores para trabajar
     *  con el documento xml
         */
        try {
            SAXBuilder builder = new SAXBuilder(false); //parse que maneja el XMl
            Document doc = builder.build(fileLocation);
            root = doc.getRootElement();
        } catch (JDOMException ex) {
            System.out.println("No se pudo iniciar la operacion por: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("No se pudo iniciar la operacion por: " + ex.getMessage());
        }
    }

    private Element DeportistatoXmlElement(Deportista depo) {
        /*Aqui lleno todo el contexto que le voy a insertar al archivo, es decir
    el nodo proncipal que es Estudiante con los atributos que le corresponden,
    los cuales seria cedula,nombre y apellido,etc. Debes ser muuuuy preciso en
    este llenado, es decir, indicar los atributos con pelos y señales exactamente
    como están en la Clase, de lo contrario la tabla XML no se generará y no
    se produzca ningún error que te advierta que falta un acento, un espacio u
   otro símbolo     
         */
        //nombre de la Clase
        Element deportista = new Element("Deportista");

        //se crea cada etiqueta del XML
        Element nombre = new Element("nombreyapellido");
        Element cedula = new Element("cedula");
        Element edad = new Element("edad");
        Element sexo = new Element("sexo");
        Element direccion = new Element("direccion");
        Element peso = new Element("peso");
        Element altura = new Element("altura");
        Element ritmoCardiaco = new Element("frecuenciaCardiaca");
        Element frecuenciaEntrenamiento = new Element("frecuenciaEntrenamiento");
        Element tipoEjercicio = new Element("ejercicio");

        //asocia el valor a la etiqueta 
        nombre.setText(depo.getNombre());
        cedula.setText(Integer.toString(depo.getCedula()));
        edad.setText(Integer.toString(depo.getEdad()));
        sexo.setText(depo.getSexo());
        direccion.setText(depo.getDireccion());
        peso.setText(Double.toString(depo.getPeso()));
        altura.setText(Double.toString(depo.getAltura()));
        ritmoCardiaco.setText(Integer.toString(depo.getRitmoCardiaco()));
        frecuenciaEntrenamiento.setText(depo.getFrecuenciaEntrenamiento());
        tipoEjercicio.setText(depo.getTipoEjercicio());

        //se pasan los valores al documento XML
        deportista.addContent(nombre);
        deportista.addContent(cedula);
        deportista.addContent(edad);
        deportista.addContent(sexo);
        deportista.addContent(direccion);
        deportista.addContent(peso);
        deportista.addContent(altura);
        deportista.addContent(ritmoCardiaco);
        deportista.addContent(frecuenciaEntrenamiento);
        deportista.addContent(tipoEjercicio);

        return deportista;
    }

    private Element EntrenadortoXmlElement(Entrenador ent) {
        Element entrenador = new Element("Entrenador");
        Element nombre = new Element("nombreyapellido");
        Element cedula = new Element("cedula");
        Element edad = new Element("edad");
        Element sexo = new Element("sexo");
        Element direccion = new Element("direccion");
        Element peso = new Element("peso");
        Element altura = new Element("altura");
        Element especialidad = new Element("especialidad");
        Element experiencia = new Element("experienciaLaboral");

        nombre.setText(ent.getNombre());
        cedula.setText(Integer.toString(ent.getCedula()));
        edad.setText(Integer.toString(ent.getEdad()));
        sexo.setText(ent.getSexo());
        direccion.setText(ent.getDireccion());
        peso.setText(Double.toString(ent.getPeso()));
        altura.setText(Double.toString(ent.getAltura()));
        especialidad.setText(ent.getEspecialidad());
        experiencia.setText(Integer.toString(ent.getExperienciaLaboral()));

        entrenador.addContent(nombre);
        entrenador.addContent(cedula);
        entrenador.addContent(edad);
        entrenador.addContent(sexo);
        entrenador.addContent(direccion);
        entrenador.addContent(peso);
        entrenador.addContent(altura);
        entrenador.addContent(especialidad);
        entrenador.addContent(experiencia);

        return entrenador;
    }

    private Deportista DeportistaToObject(Element element) throws ParseException {
        /*Método que retorna un Deportista. A este metodo se le manda un Element y con
    sus datos se hará los pasos requeridos para crear el objeto deportista*/
        Deportista depo = new Deportista(Integer.parseInt(element.getChildText("cedula")), element.getChildText("nombreyapellido"), Integer.parseInt(element.getChildText("edad")), element.getChildText("sexo"), Double.parseDouble(element.getChildText("peso")), Double.parseDouble(element.getChildText("altura")), element.getChildText("direccion"), Integer.parseInt(element.getChildText("frecuenciaCardiaca")), element.getChildText("frecuenciaEntrenamiento"), element.getChildText("ejercicio"));
        return depo;
    }

    private Entrenador EntrenadorToObject(Element element) throws ParseException {
        Entrenador ent = new Entrenador(Integer.parseInt(element.getChildText("cedula")), element.getChildText("nombreyapellido"), Integer.parseInt(element.getChildText("edad")), element.getChildText("sexo"), Double.parseDouble(element.getChildText("peso")), Double.parseDouble(element.getChildText("altura")), element.getChildText("direccion"), Integer.parseInt(element.getChildText("experienciaLaboral")), element.getChildText("especialidad"));

        return ent;
    }

    private boolean updateDocument() {
        /* método para guardar en el documento Xml los cambios efectuados
    * @return true si se cumplió la operacion con éxito, false en caso contrario*/
        try {
            XMLOutputter out = new XMLOutputter(org.jdom.output.Format.getPrettyFormat());
            FileOutputStream file = new FileOutputStream(fileLocation);
            out.output(root, file);
            file.flush();
            file.close();
            return true;
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
            return false;
        }
    }

    public boolean agregarDeportista(Deportista depo) {
        // @return valor boleano con la condición de éxito     
        root.addContent(DeportistatoXmlElement((Deportista) depo));
        boolean resultado = updateDocument();
        return resultado;
    }

    public boolean agregarEntrenador(Entrenador ent) {
        // @return valor boleano con la condición de éxito     
        root.addContent(EntrenadortoXmlElement((Entrenador) ent));
        boolean resultado = updateDocument();
        return resultado;
    }

    public boolean borrarDeportista(Integer cedula) {
        /* @param cedula cédula del Estudiante a borrar
    * @return valor booleano con la condición de éxito */
        boolean resultado = false;
        Element aux = new Element("Deportista");
        List Estudiantes = this.root.getChildren("Deportista");
        while (aux != null) {
            aux = PersonasXml.buscar(Estudiantes, Integer.toString(cedula));
            if (aux != null) {
                Estudiantes.remove(aux);
                resultado = updateDocument();
            }
        }
        return resultado;
    }

    public boolean borrarEntrenador(Integer cedula) {
        /* @param cedula cédula del Estudiante a borrar
         * @return valor booleano con la condición de éxito */
        boolean resultado = false;
        Element aux = new Element("Entrenador");
        List Estudiantes = this.root.getChildren("Entrenador");
        while (aux != null) {
            aux = PersonasXml.buscar(Estudiantes, Integer.toString(cedula));
            if (aux != null) {
                Estudiantes.remove(aux);
                resultado = updateDocument();
            }
        }
        return resultado;
    }

    public static Element buscar(List raiz, String dato) {
        /* Operacion que busca un elemento que cumpla con una condicion en el id del xml
     * @param raiz = raiz del documento xml
     * @param dato = elemento a buscar.
     * @return retorna el elemento si existe con la condicion, en caso contrario retorna null */
        Iterator i = raiz.iterator();
        while (i.hasNext()) {
            Element e = (Element) i.next();
            if (dato.equals(e.getChild("cedula").getText())) {
                return e;
            }
        }
        return null;
    }

    public Deportista buscarDeportista(Integer cedula) {
        /* @param cedula número de cedula del Deportista a buscar
    * @return objeto Deportista con sus datos segun busqueda*/
        Element aux = new Element("Deportista");
        List Deportista = this.root.getChildren("Deportista");
        while (aux != null) {
            aux = PersonasXml.buscar(Deportista, Integer.toString(cedula));
            if (aux != null) {
                try {
                    return DeportistaToObject(aux);
                } catch (ParseException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        return null;
    }

    public Entrenador buscarEntrenador(Integer cedula) {
        /* @param cedula número de cedula del Entrenador a buscar
    * @return objeto Estudiante con sus datos segun busqueda*/
        Element aux = new Element("Entrenador");
        List Deportista = this.root.getChildren("Entrenador");
        while (aux != null) {
            aux = PersonasXml.buscar(Deportista, Integer.toString(cedula));
            if (aux != null) {
                try {
                    return EntrenadorToObject(aux);
                } catch (ParseException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        return null;
    }

    public void actualizarDeportista(Deportista depo) {
        /* @param Deportista objeto Deportista a actualizar
     * @return valor booleano con la condición de éxito */
        boolean resultado = false;
        Element aux = new Element("Deportista");
        List Deportistas = this.root.getChildren("Deportista");
        while (aux != null) {
            aux = PersonasXml.buscar(Deportistas, Integer.toString(depo.getCedula()));
            if (aux != null) {
                Deportistas.remove(aux);
                resultado = updateDocument();
            }
        }
        agregarDeportista(depo);
    }

    public boolean actualizarEntrenador(Entrenador ent) {
        /* @param Entrenador objeto Entrenador a actualizar
     * @return valor booleano con la condición de éxito */
        boolean resultado = false;
        Element aux = new Element("Entrenador");
        List Entrenador = this.root.getChildren("Entrenador");
        while (aux != null) {
            aux = PersonasXml.buscar(Entrenador, Integer.toString(ent.getCedula()));
            if (aux != null) {
                Entrenador.remove(aux);
                resultado = updateDocument();
            }
        }
        agregarEntrenador(ent);
        return resultado;
    }

    public ArrayList<Deportista> todosLosDeportistas() {
        ArrayList<Deportista> resultado = new ArrayList<>();
        for (Object it : root.getChildren("Deportista")) {
            Element xmlElem = (Element) it;
            try {
                resultado.add(DeportistaToObject(xmlElem));
            } catch (ParseException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return resultado;
    }

    public ArrayList<Entrenador> todosLosEntrenadores() {
        ArrayList<Entrenador> resultado = new ArrayList<>();
        for (Object it : root.getChildren("Entrenador")) {
            Element xmlElem = (Element) it;
            try {
                resultado.add(EntrenadorToObject(xmlElem));
            } catch (ParseException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return resultado;
    }
}
