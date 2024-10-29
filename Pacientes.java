/**
 * @author romer
 * @since 2024-10-24
 */

public class Pacientes {

   int id;
   String nombre;
   int[] glucosaMedidas;

   public Pacientes(int id, String nombre, int[] glucosaMedidas) {
      this.id = id;
      this.nombre = nombre;
      this.glucosaMedidas = glucosaMedidas;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getNombre() {
      return nombre;
   }

   public void setNombre(String nombre) {
      this.nombre = nombre;
   }

   public int[] getGlucosaMedidas() {
      return glucosaMedidas;
   }

   public void setGlucosaMedidas(int[] glucosaMedidas) {
      this.glucosaMedidas = glucosaMedidas;
   }
}