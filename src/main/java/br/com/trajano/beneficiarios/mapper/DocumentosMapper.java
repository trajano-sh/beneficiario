package br.com.trajano.beneficiarios.mapper;

import br.com.trajano.beneficiarios.database.model.Documentos;
import br.com.trajano.beneficiarios.dto.DocumentosRequestDTO;
import br.com.trajano.beneficiarios.dto.DocumentosResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class DocumentosMapper {
    public Documentos toEntity(DocumentosRequestDTO dto){
        Documentos docs = new Documentos();
        docs.setTypeDocument(dto.typeDocument());
        docs.setDescription(dto.description());
        return docs;
    }

    public DocumentosResponseDTO toDto(Documentos docs){
        return new DocumentosResponseDTO(
                docs.getId(),
                docs.getTypeDocument(),
                docs.getDescription(),
                docs.getCreatedAt(),
                docs.getUpdatedAt(),
                docs.getBeneficiario().getId()
        );
    }
}
