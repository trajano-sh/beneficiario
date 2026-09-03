package br.com.trajano.beneficiarios.mapper;

import br.com.trajano.beneficiarios.database.model.Recipient;
import br.com.trajano.beneficiarios.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RecipientMapper {
    private final DocumentsMapper docsMapper;

    public Recipient toEntity(RecipientRequestDTO dto) {
        Recipient recipient = new Recipient();

        if (dto.documents() != null && !dto.documents().isEmpty()) {
            docsMapper.toEntity(recipient,dto.documents());
        }

        recipient.setName(dto.name());
        recipient.setPhone(dto.phone());
        recipient.setDateOfBirth(dto.dateOfBirth());
        return recipient;
    }

    public void toUpdate(Recipient recipient, RecipientUpdateRequestDTO dto) {
        recipient.setName(dto.name());
        recipient.setPhone(dto.phone());
        recipient.setDateOfBirth(dto.dateOfBirth());
    }

    public List<RecipientsResponseDTO> getAll(List<Recipient> recipients) {
        if (recipients == null || recipients.isEmpty()) {
            return List.of();
        }
        return recipients.stream().map(b -> new RecipientsResponseDTO(b.getId(), b.getName(), b.getPhone(), b.getDateOfBirth())).toList();
    }

    public RecipientResponseDTO toDto(Recipient bf) {
        List<DocumentsResponseDTO> docsResponse = docsMapper.toDto(bf.getDocuments());

        return new RecipientResponseDTO(bf.getId(), bf.getName(), bf.getPhone(), bf.getDateOfBirth(), bf.getCreatedAt(), bf.getUpdatedAt(), docsResponse);
    }
}
