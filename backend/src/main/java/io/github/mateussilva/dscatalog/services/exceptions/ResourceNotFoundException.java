package io.github.mateussilva.dscatalog.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    private static final String RESOURCE_NOT_FOUND = "Recurso não encontrado";

    public ResourceNotFoundException() {
        super(RESOURCE_NOT_FOUND);
    }

}
