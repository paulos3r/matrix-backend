package com.paulos3r.matrix.rest;

import com.paulos3r.matrix.model.entity.Cliente;
import com.paulos3r.matrix.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/clientes") //url base que vai ser usada nesse controller
public class ClienteController {

    //utilizando a interface jpa para persistir
    private final ClienteRepository repository;

    @Autowired
    public ClienteController(ClienteRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) //retorna o codigo de status 100,200,300,400 ou 500
    public Cliente salvarCliente(@RequestBody Cliente cliente){
        return repository.save(cliente);
    }

    @GetMapping("{id}") //criando uma variavel id api/clientes/{id}
    @ResponseStatus(HttpStatus.OK)
    public Cliente buscarClientePorId(@PathVariable Integer id){
        return repository.findById(id)//retorna um opcional
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND)); //se nao encontrar ele retorna nao encontrado
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarCliente(@PathVariable Integer id){
         repository
                .findById(id) //busca o cliente primeiro para saber se o cliente existe
                .map( cliente -> {
                    repository.delete(cliente);  //passando o cliente para excluir
                    return Void.TYPE;
                })
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND)); //se caso não encontrar o cliente retorna não encontrado 404
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarCiente(@PathVariable Integer id, @RequestBody Cliente clienteAtualizado){
        repository.findById(id)
                .map( cliente -> {
                    cliente.setNome(clienteAtualizado.getNome());
                    cliente.setCpf(clienteAtualizado.getCpf());

                    return repository.save(cliente);
                    /*clienteAtualizado.setId(cliente.getId());
                    return repository.save(clienteAtualizado);*/
                })
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
