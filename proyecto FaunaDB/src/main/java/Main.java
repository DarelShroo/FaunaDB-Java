import com.faunadb.client.FaunaClient;
import com.faunadb.client.errors.*;
import com.faunadb.client.types.Value;

import java.util.Scanner;
import java.util.concurrent.ExecutionException;

import static com.faunadb.client.query.Language.*;

public class Main {
    public static void main(String[] args) throws Exception {
        try {
            Scanner sc = new Scanner(System.in);
            String opcion = "1";
            String DB_NAME = "hoteles";
            FaunaClient adminClient = FaunaClient.builder()
                    .withSecret("fnAEcDG18HAAx2ZqrcLFwVOyjIVVirzokDAngBc3")
                    .withEndpoint("https://db.eu.fauna.com:443")
                    .build();
            System.out.println("Conexión realizada como admin a Faunadb\n");

            Value dbResults = adminClient.query(
                    Do(
                            If(
                                    Exists(Database(DB_NAME)),
                                    Delete(Database(DB_NAME)),
                                    Value(true)
                            ),
                            CreateDatabase(Obj("name", Value(DB_NAME)))
                    )
            ).get();

            System.out.println("Base de datos creada satisfactoriamente: " + dbResults.at("name").to(String.class).get() + "\n" + dbResults + "\n");

            //Generamos la key
            Value keyResults = adminClient.query(
                    CreateKey(Obj("database", Database(Value(DB_NAME)), "role", Value("server")))
            ).get();

            //Obtenemos la key de la nueva base de datos para acceder y trabajar sobre ella.
            String key = keyResults.at("secret").to(String.class).get();

            //Realizamos la conexión
            FaunaClient client = adminClient.newSessionClient(key);

            Init.init(DB_NAME, client);

            System.out.println("Conexión realizada a la base de datos faunadb, estás usando la base de datos " + DB_NAME + "\n");


            System.out.println("**************************************************************");
            System.out.println("****************** Darel Martínez Caballero ******************");
            System.out.println("**************************************************************");
            System.out.println();

            while (!opcion.equals("9")) {
                System.out.println("¿Que desea hacer?");
                System.out.println("1 - Insertar Cliente");
                System.out.println("2 - Insertar Estancia");
                System.out.println("3 - Visualizar Clientes");
                System.out.println("4 - Visualizar Estancias");
                System.out.println("5 - Visualizar Habitaciones");
                System.out.println("6 - Visualizar Hoteles");
                System.out.println("7 - Actualizar Cliente");
                System.out.println("8 - Borrar Cliente");
                System.out.println("9 -  Salir");



                opcion = sc.nextLine();

                if (!(opcion.equals("1") || opcion.equals("2") || opcion.equals("3")
                        || opcion.equals("4") || opcion.equals("5") || opcion.equals("6")
                        || opcion.equals("7") || opcion.equals("8"))) {
                    System.out.println("Escribe una opción válida");
                    opcion = sc.nextLine();
                }

                switch (opcion) {
                    case "1" -> Sentencias.insertarCliente(client, "clientes");
                    case "2" -> Sentencias.insertarEstancia(client, "estancias");
                    case "3" -> Sentencias.visualizarClientes(client, "clientes_index");
                    case "4" -> Sentencias.visualizarEstancias(client, "estancias_index");
                    case "5" -> Sentencias.visualizarHabitaciones(client, "habitaciones_index");
                    case "6" -> Sentencias.visualizarHoteles(client, "hoteles_index");
                    case "7" -> Sentencias.actualizarCliente(client, "clientes_index");
                    case "8" -> Sentencias.borrarCliente(client);
                }
            }
        } catch (BadRequestException bre) {
            System.out.println("Esta consulta no puede ser evaluada");
        } catch (InternalException ie) {
            System.out.println("HTTP 500 (Error interno del servidor) al realizar una solicitud a FaunaDB.");
        } catch (NotFoundException nfe) {
            System.out.println("error HTTP 404 (No encontrado).");
        } catch (PermissionDeniedException pde) {
            System.out.println("error HTTP 403 (Prohibido) desde FaunaDB.");
        } catch (StreamingException se) {
            System.out.println("Evento de error en la transmisión.");
        } catch (TransactionContentionException tce) {
            System.out.println("Error HTTP 409 desde FaunaDB.");
        } catch (UnauthorizedException ue) {
            System.out.println("Error HTTP 401 (no autorizado).");
        } catch (UnavailableException ue) {
            System.out.println("El host de FaunaDB no está disponible por algún motivo.");
        } catch (UnknownException ue) {
            System.out.println("El cliente desconoce o no puede analizar una respuesta de FaunaDB.");
        } catch (ExecutionException ee) {
            System.out.println("Error en tiempo de ejecución");
        }
    }
}
