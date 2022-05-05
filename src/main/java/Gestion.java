import Vehiculos.Coche;
import Vehiculos.Moto;
import Vehiculos.Vehiculo;

import java.util.ArrayList;
import java.util.Scanner;



public class Gestion {
    private Boolean salir;
    private final Scanner teclado = new Scanner(System.in);
    private final ArrayList<Vehiculo> vehiculos;
    private final Coche coche = new Coche();
    private final Moto moto = new Moto();



    protected Gestion() {
        //Relleno la colección con algunos vehículos, para que podamos tener funcionalidad
        vehiculos = new ArrayList<>();
        Vehiculo nuevoVehiculo = new Coche("Opel", "Corsa", 3489,
                "2021", "OC2021", false, "Gasolina",
                5, "0344JFW", 85.4F, false);

        vehiculos.add(nuevoVehiculo);
        nuevoVehiculo = new Moto("Honda", "SH350i", 2500,
                "2021", "SH350i", true,
                "Gasolina", true, "7894AAA", 71.6F,false);

        vehiculos.add(nuevoVehiculo);
        salir = false;
    }

    public void ejecutar () {
        do {
            System.out.println("========================================================");
            System.out.println("==============Aplicación GesFlota v0.1==================");
            System.out.println("========================================================");
            System.out.println("                1. Ver Vehículos                        ");
            System.out.println("                2. Crear Vehículos                      ");
            System.out.println("                x. Salir                                ");
            System.out.print("Selecciona: ");
            String opcion = teclado.nextLine();

            switch (opcion) {
                case "1":
                    verVehiculos();
                    break;
                case "2":
                    crearVehiculos();
                    break;
                case "x":
                case "X":
                    salir();
                    break;
                default:
                    System.out.println("========================================================");
                    System.out.println("=========Opción incorrecta, selecciona de nuevo=========");
                    System.out.println("========================================================");
            }
        } while(!salir);
    }
    private void verVehiculos() {
        do {
            System.out.println("========================================================");
            System.out.println("==Quieres consultar todos los vehículos o uno concreto==");
            System.out.println("========================================================");
            System.out.println("        1. Ver Todos los Vehículos registrados          ");
            System.out.println("        2. Escoger un Vehículo por el número de bastidor");
            System.out.println("        3. Escoger Vehículos por marca                  ");
            System.out.println("        x. Volver al menú principal                     ");
            System.out.print("Selecciona: ");
            String opcion = teclado.nextLine();

            switch (opcion) {
                case "1":
                    System.out.println("Estos son todos los vehículos registrados:");
                    for (Vehiculo vehiculo : vehiculos){
                        System.out.println(vehiculo);
                    }
                    break;
                case "2":
                    ArrayList<Vehiculo> vehBuscado = new ArrayList<>();
                    System.out.println("Escribe el numero de bastidor: ");
                    String busqueda = teclado.nextLine();
                    for (Vehiculo object  : vehiculos) {
                        if (object.getNumBastidor().equals(busqueda)) {
                            vehBuscado.add(object);
                        }
                    }
                    if (vehBuscado.isEmpty()){
                        System.out.println("La búsqueda no devuelve resultados.");
                        System.out.println("Realiza una nueva búsqueda.");

                    }else {
                        System.out.println("El vehículo buscado es: ");
                        for (Vehiculo vehiculo : vehBuscado){
                            System.out.println(vehiculo);
                        }
                    }
                    break;
                case "3":
                    vehBuscado = new ArrayList<>();
                    System.out.println("Escribe la marca por la que buscar: ");
                    busqueda = teclado.nextLine();
                    for (Vehiculo object  : vehiculos) {
                        if (object.getMarca().equalsIgnoreCase(busqueda)) {
                            vehBuscado.add(object);
                        }
                    }
                    if (vehBuscado.isEmpty()){
                        System.out.println("La búsqueda no devuelve resultados.");
                        System.out.println("Realiza una nueva búsqueda.");
                    }else {
                        System.out.println("Estos son los vehículos encontrados de esa marca: ");
                        for (Vehiculo vehiculo : vehBuscado){
                            System.out.println(vehiculo);
                        }
                    }
                    break;
                case "x":
                case "X":
                    ejecutar();
                    break;
                default:
                    System.out.println("========================================================");
                    System.out.println("=========Opción incorrecta, selecciona de nuevo=========");
                    System.out.println("========================================================");
            }
        } while (!salir);
    }

