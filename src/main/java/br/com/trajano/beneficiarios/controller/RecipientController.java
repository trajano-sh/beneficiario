package br.com.trajano.beneficiarios.controller;

import br.com.trajano.beneficiarios.dto.*;
import br.com.trajano.beneficiarios.service.RecipientService;
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
    private final RecipientService recipientService;
    private final DocumentsService documentsService;

    @GetMapping
    public ResponseEntity<List<RecipientsResponseDTO>> getAllRecipients() {
        return ResponseEntity.ok(recipientService.getAllRecipients());
    }

    @GetMapping("/{recipientId}")
    public ResponseEntity<RecipientResponseDTO> getRecipient(@PathVariable Long recipientId) {
        return ResponseEntity.ok(recipientService.getRecipient(recipientId));
    }

    @PostMapping
    public ResponseEntity<Void> createRecipient(@RequestBody @Valid RecipientRequestDTO dto) {
        recipientService.createRecipient(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/{recipientId}/docs")
    public ResponseEntity<Void> createDocs(@PathVariable Long recipientId, @RequestBody @Valid List<DocumentsRequestDTO> dto) {
        documentsService.createDocuments(recipientId, dto);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{recipientId}")
    public ResponseEntity<RecipientResponseDTO> updateRecipient(@PathVariable Long recipientId, @RequestBody RecipientUpdateRequestDTO dto) {
        return ResponseEntity.ok(recipientService.updatedRecipient(recipientId, dto));
    }

    @DeleteMapping("/{recipientId}")
    public ResponseEntity<Void> deleteRecipient(@PathVariable Long recipientId) {
        recipientService.deleteRecipient(recipientId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
