package br.com.trajano.beneficiarios.service;

import br.com.trajano.beneficiarios.database.model.Documents;
import br.com.trajano.beneficiarios.database.model.Recipient;
import br.com.trajano.beneficiarios.database.repository.IDocumentsRepository;
import br.com.trajano.beneficiarios.database.repository.IRecipientsRepository;
import br.com.trajano.beneficiarios.dto.DocumentsRequestDTO;
import br.com.trajano.beneficiarios.dto.DocumentsResponseDTO;
import br.com.trajano.beneficiarios.exceptions.NotFoundException;
import br.com.trajano.beneficiarios.mapper.DocumentsMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DocumentsService {
    private final IDocumentsRepository documentsRepository;
    private final DocumentsMapper documentsMapper;
    private final IRecipientsRepository recipientsRepository;

    @Transactional
    public void createDocuments(Long recipientId, List<DocumentsRequestDTO> dto) {
        Recipient recipient = recipientsRepository.findById(recipientId)
                .orElseThrow(() -> new NotFoundException("Recipient not found."));
        List<Documents> docs = documentsMapper.toEntity(recipient, dto);
        documentsRepository.saveAll(docs);
    }

    @Transactional(readOnly = true)
    public List<DocumentsResponseDTO> listDocumentsByRecipient(Long id) {
        Recipient recipient = recipientsRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Recipient not found"));
        return documentsMapper.toDto(recipient.getDocuments());
    }
}
