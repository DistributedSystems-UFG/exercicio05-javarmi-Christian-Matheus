package example.hello;

import java.rmi.Naming;
import example.hello.TextService;

public class Client {

    private Client() {}

    public static void main(String[] args) {

        System.out.println("Initiating client");
        
        String host = (args.length < 1) ? "localhost" : args[0];

        try {
            // 🔹 Servidor Hello
            Hello stub = (Hello) Naming.lookup("rmi://" + host + "/MyHello"); 
            System.out.println("Found Hello server");

            String response = stub.sayHello();
            System.out.println("Response: " + response);

            int result = stub.soma(100, 1000);
            System.out.println("Response from soma: " + result);

            String texto = "Threads RMI";

            String invertido = stub.inverter(texto);
            System.out.println("Texto invertido: " + invertido);

            int tamanho = stub.contarCaracteres(texto);
            System.out.println("Quantidade de caracteres: " + tamanho);

            // 🔹 Novo servidor (TextService)
            TextService textStub = (TextService) Naming.lookup("rmi://" + host + "/TextService");
            System.out.println("Found TextService server");

            String maiusculo = textStub.maiusculo("threads rmi");
            System.out.println("Maiúsculo: " + maiusculo);

        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}