package gestisimal;
import java.util.Scanner;

/*
 * @author Rafael Alberto Caballero Osuna
 * https://github.com/rafacab1
 */
public class TestAlmacen {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int estado = 0;
    Almacen a1 = new Almacen();
    while (estado != 7) {
      System.out.println("\n\n***GESTISIMAL***");
      System.out.println("________________");
      System.out.println("1. Listado");
      System.out.println("2. Alta");
      System.out.println("3. Baja");
      System.out.println("4. Modificación");
      System.out.println("5. Entrada de mercancía");
      System.out.println("6. Salida de mercancía");
      System.out.println("7. Salir");
      
      System.out.print("Introduce una opción: ");
      estado = s.nextInt();
      
      switch (estado) {
      case 1:
        System.out.println(a1);
        break;
        
      case 2:
        System.out.print("Introduce la descripción del artículo: ");
        String desc = s.next();
        System.out.print("\nIntroduce el precio de compra: ");
        double pCompra = s.nextDouble();
        System.out.print("\nIntroduce el precio de venta: ");
        double pVenta = s.nextDouble();
        System.out.print("\nIntroduce las unidades: ");
        int udes = s.nextInt();
        a1.addArt(desc, pCompra, pVenta, udes);
        break;
        
      case 3:
        System.out.print("\nIntroduce el código el artículo a eliminar: ");
        int code = s.nextInt();
        a1.remArt(code);
        break;
        
      case 4:
        System.out.print("\nIntroduce el código del artículo a modificar: ");
        int code2 = s.nextInt();
        
        System.out.print("Introduce la descripción del artículo: ");
        String desc2 = s.next();
        System.out.print("\nIntroduce el precio de compra: ");
        double pCompra2 = s.nextDouble();
        System.out.print("\nIntroduce el precio de venta: ");
        double pVenta2 = s.nextDouble();
        System.out.print("\nIntroduce las unidades: ");
        int udes2 = s.nextInt();
        a1.modArt(code2, desc2, pCompra2, pVenta2, udes2);
        break;
        
      case 5:
        System.out.print("\n¿De que artículo es la entrada de mercancía?: ");
        int codeam = s.nextInt();
        
        System.out.print("\n¿Cuantos entran?: ");
        int entrada = s.nextInt();
        
        a1.iExistencias(codeam, entrada);
        break;
        
      case 6:
        System.out.print("\n¿De que artículo es la salida de mercancía?: ");
        int codesm = s.nextInt();
        
        System.out.print("\n¿Cuantos salen?: ");
        int salida = s.nextInt();
        
        a1.dExistencias(codesm, salida);
        break;
        
      case 7:
        System.out.print("\nSaliendo...");
        System.exit(0);
      }
    }
    s.close();
  }

}
