package com.eam.mscompaniesmanage.controller;

import org.springframework.web.bind.annotation.*;
import com.eam.mscompaniesmanage.model.Company;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    /*
     * private final CompanyService companyService;
     * @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }
     */
    

    @GetMapping("/all")
    @Operation(summary = "Get all companies", description = "Returns a list of all registered companies.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Companies retrieved successfully"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public String getAllCompanies() {
        return "All companies returned.";
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get company by ID", description = "Returns a specific company based on its ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Company found"),
            @ApiResponse(responseCode = "404", description = "Company not found")
    })
    public String getCompanyById(@PathVariable @Parameter(description = "Company ID") String id) {
        return "Company " + id + " returned.";
    }

    @PostMapping("/new")
    @Operation(summary = "Create a new company", description = "Creates a new company with the provided data.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Company created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid data")
    })
    public String createCompany(@RequestBody @Parameter(description = "Company data to create") Company company) {
        return "Company " + company.getName() + " created.";
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Update a company", description = "Updates the data of an existing company.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Company updated successfully"),
            @ApiResponse(responseCode = "404", description = "Company not found")
    })
    public String updateCompany(@PathVariable @Parameter(description = "Company ID") String id,
                                                 @RequestBody @Parameter(description = "Updated company data") Company company) {
        return "Company updated.";
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a company", description = "Deletes a company based on its ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Company deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Company not found")
    })
    public String deleteCompany(@PathVariable @Parameter(description = "Company ID") String id) {
        return "Company deleted.";
    }

}