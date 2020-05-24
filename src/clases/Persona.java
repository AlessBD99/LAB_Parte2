package clases;

import java.util.Scanner;

public class Persona {

    //Atributos
    protected int cedula;
    protected String nombre;
    protected int edad;
    protected char sexo;
    protected double peso;
    protected double altura;
    protected String direccion;

    //Metodos
    //Metodos constructores
    public Persona(int cedula, String nombre, int edad, char sexo, double peso, double altura, String direccion) {
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
        sexo = ' ';
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

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
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

    //Metodo para mostrar si es mayor o menor de edad
    public boolean esMayorDeEdad() {
        boolean mayorEdad;

        if (edad < 18) {
            mayorEdad = false;
        } else {
            mayorEdad = true;
        }
        return mayorEdad;
    }

    //Metodo para validar el Sexo ingresado
    public boolean comprobarSexo(char sexo) {
        if (sexo == 'F' || sexo == 'f' || sexo == 'M' || sexo == 'm') {
            return true;
        } else {
            return false;
        }
    }

    //Metodo para validar la Dirrecion ingresada
    public void validarDireccion(String direccion) {

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
    public void imprimirDatosPer() {
        System.out.println("\n----DATOS----");
        System.out.println("Nombre: " + nombre + " \nCedula: " + cedula + " \nEdad: " + edad + " años \nSexo: " + sexo + " \nPeso: " + peso + "kg \nAltura: " + altura + "m \nDirecion: " + direccion);
        //diagnosticoIMC();
    }

    //Metodo para leer los datos de la Persona
    public void leerDatosPer() {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Ingrese su nombre: ");
        nombre = entrada.nextLine();
        
        //Verifica si la cedula es positiva
        do {
            System.out.print("\nIngrese su cedula: ");
            cedula = entrada.nextInt();  
            if (cedula < 0){
                System.out.println("ERROR : Solo se aceptan numeros positivos");
            }
        } while (cedula < 0);

        //Valido si la edad no es negativa ni se sobrepase de 200 años
        do {
            System.out.print("\nIngrese su edad: ");
            edad = entrada.nextInt();
            if (edad < 1 || edad > 200) {
                System.out.println("\nHa ingresado una edad fuera de rango, ingrese solo un edad mayor o igual a 1 año y menor de 200 años");
            }
        } while (edad < 1 || edad > 200);

        //Imprime si es mayor o menor de edad
        if (esMayorDeEdad() == true) {
            System.out.println("\nEs mayor de edad");
        } else {
            System.out.println("\nEs menor de edad");
        }

        //Verificar si ingreso un sexo correcto
        do {
            System.out.print("\nIngrese su sexo: ");
            sexo = entrada.next().charAt(0);
            if (comprobarSexo(sexo) == false) {
                System.out.println("\n Ha ingresado un sexo erroneamente, recuerde solo M = masculino, F = femenino");
            }
        } while (comprobarSexo(sexo) == false);

        //Validar Peso entre 0kg y 500kg
        do {
            System.out.print("\nIngrese su peso: ");
            peso = entrada.nextDouble();
            if (peso < 0 || peso > 500) {
                System.out.println("\n Ha ingresado un peso fuera de rango, ingrese solo un peso mayor a 0,0kg y menor de 500,0kg");
            }
        } while (peso < 0 || peso > 500);

        //Validar Altura
        do {
            System.out.print("\nIngrese su altura: ");
            altura = entrada.nextDouble();
            if (altura < 0.0 || altura > 5.0) {
                System.out.println("\n Ha ingresado una altura fuera de rango, ingrese solo una altura mayor a 0,0m y menor de 5,0m");
            }
        } while (altura < 0.0 || altura > 5.0);

        entrada.nextLine();

        //Introducir direccion
        System.out.print("\nIngrese su direccion: ");
        direccion = entrada.nextLine();
    }
}
