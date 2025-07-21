package telran.java58.post.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class NewCommentDto {
    @NotBlank(message = "Message is required")
    @Size(min = 5, max = 100, message = "Message must be between 5 and 100 characters")
    private String message;
}
