package cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

//esta clase es el controlador del cliente
public class Client extends Thread {

    private final Form form;
    private final DataInputStream dis;
    private final DataOutputStream dos;

    public Client(Form form, DataInputStream dis, DataOutputStream dos) {
        this.form = form;
        this.dis = dis;
        this.dos = dos;

    }

    //solo se llama a este cosntructr cuando no se puede conectar al servidor
    public Client() {
        this.form = null;
        this.dis = null;
        this.dos = null;
        JOptionPane.showMessageDialog(null, "No fue posible realizar la conexion");
        System.exit(0);
    }

    public void exit() {
        try {
            //envia un 0 a al hilo del servidor para que elimine su controlador
            dos.writeInt(0);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.exit(0);
    }

    @Override
    public void run() {
        while (true) {
            try {
               /*lee constantemente lo que le manda el servidor
                *para modificar la posicion de la figura del cliente y
                *
                *en caso de que mande 0.01 (cuando se cierra el servidor)
                *cierra solo esta ventana 
                *
                *en caso de que mande 0.02 (cuando se cierra su controlador)
                *cierra esta ventana y manda a que termine el hilo de su 
                *controlador
                */
                double position = dis.readDouble();
                if (position == 0.01) {
                    break;
                } else if (position == 0.02) {
                    dos.writeInt(0);
                    break;
                }
                form.setPosition(position);
            } catch (IOException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.exit(0);
    }
}
