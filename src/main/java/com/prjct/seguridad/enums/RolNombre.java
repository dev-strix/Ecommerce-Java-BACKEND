package com.prjct.seguridad.enums;

public enum RolNombre {
	ROLE_ADMIN, 
	ROLE_USER,
	ROLE_SUPPORT,
	ROLE_VIEWER,
	ROLE_CONTRIBUTOR,
	ROLE_MANAGER,
	ROLE_OPERATIONS,
	ROLE_FINANCE
}
/*
ROLE_ADMIN ---------Es el administrador, puede crear/borrar/modificar usuarios, roles, productos y todo
ROLE_USER ----------Considerado tambien como un cliente, esto se crea por defecto al crear un usuario
ROLE_SUPPORT -------Son los encargados del soporte, pueden crear/modificar usuarios
ROLE_VIEWER --------Son los que solo ven
ROLE_CONTRIBUTOR ---Son los que contribuyen
ROLE_MANAGER -------Son los que administran los productos
ROLE_OPERATIONS -----Son los encargados de las operaciones
ROLE_FINANCE -------Son los encargados de las finanzas
 * 
 */