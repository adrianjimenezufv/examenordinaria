package ufv.dis.final2022.AJC;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Funciones {

    public ArrayList<IPClass> leerIPs(){

        ArrayList<IPClass> ListaIP = new ArrayList<>();

        try {
            // create Gson instance
            Gson gson = new Gson();

            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("Json/LocalizaIP.json"));

            // convert JSON array to list of users
            ListaIP = new Gson().fromJson(reader, new TypeToken<ArrayList<IPClass>>() {
            }.getType());


            // close reader
            reader.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ListaIP;
    }

    public static String longToIp(long ip) {
        StringBuilder result = new StringBuilder(15);
        for (int i = 0; i < 4; i++) {
            result.insert(0, Long.toString(ip & 0xff));
            if (i < 3) {
                result.insert(0, '.');
            }
            ip = ip >> 8;
        }
        return result.toString();
        //192.168.1.2 -> 3232235778
    }

    public static Long Dot2LongIP(String dottedIP) {
        String[] addrArray = dottedIP.split("\\.");
        long num = 0;
        for (int i=0;i<addrArray.length;i++) {
            int power = 3-i;
            num += ((Integer.parseInt(addrArray[i]) % 256) * Math.pow(256,power));
        }
        return num;
    }
}
