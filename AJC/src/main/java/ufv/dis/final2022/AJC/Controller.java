package ufv.dis.final2022.AJC;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
        long iptransformada = aux.D

        return c.getIp();
    }
}
