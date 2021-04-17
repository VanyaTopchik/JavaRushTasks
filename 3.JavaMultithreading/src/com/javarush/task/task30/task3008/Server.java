package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static Map<String,Connection> connectionMap = new ConcurrentHashMap<String, Connection>();
    public static void sendBroadcastMessage(Message message){
        for(Map.Entry<String,Connection> pair: connectionMap.entrySet()){
            try {
                pair.getValue().send(message);
            } catch (IOException e) {
                ConsoleHelper.writeMessage("Не получилось отправить сообщение.");
            }
        }
    }
    private static class Handler extends Thread{
        public Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }
        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            while(true) {
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message message = connection.receive();
                if(message.getType() != MessageType.USER_NAME){
                    ConsoleHelper.writeMessage("Неверно введенное имя пользователя.");
                    continue;
                }
                String name = message.getData();
                if(name.isEmpty()){
                   ConsoleHelper.writeMessage("Неверно введенное имя пользователя.");
                   continue;
                }
                if(connectionMap.containsKey(name)){
                    ConsoleHelper.writeMessage("Данное имя уже зарегистрировано. Выберите другое.");
                    continue;
                }
                connectionMap.put(name,connection);
                connection.send(new Message(MessageType.NAME_ACCEPTED));
                ConsoleHelper.writeMessage("Ваше имя принято.");
                return name;
            }
        }
        private void notifyUsers(Connection connection,String userName) throws IOException {
            for (Map.Entry<String,Connection> pair: connectionMap.entrySet()){
                if(!pair.getKey().equals(userName)) {
                    connection.send(new Message(MessageType.USER_ADDED, pair.getKey()));
                }
            }
        }
        private void serverMainLoop(Connection connection,String userName) throws IOException, ClassNotFoundException {
            while(true) {
                Message message = connection.receive();
                if (message.getType() == MessageType.TEXT) {
                    message = new Message(MessageType.TEXT, userName + ": " + message.getData());
                    sendBroadcastMessage(message);
                } else {
                    ConsoleHelper.writeMessage("Не получилось отправить сообщение.");
                }
            }
        }
        @Override
        public void run() {
            ConsoleHelper.writeMessage("Установлено соединеник с:" + socket.getRemoteSocketAddress());
            try (Connection connection = new Connection(socket)){
                String userName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));
                notifyUsers(connection,userName);
                serverMainLoop(connection,userName);
                connectionMap.remove(userName);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
            } catch (Exception e) {
                ConsoleHelper.writeMessage("Произошла ошибка при обмене данными с удаленным адресом.");
            }
            ConsoleHelper.writeMessage("Соединение с удаленным адресом закрыто.");
        }
    }
    public static void main(String[] args) throws IOException {
        ConsoleHelper.writeMessage("Введите порт сервера:");
        int port = ConsoleHelper.readInt();
        try(ServerSocket serverSocket = new ServerSocket(port)) {
            ConsoleHelper.writeMessage("Сервер запущен.");
            while (true) {
                Socket socket = serverSocket.accept();
                Handler handler = new Handler(socket);
                handler.start();
            }
        } catch (Exception e){
            ConsoleHelper.writeMessage("Произошла ошибка при запуске или работе сервера.");
        }
    }
}