package group.isi.ecommerce.exceptions;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class EntityNotFoundException extends RuntimeException {
  private String message;
}
