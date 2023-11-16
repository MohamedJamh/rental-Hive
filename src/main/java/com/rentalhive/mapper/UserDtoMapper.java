package com.rentalhive.mapper;

import com.rentalhive.domain.Organization;
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
                .organizationId(user.getOrganization().getId())
                .build();
    }
    public static User toEntity(UserDto userDto) {
        List<Role> roles = new ArrayList<>();
        for (Long roleId : userDto.getRolesId()) {
            roles.add(Role.builder().id(roleId).build());
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
                    Organization.builder()
                            .id(userDto.getOrganizationId())
                            .build()
            )
            .build();
    }
}
