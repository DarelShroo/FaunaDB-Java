import Colecciones.Clientes;
import Colecciones.Estancias;
import Colecciones.Habitaciones;
import Colecciones.Hoteles;
import com.faunadb.client.FaunaClient;
import com.faunadb.client.errors.*;
import com.faunadb.client.types.Value;

import java.time.Clock;
import java.time.Instant;
import java.util.Collection;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

import static com.faunadb.client.query.Language.*;

public class Sentencias {
    public Sentencias() {
    }

    public static void visualizarClientes(FaunaClient client, String INDEX_NAME) throws ExecutionException, InterruptedException {
        try {
            Value findAllClientes = client.query(
                    SelectAll(Path("data", "data"),
                            Map(
                                    Paginate(
                                            Match(Index(Value(INDEX_NAME)))
                                    ),
                                    Lambda(Value("NXT_CLIENTE"), Get(Var("NXT_CLIENTE"))))
                    )
            ).get();

            Value queryResultIds = client.query(
                    SelectAll(Path("data", "id"),
                            Paginate(
                                    Match(Index(Value(INDEX_NAME)))
                            ))
            ).get();

            Collection<Clientes> allClientesCollections = findAllClientes.asCollectionOf(Clientes.class).get();
            Collection<String> allClientesIdsCollections = queryResultIds.asCollectionOf(String.class).get();
            System.out.println("Leyendo " + allClientesCollections.size() + " Usuarios:");
            for (int i = 0; i < allClientesIdsCollections.size(); i++) {
                System.out.println("ref = " + allClientesIdsCollections.toArray()[i] + " " + allClientesCollections.toArray()[i]);
            }
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
        } catch (ExecutionException ee) {
            System.out.println("Error en tiempo de ejecución");
        }
    }

