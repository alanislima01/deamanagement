package br.com.dea.management;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController //Ele vai fornecer alguma API rest de alguma forma
public class HelloWorldController {

@RequestMapping(value = "/hello-world", method = RequestMethod.GET) //mapeando o metodo para ser executado sempre que a URL for invocada
    public ResponseEntity<String> getFactory() {
        return ResponseEntity.ok("Hello World aqui");
    }
}
