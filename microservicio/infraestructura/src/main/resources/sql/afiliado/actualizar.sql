update afiliado
set nombre = :nombre,
    tipo_documento = :tipoDocumento,
    numero_documento = :numeroDocumento,
    fecha_nacimiento = :fechaNacimiento,
    email = :email,
    direccion= :direccion,
    telefono= :telefono,
where id = :id;