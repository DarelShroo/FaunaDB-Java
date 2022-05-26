import Colecciones.Clientes;
import Colecciones.Estancias;
import Colecciones.Habitaciones;
import Colecciones.Hoteles;
import com.faunadb.client.FaunaClient;
import com.faunadb.client.errors.*;
import com.faunadb.client.query.Language;
import com.faunadb.client.types.Value;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutionException;

import static com.faunadb.client.query.Language.*;
import static com.faunadb.client.query.Language.Obj;

public class Init {
    public static void init(String DB_NAME, FaunaClient client) throws Exception {
        runClientes(DB_NAME, client);
        runEstancias(DB_NAME, client);
        runHabitaciones(DB_NAME, client);
        runHoteles(DB_NAME, client);
    }

    private static void runClientes(String DB_NAME, FaunaClient client) throws Exception {
        try {
            /*
             * Crear indice de la clase Clientes
             */
            String CLIENTE_CLASS = "clientes";
            String INDEX_NAME = "clientes_index";

            //Creamos la colección (Tabla)
            Value classResults = client.query(
                    CreateCollection(
                            Obj("name", Value(CLIENTE_CLASS))
                    )
            ).get();

            System.out.println("Crear clase como " + DB_NAME + ":\n " + classResults + "\n");


            //Creamos un índice para poder recuperar objetos por sus propiedades y no solo por su referencia
            Value indexResults = client.query(
                    CreateIndex(
                            Obj("name", Value(INDEX_NAME) , "source", Collection(Value(CLIENTE_CLASS)))
                    )
            ).get();

            System.out.println("Creación de índice para " + DB_NAME + ":\n " + indexResults + "\n");

            Clientes newCliente1 = new Clientes("000000J", "Adrián", "Española");
            Clientes newCliente2 = new Clientes("111111J", "Juán", "Española");
            Clientes newCliente3 = new Clientes("222222J", "Julia", "Venezolana");
            Clientes newCliente4 = new Clientes("333333A", "Clara", "Española");
            Clientes newCliente5 = new Clientes("444444A", "Ana", "Cubana");
            Clientes newCliente6 = new Clientes("555555J", "Hoffman", "Venezolana");
            Clientes newCliente7 = new Clientes("555555J", "Hoffman", "Venezolana");

            List<Clientes> clientesList = Arrays.asList(newCliente1, newCliente2, newCliente3, newCliente4, newCliente5, newCliente6, newCliente7);

            Value clientesListSave = client.query(
                    Foreach(
                            Value(clientesList),
                            Lambda(Value("NXT_CLIENTE"),
                                    Create(
                                            Collection(Value(CLIENTE_CLASS)),
                                            Obj("data", Var("NXT_CLIENTE"))
                                    )
                            )
                    )
            ).get();

            System.out.println("Lista creada de objetos Clientes de java \n" + clientesListSave + "\n");
            Collection<Clientes> clientesCollection = clientesListSave.asCollectionOf(Clientes.class).get();
            System.out.println("Guardado " + clientesCollection.size() + " Clientes:");
            clientesCollection.forEach(nextSpell -> System.out.println("   " + nextSpell));
        } catch (
                BadRequestException bre) {
            System.out.println("Esta consulta no puede ser evaluada");
        } catch (
                InternalException ie) {
            System.out.println("HTTP 500 (Error interno del servidor) al realizar una solicitud a FaunaDB.");
        } catch (
                NotFoundException nfe) {
            System.out.println("error HTTP 404 (No encontrado).");
        } catch (
                PermissionDeniedException pde) {
            System.out.println("error HTTP 403 (Prohibido) desde FaunaDB.");
        } catch (
                StreamingException se) {
            System.out.println("Evento de error en la transmisión.");
        } catch (TransactionContentionException tce) {
            System.out.println("Error HTTP 409 desde FaunaDB.");
        } catch (UnauthorizedException ue) {
            System.out.println("Error HTTP 401 (no autorizado).");
        } catch (UnavailableException ue) {
            System.out.println("El host de FaunaDB no está disponible por algún motivo.");
        } catch (UnknownException ue) {
            System.out.println("El cliente desconoce o no puede analizar una respuesta de FaunaDB.");
        } catch (
                ExecutionException ee) {
            System.out.println("Error en tiempo de ejecución");
        }
    }

