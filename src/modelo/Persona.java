package modelo;

import java.util.Scanner;

public abstract class Persona {

    //Atributos
    private int cedula;
    private String nombre;
    private int edad;
    private String sexo;
    private double peso;
    private double altura;
    private String direccion;
    private String numCadena;
    private String patron;
    private boolean comprobar;
    

    //Metodos
    //Metodos constructores
    public Persona(int cedula, String nombre, int edad, String sexo, double peso, double altura, String direccion) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.peso = peso;
        this.altura = altura;
        this.direccion = direccion;
    }

    public Persona() {
        cedula = 0;
        nombre = "";
        edad = 0;
        sexo = " ";
        peso = 0;
        altura = 0;
        direccion = "";
    }

    //Getters y Setters
    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    //Metodos
    //Metodo para calcular IMC de la Persona
    public double calcularIMC() {
        double valorIMC;

        valorIMC = peso / Math.pow(altura, 2);
        return valorIMC;
    }

    //Metodo para devolver el valor de la categoria segun el IMC calculado de la Persona
    public int categoriaIMC(double valorIMC) {
        int valorADevolver = 0;

        if (valorIMC >= 18 || valorIMC < 25) {
            valorADevolver = 0;
        }
        if (valorIMC < 18) {
            valorADevolver = -1;
        }
        if (valorIMC >= 25 || valorIMC < 35) {
            valorADevolver = 1;
        }
        if (valorIMC >= 35) {
            valorADevolver = 2;
        }

        return valorADevolver;
    }

    //Se calcula el IMC del paciente y se le da el diagnostico con respecto a este segun la categoria en que se le asigno previamente
    public void diagnosticoIMC() {
        System.out.println("\n----DIAGNOSTICO IMC----");
        System.out.println("IMC: " + calcularIMC());
        System.out.print("Segun su IMC usted: ");
        if (categoriaIMC(calcularIMC()) == 0) {
            System.out.println("Esta en su peso ideal");
        }
        if (categoriaIMC(calcularIMC()) == -1) {
            System.out.println("Esta por debajo de su peso ideal");
        }
        if (categoriaIMC(calcularIMC()) == 1) {
            System.out.println("Esta por encima de su peso ideal (sobrepeso)");
        }
        if (categoriaIMC(calcularIMC()) == 2) {
            System.out.println("Tiene Obesidad");
        }
    }

    //Metodo para imprimir los datos de la Persona
    public abstract void imprimirDatosPer();

    //Metodo para leer los datos de la Persona
    public void leerDatosPer() {
        Scanner entrada = new Scanner(System.in);
        
        //Verifica el nombre
        do {

            System.out.print("Ingrese su nombre: ");
            String nombreString = entrada.nextLine();
             comprobar = Validación.validarNombre(nombreString); //Verifica si la cedula es positiva
            
            if (comprobar) {
                nombre = nombreString;
            } else {
                System.err.println("ERROR : Ingresar nuevamente su nombre");
            }
        } while (comprobar == false);

        //Verifica la cedula
        do {

            System.out.print("\nIngrese su cedula [min:7 digitos - max:9 digitos]: ");
            numCadena = entrada.nextLine();
            comprobar = Validación.validarEnteroPositivo(numCadena);
            
            if (comprobar == false) {
                System.err.println("ERROR : Ingrese nuevamente la cedula ");
            } else {
                cedula = Integer.parseInt(numCadena);
                if (cedula == 0){
                System.err.println("ERROR : Ingresa nuevamente su cedula de identidad");
                }
            }
        } while (cedula == 0);

        //Valid si la edad no es negativa ni se sobrepase de 100 años
        do {
            System.out.print("\nIngrese su edad: ");
            numCadena = entrada.nextLine();
            comprobar = Validación.validarEntradaEdad(numCadena);
            
            if (comprobar == false) {
                System.err.println("ERROR : Ingrese nuevamente su edad ");
            } else {
                edad = Integer.parseInt(numCadena);
                if (edad < 18 || edad > 100) {
                    System.err.println("ERROR : Debe tener entre 18 y 100 años ");
                }
            }
        } while (edad < 18 || edad > 100);

        //Verificar si ingreso un sexo correcto
        char sex ;
        do {
            System.out.print("\nIngrese su sexo (masculino o femenino): ");
            sexo = entrada.nextLine();
            numCadena = sexo.toLowerCase();
            comprobar = Validación.validarSexo(numCadena);
            
            if (comprobar == false) {
                System.err.println("ERROR: Ha ingresado un sexo erroneo , recuerde masculino,femenino");
            }
        } while (comprobar == false);

        //Validar Peso entre 45kg y 500kg
        do {
            
            System.out.print("\nIngrese su peso [min:45 Kg - max:500 Kg] : ");
            numCadena = entrada.nextLine();
            comprobar = Validación.validarDoublePositivo(numCadena);

            if (comprobar == false) {
                System.err.println("ERROR: Ingrese nuevamente su peso");
            } else {
                peso = Double.parseDouble(numCadena);
                if (peso < 45 || peso > 500) {
                    System.err.println("ERROR : Debe estar entre 45 Kg y 500 Kg ");
                }
            }
        } while (peso < 45 || peso > 500);

        
        //Validar Altura
        do {
            
            System.out.print("\nIngrese su altura [min:1.45 m - max:2.7 m] : ");
            numCadena = entrada.nextLine();
            comprobar = Validación.validarDoublePositivo(numCadena);
            
            if (comprobar == false ) {
                System.err.println("ERROR: Ingrese nuevamente su altura ");
            } else {
                altura = Double.parseDouble(numCadena);
                if (altura < 1.45 || altura > 2.7) {
                    System.err.println("ERROR : Debe estar entre 1.45 m y 2.7 m");
                }
            }
        } while (altura < 1.45 || altura > 2.7);

        

        //Introducir direccion
        
        do {
            System.out.print("\nIngrese su direccion: ");
            String direccionString = entrada.nextLine();
            comprobar= Validación.validarDireccion(direccionString);
            
            if (comprobar) {
                direccion = direccionString;
            } else {
                System.err.println("ERROR: Ingrese nuevamente su direccion");
            }
        } while (comprobar == false);
    }

}
