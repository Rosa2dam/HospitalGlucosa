/**
 * @author romer
 * @fecha 2024-10-24
 */

import java.util.Scanner;

/**
 * Tenemos  pacientes con los datos : id, nombre y unos datos de con los ultimos 10 valores del análisis de glucosa, (5 pacientes)
 * tenemos medicos con los datos: id, nombre,especialidad , tanto para  pacientes como medicos , (3 medicos)
 * los datos estan inicializados en el programa,
 * No todos los medicos trata a todos los pacientes,tenemos tambien en el programa estos valores que
 * indica cuando la glucosa es baja,normal o alta: 70,90,120;  queremos un programa en JAVA,
 * que con id del medico por teclado me diga el valor de glucosa es mas bajo,normal o mas alto de sus analisis ,
 * de todos los paciente que trate.
 */
public class Main {
    // Definimos 3 constantes con los valores de referencia para glucosa baja, normal y alta
    static final int GLUCOSA_BAJA = 70;
    static final int GLUCOSA_NORMAL = 90;
    static final int GLUCOSA_ALTA = 120;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //creamos e inicializamos las instacias para medicos y pacientes
        Pacientes[] pacientes = {
                new Pacientes(1, "Pedro Ruiz", new int[]{80, 65, 110, 120, 95, 75, 140, 110, 120, 95}),
                new Pacientes(2, "Antonio Lopez", new int[]{65, 72, 75, 90, 95, 90, 85, 80, 115, 110}),
                new Pacientes(3, "María Romero", new int[]{95, 100, 110, 80, 85, 90, 70, 75, 85, 120}),
                new Pacientes(4, "Alberto Entrena", new int[]{60, 68, 85, 80, 95, 100, 110, 115, 90, 85}),
                new Pacientes(5, "Jimena Ruiz", new int[]{75, 80, 70, 68, 65, 100, 180, 120, 125, 110}),
        };
        Medicos[] medicos = {
                new Medicos(1, "Dra.Ventura", "Nutrición"),
                new Medicos(2, "Dr.Carranza", "Endocrinología"),
                new Medicos(3, "Dra.Manzanares ", "Medicina de Familia"),

        };
        //tenemos que relacionar los medicos con los pacientes de cada uno. Para ello usaremos una matriz de adyacencia
        //Fila: son los medicos, Columnas: son los pacientes. Se usa un boolean para marcar true si lo trata, o false si no lo trata.

        boolean[][] matrizAdyacencia = {
                {true, false, true, false, true}, //pacientes de la doctora ventura
                {false, true, false, true, false},//pacientes del doctor carranza
                {true, true, false, true, true}, //pacientes de la doctora manzanares
        };

        //se solicita por pantalla el id del médico
        System.out.println("Ingrese el Id del médico: ");
        int idMedicos = sc.nextInt();//lectura del id ingresado
        sc.close();//cerramos escaner para que no de error.


        //se llama al método resultadosgulocosa, para mostar los datos de glucosa de los pacientes que trata el médico
        resultadosGlucosa(idMedicos,medicos,pacientes,matrizAdyacencia);
    }
 //metodo para mostrar los resultados de glucosa de los pacientes de un médico
    public static void resultadosGlucosa(int idMedicos,Medicos[] medicos, Pacientes[] pacientes, boolean[][] matrizAdyacencia) {
        //verificamos si el ID del médico es válido
        if (idMedicos < 1 || idMedicos > medicos.length) {
            System.out.println("El ID introducido no es válido");
            return;
        }

        //obtener el índice del médico de la matriz
        int indiceMedico = idMedicos - 1;
        System.out.println("Resultados de glucosa para " + medicos[indiceMedico].getNombre() + ":");

    //recorremos la lista de pacientes
        for (int j = 0; j < pacientes.length; j++) {
             //si el medico trata al paciente
              if (matrizAdyacencia[indiceMedico][j]) {
                  Pacientes paciente = pacientes[j];//se obtiene el paciente
                  System.out.println("Paciente: " + paciente.getNombre());// se muestra el nombre del paciente

                  // recorremos los valores de glucosa del paciente

                  for (int valor : paciente.getGlucosaMedidas()) {
                      String categoria = "";//variable para almacenar la categoria de glucosa

                      // se define la categoría según valor de glucosa
                      if(valor < GLUCOSA_BAJA){
                         categoria= "Fuera de rango";//menor a 70
                      } else if (valor >=GLUCOSA_BAJA && valor <= GLUCOSA_NORMAL) {
                          categoria="Baja";//entre 70 y 90
                     } else if (valor >= GLUCOSA_NORMAL && valor < GLUCOSA_ALTA) {
                          categoria="Normal";// entre 90 y 120
                     } else if (valor >=GLUCOSA_ALTA) {
                          categoria="Alto";// superior a 120
                      }
                        //se muestra por pantalla el valor de glucosa y su categoría
                      System.out.println("Valor de glucosa: "+valor+" Categoria: "+categoria);
                  }
             }
         }
      }
  }