    private static void runEstancias(String DB_NAME, FaunaClient client) throws Exception {
        try {
            /*
             * Crear indice de la clase Clientes
             */
            String ESTANCIAS_CLASS = "estancias";
            String INDEX_NAME = "estancias_index";

            //Creamos la colección (Tabla)
            Value classResults = client.query(
                    CreateCollection(
                            Obj("name", Value(ESTANCIAS_CLASS))
                    )
            ).get();

            System.out.println("Crear clase como " + DB_NAME + ":\n " + classResults + "\n");


            //Creamos un índice para poder recuperar objetos por sus propiedades y no solo por su referencia
            Value indexResults = client.query(
                    CreateIndex(
                            Obj("name", Value(INDEX_NAME), "source", Collection(Value(ESTANCIAS_CLASS)))
                    )
            ).get();

            System.out.println("Creación de índice para " + DB_NAME + ":\n " + indexResults + "\n");

            Estancias newEstancia1 = new Estancias(001, "000000J", 001, "01/01/2020", "02/02/2020", 4, 20, 1);
            Estancias newEstancia2 = new Estancias(002, "111111J", 002, "03/03/2020", "04/04/2020", 3, 30, 0);
            Estancias newEstancia3 = new Estancias(003, "222222J", 003, "05/05/2020", "06/06/2020", 6, 15, 1);
            List<Estancias> estanciasList = Arrays.asList(newEstancia1, newEstancia2, newEstancia3);

            Value estanciasListSave = client.query(
                    Foreach(
                            Value(estanciasList),
                            Lambda(Value("NXT_CLIENTE"),
                                    Create(
                                            Collection(Value(ESTANCIAS_CLASS)),
                                            Obj("data", Var("NXT_CLIENTE"))
                                    )
                            )
                    )
            ).get();

            System.out.println("Lista creada de objetos Estancias de java \n" + estanciasListSave + "\n");
            Collection<Estancias> estanciasCollection = estanciasListSave.asCollectionOf(Estancias.class).get();
            System.out.println("Guardado " + estanciasCollection.size() + " estancias:");
            estanciasCollection.forEach(nextSpell -> System.out.println("   " + nextSpell));
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

    private static void runHabitaciones(String DB_NAME, FaunaClient client) throws Exception {
        try {
            /*
             * Crear indice de la clase Clientes
             */
            String HABITACIONES_CLASS = "habitaciones";
            String INDEX_NAME = "habitaciones_index";

            //Creamos la colección (Tabla)
            Value classResults = client.query(
                    CreateCollection(
                            Obj("name", Value(HABITACIONES_CLASS))
                    )
            ).get();

            System.out.println("Crear clase como " + DB_NAME + ":\n " + classResults + "\n");


            //Creamos un índice para poder recuperar objetos por sus propiedades y no solo por su referencia
            Value indexResults = client.query(
                    CreateIndex(
                            Obj("name", Value(INDEX_NAME), "source", Collection(Value(HABITACIONES_CLASS)))
                    )
            ).get();

            System.out.println("Creación de índice para " + DB_NAME + ":\n " + indexResults + "\n");

            Habitaciones newHabitacion1 = new Habitaciones(001, "AAA", "001", 5, 40, 1);
            Habitaciones newHabitacion2 = new Habitaciones(002, "BBB", "002", 3, 20, 1);
            Habitaciones newHabitacion3 = new Habitaciones(003, "CCC", "003", 4, 30, 0);
            List<Habitaciones> habitacionesList = Arrays.asList(newHabitacion1, newHabitacion2, newHabitacion3);

            Value habitacionesListSave = client.query(
                    Foreach(
                            Value(habitacionesList),
                            Lambda(Value("NXT_HABITACION"),
                                    Create(
                                            Collection(Value(HABITACIONES_CLASS)),
                                            Obj("data", Var("NXT_HABITACION"))
                                    )
                            )
                    )
            ).get();

            System.out.println("Lista creada de objetos Habitaciones de java \n" + habitacionesListSave + "\n");
            Collection<Habitaciones> estanciasCollection = habitacionesListSave.asCollectionOf(Habitaciones.class).get();
            System.out.println("Guardado " + estanciasCollection.size() + " habitaciones:");
            estanciasCollection.forEach(nextSpell -> System.out.println("   " + nextSpell));
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

    private static void runHoteles(String DB_NAME, FaunaClient client) throws Exception {
        try {
            /*
             * Crear indice de la clase Clientes
             */
            String HOTELES_CLASS = "hoteles";
            String INDEX_NAME = "hoteles_index";

            //Creamos la colección (Tabla)
            Value classResults = client.query(
                    CreateCollection(
                            Obj("name", Value(HOTELES_CLASS))
                    )
            ).get();

            System.out.println("Crear clase como " + DB_NAME + ":\n " + classResults + "\n");


            //Creamos un índice para poder recuperar objetos por sus propiedades y no solo por su referencia
            Value indexResults = client.query(
                    CreateIndex(
                            Obj("name", Value(INDEX_NAME), "source", Collection(Value(HOTELES_CLASS)))
                    )
            ).get();

            System.out.println("Creación de índice para " + DB_NAME + ":\n " + indexResults + "\n");


            Hoteles newHotel1 = new Hoteles("AAA", "Mariachi");
            Hoteles newHotel2 = new Hoteles("BBB", "Las luces");
            Hoteles newHotel3 = new Hoteles("CCC", "New Hotel");
            List<Hoteles> hotelesList = Arrays.asList(newHotel1, newHotel2, newHotel3);

            Value hotelesListSave = client.query(
                    Foreach(
                            Value(hotelesList),
                            Lambda(Value("NXT_HOTEL"),
                                    Create(
                                            Collection(Value(HOTELES_CLASS)),
                                            Obj("data", Var("NXT_HOTEL"))
                                    )
                            )
                    )
            ).get();

            System.out.println("Lista creada de objetos Hoteles de java \n" + hotelesListSave + "\n");
            Collection<Hoteles> hotelesCollection = hotelesListSave.asCollectionOf(Hoteles.class).get();
            System.out.println("Guardado " + hotelesCollection.size() + " hoteles:");
            hotelesCollection.forEach(nextSpell -> System.out.println("   " + nextSpell));
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
