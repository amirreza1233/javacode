/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WithServer;

import java.io.*;
import java.net.*;

/**
 *
 * @author amalb
 */
public class Server {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket s = new ServerSocket(4999);
        while (true) {
            Socket ss = s.accept();
            System.out.println("Client Connected");
            ObjectInputStream input = new ObjectInputStream(ss.getInputStream());
            DataOutputStream send_back = new DataOutputStream(ss.getOutputStream());

        }

    }
}