    public static void visualizarEstancias(FaunaClient client, String INDEX_NAME) throws ExecutionException, InterruptedException {
        try {
            Value findAllEstancias = client.query(
                    SelectAll(Path("data", "data"),
                            Map(
                                    Paginate(
                                            Match(Index(Value(INDEX_NAME)))
                                    ),
                                    Lambda(Value("NXT_ESTANCIA"), Get(Var("NXT_ESTANCIA"))))
                    )
            ).get();


            Value queryResultIds = client.query(
                    SelectAll(Path("data", "id"),
                            Paginate(
                                    Match(Index(Value(INDEX_NAME)))
                            ))
            ).get();

            Collection<Estancias> allEstanciasCollections = findAllEstancias.asCollectionOf(Estancias.class).get();
            Collection<String> allEstanciasIdsCollections = queryResultIds.asCollectionOf(String.class).get();
            System.out.println("Leyendo " + allEstanciasCollections.size() + " Estancias:");
            for (int i = 0; i < allEstanciasCollections.size(); i++) {
                System.out.println("ref = " + allEstanciasIdsCollections.toArray()[i] + " " + allEstanciasCollections.toArray()[i]);
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

    public static void visualizarHabitaciones(FaunaClient client, String INDEX_NAME) throws ExecutionException, InterruptedException {
        try {
            Value findAllHabitaciones = client.query(
                    SelectAll(Path("data", "data"),
                            Map(
                                    Paginate(
                                            Match(Index(Value(INDEX_NAME)))
                                    ),
                                    Lambda(Value("NXT_HABITACION"), Get(Var("NXT_HABITACION"))))
                    )
            ).get();


            Value queryResultIds = client.query(
                    SelectAll(Path("data", "id"),
                            Paginate(
                                    Match(Index(Value(INDEX_NAME)))
                            ))
            ).get();

            Collection<Habitaciones> allHabitacionesCollections = findAllHabitaciones.asCollectionOf(Habitaciones.class).get();
            Collection<String> allHabitacionesIdsCollections = queryResultIds.asCollectionOf(String.class).get();
            System.out.println("Leyendo " + allHabitacionesCollections.size() + " Habitaciones:");
            for (int i = 0; i < allHabitacionesCollections.size(); i++) {
                System.out.println("ref = " + allHabitacionesIdsCollections.toArray()[i] + " " + allHabitacionesCollections.toArray()[i]);
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

    public static void visualizarHoteles(FaunaClient client, String INDEX_NAME) throws ExecutionException, InterruptedException {
        try {
            Value findAllHoteles = client.query(
                    SelectAll(Path("data", "data"),
                            Map(
                                    Paginate(
                                            Match(Index(Value(INDEX_NAME)))
                                    ),
                                    Lambda(Value("NXT_HOTEL"), Get(Var("NXT_HOTEL"))))
                    )
            ).get();


            Value queryResultIds = client.query(
                    SelectAll(Path("data", "id"),
                            Paginate(
                                    Match(Index(Value(INDEX_NAME)))
                            ))
            ).get();

            Collection<Hoteles> allHotelesCollections = findAllHoteles.asCollectionOf(Hoteles.class).get();
            Collection<String> allHotelesIdsCollections = queryResultIds.asCollectionOf(String.class).get();
            System.out.println("Leyendo " + allHotelesCollections.size() + " Hoteles:");
            for (int i = 0; i < allHotelesCollections.size(); i++) {
                System.out.println("ref = " + allHotelesIdsCollections.toArray()[i] + " " + allHotelesCollections.toArray()[i]);
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


    public static void borrarCliente(FaunaClient client) throws ExecutionException, InterruptedException {
        try {
            Scanner in = new Scanner(System.in);
            String ref;
            visualizarClientes(client, "clientes_index");
            System.out.println("Escribe el código de referencia del cliente a borrar");
            ref = in.nextLine();

            System.out.println("Eliminado = " +
                    client.query(
                            Delete(Ref(Collection("clientes"), Value(ref)))
                    ).get());
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

    public static void insertarCliente(FaunaClient client, String CLIENTE_CLASS) throws ExecutionException, InterruptedException {
        try {
            Scanner in = new Scanner(System.in);
            String codDNIoNIE;
            String nombre;
            String nacionalidad;

            System.out.println("Escribe el codDNIoNIE");
            codDNIoNIE = in.nextLine();
            System.out.println("Esscribe el nombre del cliente");
            nombre = in.nextLine();
            System.out.println("Escribe la nacionalidad");
            nacionalidad = in.nextLine();

            Clientes newCliente = new Clientes(codDNIoNIE, nombre, nacionalidad);
            Value storeClientResult = client.query(
                    Create(
                            Collection(Value(CLIENTE_CLASS)),
                            Obj("data", Value(newCliente))
                    )
            ).get();

            System.out.println("Guardado Cliente:\n " + storeClientResult + "\n");
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

    public static void insertarEstancia(FaunaClient client, String CLIENTE_CLASS) throws ExecutionException, InterruptedException {
        try {
            Scanner in = new Scanner(System.in);
            int codEstancia;
            String codDNIoNIE;
            int codHabitacion;
            String fechaInicio;
            String fechaFin;
            int ocupantes;
            int preciosetsancia;
            int pagado;

            System.out.println("Escribe el codEstancia");
            codEstancia = in.nextInt();
            System.out.println("Escribe el codDNIoNIE");
            in.nextLine();
            codDNIoNIE = in.nextLine();
            System.out.println("Escribe el codHabitacion");
            codHabitacion = in.nextInt();
            System.out.println("Escribe la fecha de inicio");
            in.nextLine();
            fechaInicio = in.nextLine();
            System.out.println("Escribe la fecha de fin");
            fechaFin = in.nextLine();
            System.out.println("Escribe el numero de ocupantes");
            ocupantes = in.nextInt();
            System.out.println("Escribe el precio de estancia");
            preciosetsancia = in.nextInt();
            System.out.println("Escribe pagado (1 = si) o (0 = no)");
            pagado = in.nextInt();

            Estancias newEstancia = new Estancias(codEstancia, codDNIoNIE, codHabitacion, fechaInicio, fechaFin, ocupantes, preciosetsancia, pagado);
            Value storeEstanciaResult = client.query(
                    Create(
                            Collection(Value(CLIENTE_CLASS)),
                            Obj("data", Value(newEstancia))
                    )
            ).get();

            System.out.println("Guardada la Estancia:\n " + storeEstanciaResult + "\n");
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

    public static void actualizarCliente(FaunaClient client, String INDEX_NAME) throws ExecutionException, InterruptedException {
        try {
            Scanner in = new Scanner(System.in);
            String ref;

            visualizarClientes(client, "clientes_index");
            System.out.println("Escribe el código de referencia el cliente que quieres actualizar");
            ref = in.nextLine();

            System.out.println("Actualizar nombre si o no");
            if(in.nextLine().equals("si")){
                actualizarDato(client, ref, "nombre");
            }

            System.out.println("Actualizar codDNIoNIE si o no");
            if(in.nextLine().equals("si")){
                actualizarDato(client, ref, "codDNIoNIE");
            }

            System.out.println("Actualizar nacionalidad si o no");
            if(in.nextLine().equals("si")){
                actualizarDato(client, ref, "nacionalidad");
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
    public static void actualizarDato (FaunaClient client, String ref, String dato) throws ExecutionException, InterruptedException {
        try {
        Scanner in = new Scanner(System.in);
        System.out.println("Escribe el nuevo " + dato);
        String datoUpdate;
        datoUpdate = in.nextLine();
        System.out.println(
                dato + " actualizado = "+
                        client.query(
                                Update(
                                        Ref(Collection("clientes"), Value(ref)),
                                        Obj(
                                                "data", Obj(
                                                        dato, Value(datoUpdate)
                                                )
                                        )
                                )
                        ).get());

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
