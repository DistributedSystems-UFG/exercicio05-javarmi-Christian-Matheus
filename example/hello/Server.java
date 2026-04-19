package example.hello;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {

    public Server() {}

    public static void main(String args[]) {
        try {
            // Cria o registry na porta padrão (1099)
            LocateRegistry.createRegistry(Registry.REGISTRY_PORT);

            // 🔹 Servidor original
            HelloImplem helloObj = new HelloImplem(5678);
            Naming.rebind("MyHello", helloObj);

            // 🔹 NOVO servidor (TextService)
            TextServiceImpl textObj = new TextServiceImpl(5679);
            Naming.rebind("TextService", textObj);

            System.out.println("Servidor pronto (Hello + TextService)");

        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}