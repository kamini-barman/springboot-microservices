package upskill.ms.organizationservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(
        description = "Organization DTO Model Info"
)
public class OrganizationDto {

    private  Long id;
    @Schema(
            description = "Organization Name"
    )
    private String organizationName;

    @Schema(
            description = "Organization Name"
    )
    private String organizationDescription;

    @Schema(
            description = "Organization Name"
    )
    private String organizationCode;

    @Schema(
            description = "Organization Created Date"
    )
    private LocalDateTime createdDate;
}
