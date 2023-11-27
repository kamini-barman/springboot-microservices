package upskill.ms.organizationservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upskill.ms.organizationservice.dto.OrganizationDto;
import upskill.ms.organizationservice.service.OrganizationService;

@RestController
@RequestMapping("/api/organizations")
@AllArgsConstructor
@Tag(
        name="Organization-controller",
        description = "Organization Controller exposes rest api for Organization services"
)
public class OrganizationController {

    private OrganizationService organizationService;

    @Operation(
            summary = "Save Organization Rest api",
            description = "To Save Organization object in a database "
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )
    // Build Save Organization REST API
    @PostMapping
    public ResponseEntity<OrganizationDto> saveOrganization(@RequestBody OrganizationDto organizationDto){
        OrganizationDto savedOrganization = organizationService.saveOrganization(organizationDto);
        return new ResponseEntity<>(savedOrganization, HttpStatus.CREATED);
    }

    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
//     Build Get Organization by Code REST API
    @GetMapping("{code}")
    public ResponseEntity<OrganizationDto> getOrganization(@PathVariable("code") String organizationCode){
        OrganizationDto organizationDto = organizationService.getOrganizationByCode(organizationCode);
        return ResponseEntity.ok(organizationDto);
    }
}
