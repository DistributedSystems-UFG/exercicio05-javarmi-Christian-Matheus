package example.hello;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Hello extends Remote {
    String sayHello() throws RemoteException;
    int soma(int a, int b) throws RemoteException;
    String inverter(String texto) throws RemoteException;
    int contarCaracteres(String texto) throws RemoteException;
}
