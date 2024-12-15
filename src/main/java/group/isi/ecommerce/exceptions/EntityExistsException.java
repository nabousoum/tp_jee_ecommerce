package group.isi.ecommerce.exceptions;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class EntityExistsException extends RuntimeException {
    private String message;
}
