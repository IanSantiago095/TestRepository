import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Proyecto {
    
    public static void main(String[] args) {
        CatalogoProductos catalogo = new CatalogoProductos();
        
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Buscar Producto");
            System.out.println("2. Eliminar Producto");
            System.out.println("3. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    mostrarMenuBusqueda(catalogo, scanner);
                    break;

                case 2:
                    System.out.print("Ingresa el ID del producto a eliminar: ");
                    int idEliminar = scanner.nextInt();

                    if (catalogo.eliminarProducto(idEliminar)) {
                        System.out.println("Producto eliminado correctamente.");
                    } else {
                        System.out.println("Producto no encontrado o ya eliminado.");
                    }
                    break;

                case 3:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida. Intenta nuevamente.");
            }
        } while (opcion != 3);

        scanner.close();
    }

    static class Producto {
        private int id;
        private String title;
        private double price;
        private String categoryName;
        private boolean eliminado;

        public Producto(int id, String title, double price, String categoryName) {
            this.id = id;
            this.title = title;
            this.price = price;
            this.categoryName = categoryName;
            this.eliminado = false;
        }


        public int getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public double getPrice() {
            return price;
        }

        public String getCategoryName() {
            return categoryName;
        }

        public boolean isEliminado() {
            return eliminado;
        }

        public void setEliminado(boolean eliminado) {
            this.eliminado = eliminado;
        }

        @Override
        public String toString() {
            return "Producto [ID: " + id + ", Nombre: " + title + ", Categoría: " + categoryName + ", Precio: " + price + "]";
        }
    }

    static class CatalogoProductos {
        private List<Producto> productos;

        public CatalogoProductos() {    
            this.productos = new ArrayList<>();
            cargarProductosDesdeAPI();
        }

        private void cargarProductosDesdeAPI() {
            try {
                URL url = new URL("https://api.escuelajs.co/api/v1/products");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");

                int responseCode = connection.getResponseCode();
                if (responseCode == 200) {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    StringBuilder response = new StringBuilder();
                    String line;

                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }
                    reader.close();

                    // Extraer datos del JSON
                    String jsonResponse = response.toString();
                    int startIndex = 1; // Empezar después del [ en el JSON
                    int endIndex = jsonResponse.length() - 1; // Terminar antes del ]

                    String productosJson = jsonResponse.substring(startIndex, endIndex);
                    String[] productosArray = productosJson.split("},\\{");

                    for (String productoJson : productosArray) {
                        productoJson = productoJson.replace("{", "").replace("}", "");
                        String[] atributos = productoJson.split(",");

                        int id = Integer.parseInt(atributos[0].split(":")[1].trim());
                        String title = atributos[1].split(":")[1].replace("\"", "").trim();
                        double price = Double.parseDouble(atributos[2].split(":")[1].trim());
                        String categoryName = atributos[3].split(":")[1].replace("\"", "").trim();

                        Producto producto = new Producto(id, title, price, categoryName);
                        productos.add(producto);
                    }

                    System.out.println("Productos cargados correctamente desde la API.");
                } else {
                    System.out.println("Error al conectar con la API. Código de respuesta: " + responseCode);
                }
            } catch (Exception exp) {
                System.out.println("Error al cargar productos desde la API: " + exp.getMessage());
            }
        }

        public Producto buscarPorId(int id) {
            for (Producto producto : productos) {
                if (producto.getId() == id && !producto.isEliminado()) {
                    return producto;
                }
            }
            return null;
        }

        public List<Producto> buscarPorNombre(String nombre) {
            List<Producto> resultados = new ArrayList<>();
            for (Producto producto : productos) {
                if (producto.getTitle().toLowerCase().contains(nombre.toLowerCase()) && !producto.isEliminado()) {
                    resultados.add(producto);
                }
            }
            return resultados;
        }

        public List<Producto> buscarPorCategoria(String categoria) {
            List<Producto> resultados = new ArrayList<>();
            for (Producto producto : productos) {
                if (producto.getCategoryName().toLowerCase().contains(categoria.toLowerCase()) && !producto.isEliminado()) {
                    resultados.add(producto);
                }
            }
            return resultados;
        }

        public List<Producto> buscarPorRangoDePrecio(double min, double max) {
            List<Producto> resultados = new ArrayList<>();
            for (Producto producto : productos) {
                if (!producto.isEliminado() && producto.getPrice() >= min && producto.getPrice() <= max) {
                    resultados.add(producto);
                }
            }
            return resultados;
        }

        public boolean eliminarProducto(int id) {
            Producto producto = buscarPorId(id);
            if (producto != null && !producto.isEliminado()) {
                producto.setEliminado(true);
                return true;
            }
            return false;
        }

        public List<Producto> getProductos() {
            return productos;
        }
    }

    private static void mostrarMenuBusqueda(CatalogoProductos catalogo, Scanner scanner) {
        int tipoBusqueda;

        do {
            System.out.println("\n--- TIPOS DE BÚSQUEDA ---");
            System.out.println("1. Buscar por Nombre");
            System.out.println("2. Buscar por ID");
            System.out.println("3. Buscar por Categoría");
            System.out.println("4. Buscar por Rango de Precio");
            System.out.println("5. Regresar al Menú Principal");
            System.out.print("Selecciona una opción: ");
            tipoBusqueda = scanner.nextInt();

            switch (tipoBusqueda) {
                case 1:
                    System.out.print("Ingresa las letras o palabra del producto: ");
                    String nombre = scanner.next();

                    List<Producto> resultadosNombre = catalogo.buscarPorNombre(nombre);

                    if (resultadosNombre.isEmpty()) {
                        System.out.println("No se encontraron productos con ese nombre.");
                    } else {
                        System.out.println("Productos encontrados:");
                        for (Producto producto : resultadosNombre) {
                            System.out.println(producto);
                        }
                    }
                    break;

                case 2:
                    System.out.print("Ingresa el ID del producto: ");
                    int id = scanner.nextInt();

                    Producto resultadoId = catalogo.buscarPorId(id);

                    if (resultadoId == null) {
                        System.out.println("Producto no encontrado o ya eliminado.");
                    } else {
                        System.out.println("Producto encontrado:");
                        System.out.println(resultadoId);
                    }
                    break;

                case 3:
                    System.out.print("Ingresa las letras o palabra de la categoría: ");
                    String categoria = scanner.next();

                    List<Producto> resultadosCategoria = catalogo.buscarPorCategoria(categoria);

                    if (resultadosCategoria.isEmpty()) {
                        System.out.println("No se encontraron productos en esa categoría.");
                    } else {
                        System.out.println("Productos encontrados:");
                        for (Producto producto : resultadosCategoria) {
                            System.out.println(producto);
                        }
                    }
                    break;

                case 4:
                    System.out.print("Ingresa el precio mínimo: ");
                    double min = scanner.nextDouble();
                    System.out.print("Ingresa el precio máximo: ");
                    double max = scanner.nextDouble();

                    List<Producto> resultadosPrecio = catalogo.buscarPorRangoDePrecio(min, max);

                    if (resultadosPrecio.isEmpty()) {
                        System.out.println("No se encontraron productos en ese rango de precio.");
                    } else {
                        System.out.println("Productos encontrados:");
                        for (Producto producto : resultadosPrecio) {
                            System.out.println(producto);
                        }
                    }
                    break;

                case 5:
                    return;

                default:
                    System.out.println("Opción inválida. Intenta nuevamente.");
            }

            System.out.print("¿Deseas realizar otra búsqueda? (si/no): ");
            scanner.nextLine();
            String continuar = scanner.nextLine();
            
            if (continuar.equalsIgnoreCase("si")) {
            } else {
                break;
            }

        } while (tipoBusqueda != 5);
    }
}
