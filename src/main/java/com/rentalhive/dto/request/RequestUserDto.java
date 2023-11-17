package com.rentalhive.dto.request;


import com.rentalhive.dto.OrganizationDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestUserDto {
    private Long id;
    @NotNull(message = "First name cannot be null")
    private String firstName;
    @NotNull(message = "Last name cannot be null")
    private String lastName;
    @NotNull(message = "Email cannot be null")
    @Email(message = "Email should be valid")
    private String email;
    @Min(value = 8,message = "Password should be at least 8 characters")
    private String password;
    private List<Long> rolesId;
    @NotNull(message = "Organization cannot be null")
    private OrganizationDto organization;
}
