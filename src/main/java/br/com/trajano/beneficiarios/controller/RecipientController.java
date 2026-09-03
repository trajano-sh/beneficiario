package br.com.trajano.beneficiarios.controller;

import br.com.trajano.beneficiarios.dto.*;
import br.com.trajano.beneficiarios.service.BeneficiarioService;
import br.com.trajano.beneficiarios.service.DocumentsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/recipients")
public class RecipientController {
    private final BeneficiarioService beneficiarioService;
    private final DocumentsService documentsService;

    @GetMapping
    public ResponseEntity<List<RecipientsResponseDTO>> getAllRecipients() {
        return ResponseEntity.ok(beneficiarioService.getAllRecipientes());
    }

    @GetMapping("/{recipientId}")
    public ResponseEntity<RecipientResponseDTO> getRecipient(@PathVariable Long recipientId) {
        return ResponseEntity.ok(beneficiarioService.getRecipient(recipientId));
    }

    @PostMapping
    public ResponseEntity<Void> createRecipient(@RequestBody @Valid RecipientRequestDTO dto) {
        beneficiarioService.createBeneficiario(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/{recipientId}/docs")
    public ResponseEntity<Void> createDocs(@PathVariable Long recipientId, @RequestBody @Valid List<DocumentsRequestDTO> dto) {
        documentsService.createDocuments(recipientId, dto);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{recipientId}")
    public ResponseEntity<RecipientResponseDTO> updateRecipient(@PathVariable Long recipientId, @RequestBody RecipientUpdateRequestDTO dto) {
        return ResponseEntity.ok(beneficiarioService.updatedBeneficario(recipientId, dto));
    }

    @DeleteMapping("/{recipientId}")
    public ResponseEntity<Void> deleteRecipient(@PathVariable Long recipientId) {
        beneficiarioService.deleteBeneficiario(recipientId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
