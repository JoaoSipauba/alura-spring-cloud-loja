package br.com.alura.microservices.loja.service;

import br.com.alura.microservices.loja.controller.dto.CompraDTO;
import br.com.alura.microservices.loja.controller.dto.InfoFornecedorDTO;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CompraService {
    public void realizaCompra(CompraDTO compra) {

        RestTemplate client = new RestTemplate();
        ResponseEntity<InfoFornecedorDTO> exchange =
                client.exchange("http://localhost:8081/info/"+compra.getEndereco().getEstado(),
                HttpMethod.GET, null, InfoFornecedorDTO.class);

        System.out.println(exchange.getBody().getEndereco());
    }
}
