package io.github.mateussilva.dscatalog.services.exceptions;

public class EntityNotFoundException extends RuntimeException {

    private static final String RESOURCE_NOT_FOUND = "Recurso não encontrado";

    public EntityNotFoundException() {
        super(RESOURCE_NOT_FOUND);
    }

}
