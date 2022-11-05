package com.cadastro.DTO;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUsuarioRoleDTO {
	public Long id;
	public List<Long> idsRoles;
}
