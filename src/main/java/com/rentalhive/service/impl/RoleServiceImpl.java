package com.rentalhive.service.impl;

import com.rentalhive.domain.Role;
import com.rentalhive.repository.RoleRepository;
import com.rentalhive.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role save(Role role) {
        validateRole(role);
        return roleRepository.save(role);
    }

    @Override
    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }

    @Override
    public List<Role> getALlRoles()
    {
        return roleRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        Optional<Role> role = roleRepository.findById(id);
        if(role.isPresent())
            roleRepository.delete(role.get());
        else
            throw new NoSuchElementException("Role not found with id: " + id);
    }

    @Override
    public Role findById(Long id) {
        return roleRepository.findById(id).get();
    }

    private void validateRole(Role role) {
        validateNonNull(role);
        validateRoleName(role.getName());
    }

    private void validateNonNull(Role role) {
        if (role == null) {
            throw new IllegalArgumentException("Role cannot be null");
        }
    }

    private void validateRoleName(String roleName) {
        if (roleName == null || roleName.trim().isEmpty()) {
            throw new IllegalArgumentException("Role name cannot be blank");
        }
    }


}
