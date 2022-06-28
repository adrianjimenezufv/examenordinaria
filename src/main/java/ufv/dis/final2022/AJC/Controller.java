package ufv.dis.final2022.AJC;

import com.google.gson.Gson;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

@RestController
public class Controller {
    Funciones aux = new Funciones();
    ArrayList<IPClass> ListaIPs = aux.leerIPs();

    ArrayList<IPBuscada> IpsBuscadas = new ArrayList<>();
    ArrayList<IPEncontrada> IpsEncontradas = new ArrayList<>();

    @PostMapping("/ip")
    public String BuscarIP(@RequestBody IPBuscada c){
        String ippuntos = c.getIp();
        long iptransformada = aux.Dot2LongIP(ippuntos);

        IPBuscada ipbuscada = new IPBuscada();
        IPEncontrada ipencontrada = new IPEncontrada();

        boolean encontrado = false;

        for(int i = 0; i<ListaIPs.size(); i++){
            if((iptransformada >= ListaIPs.get(i).getIp_from()) && (iptransformada <= ListaIPs.get(i).getIp_to())){
                ipencontrada.setIP(ippuntos);
                ipencontrada.setCountry_code(ListaIPs.get(i).getCountry_code());
                ipencontrada.setRegion_code(ListaIPs.get(i).getRegion_name());
                ipencontrada.setCity_name(ListaIPs.get(i).getCity_name());
                ipencontrada.setZip_code(ListaIPs.get(i).getTime_zone());

                ipbuscada.setIp(c.getIp());
                ipbuscada.setMensaje("Ip encontrada");
                IpsBuscadas.add(ipbuscada);

                encontrado = true;

                String ResponseSI = new Gson().toJson(ipencontrada);
                return ResponseSI;
            }

        }

        if(encontrado==false){
            ipbuscada.setIp(c.getIp());
            ipbuscada.setMensaje("Ip no encontrada");
            IpsBuscadas.add(ipbuscada);
        }
        String ResponseNO = new Gson().toJson(ipbuscada);
        return ResponseNO;
    }

    @GetMapping("/ip")
    public ArrayList<IPBuscada> MostrarBusquedas(){
        String gson = new Gson().toJson(IpsBuscadas);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("J son/IPsBuscadas.json"))) {
            bw.write(gson);
            System.out.println("Fichero creado\n ------------ \n");
        } catch (IOException ex) {
            System.out.println("No ha sido posible crear el archivo.");
        }
        return IpsBuscadas;
    }
}
