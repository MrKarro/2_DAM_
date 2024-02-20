/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio13_conexiones;

/**
 *
 * @author 6002755
 */
import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
    private Socket socket;
    private PrintWriter output;
    private Scanner input;

    public Server(int port) throws UnknownHostException, IOException {
        socket = new Socket("localhost", port);
        output = new PrintWriter(socket.getOutputStream(), true);
        input = new Scanner(socket.getInputStream());
    }

    public void start() {
        System.out.println("Servidor iniciado en el puerto 8080");
        while (true) {
            String message = input.nextLine();
            if (message.equals("salir")) {
                break;
            }
            String answer = answerQuestion(message);
            output.println(answer);
        }
    }

    private String answerQuestion(String question) {
        List<String> questions = getQuestions();
        int randomQuestionIndex = (int) (Math.random() * questions.size());
        String randomQuestion = questions.get(randomQuestionIndex);
        String answer = "Respuesta aleatoria";
        return answer;
    }
    
    private List<String> getQuestions() {
        List<String> questions = new ArrayList<>();
        questions.add("¿Cuál es la capital de Francia?");
        questions.add("¿Quién es el autor de la obra 'La Odisea'?");
        questions.add("¿Cuál es el nombre del personaje principal de la novela '1984' de George Orwell?");
        questions.add("¿Cuál es el nombre de la primera canción de la banda 'The Beatles'?");
        questions.add("¿Cuál es el nombre del primer presidente de los Estados Unidos?");
    return questions;
}
}

