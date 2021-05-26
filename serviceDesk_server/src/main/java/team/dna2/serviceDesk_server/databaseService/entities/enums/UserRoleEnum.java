package team.dna2.serviceDesk_server.databaseService.entities.enums;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@Getter
@NoArgsConstructor
@Deprecated
public enum UserRoleEnum {
    ROLE_USER,
    ROLE_ADMIN,
    ROLE_MEMBER,
    ROLE_DEVELOPER
}
