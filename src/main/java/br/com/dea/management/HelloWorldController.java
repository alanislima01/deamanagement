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

        //para ver tem que usar o http://localhost:8080/hello-world
    }
}

// fazer um git add e depois um git commit -m "", depois git push para mandar ao repositorio github

//para criar uma branch usa git checkout -b

//para trocar poderia ser git checkout nomeBranch