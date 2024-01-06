package ngn.api.nhathau.reponse;

import java.util.List;

import lombok.Data;
import ngn.api.nhathau.models.NhaThauModel;

@Data
public class ListNhaThauReponse {
	private Integer status;
	private String messager;
	private List<NhaThauModel> data;
}
