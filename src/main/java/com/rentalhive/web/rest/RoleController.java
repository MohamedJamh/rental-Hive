package com.rentalhive.web.rest;

import com.rentalhive.domain.Role;
import com.rentalhive.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RoleController {

    private final RoleService roleService;
    private final Role role = new Role();

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping("/role/save")
    public ResponseEntity<Role> save(@RequestParam String name){
        Role role1 = new Role();
        role1.setName(name);

        if (roleService.save(role1) == null) {
            return new ResponseEntity<>(
                     HttpStatus.BAD_REQUEST
            );
        }
        return new ResponseEntity<>(
                role1, HttpStatus.OK
        );
    }

    @GetMapping("/roles")
    public ResponseEntity<List<Role>> getAllRoles() {
        try {
            List<Role> roles = new ArrayList<>();
            roleService.getALlRoles().forEach(roles::add);

            return new ResponseEntity<>(roles, HttpStatus.OK);
        } catch (Exception e) {
            List<Role> rolesDto = new ArrayList<>();
            rolesDto.add(null);
            return new ResponseEntity<>(rolesDto, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/{name}")
    public ResponseEntity<Role> getRoleWithName(@PathVariable("name") String name)
    {
        role.setName(name);
        Role roleOptional = roleService.findByName(name);

        return new ResponseEntity<>(roleOptional,HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRole(@PathVariable("id") Long id)
    {
        try
        {
            roleService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e)
        {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/Edit/{id}")
    public ResponseEntity<Role> updateRole(@PathVariable("id") long id, @RequestParam String name)
    {
        try {
            Role role1 = roleService.findById(id);
            role1.setName(name);
            return new ResponseEntity<>(roleService.save(role1),HttpStatus.OK);
        }catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
