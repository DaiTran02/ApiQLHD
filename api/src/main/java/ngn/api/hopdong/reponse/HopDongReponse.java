package ngn.api.hopdong.reponse;

import lombok.Data;
import ngn.api.hopdong.models.HopDongModel;

@Data
public class HopDongReponse {
	private int status;
	private String message;
	private HopDongModel data;

}
