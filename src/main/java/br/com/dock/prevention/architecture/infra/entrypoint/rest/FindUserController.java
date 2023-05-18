package br.com.dock.prevention.architecture.infra.entrypoint.rest;

import br.com.dock.prevention.architecture.domain.usecase.finduser.FindUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FindUserController {

    private final FindUser findUser;

    @GetMapping(value = "/user/{name}")
    public ResponseEntity<String> findByName(@PathVariable("name") String name){
        return ResponseEntity.ok(findUser.findByName(name).name());
    }

}