import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AlquilerPelis {
    public static void main(String[] args) {
        List<Peliculas> catalogo = new ArrayList<>();
        List<Cliente> clientes = new ArrayList<>();
        List<Alquiler> alquileres = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            mostrarMenu();
            System.out.print("Ingrese su opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    registrarPelicula(catalogo, scanner);
                    break;
                case 2:
                    realizarAlquiler(catalogo, alquileres, clientes, scanner);
                    break;
                case 3:
                    registrarCliente(clientes, scanner);
                    break;
                case 4:
                    mostrarPeliculas(catalogo);
                    break;
                case 5:
                    mostrarClientes(clientes);
                    break;
                case 6:
                    System.out.println("Cerrando el programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, ingrese una opción válida.");
            }
        } while (opcion != 6);

        // Close the scanner to prevent resource leaks
        scanner.close();
    }

    public static void mostrarMenu() {
        System.out.println("----MENU----");
        System.out.println("1: Registrar Película");
        System.out.println("2: Realizar Alquiler");
        System.out.println("3: Registrar Cliente");
        System.out.println("4: Mostrar Películas");
        System.out.println("5: Mostrar Clientes");
        System.out.println("6: Cerrar");
    }

    public static void registrarPelicula(List<Peliculas> catalogo, Scanner scanner) {
        System.out.println("Ingrese el ID de la película:");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese el título de la película:");
        String titulo = scanner.nextLine();

        System.out.println("Ingrese el director de la película:");
        String director = scanner.nextLine();

        System.out.println("Ingrese el género de la película:");
        String genero = scanner.nextLine();

        System.out.println("Ingrese el precio de alquiler de la película:");
        double precioAlquiler = scanner.nextDouble();

        System.out.println("Ingrese el descuento de la película:");
        double descuento = scanner.nextDouble();

        Peliculas nuevaPelicula = new Peliculas(id, titulo, director, genero, precioAlquiler, descuento);
        catalogo.add(nuevaPelicula);

        System.out.println("Película registrada con éxito.");
    }

    public static void realizarAlquiler(List<Peliculas> catalogo, List<Alquiler> alquileres, List<Cliente> clientes, Scanner scanner) {
        System.out.println("Ingrese el ID del cliente:");
        int idCliente = scanner.nextInt();
        scanner.nextLine();

        Cliente clienteExistente = buscarClientePorId(clientes, idCliente);
        if (clienteExistente == null) {
            System.out.println("Cliente no encontrado. Por favor, registre al cliente antes de realizar un alquiler.");
            return;
        }

        // Mostrar el catálogo de películas disponibles
        System.out.println("Catálogo de Películas Disponibles:");
        mostrarCatalogo(catalogo);

        // Seleccionar películas para el alquiler
        List<Peliculas> peliculasAlquiler = new ArrayList<>();
        System.out.println("Ingrese el ID de la película a alquilar (o 0 para finalizar):");
        int idPelicula;
        do {
            idPelicula = scanner.nextInt();
            if (idPelicula != 0) {
                Peliculas peliculaSeleccionada = buscarPeliculaPorId(catalogo, idPelicula);
                if (peliculaSeleccionada != null) {
                    peliculasAlquiler.add(peliculaSeleccionada);
                    System.out.println("Película agregada al alquiler.");
                } else {
                    System.out.println("ID de película no válido. Intente nuevamente.");
                }
            }
        } while (idPelicula != 0);

        // Crear instancia de Alquiler
        Alquiler nuevoAlquiler = new Alquiler(alquileres.size() + 1, peliculasAlquiler, clienteExistente);
        alquileres.add(nuevoAlquiler);

        System.out.println("Alquiler realizado con éxito.");
    }

    public static void registrarCliente(List<Cliente> clientes, Scanner scanner) {
        System.out.println("Ingrese el ID del cliente:");
        int idCliente = scanner.nextInt();
        scanner.nextLine();

        Cliente clienteExistente = buscarClientePorId(clientes, idCliente);
        if (clienteExistente != null) {
            System.out.println("Ya existe un cliente con ese ID. Por favor, ingrese un ID único.");
            return;
        }

        System.out.println("Ingrese el nombre del cliente:");   
        String nombreCliente = scanner.nextLine();

        System.out.println("Ingrese el correo del cliente:");
        String correoCliente = scanner.nextLine();

        System.out.println("Ingrese el número de celular del cliente:");
        String celularCliente = scanner.nextLine();

        Cliente nuevoCliente = new Cliente(idCliente, nombreCliente, correoCliente, celularCliente);
        clientes.add(nuevoCliente);

        System.out.println("Cliente registrado con éxito.");
    }

    public static void mostrarPeliculas(List<Peliculas> catalogo) {
        System.out.println("Catálogo de Películas:");
        mostrarCatalogo(catalogo);
    }

    public static void mostrarClientes(List<Cliente> clientes) {
        System.out.println("Lista de Clientes:");
        for (Cliente cliente : clientes) {
            System.out.println("ID: " + cliente.getId() + ", Nombre: " + cliente.getNombre() +
                    ", Correo: " + cliente.getCorreo() + ", Celular: " + cliente.getCelular());
        }
    }

    public static Peliculas buscarPeliculaPorId(List<Peliculas> catalogo, int id) {
        for (Peliculas pelicula : catalogo) {
            if (pelicula.getId() == id) {
                return pelicula;
            }
        }
        return null;
    }

    public static Cliente buscarClientePorId(List<Cliente> clientes, int id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null;
    }

    public static void mostrarCatalogo(List<Peliculas> catalogo) {
        for (Peliculas pelicula : catalogo) {
            System.out.println("- ID: " + pelicula.getId() + ", Título: " + pelicula.getTitulo());
        }
    }
}
