package ngn.api.hopdong.reponse;

import lombok.Data;
import ngn.api.hopdong.models.PhieuBaoHanhModel;

@Data
public class PhieuBaoHanhReponse {
	private int status;
	private String message;
	private PhieuBaoHanhModel data;

}
