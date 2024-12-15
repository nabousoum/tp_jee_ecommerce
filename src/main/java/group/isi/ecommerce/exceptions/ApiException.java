package group.isi.ecommerce.exceptions;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
public class ApiException {
    private String message;
    private HttpStatus status;
    private LocalDateTime timestamp;
}