    private void crearVehiculos() {
        do {
            System.out.println("========================================================");
            System.out.println("=========¿Que tipo de vehículo quieres crear?===========");
            System.out.println("========================================================");
            System.out.println("                1. Crear un nuevo coche                 ");
            System.out.println("                2. Crear una nueva moto                 ");
            System.out.println("                x. Volver al menu principal             ");
            System.out.print("Selecciona: ");
            String opcion = teclado.nextLine();

            switch (opcion) {
                case "1":
                    System.out.println("Vas a crear un nuevo Coche");
                    System.out.println("Introduce la marca: ");
                    coche.setMarca(teclado.nextLine());
                    System.out.println("Introduce el modelo: ");
                    coche.setModelo(teclado.nextLine());
                    System.out.println("Introduce los kms: ");
                    String ckms = teclado.nextLine();
                    int kms = Integer.parseInt(ckms);
                    coche.setKms(kms);
                    System.out.println("Introduce el año de fabricación: ");
                    coche.setAnoFabricacion(teclado.nextLine());
                    System.out.println("Introduce el número de bastidor: ");
                    coche.setNumBastidor(teclado.nextLine());
                    System.out.println("Esta alquilado (Indica true o false): ");
                    String alquilado = teclado.nextLine();
                    boolean alq = Boolean.parseBoolean(alquilado);
                    coche.setAlquilado(alq);
                    System.out.println("Introduce el tipo de combustible: ");
                    coche.setCombustible(teclado.nextLine());
                    System.out.println("Introduce el número de puertas: ");
                    String puertas = teclado.nextLine();
                    int nPuertas = Integer.parseInt(puertas);
                    coche.setNumPuertas(nPuertas);
                    System.out.println("Introduce la matrícula: ");
                    coche.setMatricula(teclado.nextLine());
                    System.out.println("Introduce la potencia en KV (utiliza el . para los decimales): ");
                    String potencia = teclado.nextLine();
                    float pot = Float.parseFloat(potencia);
                    coche.setPotencia(pot);
                    System.out.println("Introduce si es eléctrico (Indica true o false): ");
                    String electrico = teclado.nextLine();
                    boolean elec = Boolean.parseBoolean(electrico);
                    coche.setElectrico(elec);
                    for (Vehiculo vehiculo : vehiculos){
                        if (coche.equals(vehiculo)){
                            System.out.println("El vehiculo ya existe");
                        }else {
                            vehiculos.add(coche);
                            System.out.println("El vehículo ha sido añadido.");
                        }break;
                    }
                    break;
                case "2":
                    System.out.println("Vas a crear una nueva moto");
                    System.out.println("Introduce la marca: ");
                    moto.setMarca(teclado.nextLine());
                    System.out.println("Introduce el modelo: ");
                    moto.setModelo(teclado.nextLine());
                    System.out.println("Introduce los kms: ");
                    ckms = teclado.nextLine();
                    kms = Integer.parseInt(ckms);
                    moto.setKms(kms);
                    System.out.println("Introduce el año de fabricación: ");
                    moto.setAnoFabricacion(teclado.nextLine());
                    System.out.println("Introduce el número de bastidor: ");
                    moto.setNumBastidor(teclado.nextLine());
                    System.out.println("Esta alquilada (Indica true o false): ");
                    alquilado = teclado.nextLine();
                    alq = Boolean.parseBoolean(alquilado);
                    moto.setAlquilado(alq);
                    System.out.println("Introduce el tipo de combustible: ");
                    moto.setCombustible(teclado.nextLine());
                    System.out.println("Introduce si incluye casco (Indica true o false): ");
                    String casco = teclado.nextLine();
                    boolean cas = Boolean.parseBoolean(casco);
                    moto.setIncluyeCasco(cas);
                    System.out.println("Introduce la matrícula: ");
                    moto.setMatricula(teclado.nextLine());
                    System.out.println("Introduce la potencia en KV (utiliza el . para los decimales): ");
                    potencia = teclado.nextLine();
                    pot = Float.parseFloat(potencia);
                    moto.setPotencia(pot);
                    System.out.println("Introduce si es eléctrico (Indica true o false): ");
                    electrico = teclado.nextLine();
                    elec = Boolean.parseBoolean(electrico);
                    moto.setElectrico(elec);
                    for (Vehiculo vehiculo : vehiculos){
                        if (moto.equals(vehiculo)){
                            System.out.println("El vehiculo ya existe");
                        }else {
                            vehiculos.add(moto);
                            System.out.println("El vehículo ha sido añadido.");
                        }break;
                    }
                    break;


                case "X":
                    ejecutar();
                    break;
                default:
                    System.out.println("========================================================");
                    System.out.println("=========Opción incorrecta, selecciona de nuevo=========");
                    System.out.println("========================================================");
            }
        } while (!salir);
    }

    private void salir() {
        System.out.println("========================================================");
        System.out.println("========SE HA CERRADO EL PROGRAMA CORRECTAMENTE=========");
        System.out.println("========================================================");
        salir = true;
    }

}
