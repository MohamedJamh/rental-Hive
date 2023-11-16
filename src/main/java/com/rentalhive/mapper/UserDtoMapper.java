package com.rentalhive.mapper;

import com.rentalhive.domain.Role;
import com.rentalhive.domain.User;
import com.rentalhive.dto.UserDto;

import java.util.ArrayList;
import java.util.List;

public class UserDtoMapper {

    private UserDtoMapper() {
    }

    public static UserDto toDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .password(user.getPassword())
                .createdAt(user.getCreatedAt())
                .verifiedAt(user.getVerifiedAt())
                .rolesId(user.getRoles().stream().map(Role::getId).toList())
                .organization(
                        OrganizationDtoMapper.toDto(user.getOrganization())
                )
                .build();
    }
    public static User toEntity(UserDto userDto) {
        List<Role> roles = new ArrayList<>();
        if(userDto.getRolesId() != null){
            for (Long roleId : userDto.getRolesId()) {
                roles.add(Role.builder().id(roleId).build());
            }
        }
        return User.builder()
            .firstName(userDto.getFirstName())
            .lastName(userDto.getLastName())
            .email(userDto.getEmail())
            .password(userDto.getPassword())
            .createdAt(userDto.getCreatedAt())
            .verifiedAt(userDto.getVerifiedAt())
            .roles(roles)
            .organization(
                    OrganizationDtoMapper.toEntity(userDto.getOrganization())
            )
            .build();
    }
}
