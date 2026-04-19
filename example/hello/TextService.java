package example.Hello;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TextService extends Remote {
    String maiusculo(String texto) throws RemoteException;
}