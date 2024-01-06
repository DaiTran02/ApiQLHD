package ngn.api.nhathau.reponse;

import lombok.Data;
import ngn.api.nhathau.models.NhaThauModel;

@Data
public class NhaThauReponse {
	private Integer status;
	private String messager;
	private NhaThauModel data;
}
