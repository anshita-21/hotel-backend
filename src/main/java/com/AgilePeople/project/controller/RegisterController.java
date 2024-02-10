package com.AgilePeople.project.controller;

//import lombok.AllArgsConstructor;
import com.AgilePeople.project.entity.Register;
import com.AgilePeople.project.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // returns the data directly in a format like JSON
//@AllArgsConstructor
@RequestMapping("api/register") //routed to the appropriate method
public class RegisterController {
    @Autowired //creats objects
    private RegisterService registerService;

    // build create Register REST API
    @PostMapping
    public Register createRegister(@RequestBody Register register) {
        Register savedRegister = registerService.createRegister(register);
        return savedRegister;
    }

    // build get register by id REST API
    // http://localhost:8080/api/register/1
    @GetMapping("{id}")
    public Register getRegisterById(@PathVariable("id") Long registerId) {
        Register register = registerService.getRegisterById(registerId);
        return register;
    }

    // Build Get All registers REST API
    // http://localhost:8080/api/register
    @GetMapping
    public List<Register> getAllRegister() {
        List<Register> registers = registerService.getAllRegister();
        return registers;
    }

    // Build Update register REST API
    @PutMapping("{id}")
    // http://localhost:8080/api/register/1
    public Register updateRegister(@PathVariable("id") Long registerId,
                                   @RequestBody Register register) {
        register.setId(registerId);
        Register updatedRegister = registerService.updateRegister(register);
        return updatedRegister;
    }

    // Build Delete register REST API
    @DeleteMapping("{id}")
    public String deleteRegister(@PathVariable("id") Long registerId) {
        registerService.deleteRegister(registerId);
        return "register successfully deleted!";
    }
}