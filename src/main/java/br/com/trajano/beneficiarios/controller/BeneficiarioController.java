package br.com.trajano.beneficiarios.controller;

import br.com.trajano.beneficiarios.dto.BeneficiarioRequestDTO;
import br.com.trajano.beneficiarios.dto.BeneficiarioResponseDTO;
import br.com.trajano.beneficiarios.dto.BeneficiarioUpdateRequestDTO;
import br.com.trajano.beneficiarios.dto.BeneficiariosResponseDTO;
import br.com.trajano.beneficiarios.service.BeneficiarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/beneficiarios")
public class BeneficiarioController {
    private final BeneficiarioService beneficiarioService;

    @GetMapping
    public ResponseEntity<List<BeneficiariosResponseDTO>> getAllRecipientes() {
        return ResponseEntity.ok(beneficiarioService.getAllRecipientes());
    }

    @GetMapping("/{recipientId}")
    public ResponseEntity<BeneficiarioResponseDTO> getRecipient(@PathVariable Long recipientId) {
        return ResponseEntity.ok(beneficiarioService.getRecipient(recipientId));
    }

    @PostMapping
    public ResponseEntity<Void> createRecipient(@RequestBody @Valid BeneficiarioRequestDTO dto) {
        beneficiarioService.createBeneficiario(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{recipientId}")
    public ResponseEntity<BeneficiarioResponseDTO> updateRecipient(@PathVariable Long recipientId, @RequestBody BeneficiarioUpdateRequestDTO dto) {
        return ResponseEntity.ok(beneficiarioService.updatedBeneficario(recipientId, dto));
    }

    @DeleteMapping("/{recipientId}")
    public ResponseEntity<Void> deleteRecipient(@PathVariable Long recipientId) {
        beneficiarioService.deleteBeneficiario(recipientId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
