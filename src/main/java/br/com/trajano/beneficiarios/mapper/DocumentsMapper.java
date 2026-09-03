package br.com.trajano.beneficiarios.mapper;

import br.com.trajano.beneficiarios.database.model.Documents;
import br.com.trajano.beneficiarios.database.model.Recipient;
import br.com.trajano.beneficiarios.dto.DocumentsRequestDTO;
import br.com.trajano.beneficiarios.dto.DocumentsResponseDTO;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class DocumentsMapper {
    public List<Documents> toEntity(Recipient recipient, List<DocumentsRequestDTO> dto) {
        if (dto == null) {
            return Collections.emptyList();
        }

        return dto.stream().map(request -> {
            Documents document = new Documents();
            document.setTypeDocument(request.typeDocument());
            document.setDescription(request.description());
            document.setRecipient(recipient);
            return document;
        }).toList();
    }

    public List<DocumentsResponseDTO> toDto(List<Documents> docs) {
        if (docs == null) {
            return Collections.emptyList();
        }

        return docs.stream().map(document -> new DocumentsResponseDTO(document.getId(), document.getTypeDocument(), document.getDescription(), document.getCreatedAt(), document.getUpdatedAt(), document.getRecipient().getId())).toList();
    }
}
