package ngn.api.hopdong.reponse;

import java.util.List;

import lombok.Data;
import ngn.api.hopdong.models.PhieuBaoHanhModel;

@Data
public class ListPhieuBaoHanhReponse {
	private int status;
	private String message;
	private List<PhieuBaoHanhModel> data;
}
