package br.com.feitoamaoapi.mapper;

import java.util.List;
import java.util.stream.Collectors;

import br.com.feitoamaoapi.dto.ImagemDTO;
import br.com.feitoamaoapi.entity.Imagem;
import br.com.feitoamaoapi.infra.util.LocalDateUtils;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ImagemMapper {

	public static ImagemDTO fromEntityToDTO(Imagem imagem) {
		if (imagem == null) {
			return null;
		}

		ImagemDTO dto = new ImagemDTO();

		dto.setId(imagem.getId());
		dto.setNomeArquivo(imagem.getNomeArquivo());
		dto.setDadosImagem(imagem.getDadosImagem());
		dto.setLegenda(imagem.getLegenda());
		dto.setDataUpload(LocalDateUtils.formatLocalDateTime(imagem.getDataUpload(),
				LocalDateUtils.DATE_TIME_FORMAT_ANO_MES_DIA));
		return dto;
	}

	public static Imagem fromDTOtoEntity(ImagemDTO dto) {
		if (dto == null) {
			return null;
		}

		Imagem imagem = new Imagem();

		imagem.setId(dto.getId());
		imagem.setNomeArquivo(dto.getNomeArquivo());
		imagem.setDadosImagem(dto.getDadosImagem());
		imagem.setLegenda(dto.getLegenda());
		imagem.setDataUpload(
				LocalDateUtils.parseLocalDateTime(dto.getDataUpload(), LocalDateUtils.DATE_TIME_FORMAT_ANO_MES_DIA));

		return imagem;
	}

	public static List<ImagemDTO> toDTOList(List<Imagem> imagens) {
		return imagens.stream().map(ImagemMapper::fromEntityToDTO).collect(Collectors.toList());
	}
}
