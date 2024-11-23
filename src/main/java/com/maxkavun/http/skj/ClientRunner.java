package com.maxkavun.http.skj;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ClientRunner {

    public static void main(String[] args) throws IOException {
        ClientRunner clientRunner = new ClientRunner();

        try (Client client = new Client("172.21.40.125", 15000)) {

            client.sendMessage("s30908 BX3YBZbK7y\n");
            // тут первая задача - склейка текста
            String responseFromServer = client.getMessage();
            System.out.println("Response from server: " + responseFromServer);

            String responseToServer = responseFromServer.replaceAll(" ", "");
            client.sendMessage(responseToServer + "\n");
            System.out.println(client.getMessage());

            // тут вторая задача - склейка текста если он пришел в разных линиях
            StringBuilder resToServer = new StringBuilder();
            System.out.println("Response from server: ");
            for (int i = 0; i < 4; i++) {
                String s = client.getMessage().trim().replaceAll(" ", "");
                System.out.println(s);
                resToServer.append(s);
            }
            System.out.println(resToServer);
            client.sendMessage(resToServer + "\n");

            System.out.println(client.getMessage());
            resToServer.delete(0, resToServer.length()); // очистил StringBuilder

            // тут третья задача
            List<String> list = new ArrayList<String>();
            System.out.println("Response from server: ");
            for (int i = 0; i < 8; i++) {
                String res = client.getMessage().trim().replaceAll(" ", "");
                System.out.println(res);
                list.add(res);
            }
            for (int i = 0, j = 0; i < 4; i++) {
                resToServer.append(list.get(j));
                ++j;
                resToServer.append(list.get(j));
                ++j;
                client.sendMessage(resToServer + "\n");
                resToServer.delete(0, resToServer.length());
            }
            System.out.println(client.getMessage());

            // тут задание 4
            System.out.println("Response from server: ");
            String stringK = client.getMessage().trim().replaceAll(" ", "");
            System.out.println("KKK -----------------> " + stringK);
            int k = Integer.parseInt(stringK);
            List<String> l1 = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                String res = client.getMessage().trim().replaceAll(" ", "");
                System.out.println(res);
                l1.add(res);
            }
            for (int i = 0; i < k; i++) {
                String res = client.getMessage().trim().replaceAll(" ", "");
                System.out.println(res);
                resToServer.append(l1.get(i));
                resToServer.append(res);
                client.sendMessage(resToServer + "\n");
                resToServer.delete(0, resToServer.length());

            }
            System.out.println(client.getMessage());

            // Задание 5
            List<String> li1 = new ArrayList<>();
            List<String> li2 = new ArrayList<>();
            StringBuilder respToServ = new StringBuilder();
            System.out.println("Response from server: ");
            boolean isStop = false;

            while (!isStop) {
                String str = client.getMessage().trim().replaceAll(" ", "");
                li1.add(str);
                System.out.println(str);
                if (str.isEmpty()) {
                    isStop = true;
                }
            }
            li1.remove(li1.get(li1.size() - 1));

            String su = new String(li1.get(li1.size() - 1));
            li2.add(su);
            li1.remove(li1.get(li1.size() - 1));

            for (int i = 0; i < li1.size(); i++) {
                respToServ.append(li1.get(i));
                respToServ.append(li2.get(i));
                client.sendMessage(respToServ + "\n");

                System.out.println(respToServ);
                String next = client.getMessage().trim().replaceAll(" ", "");
                li2.add(next);
                respToServ.delete(0, respToServ.length());
            }
            System.out.println("Server response: " + li2.get(li2.size()-1));
        }
    }
}
